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
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;


@WebServlet("/MateriauxServlet")
public class MaterielStyleServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idStyle = request.getParameter("idStyle");
            Service data = new Service();
            List<Materiel> materiauxList = data.getMaterielByStyle(idStyle);

            // Mettez les matériaux dans l'attribut de la requête
            request.setAttribute("materiauxList", materiauxList);

            // Redirigez vers la page JSP pour afficher les résultats
            RequestDispatcher dispatcher = request.getRequestDispatcher("materiauxPage.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs
        }
    }
}


    



