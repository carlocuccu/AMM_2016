package ecommerce.Classi;

public class Oggetto{
        Integer id;
	String nome;
	String urlImmagine;
        String descrizione;
	Double prezzo;
	int quantita;
        Integer idVenditore;
        Venditore seller;

	/*Costruttore*/
	public Oggetto(){
            id=0;
            nome="";
            urlImmagine="";
            descrizione="";
            prezzo=0.0;
            quantita=0;
	}

	/*Metodi*/
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id=id;
	}


	public String getNome(){
	    if(nome != null){
                return nome;
            }
            else{
                return null;
            }
	}

	public void setNome(String nome){
		this.nome=nome;
	}


	public String getUrlImmagine(){
	    if(urlImmagine != null){
                return urlImmagine;
            }
            else{
                return null;
            }
	}

	public void setUrlImmagine(String urlImmagine){
		this.urlImmagine=urlImmagine;
	}
        
        public String getDescrizione(){
            if(descrizione != null){
                return descrizione;
            }
            else
            {
                return null;
            }
        }
        
        public void setDescrizione(String descrizione){
            this.descrizione=descrizione;
        }
        
	public Double getPrezzo(){
		return prezzo;
	}

	public void setPrezzo(Double prezzo){
		this.prezzo=prezzo;
	}


	public int getQuantita(){
		return quantita;
	}

	public void setQuantita(int quantita){
		this.quantita=quantita;
	}
        
        public void setVenditore(Venditore seller){
            this.seller=seller;
        }
        
        public Venditore getVenditore(){
            return seller;
        }
        
        
        public void setIdVenditore(Integer id){
            this.idVenditore = id;
        }
        
        public int getIdVenditore(){
            return this.idVenditore;
        }
        
        public void subQuantita(){
            this.quantita --;
        }
}