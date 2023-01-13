package com.rizen.services;

import java.sql.*;

import com.rizen.domain.Client;
import com.rizen.domain.Produit;
import com.rizen.utils.Constantes;


public class ProduitService {
	
	private Connection getConnectionDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cx = DriverManager.getConnection(Constantes.URL_DB, Constantes.USER_DB, Constantes.PASSWORD_DB);
		return cx;
	}
	
	
	public Produit getProduitByIdProduit(Long idProduit) {
		
		String findProduitById = "select idProduit, reference, nomProduit, Stock from produit where idproduit = " + idProduit;
				
		try {
			Connection cx = getConnectionDB();
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(findProduitById);
			
			Produit findProduit = new Produit();
			
			if(rs.next()) {
//				System.out.println("idProduit : " + rs.getString(1) + "reference : " + rs.getString(2) + "nomProduit : " + rs.getString(3) + "Stock : " + rs.getString(4));
				
				findProduit = new Produit(rs.getLong("idProduit"), rs.getString("reference"), rs.getString("nomProduit"),
						rs.getLong("Stock"));
			}
			
			return findProduit;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ce produit n'est pas dans la base");
		}


		return null;

	}
	
	
	public void postProduit(Produit produit) {
		String addProduit = "insert into produit (reference, nomProduit, Stock) values ('8132', 'Arachide', '3887')";
		
		try {
			Connection cx = getConnectionDB();
			Statement st = cx.createStatement();
			st.executeUpdate(addProduit);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No add");
		}
		
	}

}
