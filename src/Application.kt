package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*
import kotlinx.css.script
import io.ktor.routing.Routing

import kotlinx.html.dom.*
import io.ktor.client.*
import io.ktor.features.CallLogging
import io.ktor.http.content.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.stream.createHTML
import sun.security.pkcs11.wrapper.Functions
import java.awt.SystemColor.window
import java.io.File

fun main() {
     val port=Integer.valueOf(System.getenv("PORT"))
    embeddedServer(Netty,port,watchPaths = listOf("Ktor-Website"),module = Application::module).start(true)

fun Application.module() {


    val myname = " Shreeman Arjun Sahu"
    routing {

        static("static") {
            staticRootFolder= File("files")
            files("css")
            files("js")
            files("vendor")
            files("fonts")
            files("fonts/poppins")
            files("vendor/datepicker")
            files("vendor/font-awesome-4.7")
            files("vendor/jquery")
            files("vendor/mdi-font")
            files("vendor/select2")
            files("eclipse")
            files("eclipse/index.html")
            file("img-01.png")
            file("b.jpg")
            file("main.css")
            file("marksheet.css")
            file("util.css")
            default("static/index.html")
        }

         get("/") {
             call.respondHtml { this@routing.file("index.html").toString() }

         }
        get("/login") {
            call.respondHtml {
                body {
                    form(
                        action = "/auth",
                        encType = FormEncType.applicationXWwwFormUrlEncoded,
                        method = FormMethod.post
                    ) {
                        p {
                            +"user:"
                            textInput(name = "user")

                        }
                        p {
                            +"password:"
                            passwordInput { name = "pass" }
                        }
                        p {
                            submitInput {
                                value = "submit"
                            }
                        }
                    }
                }
            }

        }
        get("/studentlogin"){
            call.respondHtml { newLogin() }
        }

        post("/auth") {
            val post = call.receiveParameters()
            this@routing.file("b.jpg")
            var m = DBConnect(post["email"]!!.capitalize(), post["pass"]!!)
            when {
                m.fname.isNullOrBlank() -> call.respondHtml {
                    body {
                        onLoad="window.history.back();"
                        script(ScriptType.textJavaScript) {
                            unsafe {
                                raw(
                                    """
                                           window.alert('Enter Valid username and password')
                                       """.trimIndent()
                                )
                            }

                        }
                    }
                }
                m.fname.isNotEmpty()-> call.respondHtml { marksheet(m.name,m.fname,m.inst,m.roll,
                    m.H1N,m.H1I,m.H1S,m.H1P,m.H1T,
                    m.H2N,m.H2I,m.H2S,m.H2P,m.H2T,
                    m.E1N,m.E1I,m.E1S,m.E1P,m.E1T,
                    m.C1N,m.C1I,m.C11S,m.C1T)
                }
            }
        }
        get("/marksheet"){
            this@routing.file("b.jpg")
            call.respondHtml { }
        }


        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        get("/styles.css") {
            call.respondCss {
                body {
                    backgroundColor = Color.white
                }
                h1 {
                    backgroundColor = rgb(255, 255, 255)
                    color=rgb(39, 179, 30)
                    fontSize = 19.px
                }
                rule("p.myclass") {
                    color = Color.blue
                }
            }
        }
    }
}


fun FlowOrMetaDataContent.styleCss(builder: CSSBuilder.() -> Unit) {
    style(type = ContentType.Text.CSS.toString()) {
        +CSSBuilder().apply(builder).toString()
    }
}

fun CommonAttributeGroupFacade.style(builder: CSSBuilder.() -> Unit) {
    this.style = CSSBuilder().apply(builder).toString().trim()
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}

