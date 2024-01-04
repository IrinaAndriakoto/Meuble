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

@WebServlet("/fabrication")
public class FabricationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
                 Service dataService = new Service();
        request.setAttribute("connection",dataService.getConnection());
                 List<V_getquantitemateriel> list = dataService.getAllQuantite();
//                 List<Materiel> listMat = dataService.getAllMateriel();
                 request.setAttribute("liste", list);
//                 request.setAttribute("listMatr",listMat);
        
        // Redirigez vers la page JSP d'affichage
        request.getRequestDispatcher("/WEB-INF/fabrication.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);
//            e.printStackTrace();
        }
    }
    


}
