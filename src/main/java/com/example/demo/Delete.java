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

@WebServlet("/Delete")
public class Delete extends HttpServlet {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;



    public void doGet(HttpServletRequest req,HttpServletResponse rsp ) throws IOException,ServletException
    {

        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();

        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");


        String id = req.getParameter("id");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            pst = con.prepareStatement("delete from demo1 where id = ?");
            pst.setString(1, id);
            row = pst.executeUpdate();

            out.println("<font color='green'>  Record Deletedddddd   </font>");
            out.println("<br>");
            out.println("<a class='badge badge-primary' href='viewemployee'>View Students</a>");


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            out.println("<font color='red'>  Record Failed   </font>");

        }


    }

}
