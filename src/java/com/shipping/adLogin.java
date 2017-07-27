/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shipping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shipping.ConnectionProvider;

/**
 *
 * @author dashmeetkaur
 */
public class adLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
           int id=Integer.parseInt(request.getParameter("slId"));
           String pwd=request.getParameter("pwd");
           Connection con=ConnectionProvider.getCon();
           PreparedStatement ps=con.prepareStatement("select * from shippingLine where shipLineId=?");
           ps.setInt(1,id);
           ResultSet rs=ps.executeQuery();
           if(!rs.next())
           { 
              out.print("Wrong ShipLine Id");
            }
           else
           { rs.beforeFirst();
                rs.next();
                if(pwd.equals(rs.getString("password")))
                {
                 RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
                 rd.forward(request, response);
                }
                else
                {
                 out.print("Wrong password");
                }
           
           }
        }catch (Exception e)
        { e.printStackTrace(out); }
        out.print("<a href='home.jsp'>Home<a>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
