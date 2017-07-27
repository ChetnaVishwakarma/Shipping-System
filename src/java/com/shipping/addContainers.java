package com.shipping;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shipping.ConnectionProvider;

/**
 *
 * @author dashmeetkaur
 */
@WebServlet(urlPatterns = {"/addContainers"})
public class addContainers extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addContainer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addContainer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
             int size=Integer.parseInt(request.getParameter("size"));
         String type=request.getParameter("type");
         int capacity=Integer.parseInt(request.getParameter("capacity"));
         //int noOfItems=Integer.parseInt(request.getParameter("noOfItems"));
         int price=Integer.parseInt(request.getParameter("price"));
         Connection con=ConnectionProvider.getCon();
         PreparedStatement ps=con.prepareStatement("insert into container(type,size,capacity,status,price) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
         ps.setString(1,type);
         ps.setInt(2,size);
         ps.setInt(3,capacity);
         ps.setString(4,"free");
         ps.setInt(5, price);
         
        
         
         int status=ps.executeUpdate();
         if(status>0)
         {
             ResultSet rs=ps.getGeneratedKeys();
             rs.next();
             out.print("Added Conatiner Id: "+rs.getInt(1));
         }
         else{
             out.println("Something went wrong!!");
          }
     }catch(Exception e){} 
        out.print("<a href='home.jsp'>Home<a>");
        /*RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
         rd.forward(request,response);*/
        
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