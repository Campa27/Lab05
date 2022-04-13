package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
public boolean isCorrect(String parola) {
		
	final String sql = "select * "
			+ "from parola "
			+ "where nome = ?";
		
	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, parola);

		ResultSet rs = st.executeQuery();
			
		while (rs.next()) {

			if (rs.getString("nome").isBlank()){
				return false;
			} else {
				return true;
			}
		}

		conn.close();

	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
	}
		
	return false;
	}
}
