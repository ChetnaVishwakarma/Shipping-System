/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shipping;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import shipping.ConnectionProvider;

/**
 *
 * @author dashmeetkaur
 */
@WebServlet(name = "addRoutes", urlPatterns = {"/addRoutes"})
public class addRoutes extends HttpServlet {

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
            out.println("<title>Servlet addRoute</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addRoute at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            String rname=request.getParameter("rName");
            int noOfStops=Integer.parseInt(request.getParameter("noOfStops"));
            int portid[]=new int[10];
            int i=0;
            String port[]=request.getParameterValues("stop");
            String day[]=request.getParameterValues("days");
            int noDays[]=new int[10];
            while(i<noOfStops)
            {
               portid[i]=Integer.parseInt(port[i]);
               noDays[i]=Integer.parseInt(day[i]);
               i++;
            }
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("insert into routes(rName) values (?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,rname);
            int s=ps.executeUpdate();
            if(s>0)
            {
                ResultSet rs=ps.getGeneratedKeys();
                rs.next();
                int rid=rs.getInt(1);
                ps=con.prepareStatement("insert into routeDetails values (?,?,?,?)");
                i=0;
                while(i<port.length)
                {
                    ps.setInt(1,rid);
                    ps.setInt(2,i+1);
                    ps.setInt(3,portid[i]);
                    ps.setInt(4,noDays[i]);
                    ps.executeUpdate();
                    i++;
                }
                out.println("Added route id: "+rid);
                out.print("<a href='home.jsp'>Home</a>");
            }
            else
            {
                out.print("Something went wrong!!");
                out.print("<a href='home.jsp'>Home<a>");
            }
            
            
            
        }catch(Exception e)
        { e.printStackTrace(out);
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
