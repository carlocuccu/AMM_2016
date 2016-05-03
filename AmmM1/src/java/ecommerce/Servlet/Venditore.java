/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Servlet;

import ecommerce.Classi.OggettiFactory;
import ecommerce.Classi.Oggetto;
import ecommerce.Classi.UtentiFactory;
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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class Venditore extends HttpServlet {

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
        
        
        if (session != null && new Boolean (true).equals(session.getAttribute("loggedId")) && new Boolean(true).equals(session.getAttribute("isVenditore") )){
            
            if( request.getParameter("logout") != null){
                request.getSession().invalidate(); 
                request.getRequestDispatcher("descrizione.jsp").forward(request, response);
            }
            
            if(request.getParameter("Submit") != null){

                Oggetto newObj = new Oggetto();
                newObj.setId("o6");
                newObj.setVenditore(VenditoriFactory.getInstance().getVenditoreByID("id")); //Collego l'oggetto al venditore che l'ha inserito
                newObj.setNome(request.getParameter("nomeOggetto"));
                newObj.setUrlImmagine(request.getParameter("immagineOggetto"));
                newObj.setDescrizione(request.getParameter("descrizioneOggetto"));
                
                //Controllo se i campi inseriti sono null
                if(newObj.getNome() == null || newObj.getUrlImmagine() == null || newObj.getDescrizione() == null ){
                    String inputError="Campi incompleti. Compila tutti i campi per poter continuare";
                    request.setAttribute("inputError", inputError);
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                
                //Controllo se i campi inseriti sono tringhe vuote
                if(newObj.getNome() == "" || newObj.getUrlImmagine() == "" || newObj.getDescrizione() == "" ){
                    String inputError="Campi incompleti. Compila tutti i campi per poter continuare";
                    request.setAttribute("inputError", inputError);
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                
                /*Controlli sulla correttezza dei numeri inseriti*/
                try{
                    newObj.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
                }
                catch(NumberFormatException exception){
                    String inputError="Il prezzo inserito non è corretto. Inserisci un numero decimale ( , ).";
                    request.setAttribute("inputError", inputError);
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                
                try{
                    newObj.setQuantita(Integer.parseInt(request.getParameter("numeroOggetti")));
                }
                catch(NumberFormatException exception){
                    String inputError="La quantità inserita non è corretta. Inserisci un numero.";
                    request.setAttribute("inputError", inputError);
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
               
                
                OggettiFactory.getInstance().addOggettoList(newObj); //Aggiungo l'oggetto appena inserito alla lista
                request.setAttribute("nuovoOggetto", newObj);
                request.getRequestDispatcher("riepilogoInserimento.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
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
