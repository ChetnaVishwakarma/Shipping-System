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
public class addShips extends HttpServlet {

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
     
   PrintWriter out = response.getWriter();
    try{
         String shipname=request.getParameter("shipName");
         String type=request.getParameter("type");
         int noOfContainers=Integer.parseInt(request.getParameter("noOfContainers"));
         int slotAvailability=Integer.parseInt(request.getParameter("slotAvailable"));
         int shipLineId=Integer.parseInt(request.getParameter("shipLineId"));
         int rId=Integer.parseInt(request.getParameter("rId"));
         Connection conn=ConnectionProvider.getCon();
         PreparedStatement ps=conn.prepareStatement("insert into ship(shipName,type,noOfContainers,slotAvailability,shipLineId,rId) values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
         ps.setString(1,shipname);
         ps.setString(2,type);
         ps.setInt(3,noOfContainers);
         ps.setInt(4,slotAvailability);
         ps.setInt(5,shipLineId);
         ps.setInt(6,rId);
         
         int status=ps.executeUpdate();
         
         if(status>0)
         {
             ResultSet rs=ps.getGeneratedKeys();
             rs.next();
             out.print("Added Ship Id: "+rs.getInt(1));
         }
         else{
             out.println("Something went wrong!!");}
         /*RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
         rd.include(request,response);*/
        
    }
     catch(Exception e){
         e.printStackTrace(out);
     }  
     out.print("<a href='home.jsp'>Home</a>");
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
