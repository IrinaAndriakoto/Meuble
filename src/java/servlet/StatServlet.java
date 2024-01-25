/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import inc.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Materiel;
import model.Client;
import model.V_getCommande;

/**
 *
 * @author Irina
 */
@WebServlet("/stat")
public class StatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
                 Service dataService = new Service();
        request.setAttribute("connection",dataService.getConnection());
                 List<Client> list = dataService.getAllClients();
                 List<V_getCommande> cm = dataService.getAllCommande();
                 request.setAttribute("cl", list);
                 request.setAttribute("commande",cm);
        
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/stat.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);
//            e.printStackTrace();
        }
    }
    


}
