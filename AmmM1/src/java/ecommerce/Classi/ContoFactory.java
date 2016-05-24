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
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class ContoFactory {
    
    String connectionString;
    
    private static ContoFactory singleton;
    public static ContoFactory getInstance() {
        if (singleton == null) {
            singleton = new ContoFactory();
        }
        return singleton;
    }
    
    private ArrayList<Conto> listaConti = new ArrayList<Conto>();
    
    public ContoFactory(){
       
    }
    
    public double getSaldoByID(Integer id){
        
        double current=0.0;
        
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            String query = "select saldo from conto where" + " id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id); //Passo alla query l'id del conto di cui voglio conoscere il saldo
            
            ResultSet set = stmt.executeQuery();

            if(set.next()) 
            {
                current = set.getDouble("saldo"); 
                
            } 
            
            stmt.close();
            conn.close();
            
            
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return current;
    }
    
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
}
