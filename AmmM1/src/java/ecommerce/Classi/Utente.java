package ecommerce.Classi;

public abstract class Utente{
        protected Integer id;
	protected String username;
	protected String password;
        protected Integer idConto;
	protected Conto saldo;


	/*Costruttore*/
	public Utente(){
                id=0;
		username="";
		password="";
	}

	/*Metodi set e get*/
        public Integer getId(){
            return id;
        }
        public void setId(Integer id){
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
        
        public void setIdConto(Integer idConto){
            this.idConto=idConto;
        }
        
        public Integer getIdConto(){
            return idConto;
        }
        
        public void setConto(Conto saldo){
            this.saldo=saldo;
        }
}