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
public class ContoFactory {
    
    private static ContoFactory singleton;
    public static ContoFactory getInstance() {
        if (singleton == null) {
            singleton = new ContoFactory();
        }
        return singleton;
    }
    
    private ArrayList<Conto> listaConti = new ArrayList<Conto>();
    
    public ContoFactory(){
        
        //Conto1
        Conto conto1 = new Conto(2250.0, "cc1");
        listaConti.add(conto1);
        
        //Conto2
        Conto conto2 = new Conto(150.0, "cc2");
        listaConti.add(conto2);
        
        //Conto3
        Conto conto3 = new Conto(3650.0, "cc3");
        listaConti.add(conto3);

        //Conto4
        Conto conto4 = new Conto(1200.0, "cc4");
        listaConti.add(conto4);

        //Conto5
        Conto conto5 = new Conto(500.0, "cc5");
        listaConti.add(conto5);
        
        //Conto6
        Conto conto6 = new Conto(450.0, "cc6");
        listaConti.add(conto6);
    }
    
    public Conto getContoByID(String id){
        
        for(Conto c: listaConti){
            if(c.id.equals(id)){
                return c;
            }
        }
        return null;
    }
}
