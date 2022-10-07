package view;

import java.util.ArrayList;

import manejador.ManejadorWeb;

import model.Noticia;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManejadorWeb manejador = new ManejadorWeb("https://infocar.dgt.es/etraffic/rss_ca_13.xml");
		ArrayList<Noticia> noticias = manejador.parsear();
			
		for (Noticia noticia: noticias) {
			System.out.println(noticias);
		}
	}

}
