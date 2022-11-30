package model.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entities.Marca;

public class DaoMarca {
	public ArrayList<Marca> getMarcas(Connection con) throws SQLException {

		ArrayList<Marca> marcas = new ArrayList<Marca>();
		Statement st = con.createStatement();
		String ordenSql = "SELECT  * FROM marca";
		ResultSet rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Marca marca = new Marca();
			marca.setId(rs.getInt("id"));
			marca.setNombre(rs.getString("nombre"));
			marcas.add(marca);

		}
		rs.close();
		st.close();

		return marcas;
	}
}
