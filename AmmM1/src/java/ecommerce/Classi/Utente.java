package ecommerce.Classi;

public abstract class Utente{
        protected String id;
	protected String username;
	protected String password;
        protected String idConto;
	protected Conto saldo;


	/*Costruttore*/
	public Utente(){
                id="";
		username="";
		password="";
	}

	/*Metodi set e get*/
        public String getId(){
            return id;
        }
        public void setId(String id){
            this.id=id;
        }
        
	public String getUsername(){
            return username;
	}

	public void setUsername(String username){
		this.username=username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}
        
        public void setIdConto(String idConto){
            this.idConto=idConto;
        }
        
        public String getIdConto(){
            return idConto;
        }
        
        public void setConto(Conto saldo){
            this.saldo=saldo;
        }
}