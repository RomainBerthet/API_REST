package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bean.Ville;

public class VilleDAO {
	
	private static Logger logger = Logger.getLogger(VilleDAO.class.getName());
	
	private VilleDAO() {
	}

	public static List<Ville> listeVilles(String insee, String nomVille) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/TWIC?serverTimezone=Australia/Melbourne&user=root&password=");
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ville_france WHERE Code_commune_INSEE LIKE '%"+insee+"%' AND Nom_commune LIKE '%"+nomVille+"%' ORDER BY Nom_commune");
		ResultSet rst = pstmt.executeQuery();
		List<Ville> villes = new ArrayList<Ville>();	
		while(rst.next()) {
			Ville ville = new Ville(rst.getString("Code_commune_INSEE"), rst.getString("Nom_commune"), rst.getString("Code_postal"), rst.getDouble("Latitude"), rst.getDouble("Longitude"));
			villes.add(ville);
		}
		return villes;
	}

	private static Statement connection() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/TWIC?serverTimezone=Australia/Melbourne&user=root&password=");
			Statement stm = connect.createStatement();
			return stm;
		} catch (Exception e) {
			logger.log(Level.WARN, "Échec de la connexion à la base de données", e);
		}
		return null;
	}

	public static void ajouterModifVille(String insee, String nom, String cp, String lati, String longi) throws SQLException {
		List<Ville> ville = listeVilles(insee, "");
		System.out.println(ville.get(0).getNom());
		Statement stmt = connection();
		if (ville.size()>0) {
			stmt.executeUpdate("UPDATE ville_france SET Code_commune_INSEE='"+insee+"', Nom_commune='"+nom+"', Code_postal='"+cp+"', Latitude='"+lati+"', Longitude='"+longi+"' WHERE Code_commune_INSEE="+insee);
		} else {
			stmt.execute("INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Latitude, Longitude) VALUES ('"+insee+"', '"+nom+"', '"+cp+"', '"+lati+"', '"+longi+"')");
			
		}
	}

	public static void supprimerVille(String insee) throws SQLException {
		Statement stmt = connection();
		stmt.execute("DELETE FROM ville_france WHERE Code_commune_INSEE LIKE '"+insee+"'");
	}
}
