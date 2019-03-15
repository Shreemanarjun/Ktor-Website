package com.example

import java.lang.Exception
import java.sql.Blob
import java.sql.DriverManager
import java.sql.ResultSet

data class Student(var RollNo:String,var DOB:String,var FullName:String,var FatherName:String,var Instname:String,var profilepic:Blob,var Hons1:String,var Hons2:String,var Elective:String,var Compulsory:String)
fun StudentInformation( user:String?, pass:String?):String{
    try {
        Class.forName("com.mysql.jdbc.Driver")
        val con=DriverManager.getConnection("jdbc:mysql//localhost:3306/college","root","password")

        val st = con.createStatement();
        val sql = "select * from streams where RollNo='$user' and DOB='$pass'"
        var result: ResultSet? = st.executeQuery(sql)
        //  var s=Student()
        //while (result!!.next()){
        //   var s
        //  }

        return "connection cannt be created"
    }catch (e:Exception){
        return e.localizedMessage+ "exception occured"
    }
    return "Information found"
}
fun main(){

}