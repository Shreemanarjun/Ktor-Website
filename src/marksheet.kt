package com.example
import kotlinx.html.*
import kotlinx.html.Entities.*
fun HTML.marksheet( name1:String, fname:String, inst:String, roll:String,
                    H1N:String, H1I:Int,H1S:Int, H1P:Int, H1T:Int,
                    H2N:String, H2I:Int,H2S:Int, H2P:Int, H2T:Int,
                    E1N:String, E1I:Int, E1S:Int, E1P:Int, E1T:Int,
                    C1N:String, C1I:Int, C1S:Int, C1T:Int){

    head{
        title{
            +"Student Marksheet"
        }


    }

    body(classes ="body") {
        link { rel="Stylesheet";type="text/css";href="static/marksheet.css";media="print" }
        link { rel="Stylesheet";type="text/css";href="static/marksheet.css";media="screen" }
        div { id = "container"

            div(classes = "marksheet") {

                h1{
                    +"GOVERNMENT AUTONOMOUS COLLEGE,ANGUL"

                }
                h1 { +"\n STUDENT MARKSHEET" }
                div(classes = "image") {
                    +nbsp
                    img {

                        src="static/b.jpg"
                    }
                }
                fieldSet {
                    legend {
                        id="it"
                        +"Student Information"
                    }
                    table { id="tbl1"
                        form {
                            this@table.tr{
                                id="it"
                                td{+ "Name:"}
                                td{
                                    input {
                                        type=InputType.text
                                        name="txtname"
                                        value="$name1"
                                        attributes["readonly"]="readonly"
                                    }
                                    this@tr.td{
                                        +nbsp
                                        +nbsp
                                        +"Father Name"
                                    }
                                    this@tr.td{
                                        input {
                                            type=InputType.text
                                            name="txtname"
                                            value="$fname"
                                            attributes["readonly"]="readonly"
                                        }
                                    }
                                }
                            }
                            this@table.tr{
                                id="it"
                                td {
                                    +"Institute Name"
                                }
                                td {
                                    input {
                                        type=InputType.text
                                        name="txtinstitute"
                                        value="$inst"
                                        attributes["readonly"]="readonly"
                                    }
                                }
                                td{
                                    +nbsp
                                    +"RollNo.:"
                                }
                                td {
                                    input {
                                        type=InputType.text
                                        name="txtbatch"
                                        value="$roll"
                                        attributes["readonly"]="readonly"
                                    }
                                }
                            }
                        }
                    }
                }
                table(classes = "table") {
                    id="mark"
                    thead {
                        tr {
                            th { +"Subject"
                                +nbsp }
                            th { +"Practical" }
                            +nbsp
                            th { +"Internal" }
                            +nbsp
                            th { +"Semester" }
                            +nbsp
                            th { +"Total Mark" }
                            +nbsp
                        }
                    }
                    tbody {
                        tr(classes = "Honours-I") {
                            td { +"Honours-I :($H1N)"}
                            td { +"$H1P" }
                            td { +"$H1I" }
                            td { +"$H1S" }
                            td { +"$H1T" }
                        }
                        tr(classes = "Honours-II") {
                            td { +"Honours-II   :($H2N)" }
                            td { +"$H2P" }
                            td { +"$H2I" }
                            td { +"$H2S" }
                            td { +"$H2T" }
                        }
                        tr(classes = "Elective") {
                            td { +"Elective($E1N)" }
                            td { +"$E1P" }
                            td { +"$E1I" }
                            td { +"$E1S "}
                            td { +"$E1T" }
                        }
                        tr(classes = "Compulsory") {
                            td { +"Compulsory($C1N)" }
                            td { +"0" }
                            td { +"$C1I" }
                            td { +"$C1S" }
                            td { +"$C1I" }
                        }
                        tr(classes = "Total") {
                            td { +"Total" }
                            td {+"${H1P+H2P+E1P}" }
                            td { +"${H1I+H2I+E1I+C1I}" }
                            td { +"${H1S+H2S+E1S+C1S}" }
                            td { +"${H1T+H2T+E1T+C1T}" }
                        }
                    }

                }

            }
        }


        div (classes = "print"){
            style="text-align:center"
            button(classes = "print-button")
            {
                span(classes = "print-icon") {

                    title="Click to print the page"
                    onClick="window.print()"
                    onDrag
                }
                +"Print"
            }
        }

        script(src = "static/global.js"){}

    }

}