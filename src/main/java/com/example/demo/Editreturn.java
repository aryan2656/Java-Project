package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Editreturn")
public class Editreturn extends HttpServlet {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;

    public void doGet(HttpServletRequest req,HttpServletResponse rsp ) throws IOException,ServletException
    {

        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");

        String eid = req.getParameter("id");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");

            pst = con.prepareStatement("select * from demo1 where id = ?");
            pst.setString(1, eid);
            rs = pst.executeQuery();

            while(rs.next())
            {
                out.println("<form action='EditServlet' method='POST' class='form-group'>");
                out.println("<table class='table table-striped'>");
                out.println("<thead class='thead-dark'>");
                out.println("<th colspan='5'><h1>Edit Student Details</h1> </th>");
                out.println("</thead>");
                out.println("<tr>");
                out.println("<td>Student ID</td>");
                out.println("<td> <input type='text' name ='id' id='id' value= '" + rs.getString("id") + "'> </td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>FirstName</td>");
                out.println("<td> <input type='text' name ='Fname' id='Fname' value= '" + rs.getString("Fname") + "'> </td>");
                out.println("</tr>");
                out.println("<tr> <td>Lastname</td><td> <input type='text' name ='lname' id='lname' value= '" + rs.getString("lname") + "'/> </td> </tr>");
                out.println("<tr> <td>Branch</td><td> <input type='text' name ='branch' id='branch' value= '" + rs.getString("branch") + "'/> </td> </tr>");
                out.println("<tr> <td>Mobile No</td><td> <input type='text' name ='mno' id='mno' value= '" + rs.getString("mno") + "'/> </td> </tr>");
                out.println("<tr> <td>Email</td><td> <input type='text' name ='email' id='email' value= '" + rs.getString("email") + "'/> </td> </tr>");

                out.println("<tr>  <td colspan ='2'> <input type='submit'  value= 'Edit' class='btn btn-primary btn-block'/> </td> </tr>");
                out.print("</table>");
                out.print("</form>");



            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            out.println("<font color='red'>  Record Failed   </font>");

        }
    }

}
