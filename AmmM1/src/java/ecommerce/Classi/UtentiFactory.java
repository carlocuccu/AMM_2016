/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Classi;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class UtentiFactory {
    
    private static UtentiFactory singleton;
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    private ArrayList<Utente> listaUtenti;
    
    /*Metodo che unisce le liste Venditore e Cliente in una listaUtenti*/
    public ArrayList<Utente> getUserList(){
        
        if(listaUtenti == null){
        
            ArrayList<Cliente> listaClienti = ClientiFactory.getInstance().getClienteList();
            ArrayList<Venditore> listaVenditori = VenditoriFactory.getInstance().getVenditoriList();
            
            listaUtenti = new ArrayList<Utente>();
            
            listaUtenti.addAll(listaClienti);
            listaUtenti.addAll(listaVenditori);
        }
        return listaUtenti;
        
    }
    
    public Utente getUtenteByID(String id){
        for(Utente u : listaUtenti)
        {
            if(u.id.equals(id))
                return u;
        }
        return null;
    }
}
