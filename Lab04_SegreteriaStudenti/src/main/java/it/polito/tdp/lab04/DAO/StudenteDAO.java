package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente getStudenteFromMatricola (int matricola) {
		
		Studente s = new Studente();
		
		final String sql = "SELECT nome, cognome FROM studente\r\n" + 
				"WHERE matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				
			}

			conn.close();
			
			return s;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore StudenteDAO", e);
		}
		
	}

}
