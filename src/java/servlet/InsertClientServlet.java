/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import inc.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nalya
 */
@WebServlet("/insertClient")
public class InsertClientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
        request.getRequestDispatcher("WEB-INF/insertClient.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
//        String dtn = request.getParameter("date_naissance");
        
//        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date dateNaiss = null;
        
        String genre = request.getParameter("genre");
        
        Connection connection = null;
        
        try {
//          dateNaiss= dateFormat.parse(dtn);
//          java.sql.Date date= new java.sql.Date(dateNaiss.getTime());
//          
            Service dataService = new Service();
                 connection = dataService.getConnection();
            request.setAttribute("connection",connection);

            dataService.insertClient(connection, nom, genre);

            // Fermer la connexion
            connection.close();

            // Rediriger vers une page de confirmation ou une autre page appropriée
            response.sendRedirect("confirmation.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Rediriger vers une page d'erreur avec le message d'erreur approprié
            request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'insertion du style : " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            // Gérer les erreurs SQL (par exemple, afficher un message d'erreur)
        } finally {
            // Assurez-vous de bien fermer la connexion dans le bloc finally
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
