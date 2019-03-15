package com.example

import kotlinx.css.*
import kotlinx.html.*
fun HTML.newLogin(){
    head{
        title{+"Student LOGIN"}
        styleLink("static/main.css")
        styleLink("static/util.css")
        styleLink("static/css/material-design-iconic-font.min.css")
        styleLink("static/css/font-awesome.min.css")
        //font special for pages
        styleLink("https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i")
        styleLink("static/select2/select2.min.css" )
        styleLink("static/datepicker/daterangepicker.css")


    }
    body {

        div("limiter") {
            div("container-login100") {
                div("wrap-login100") {
                    div("login100-pic js-tilt data-tilt") {
                        img { src = "static/img-01.png";alt = "IMG"; }
                    }
                    form(
                        classes = "login100-form validate-form boxd",
                        action = "/auth",
                        encType = FormEncType.applicationXWwwFormUrlEncoded,
                        method = FormMethod.post
                    ) {
                        for(i in 0..4
                        ){
                            span {  }
                        }
                        span(classes = "login100-form-title") {
                            +"Student Login"
                        }
                        div(classes = "wrap-input100 validate-input") {



                            input(classes = "input100", type = InputType.text, name = "email") {
                                placeholder = "RollNo"
                                id = "unname"

                                attributes["data-validate"] = "Valid email is required"
                                attributes["required"]="required"

                            }
                            span(classes = "focus-input100") { }
                            span(classes = "symbol-input100") {
                                i(classes = "fa fa-envelope") { attributes["aria-hidden"] = "true" }
                            }
                        }
                        div(classes = "wrap-input100 validate-input") {
                            attributes["data-validate"] = "Password"
                            input(
                                classes = "js-datepicker input100 input--style-4 ",
                                type = InputType.password,
                                name = "pass"

                            ) {
                                placeholder = "Date of Birth"
                                id = "pass"
                                attributes["required"]="required"

                            }
                            span(classes = "focus-input100") { }
                            span(classes = "symbol-input100") {
                                i(classes = "fa fa-lock") { attributes["aria-hidden"] = "true" }
                            }
                        }
                        div(classes = "container-login100-form-btn") {
                            button()
                            {
                                id = "login"


                                type=ButtonType.submit
                                +"Login"
                            }
                        }
                        div(classes = "text-center p-t-12") {
                            span(classes = "txt1") { +"Forgot  " }
                            a(classes = "txt2", href = "/forgot") { +"Username /Password?" }
                        }
                        div(classes = "text-center p-t-136") {
                            a(classes = "txt2", href = "register.jsp") {
                                +"Create your account"
                                i(classes = "fa fa-long-arrow-right m-1-5") { attributes["aria-hidden"] = "true" }
                            }
                        }


                    }

                }
            }
        }
        script(src = "static/jquery/jquery.js"){}
        script(src = "static/jquery/jquery.min.js"){}
        script(src = "static/select2/select2.min.js"){}
        script(src = "static/datepicker/moment.min.js"){}
        script(src = "static/datepicker/daterangepicker.js"){}
        script(src = "static/global.js"){}
    }
}