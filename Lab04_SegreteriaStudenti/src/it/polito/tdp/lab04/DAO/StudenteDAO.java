package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Studente;



public class StudenteDAO {
	
	
	/**
	 * Data una matricola ottengo uno studente
	 * 
	 * @param matricola
	 * @return
	 */
	
	public boolean getStudent(Studente studente){
		
		
		String sql = "SELECT matricola,cognome,nome,cds " +
	                 " FROM studente " + 
			         " WHERE matricola= ?";  
		
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			
			
			PreparedStatement st = conn.prepareStatement(sql);
			
		
			st.setInt(1, studente.getMatricola());
			
			
			ResultSet res = st.executeQuery();
			
			
			if(res.next()){
				
				studente.setNome(res.getString("nome"));
				studente.setCognome(res.getString("cognome"));
				studente.setCds(res.getString("cds"));
				return true;
			}
			else
				return false;
			
		} catch (SQLException e) {

			throw new RuntimeException("Errore Db");
		}
		
	}
	
	


}
