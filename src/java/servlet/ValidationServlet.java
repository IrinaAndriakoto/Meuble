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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.*;

/**
 *
 * @author Irina
 */

@WebServlet("/validation")
public class ValidationServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            Connection connection = null;
            try{
                    Service dataService = new Service();
                    connection = dataService.getConnection();
        request.setAttribute("connection",connection);
                    List<V_getCommande> list = dataService.getAllCommandeNoValid();
                    
                    request.setAttribute("list",list);
            
            request.getRequestDispatcher("WEB-INF/validation.jsp").forward(request, response);
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        Connection connection =null;               


        Boolean v = true;
            try{
                Service serv = new Service();
                connection = serv.getConnection();
                request.setAttribute("connection",connection);
                        String nb = request.getParameter("nb");
        
        String idcommande = request.getParameter("idcommande");
                int nbC = Integer.parseInt(nb);
                String result = serv.updateStockAndHistorique(connection,nbC);

                if (!result.startsWith("La quantité du matériel est insuffisante.")) {
                    serv.valider(connection, idcommande, v);

                    connection.close();

                    // Rediriger vers une page de confirmation ou une autre page appropriée
                    response.sendRedirect("confirmation.jsp");
                } else {
                    // Gérer l'erreur
                    System.out.println(result);
                }
            }
            catch(Exception e){
            e.printStackTrace();
            // Rediriger vers une page d'erreur avec le message d'erreur approprié
            request.setAttribute("errorMessage", "Une erreur s'est produite  : " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
  
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
}

