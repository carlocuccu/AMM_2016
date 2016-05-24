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
 * @author carlo
 */
@WebServlet(name = "OggettiVenditore", urlPatterns = {"/oggettiVenditore.html"})
public class OggettiVenditore extends HttpServlet {

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
        
        
        if (session != null && new Boolean (true).equals(session.getAttribute("loggedId")) && new Boolean(true).equals(session.getAttribute("isVenditore"))){
            
            int idVenditore = (int) session.getAttribute("id");
            
            request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiListByIdVenditore(idVenditore));   
            
            if( request.getParameter("logout") != null){
                request.getSession().invalidate(); 
                request.getRequestDispatcher("descrizione.jsp").forward(request, response);
            }
                        
            //Ramo che gestisce la pressione del pulsante modifica
            String mod = new String("m");
            if( request.getParameter("idObj") != null && mod.equals(request.getParameter("act")) ){
                
                int idObj = parseInt(request.getParameter("idObj"));
                request.setAttribute("idObj", idObj);
                request.setAttribute("act", mod);
                
                
                if(request.getParameter("Submit") != null){
                    
                    Oggetto modObj = new Oggetto(); 
                    modObj.setId(idObj);
                    modObj.setIdVenditore((Integer)session.getAttribute("id"));
                    modObj.setNome(request.getParameter("nomeOggetto"));
                    modObj.setUrlImmagine(request.getParameter("immagineOggetto"));
                    modObj.setDescrizione(request.getParameter("descrizioneOggetto"));

                     //Controllo se i campi inseriti sono null
                    if(modObj.getNome() == null || modObj.getUrlImmagine() == null || modObj.getDescrizione() == null ){
                        String inputError="Campi incompleti. Compila tutti i campi per poter continuare";
                        request.setAttribute("inputError", inputError);
                        request.getRequestDispatcher("modOggetto.jsp").forward(request, response);
                    }

                    //Controllo se i campi inseriti sono tringhe vuote
                    if(modObj.getNome() == "" || modObj.getUrlImmagine() == "" || modObj.getDescrizione() == "" ){
                        String inputError="Campi incompleti. Compila tutti i campi per poter continuare";
                        request.setAttribute("inputError", inputError);
                        request.getRequestDispatcher("modOggetto.jsp").forward(request, response);
                    }

                    /*Controlli sulla correttezza dei numeri inseriti*/
                    try{
                        modObj.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
                    }
                    catch(NumberFormatException exception){
                        String inputError="Il prezzo inserito non è corretto. Inserisci un numero decimale ( , ).";
                        request.setAttribute("inputError", inputError);
                        request.getRequestDispatcher("modOggetto.jsp").forward(request, response);
                    }

                    try{
                        modObj.setQuantita(Integer.parseInt(request.getParameter("numeroOggetti")));
                    }
                    catch(NumberFormatException exception){
                        String inputError="La quantità inserita non è corretta. Inserisci un numero.";
                        request.setAttribute("inputError", inputError);
                        request.getRequestDispatcher("modOggetto.jsp").forward(request, response);
                    }

                    //Richiamo il metodo per la modifica, passando id dell'oggetto e oggetto d'appoggio 
                    //per conservare i nuovi dati inseriti
                    OggettiFactory.getInstance().modOggettoByID(idObj, modObj);
                    request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiListByIdVenditore(idVenditore));   
                    request.getRequestDispatcher("oggettiVenditore.jsp").forward(request, response); 
                }
                else{
                    request.getRequestDispatcher("modOggetto.jsp").forward(request, response);
                }
            }
            else{
                String remove = "r";
                //Ramo che gestisce pressione del pulsante rimuovi
                if(request.getParameter("idObj") != null && remove.equals(request.getParameter("act"))){
                        OggettiFactory.getInstance().rimuoviOggettoByID(parseInt(request.getParameter("idObj")));
                        request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiListByIdVenditore(idVenditore));   
                        request.getRequestDispatcher("oggettiVenditore.jsp").forward(request, response); 
                }
                else{
                    if(request.getParameter("idObj") == null)
                        request.getRequestDispatcher("oggettiVenditore.jsp").forward(request, response); 
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
