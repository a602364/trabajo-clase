package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entities.Coche;

public class DaoCoche {
	public ArrayList<Coche> getCoches(String marca, String order, String search, String fav, Connection con) throws SQLException {

		ArrayList<Coche> coches = new ArrayList<Coche>();
		Statement st = con.createStatement(); // c.id, c.marca, c.foto, c.nombre, c.modelo, c.precio, c.anio, c.cv, c.km
		String ordenSql ="select * from coche c where marca like '"+marca+"' and (anio like '"+search+"' or nombre like '%"+search+"%' or modelo like '%"+search+"%') AND fav LIKE '" + fav + "' order by "+ order;  // c.id, c.marca, c.nombre, c.foto, c.modelo,
					
//				"SELECT * FROM coche c, marca m WHERE c.marca = m.id AND c.marca LIKE '" + marca
//				+ "' AND fav LIKE '" + fav + "' ORDER BY " + order;// c.precio, c.anio, c.km
		ResultSet rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Coche coche = new Coche();
			coche.setId(rs.getInt("id"));
			coche.setMarca(rs.getString("marca"));
			coche.setFoto(rs.getString("foto"));
			coche.setNombre(rs.getString("nombre"));
			coche.setModelo(rs.getString("modelo"));
			coche.setPrecio(rs.getInt("precio"));
			coche.setPrecioAntes(rs.getInt("precioAntes"));
			coche.setAnio(rs.getInt("anio"));
			coche.setCaballos(rs.getInt("cv"));
			coche.setKm(rs.getInt("km"));
			coche.setFav(rs.getInt("fav"));

			coches.add(coche);

		}
		rs.close();
		st.close();

		return coches;
	}

	public int updateFav(int id, int fav, Connection con) {
		int actualizados = -1;
		String ordenSQL = "update bici set fav=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setInt(1, fav);
			st.setInt(2, id);
			actualizados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos enla BDs: " + e.getMessage());
		}
		return actualizados;
	}
}
