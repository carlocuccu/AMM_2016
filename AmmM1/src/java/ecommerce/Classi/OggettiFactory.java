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
public class OggettiFactory {
    
    String connectionString;
    
    private static OggettiFactory singleton;
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    
    private ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
    
    //Costruttore
    private OggettiFactory(){
 
    }
    
     /* Metodi */
    public void addOggettoList(Oggetto newObj) throws SQLException{
        //listaOggetti.add(newObj);
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu","0000");
            Statement stmt = conn.createStatement();
            
            String query = "insert into oggetto (id, nome, urlimmagine, descrizione, prezzo, quantita, idvenditore)"
                            + "values (default, '" +  newObj.nome + "', '" 
                            + newObj.urlImmagine + "', '"
                            + newObj.descrizione + "', "
                            + newObj.prezzo + ", "
                            + newObj.quantita + ", "
                            + newObj.idVenditore + ") ";
            
            int rows = stmt.executeUpdate(query);
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Oggetto> getOggettiList()
    {    
        /*Lista di oggetti*/
        ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
        
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from " + "oggetto";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Oggetto current = new Oggetto();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setUrlImmagine(set.getString("urlimmagine"));
                current.setDescrizione(set.getString("descrizione"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setQuantita(set.getInt("quantita"));
                current.setIdVenditore(set.getInt("idvenditore"));
                listaOggetti.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaOggetti;
    }
    
    public ArrayList<Oggetto> getOggettiList( String text){
        
        ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            String query = "select * " +
                           "from oggetto " + 
                           "where oggetto.nome LIKE ? ";         
            PreparedStatement stmt = conn.prepareStatement(query);
            // Assegna dati
            text = "%"+text+"%";
            stmt.setString(1, text);
            
            ResultSet set = stmt.executeQuery();
            
            while(set.next())
            {
                Oggetto current = new Oggetto();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setUrlImmagine(set.getString("urlimmagine"));
                current.setDescrizione(set.getString("descrizione"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setQuantita(set.getInt("quantita"));
                current.setIdVenditore(set.getInt("idvenditore"));
                listaOggetti.add(current);
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {}
        
        return listaOggetti;
    }
    
    public Oggetto getOggettoByID(Integer id)
    {   
        Oggetto current = new Oggetto();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            String query = "select * from oggetto where" + " id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id); //Passo alla query l'id dell'oggetto appena selezionato dall'utente
            
            ResultSet set = stmt.executeQuery();
            
            //in questo caso dovrei ricevere solo una riga)
            if(set.next()) 
            {
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setUrlImmagine(set.getString("urlimmagine"));
                current.setDescrizione(set.getString("descrizione"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setQuantita(set.getInt("quantita"));
                current.setIdVenditore(set.getInt("idvenditore"));
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
    
    public ArrayList<Oggetto> getOggettiListByIdVenditore(Integer id){
        
        /*Lista di oggetti del venditore loggato*/
        ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
        
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            PreparedStatement stmt = null;
            String selectObj = "select * from " + "oggetto where idvenditore = ?";
            
            stmt = conn.prepareStatement(selectObj);
            stmt.setInt(1, id); //Inserisco l'id del venditore nella query
            ResultSet set = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Oggetto current = new Oggetto();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setUrlImmagine(set.getString("urlimmagine"));
                current.setDescrizione(set.getString("descrizione"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setQuantita(set.getInt("quantita"));
                current.setIdVenditore(set.getInt("idvenditore"));
                listaOggetti.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaOggetti;
    }
    
    public void rimuoviOggettoByID(Integer id){
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            PreparedStatement stmt = null;
            String selectObj = "delete from " + "oggetto where id = ?";
            
            stmt = conn.prepareStatement(selectObj);
            stmt.setInt(1, id); //Inserisco l'id dell'oggetto da rimuovere
            int rows = stmt.executeUpdate();

            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void modOggettoByID(int id, Oggetto modObj){
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "carlocuccu", "0000");
            PreparedStatement stmt = null;
            String updateQuery = "update oggetto set nome = ?, urlimmagine = ?, descrizione = ?, prezzo = ?, quantita = ? where id = ?" ;
            
            stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, modObj.getNome());
            stmt.setString(2, modObj.getUrlImmagine());
            stmt.setString(3, modObj.getDescrizione());
            stmt.setDouble(4, modObj.getPrezzo());
            stmt.setInt(5, modObj.getQuantita());
            
            stmt.setInt(6, id);
            
            int rows = stmt.executeUpdate();

            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    //Transazione
    public int confermaAcquisto (Oggetto buyedObj, int idVenditore, int idCliente) throws SQLException{
        
        int newQuantita = (int)(buyedObj.getQuantita()-1); //Nuova quantità dell'oggetto comprato
        int idOb = buyedObj.getId(); //ID dell'oggetto comprato
        double newSaldoCliente = (ContoFactory.getInstance().getSaldoByID(idCliente) - buyedObj.prezzo);
        double newSaldoVenditore = (ContoFactory.getInstance().getSaldoByID(idVenditore) + buyedObj.prezzo);
        
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().getConnectionString(),"carlocuccu","0000");
        
        PreparedStatement updateContoVenditore = null;
        PreparedStatement updateContoCliente = null;
        PreparedStatement updateOggetti = null;
        
        // Sql 
        String deleteOggetto = "update oggetto set quantita = ?" + " where id = ? ";
        String addMoney = "update conto set saldo = ?" + " where id = ?"; //Id del venditore
        String subMoney = "update conto set saldo = ? where id = ?"; //Id cliente
        
        try
        {
           conn.setAutoCommit(false);
           updateContoVenditore = conn.prepareStatement(addMoney);
           updateContoCliente = conn.prepareStatement(subMoney);
           updateOggetti = conn.prepareStatement(deleteOggetto);
           
           // Cancello oggetto (sottraggo 1 alla quantità)
           updateOggetti.setInt(1, newQuantita);
           updateOggetti.setInt(2, idOb);
           
           //Sottraggo i soldi al cliente
           updateContoCliente.setDouble(1, newSaldoCliente);
           updateContoCliente.setInt(2, idCliente);
           
           //Agggiungo i soldi al venditore
           updateContoVenditore.setDouble(1, newSaldoVenditore);
           updateContoVenditore.setInt(2, idVenditore);          
           
           int c1 = updateOggetti.executeUpdate();
           int c2 = updateContoCliente.executeUpdate();
           int c3 = updateContoVenditore.executeUpdate();
           
           if(c1 != 1 || c2 != 1 || c3 != 1)
               conn.rollback();
           
           conn.commit();
        }catch(SQLException e)
        {
            e.printStackTrace();
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                e2.printStackTrace();
            }
        }
        finally
        {
            if(updateContoCliente != null)
                updateContoCliente.close();
            if(updateContoVenditore != null)
                updateContoVenditore.close();
            if(updateOggetti != null)
                updateOggetti.close();
            
            conn.setAutoCommit(true);
            conn.close();
            
            return newQuantita;
        }    
    }
    
    
    
    
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
}
