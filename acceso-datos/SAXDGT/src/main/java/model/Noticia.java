package model;

public class Noticia {
	private String titulo;
	private String link;
	private String fechaPub;
	private String descrip;
	
	
	
	public Noticia() {
		super();
	}

	public Noticia(String titulo, String link, String fechaPub, String descrip) {
		super();
		this.titulo = titulo;
		this.link = link;
		this.fechaPub = fechaPub;
		this.descrip = descrip;
	}
	
	//getters y setters
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getFechaPub() {
		return fechaPub;
	}



	public void setFechaPub(String fechaPub) {
		this.fechaPub = fechaPub;
	}



	public String getDescrip() {
		return descrip;
	}



	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	
	//to string
	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + ", link=" + link + ", fechaPub=" + fechaPub + ", descrip=" + descrip + "]";
	}


	
	
	
	
	
}	
