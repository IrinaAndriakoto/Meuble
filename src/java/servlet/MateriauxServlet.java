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
import java.sql.*;

@WebServlet("/listeMateriel")
public class MateriauxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection connection = null;
        try{
                Service dataService = new Service();
                 connection = dataService.getConnection();
        request.setAttribute("connection",connection);
                 List<Materiel> list = dataService.getAllMateriel();
//                 System.out.println("Nombre de stocks récupérés : " + stock.size());
                 request.setAttribute("liste_materiel", list);
        
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/listeMateriaux.jsp").forward(request, response);
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
}
