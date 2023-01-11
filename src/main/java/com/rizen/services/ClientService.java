package com.rizen.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rizen.domain.Client;

public class ClientService {
	
	public void getClientData(String url, String user, String password, String requete) {
		List<Client> clientBD = new ArrayList<Client>();

		try {
			Connection cx = getConnectionDB(url, user, password);
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(requete);

			while (rs.next()) {
				System.out.println("id :" + rs.getString(1) + "name : " + rs.getString(2) + "age :" + rs.getString(4));
				System.out.println("-------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR :" + e.getMessage());
		}
		System.out.println(clientBD.toString());
	}

	private Connection getConnectionDB(String url, String user, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection cx = DriverManager.getConnection(url, user, password);
		return cx;
	}

}
