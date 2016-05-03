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
public class OggettiFactory {
    
    private static OggettiFactory singleton;
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    
    /*Lista di utenti*/
    private ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
    
    //Costruttore
    private OggettiFactory(){
        
        //Oggetto 1
        Oggetto obj1 = new Oggetto();
        obj1.setId("o1");
        obj1.setNome("Fender Stratocaster Classic 50");
        obj1.setUrlImmagine("img/fender-classic-50s-stratocaster.jpg");
        obj1.setDescrizione("Una chitarra");
        obj1.setPrezzo(500.0);
        obj1.setQuantita(3);
        obj1.setVenditore(VenditoriFactory.getInstance().getVenditoreByID("v1"));
        listaOggetti.add(obj1);
        
        //Oggetto 2
        Oggetto obj2 = new Oggetto();
        obj2.setId("o2");
        obj2.setNome("Basso Fender Jazz");
        obj2.setUrlImmagine("img/fenderJazz.jpg");
        obj2.setDescrizione("Un basso");
        obj2.setPrezzo(700.0);
        obj2.setQuantita(20);
        //Assegno al campo venditore di ciascun oggetto un Venditore in base all'id del venditore
        obj2.setVenditore(VenditoriFactory.getInstance().getVenditoreByID("v1")); 
        listaOggetti.add(obj2);
        
        //Oggetto 3
        Oggetto obj3 = new Oggetto();
        obj3.setId("o3");
        obj3.setNome("Batteria Ludwig Classic Mapple");
        obj3.setUrlImmagine("img/classicMapple.jpg");
        obj3.setDescrizione("Una batteria");
        obj3.setPrezzo(1700.0);
        obj3.setQuantita(32);
        obj3.setVenditore(VenditoriFactory.getInstance().getVenditoreByID("v2"));
        listaOggetti.add(obj3);
        
        //Oggetto 4
        Oggetto obj4 = new Oggetto();
        obj4.setId("o4");
        obj4.setNome("Tamaky Classica");
        obj4.setUrlImmagine("img/tamaky.jpeg");
        obj4.setDescrizione("Una chitarra classica");
        obj4.setPrezzo(15.0);
        obj4.setQuantita(20);
        obj4.setVenditore(VenditoriFactory.getInstance().getVenditoreByID("v1"));
        listaOggetti.add(obj4);
        
        //Oggetto 5
        Oggetto obj5 = new Oggetto();
        obj5.setId("o5");
        obj5.setNome("Flauto Aulos");
        obj5.setUrlImmagine("img/aulos.jpg");
        obj5.setDescrizione("Un flauto");
        obj5.setPrezzo(10.0);
        obj5.setQuantita(347);
        obj5.setVenditore(VenditoriFactory.getInstance().getVenditoreByID("v3"));
        listaOggetti.add(obj5);
    }
    
     /* Metodi */
    public void addOggettoList(Oggetto newObj){
        listaOggetti.add(newObj);
    }
    
    public ArrayList<Oggetto> getOggettiList()
    {
        return listaOggetti;
    }
    
    public Oggetto getOggettoByID(String id)
    {
        for(Oggetto u : listaOggetti)
        {
            if(u.id.equals(id))
                return u;
        }
        return null;
    }    
}
