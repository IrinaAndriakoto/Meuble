/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import inc.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import model.Poste;

/**
 *
 * @author Irina
 */
@WebServlet("/insertPers")
public class InsertionPersonnel extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Connection connection = null;
        
        try{
            Service d = new Service();
        connection = d.getConnection();
        request.setAttribute("connection",connection);
            List<Poste> p = d.getAllPost();
            request.setAttribute("poste", p);
            request.getRequestDispatcher("WEB-INF/insertPersonnel.jsp").forward(request, response);
        
        }catch(Exception e){
            e.printStackTrace();
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
        String nom = request.getParameter("nompers");
        // Récupérer la valeur du champ date
        String dateString = request.getParameter("dtn");
        String dateemb = request.getParameter("embauche");
        String p = request.getParameter("post");
        // Convertir la chaîne en objet Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateUtil = null;
        java.util.Date dateEmb = null;
        Connection connection = null;
        
        try {
            // Établir la connexion à la base de données (assurez-vous d'avoir correctement configuré votre source de données / pool de connexions)
            // ...
            
            dateUtil = dateFormat.parse(dateString);
            dateEmb = dateFormat.parse(dateemb);
            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
            java.sql.Date dat = new java.sql.Date(dateEmb.getTime());
            Service dataService = new Service();
            connection = dataService.getConnection();
            request.setAttribute("connection",connection);
            
            int age = dataService.calculerAge(dateSql);
            
            if (age < 18) {
                throw new IllegalArgumentException("Trop jeune pour travailler ici , il faut avoir minimum 18 ans");
            } else {
                dataService.insertPersonnel(connection, nom,dateSql,dat,p);
            }

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
