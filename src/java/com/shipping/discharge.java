/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shipping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shipping.ConnectionProvider;

/**
 *
 * @author dashmeetkaur
 */
public class discharge extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet discharge</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet discharge at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int shipId=Integer.parseInt(request.getParameter("shipId"));
            int portId=Integer.parseInt(request.getParameter("pId"));
            int coId=Integer.parseInt(request.getParameter("coId"));
       
            Connection con=ConnectionProvider.getCon();
            PreparedStatement p=con.prepareStatement("insert into discharge(shipId,portId,coId) values(?,?,?)");
            p.setInt(1,shipId);
            p.setInt(2,portId);
            p.setInt(3,coId);
            
            int re=p.executeUpdate();
            
            PreparedStatement ps=con.prepareStatement("update container set status='free' where coId=?");
            ps.setInt(1,coId);
            
            int re2=ps.executeUpdate();
           
            
            if(re>0 && re2>0)
            {
                out.print("Container successfully discharged!!");
                 
            }
            else
            {
                out.print("Internal error!!");
            }
        }catch(Exception e)
        {
            e.printStackTrace(out);
        }
        out.print("<br/><br/><a href=home.jsp>Go to Main Menu</a>");
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
