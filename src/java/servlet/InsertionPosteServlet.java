/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

/**
 *
 * @author Irina
 */
import inc.Service;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

@WebServlet("/insertPoste")
public class InsertionPosteServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        Connection connection = null;
        try{
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/insertPoste.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);
//            e.printStackTrace();
        }
         finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
              

    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p= request.getParameter("poste");
        String sal = request.getParameter("salaire");
        Connection connection = null;
        
        try {
            
            Service dataService = new Service();
                 connection = dataService.getConnection();
            request.setAttribute("connection",connection);
            
            dataService.insertPoste(connection, p, sal);  

            connection.close();

            response.sendRedirect("confirmation.jsp");
        } catch (Exception e) {
            e.printStackTrace();
      
            request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'insertion : " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            
        } finally {
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}