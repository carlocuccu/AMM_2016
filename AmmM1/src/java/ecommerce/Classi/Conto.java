package ecommerce.Classi;

public class Conto{
	Double saldo;
        Integer id;
        
        public Conto(Double saldo, Integer id){
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
