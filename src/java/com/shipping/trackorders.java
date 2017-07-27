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
public class trackorders extends HttpServlet {

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
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet trackorders</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet trackorders at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int oId=Integer.parseInt(request.getParameter("oId"));
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("select coId from books where oId=?");
            ps.setInt(1,oId);
            ResultSet rs=ps.executeQuery();
            if(!rs.next())
            {
                out.print("This order is not loaded on ship yet!!");
                out.println("<br/><button onclick='history.go(-2)'>Back</button>");
                
            }
            else
            {rs.beforeFirst();
             rs.next();
            int coId=rs.getInt(1);
            ps=con.prepareStatement("select * from discharge where coId=?");
            ps.setInt(1,coId);
            ResultSet rs2=ps.executeQuery();
            if(rs2.next())
            {
                ps=con.prepareStatement("select * from port where portId=?");
            ps.setInt(1,rs2.getInt("portId"));
                ResultSet rs4=ps.executeQuery();
                rs4.next();
                out.println("Order is discharged at port "+ rs4.getString("pName"));
                out.println("<br/><button onclick='history.go(-2)'>Back</button>");
            }
            else
            {
            ps=con.prepareStatement("select shipId from loads where coId=?");
            ps.setInt(1,coId);
            ResultSet rs1=ps.executeQuery();
            rs1.next();
            int shipId=rs1.getInt(1);
            out.println("OId: "+oId);
            out.println("is in");
            RequestDispatcher rd=request.getRequestDispatcher("/trackShips?shipId="+shipId);
            
            rd.include(request, response);
            }
            }
            
            
            
          } catch(Exception e)
        {
            e.printStackTrace(out);
        }
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
