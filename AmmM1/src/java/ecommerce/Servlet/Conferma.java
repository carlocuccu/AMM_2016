/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Servlet;

import ecommerce.Classi.Conto;
import ecommerce.Classi.ContoFactory;
import ecommerce.Classi.OggettiFactory;
import ecommerce.Classi.Oggetto;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlo
 */
@WebServlet(name = "Conferma", urlPatterns = {"/riepilogoAcquisto.html"})
public class Conferma extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
       /*  if(request.getParameter("Confirm") != null){
                Oggetto buyedObj = OggettiFactory.getInstance().getOggettoByID(parseInt(request.getParameter("idObj")));
                Conto contoCliente = ContoFactory.getInstance().getContoByID(parseInt("id"));
                Double prezzo = buyedObj.getPrezzo();
                
                if(contoCliente.getSaldo() >= prezzo ){
                    
                    contoCliente.subFromSaldo(prezzo); //Sottraggo i soldi al cliente
                    
                    //Accredito i soldi al venditore*
                    ecommerce.Classi.Venditore objSeller =  buyedObj.getVenditore();                   
                    Conto contoVenditore = ContoFactory.getInstance().getContoByID(objSeller.getId());
                    
                    contoVenditore.addToSaldo(prezzo);  
       
                    request.getRequestDispatcher("confermaAcquisto.jsp").forward(request, response); 
                }
            } */
        
        request.getRequestDispatcher("confermaAquisto.jsp").forward(request, response);
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
