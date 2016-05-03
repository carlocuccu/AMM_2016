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
public class ClientiFactory {
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
        
        /*Cliente 1*/
        Cliente cli1 = new Cliente();
        cli1.setId("c1");
        cli1.setUsername("RossiMario");
        cli1.setPassword("c1");
        cli1.setIdConto("cc1");
        cli1.setConto(ContoFactory.getInstance().getContoByID("cc1"));
        listaClienti.add(cli1);
        
        /*Cliente 2*/
        Cliente cli2 = new Cliente();
        cli2.setId("c2");
        cli2.setUsername("MauroFrau");
        cli2.setPassword("c2");
        cli2.setIdConto("cc2");
        cli2.setConto(ContoFactory.getInstance().getContoByID("cc2"));
        listaClienti.add(cli2);
        
        /*Cliente 3*/
        Cliente cli3 = new Cliente();
        cli3.setId("c3");
        cli3.setUsername("AnnaFabiani");
        cli3.setPassword("c3");
        cli3.setIdConto("cc3");
        cli3.setConto(ContoFactory.getInstance().getContoByID("cc3"));
        listaClienti.add(cli3);
    }  
    
    
    /* Metodi */
    public ArrayList<Cliente> getClienteList()
    {
        return listaClienti;
    }
    
    public Cliente getClienteByID(String id)
    {
        for(Cliente u : listaClienti)
        {
            if(u.id.equals(id))
                return u;
        }
        return null;
    }
    
    public String getIdContoById(String id){
        for(Cliente u : listaClienti)
        {
            if(u.id.equals(id))
                return u.idConto;
        }
        return null;
    }
}
