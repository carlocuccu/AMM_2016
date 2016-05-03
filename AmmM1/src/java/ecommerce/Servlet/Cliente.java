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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author carlo
 */
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"})
public class Cliente extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        
        
        if (session != null && new Boolean (true).equals(session.getAttribute("loggedId")) && new Boolean(true).equals(session.getAttribute("isCliente"))){
            
            request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiList());   
            
            if( request.getParameter("logout") != null){
                request.getSession().invalidate(); 
                request.getRequestDispatcher("descrizione.jsp").forward(request, response);
            }
            
            //Ramo che gestisce la pressione del pulsante carrello, relativo ad un oggetto
            if(request.getParameter("idObj") != null && request.getParameter("idConfermedObj") == null){
                Oggetto buyedObj = OggettiFactory.getInstance().getOggettoByID(request.getParameter("idObj"));
                
                request.setAttribute("oggettoSelezionato", buyedObj);
                request.getRequestDispatcher("riepilogoAcquisto.jsp").forward(request, response);      
            }
            else{
                if(request.getParameter("idObj") == null && request.getParameter("idConfermedObj") == null)
                    request.getRequestDispatcher("cliente.jsp").forward(request, response); 
            }
            
            //Ramo che gestisce la conferma d'acquisto dell'oggetto selezionato
            if(request.getParameter("idConfermedObj") != null){
                Oggetto buyedObj = OggettiFactory.getInstance().getOggettoByID(request.getParameter("idConfermedObj"));
                
                String idConto = ClientiFactory.getInstance().getIdContoById((String)session.getAttribute("id"));
                Conto contoCliente = ContoFactory.getInstance().getContoByID(idConto);

                Double prezzo = buyedObj.getPrezzo();
                
                if(contoCliente.getSaldo() >= prezzo && buyedObj.getQuantita() > 0){
                    
                    //Diminuisco di 1 il numero di oggetti a disposizione, fino ad esaurimento scorte
                    buyedObj.subQuantita(); 
                   
                    contoCliente.subFromSaldo(prezzo); //Sottraggo i soldi al cliente
                    
                    //*Accredito i soldi al venditore
                    Venditore objSeller =  buyedObj.getVenditore();                   
                    Conto contoVenditore = ContoFactory.getInstance().getContoByID(objSeller.getIdConto());
                    contoVenditore.addToSaldo(prezzo);
                    request.getRequestDispatcher("confermaAcquisto.jsp").forward(request, response); 
                }
                else{
                    if(buyedObj.getQuantita() < 1){
                        request.getRequestDispatcher("oggettoTerminato.jsp").forward(request, response); 
                    }
                    else{
                        request.getRequestDispatcher("denaroInsuff.jsp").forward(request, response); 
                    }
                }
            }
        }
        else
        {   
            request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
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
