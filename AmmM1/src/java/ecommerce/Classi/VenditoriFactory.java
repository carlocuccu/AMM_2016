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
public class VenditoriFactory {
    
    String connectionString;
    
    private static VenditoriFactory singleton;
    public static VenditoriFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoriFactory();
        }
        return singleton;
    }
    
    /*Lista di utenti*/
    private ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
    
    /*Costruttore*/
    private VenditoriFactory(){
    
    }
    
    
    /* Metodi */
    
    //Restituisce la lista di tutti i Venditori
    public ArrayList<Venditore> getVenditoriList()
    {
         try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "venditore'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Venditore current = new Venditore();
                current.setId(set.getInt("id"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setIdConto(set.getInt("idconto"));
                listaVenditori.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    public Venditore getVenditoreByID(Integer id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            String query = "select * from venditore " + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
           
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Venditore current = new Venditore();
                current.setId(res.getInt("id"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setIdConto(res.getInt("idconto"));
                
                stmt.close();
                conn.close();
                return current;
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
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
