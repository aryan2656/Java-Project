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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet  {


    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;

    public void doPost(HttpServletRequest req,HttpServletResponse rsp ) throws IOException,ServletException
    {

        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();


        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");

            String id = req.getParameter("id");
            String Fname = req.getParameter("Fname");
            String lname = req.getParameter("lname");
            String branch = req.getParameter("branch");
            String mno = req.getParameter("mno");
            String email = req.getParameter("email");

            pst = con.prepareStatement("update demo1 set Fname = ?, lname = ?, branch = ?, mno = ?, email=? where id = ?");
            pst.setString(1, Fname);
            pst.setString(2, lname);
            pst.setString(3, branch);
            pst.setString(4, mno);
            pst.setString(5, email);
            pst.setString(6, id);
            row = pst.executeUpdate();

            out.println("<font color='green'>  Record Updateeeedd   </font>");
            out.println("<br>");
            out.println("<a class='badge badge-primary' href='viewemployee'>View Students</a>");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            out.println("<font color='red'>  Record Failed   </font>");

        }

    }

}
