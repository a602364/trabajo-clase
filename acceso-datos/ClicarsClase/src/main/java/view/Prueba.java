package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import model.daos.DaoCoche;
import model.daos.DaoMarca;
import model.entities.Coche;
import model.entities.Marca;

public class Prueba {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = Conexion.conecta();
		ArrayList<Coche> coches=  new DaoCoche().getCoches("%","precio asc","%",con);
		ArrayList<Marca> marcas=  new DaoMarca().getMarcas(con);
		
		for(Coche coche : coches) {
		System.out.println(coche);
		}
	}

}
