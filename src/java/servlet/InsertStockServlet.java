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
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

@WebServlet("/insertStock")
public class InsertStockServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        Connection connection = null;
        try{
                Service dataService = new Service();
                 connection = dataService.getConnection();
        request.setAttribute("connection",connection);
                 List<Materiel> list = dataService.getAllMateriel();

                 request.setAttribute("liste_materiel", list);
        
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/insertStock.jsp").forward(request, response);
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
        String materiel= request.getParameter("materiel");
        String qte = request.getParameter("qtestock");
        String date = request.getParameter("dat");
        Connection connection = null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateUtil = null;
        
        try {
            
            Service dataService = new Service();
                 connection = dataService.getConnection();
            request.setAttribute("connection",connection);

            dateUtil = dateFormat.parse(date);
            
            dataService.insertStock(connection, qte, materiel);  

            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
            dataService.insertHistoriqueStock(connection,materiel,qte,dateSql,true,false);
            connection.close();

            response.sendRedirect("confirmation.jsp");
        } catch (Exception e) {
            e.printStackTrace();
      
            request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'insertion du stock : " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            
        } finally {
            
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