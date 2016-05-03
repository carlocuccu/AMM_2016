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
public class VenditoriFactory {
    
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
        
        //Venditore 1
        Venditore vend1 = new Venditore();
        vend1.setId("v1");
        vend1.setUsername("NotaShop");
        vend1.setPassword("v1");
        vend1.setIdConto("cc4");
        vend1.setConto(ContoFactory.getInstance().getContoByID("cc4"));
        listaVenditori.add(vend1);
        
        //Venditore 2
        Venditore vend2 = new Venditore();
        vend2.setId("v2");
        vend2.setUsername("Music4All");
        vend2.setPassword("v2");
        vend2.setIdConto("cc5");
        vend2.setConto(ContoFactory.getInstance().getContoByID("cc5"));
        listaVenditori.add(vend2);
        
        //Venditore 3
        Venditore vend3 = new Venditore();
        vend3.setId("v3");
        vend3.setUsername("SweetNote");
        vend3.setPassword("v3");
        vend3.setIdConto("cc6");
        vend3.setConto(ContoFactory.getInstance().getContoByID("cc6"));
        listaVenditori.add(vend3);
    }
    
    
    /* Metodi */
    public ArrayList<Venditore> getVenditoriList()
    {
        return listaVenditori;
    }
    
    public Venditore getVenditoreByID(String id)
    {
        for(Venditore v : listaVenditori)
        {
            if(v.id.equals(id))
                return v;
        }
        return null;
    }
}
