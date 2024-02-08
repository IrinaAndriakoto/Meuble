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
import java.sql.*;
import java.util.List;
import model.Materiel;
import model.V_salairepersonnel;

/**
 *
 * @author Irina
 */
@WebServlet("/listepersonnel")
public class ListePersonnelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
                 Service dataService = new Service();
        request.setAttribute("connection",dataService.getConnection());
                 List<V_salairepersonnel> list = dataService.getAllPersonnel();
                 request.setAttribute("liste", list);
                 Connection conn=dataService.getConnection();
                 
                 String sql = "UPDATE personnel SET idmetier = CASE WHEN EXTRACT(YEAR FROM AGE(CURRENT_DATE, dateembauche)) >= 5 THEN 3 WHEN EXTRACT(YEAR FROM AGE(CURRENT_DATE, dateembauche)) >= 2 THEN 2 ELSE 1 END";

                    // Créer un objet PreparedStatement
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    // Exécuter la requête SQL
                    pstmt.executeUpdate();
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/ListePersonnel.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);
//            e.printStackTrace();
        }
    }
    
}