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
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Metier;

@WebServlet("/insertMetier")
public class InsertMetierServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Connection connection = null;
        try{
                Service dataService = new Service();
                 connection = dataService.getConnection();
        request.setAttribute("connection",connection);
                 List<Metier> list = dataService.getAllMetier();

                 request.setAttribute("list", list);
        
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/insertMetier.jsp").forward(request, response);
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
        String metier = request.getParameter("metier");
        String salaire = request.getParameter("sal");

        Connection connection = null;
        
        try {
            // Établir la connexion à la base de données (assurez-vous d'avoir correctement configuré votre source de données / pool de connexions)
            // ...
            Service dataService = new Service();
                 connection = dataService.getConnection();
            request.setAttribute("connection",connection);
        // Récupérer le salaire associé à l'idMetier
        double salaireFinal = Double.parseDouble(salaire);

        if (null == metier) {
            throw new Exception ("Une erreur s'est produite");
        } else switch (metier) {
                case "2":
                    {
                        // Si le metier sélectionné est idmetier=2, ajuster le salaire
                        double salaireMetier1 = dataService.getSalaireByIdMetier(connection, 1);
                        // Insérer dans la base de données avec le salaire final
                        salaireFinal = salaireMetier1 * 2;
                        dataService.insertMetier(connection, metier, String.valueOf(salaireFinal));
                        // Fermer la connexion
                        connection.close();
                        // Rediriger vers une page de confirmation ou une autre page appropriée
                        response.sendRedirect("confirmation.jsp");
                        break;
                    }
            // Insérer dans la base de données avec le salaire final
                case "3":
                    {
                        double salaireMetier1 = dataService.getSalaireByIdMetier(connection, 1);
                        salaireFinal=salaireMetier1*3;
                        // Insérer dans la base de données avec le salaire final
                        dataService.insertMetier(connection, metier, String.valueOf(salaireFinal));
                        // Fermer la connexion
                        connection.close();
                        // Rediriger vers une page de confirmation ou une autre page appropriée
                        response.sendRedirect("confirmation.jsp");
                        break;
                    }
                default:
                    throw new Exception ("Une erreur s'est produite");
            }

        
        } catch (Exception e) {
            e.printStackTrace();
            // Rediriger vers une page d'erreur avec le message d'erreur approprié
            request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'insertion => " + e.getMessage());
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