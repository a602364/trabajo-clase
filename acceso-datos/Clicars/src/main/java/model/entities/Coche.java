package model.entities;

public class Coche {
	private int id;
	private String marca;
	private String foto;
	private String nombre;
	private String modelo;
	private int precio;
	private int precioAntes;
	private int anio;
	private int km;
	private int caballos;
	private int fav;

	public Coche(int id, String marca, String foto, String nombre, String modelo, int precio, int precioAntes, int anio,
			int km, int caballos, int fav) {
		super();
		this.id = id;
		this.marca = marca;
		this.foto = foto;
		this.nombre = nombre;
		this.modelo = modelo;
		this.precio = precio;
		this.precioAntes = precioAntes;
		this.anio = anio;
		this.km = km;
		this.caballos = caballos;
		this.fav = fav;
	}

	public Coche() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPrecioAntes() {
		return precioAntes;
	}

	public void setPrecioAntes(int precioAntes) {
		this.precioAntes = precioAntes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getFav() {
		return fav;
	}

	public void setFav(int fav) {
		this.fav = fav;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", foto=" + foto + ", nombre=" + nombre + ", modelo=" + modelo
				+ ", precio=" + precio + ", precioAntes=" + precioAntes + ", anio=" + anio + ", km=" + km
				+ ", caballos=" + caballos + ", fav=" + fav + "]";
	}

}
