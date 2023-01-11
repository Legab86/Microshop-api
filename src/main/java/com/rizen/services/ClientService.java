package com.rizen.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rizen.domain.Client;
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

}
