/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class UtentiFactory {
    
    String connectionString;
    
    private static UtentiFactory singleton;
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    
    public Utente getUtente(String username, String password)
    {   
        Cliente cliente = new Cliente();
        Venditore venditore = new Venditore();
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu","0000");
            
            //Cliente
            // sql command
            String query = "select * from cliente where " + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                cliente.id = set.getInt("id");
                cliente.username = set.getString("username");
                cliente.password = set.getString("password");
                cliente.idConto = set. getInt("idconto");
      
                stmt.close();
                conn.close();
                
                return cliente;
            }
            
            //Venditore
            // sql command
            query = "select * from venditore where "+ "password = ? and username = ?";
            stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            set = stmt.executeQuery();
            
            if(set.next())
            {
                venditore.id = set.getInt("id");
                venditore.username = set.getString("username");
                venditore.password = set.getString("password");
                venditore.idConto = set.getInt("idconto");
                stmt.close();
                conn.close();
               
            }
            
            stmt.close();
            conn.close();
            return venditore;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
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
    
    
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
}
                     