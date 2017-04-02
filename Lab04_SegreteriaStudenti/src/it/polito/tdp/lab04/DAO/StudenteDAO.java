package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
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
	
	/**
	 * Questo metodo, dato una matricola dello studente mi deve restituire la lista dei corsi a cui é inscritto
	 * 
	 * In realtà controllo se il corso é presente oppure no con un boolean, ovvero gestisco l'errore!!!
	 */
	
	public boolean getCorsiDelloStudente(Studente studente){
		
		String sql = "SELECT * " +
                     " FROM iscrizione, corso " + 
		             " WHERE iscrizione.codins = corso.codins AND matricola= ?";  
				
		
		List<Corso> corsi = new LinkedList<Corso>();
		
		boolean valoreCorso = false;
	
	
	try {
		
		Connection conn = ConnectDB.getConnection();
		
		
		PreparedStatement st = conn.prepareStatement(sql);
		
	
		st.setInt(1, studente.getMatricola());
		
		
		ResultSet res = st.executeQuery();
		
		
		while(res.next()){
			
			valoreCorso = true;
			
			Corso c = new Corso( res.getString("codins"), res.getInt("crediti"), res.getString("nome"), res.getInt("pd") ) ;
			corsi.add(c);
			
			
			}
		
		studente.setCorsi(corsi);
		
	} catch (SQLException e) {

		throw new RuntimeException("Errore Db");
	}
	
	return valoreCorso;
		
		
		
	}


}
