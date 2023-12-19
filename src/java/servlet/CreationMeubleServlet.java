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

@WebServlet("/creationMeuble")
public class CreationMeubleServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            Connection connection = null;
            try{
                    Service dataService = new Service();
                    connection = dataService.getConnection();
                    request.setAttribute("connection",connection);
                    List<Taille> taille = dataService.getAllTaille();
                    request.setAttribute("get_tailles", taille);
                    List<Categorie> categorie = dataService.getAllCategorie();
                    request.setAttribute("get_categories", categorie);
                    List<Style> style = dataService.getAllStyle();
                    request.setAttribute("get_styles", style);
            
            request.getRequestDispatcher("WEB-INF/creationMeuble.jsp").forward(request, response);
            }
            catch(Exception e){
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