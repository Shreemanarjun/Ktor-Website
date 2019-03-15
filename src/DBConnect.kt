package com.example


import java.lang.Exception
import java.sql.DriverManager
import java.sql.*
data class Mark(val name:String,val fname:String,val inst:String,val roll:String,
                val H1N:String,val H1I:Int,val H1S:Int,val H1P:Int,val H1T:Int,
                val H2N:String,val H2I:Int,val H2S:Int,val H2P:Int,val H2T:Int,
                val E1N:String,val E1I:Int,val E1S:Int,val E1P:Int,val E1T:Int,
                val C1N:String,val C1I:Int,val C11S:Int,val C1T:Int)
fun DBConnect( user:String, pass:String):Mark{
    var name:String;
    var m=Mark("","","","","",0,0,0,0,"",0,0,0,0,"",0,0,0,0,"",0,0,0)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
        val con= DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","password")

        val st = con.createStatement();
        val sql = """

            SELECT student_info.SlNo,student_info.RollNo,student_info.Name,student_info.FName,student_info.DOB,student_info.Inst,student_info.pic,student_info.Hid,
                    honours_science.id,honours_science.HName,subjects.SubName,
                    hons_i.Name as H1N, hons_i.internal as H1I,hons_i.semester as H1S,hons_i.practical as H1P,(hons_i.internal+hons_i.semester+hons_i.practical) as H1T,
                      hons_ii.Name as H2N,hons_ii.internal as H2I,hons_ii.semester as H2S,hons_ii.practical as H2P,(hons_ii.internal+hons_ii.semester+hons_ii.practical) as  H2T,
                      elective_i.Elect_name as E1N,elective_i.Elect_name as E1N,elective_i.Internal as E1I,elective_i.semester as E1S,elective_i.practical as E1P,(elective_i.internal+elective_i.semester+elective_i.practical) as  E1T,
                       compulsory_i.Comp_name as C1N,compulsory_i.Comp_name as C1N,compulsory_i.Internal as C1I ,compulsory_i.semester as C1S,(compulsory_i.internal+compulsory_i.semester) as  C1T
                        from honours_science inner join student_info on honours_science.id=student_info.Hid
                        inner join subjects on honours_science.id=subjects.hid
                         inner join hons_i on student_info.RollNo=hons_i.RollNo
                         inner join hons_ii on student_info.RollNo=hons_ii.RollNo
                          inner join elective_i on student_info.RollNo=elective_i.RollNo
                            inner join compulsory_i on student_info.RollNo=compulsory_i.RollNo
                                where student_info.RollNo='$user' and student_info.DOB='$pass'
                                """.trimIndent()
        var rs:ResultSet=st.executeQuery(sql)
        while (rs.next()) {
            m=Mark(name = rs.getString("Name"),fname = rs.getString("FName"),inst = rs.getString("Inst"),roll = rs.getString("RollNo" ),
                H1N =  rs.getString("H1N"),H1I = rs.getInt("H1I"),H1S = rs.getInt("H1S"),H1P = rs.getInt("H1P"),H1T = rs.getInt("H1T"),
                H2N = rs.getString("H2N"),H2I = rs.getInt("H2I"),H2S = rs.getInt("H2S"),H2P = rs.getInt("H2P"),H2T = rs.getInt("H2T"),
                E1N = rs.getString("E1N"),E1I = rs.getInt("E1I"),E1S = rs.getInt("E1S"),E1P = rs.getInt("E1P"),E1T = rs.getInt("E1T"),
                C1N = rs.getString("C1N"),C1I = rs.getInt("C1I"),C11S = rs.getInt("C1S"),C1T = rs.getInt("C1T"))

            return  m

        }

    }catch (e: Exception){
        println(e.localizedMessage+ "exception occured")
    }
    return m
}
fun main(){
    print(DBConnect("16csc001","01/01/1999"))
}
