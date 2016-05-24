/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Servlet;

import ecommerce.Classi.Utente;
import ecommerce.Classi.Cliente;
import ecommerce.Classi.ClientiFactory;
import ecommerce.Classi.ContoFactory;
import ecommerce.Classi.OggettiFactory;
import ecommerce.Classi.UtentiFactory;
import ecommerce.Classi.Venditore;
import ecommerce.Classi.VenditoriFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;

        try{
            Class.forName(JDBC_DRIVER);
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        OggettiFactory.getInstance().setConnectionString(dbConnection);
        UtentiFactory.getInstance().setConnectionString(dbConnection);
        ClientiFactory.getInstance().setConnectionString(dbConnection);
        VenditoriFactory.getInstance().setConnectionString(dbConnection);
        ContoFactory.getInstance().setConnectionString(dbConnection);
    }
    
    
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

            //Creazione della sessione
            HttpSession session = request.getSession(true);
            
            if(session != null){
                Integer userID=(Integer)session.getAttribute("id");
            }
             
            if(request.getParameter("Submit") != null)
            {
                String username = request.getParameter("Username");
                String password = request.getParameter("Password");
                
                Utente u = UtentiFactory.getInstance().getUtente(username, password);
                      
                /*Controlli su Username e Password*/
                if(u != null)
                {
                    session.setAttribute("loggedId", true);
                    session.setAttribute("id", u.getId()); //Inserisco l'Id dell'utente nell'atributo di sessione id

                    if(u instanceof Cliente)
                    {
                        session.setAttribute("isCliente", true);
                        session.setAttribute("isVenditore", false);
                        session.setAttribute("cliente", u);
                        request.setAttribute("listaOggetti", OggettiFactory.getInstance().getOggettiList());      
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    }
                    else
                    {
                        session.setAttribute("isVenditore", true);
                        session.setAttribute("isCliente", false);
                        session.setAttribute("venditore", u);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                }
                else
                {
                    request.setAttribute("loginError", true);
                } 
            }
            else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
