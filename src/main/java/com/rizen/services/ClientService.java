package com.rizen.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.rizen.domain.Client;
import com.rizen.domain.Produit;
import com.rizen.utils.Constantes;

public class ClientService {

	private Connection getConnectionDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cx = DriverManager.getConnection(Constantes.URL_DB, Constantes.USER_DB, Constantes.PASSWORD_DB);
		return cx;
	}

	
	public Client getClientByClientId(Long clientId) {

		String selectClientByIdQuery = "select idclient, nom, prenom, age, adresse from client where idclient = "
				+ clientId;

		try {

			Connection cx = getConnectionDB();
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(selectClientByIdQuery);

			Client clientFound = new Client();

			if(rs.next()) {
				clientFound = new Client(rs.getLong("idclient"), rs.getString("nom"), rs.getString("prenom"),
						rs.getLong("age"), rs.getString("adresse"));
			}

			return clientFound;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Client - ERROR : Impossible de trouver le client demandé !");
		}

		return null;

	}
	
	
	
	public List<Client> getAllClient() {
		String selectAllProduitQuery = "select * from client";
		
		try {
			Connection cx = getConnectionDB();
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(selectAllProduitQuery);
			
			Client clientAll = new Client();
			
			if(rs.next()) {
				System.out.println("idclient : " + rs.getLong(1) + " nom : " + rs.getString(2) + " prenom : " + rs.getString(3) + "age :" +rs.getLong(4) + " adresse : " + rs.getString(5));
				System.out.println("-------------------------");
		}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public void postClientByClient(Client client) {
		
		String AddClientByIdRequete = "insert into client (nom, prenom, age, adresse) values('AKENG', 'Gildas', '19', 'Bitam')";
		
		try {
			
			Connection cx = getConnectionDB();
			Statement st = cx.createStatement();
			st.executeUpdate(AddClientByIdRequete);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un nouveau client");
		}		

	}

	

	
}
