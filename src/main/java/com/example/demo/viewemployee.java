package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewemployee")
public class viewemployee extends HttpServlet {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;

    public void doGet(HttpServletRequest req,HttpServletResponse rsp ) throws IOException,ServletException
    {

        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();

        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");

            String sql;

            sql = "select * from demo1";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            out.println("<table cellspacing='0' width='350px' border='1' class='table table-striped'>");
            out.println("<thead class='thead-dark'>");
            out.println("<th colspan='8'><h1>Students</h1> </th>");
            out.println("</thead>");
            out.println("<tr>");
            out.println("<td> StudentID </td>");
            out.println("<td> Firstname </td>");
            out.println("<td> Lastname </td>");
            out.println("<td> Branch </td>");
            out.println("<td> Mobile No </td>");
            out.println("<td> Email</td>");
            out.println("<td> Edit </td>");
            out.println("<td> Delete </td>");

            out.println("</tr>");

            while(rs.next())
            {
                out.println("<tr>");
                out.println("<td>"  + rs.getString("id")   +  "</td>");
                out.println("<td>"  + rs.getString("Fname")   +  "</td>");
                out.println("<td>"  + rs.getString("lname")   +  "</td>");
                out.println("<td>"  + rs.getString("branch")   +  "</td>");
                out.println("<td>"  + rs.getString("mno")   +  "</td>");
                out.println("<td>"  + rs.getString("email")   +  "</td>");

                out.println("<td>"  + "<a href='Editreturn?id=" +  rs.getString("id")  + "'> Edit </a>" + "</td>");
                out.println("<td>"  + "<a href='Delete?id=" +  rs.getString("id")  + "'> Delete </a>" + "</td>");
                out.println("</tr>");

            }

            out.println("</table>");


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            out.println("<font color='red'>  Record Failed   </font>");
        }
    }
}
