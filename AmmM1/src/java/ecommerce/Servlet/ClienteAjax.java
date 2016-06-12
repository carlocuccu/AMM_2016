/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Servlet;

import ecommerce.Classi.ClientiFactory;
import ecommerce.Classi.Conto;
import ecommerce.Classi.ContoFactory;
import ecommerce.Classi.OggettiFactory;
import ecommerce.Classi.Oggetto;
import ecommerce.Classi.Utente;
import ecommerce.Classi.UtentiFactory;
import ecommerce.Classi.Venditore;
import ecommerce.Classi.VenditoriFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlo
 */
@WebServlet(name = "ClienteAjax", urlPatterns = {"/ClienteAjax"})
public class ClienteAjax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // Controlla se è stato inviato un commando
        
        String command = request.getParameter("cmd");
        if (command != null) 
        {
            // Verifica che commando e id siano stati impostati
            if (command.equals("search")) 
            {
                // Esegue la ricerca
                ArrayList<Oggetto> listaOggetti = OggettiFactory.getInstance()
                        .getOggettiList(request.getParameter("text"));
                
                request.setAttribute("listaOggetti", listaOggetti);
                
                // Quando si restituisce del json e' importante segnalarlo ed evitare il caching
                response.setContentType("application/json");
                response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                response.setHeader("Cache-Control", "no-store, no-cache, "
                        + "must-revalidate");
                // Genero il json con una jsp
                request.getRequestDispatcher("listaOggettiJson.jsp").
                        forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}