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
public class ClientiFactory {
    
    String connectionString;
    
    private static ClientiFactory singleton;
    public static ClientiFactory getInstance() {
        if (singleton == null) {
            singleton = new ClientiFactory();
        }
        return singleton;
    }
    
    /*Lista Clienti*/
    private ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    
    /*Costruttore*/
    private ClientiFactory(){
        
    }  
    
    
    /* Metodi */
    
    //Restituisce la lista di tutti i Clienti
    public ArrayList<Cliente> getClienteList()
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from "+ "cliente";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Cliente current = new Cliente();
                current.setId(set.getInt("id"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setIdConto(set.getInt("idconto"));
                listaClienti.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
     
        return listaClienti;
    }
    
    
    // Dato un id restituisce il relativo cliente (se esiste un cliente con quell'id, altrimenti
    // restituisce null).
    public Cliente getClienteByID(Integer id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            String query = "select * from cliente "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
           
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Cliente current = new Cliente();
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
    
    
    
    public Integer getIdContoById(Integer id){
        for(Cliente u : listaClienti)
        {
            if(u.id.equals(id))
                return u.idConto;
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
