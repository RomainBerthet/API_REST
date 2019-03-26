package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Ville;

public class VilleDAO {

	public static List<Ville> listeVilles() throws SQLException {
		Statement stmt = connection();
		ResultSet rst = stmt.executeQuery("SELECT * FROM ville_france");
		List<Ville> villes = new ArrayList<Ville>();	
		while(rst.next()) {
			Ville ville = new Ville(rst.getInt("Code_commune_INSEE"), rst.getString("Nom_commune"), rst.getInt("Code_postal"), rst.getString("Latitude"), rst.getString("Longitude"));
			villes.add(ville);
		}
		return villes;
	}

	private static Statement connection() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/TWIC?user=root&password=");
			Statement stm = connect.createStatement();
			return stm;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
