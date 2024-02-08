/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import inc.Service;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Materiel;
import model.Poste;

/**
 *
 * @author ASUS
 */
@WebServlet("/listeposte")
public class ListePosteServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
                 Service dataService = new Service();
        request.setAttribute("connection",dataService.getConnection());
                 List<Poste> list = dataService.getAllPost();
//                 List<Materiel> listMat = dataService.getAllMateriel();
                 request.setAttribute("listeposte", list);
//                 request.setAttribute("listMatr",listMat);
        
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/listeposte.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);
//            e.printStackTrace();
        }
    }
    



}
