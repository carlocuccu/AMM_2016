package ecommerce.Classi;

public class Conto{
	Double saldo;
        String id;
        
        public Conto(Double saldo, String id){
            this.saldo=saldo;
            this.id=id;
        }
        
        public Double getSaldo(){
            return saldo;
        }
        
        public void addToSaldo(Double toAdd){
            this.saldo += toAdd;
        }
        
        public void subFromSaldo(Double toSub){
            this.saldo -= toSub;
        }
}
