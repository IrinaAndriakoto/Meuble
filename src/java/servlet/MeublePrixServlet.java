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
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;

@WebServlet("/prixmeuble")
public class MeublePrixServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String prixMin = request.getParameter("prixMin");
        String prixMax = request.getParameter("prixMax");
        
        try{
        // Redirigez vers la page JSP d'affichage
        // Effectuer la requête et obtenir les résultats
        Service s = new Service();
        List<V_getPrixMateriel> resultats = s.getAllMeubleByPrix(prixMin, prixMax);

        // Stocker les résultats dans l'objet request
        request.setAttribute("resultats", resultats);
        request.setAttribute("prixMin",prixMin);
        request.setAttribute("prixMax",prixMax);
        request.getRequestDispatcher("/WEB-INF/meubleparprix.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);
//            e.printStackTrace();
        }
    }
}