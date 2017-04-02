package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	
	StudenteDAO studenteDao;
	CorsoDAO corsoDao;
	
	public Model() {
		
		this.studenteDao = new StudenteDAO();
		this.corsoDao = new CorsoDAO();
		
	}

	public List<Corso> getTuttiICorsi() {
		
		
		return corsoDao.getTuttiICorsi();
		
		
	}
	
	public Studente getStudent(int matricola){
		
		
		Studente s = new Studente(matricola, null,null,null);
		
		if(studenteDao.getStudent(s))
			return s;
		else
			return null;
	}
	
	/**
	 * Questo é il metodo che richiama il controller, quindi dobbiamo passare come parametro il codice di un corso
	 * 
	 * @param codins
	 * @return
	 */
	
	
	public List<Studente> getStudentiIscrittiAlCorso(String codins) {
		
		
		Corso corso = new Corso(codins);
		corsoDao.getStudentiIscrittiAlCorso(corso);
		
		return corso.getStudenti();
		
		
	}
	
	/**
	 * Questo é il metodo che richiama il controller, quindi dobbiamo passare come parametro la matricola di uno studente
	 * 
	 * @param matricola
	 * @return
	 */
	
	public List<Corso> getCorsiDelloStudente(int matricola){
		
		Studente s = new Studente(matricola);
		studenteDao.getCorsiDelloStudente(s);
		
		return s.getCorsi();
		
		
	}
	
	/**
	 * Ritorna TRUE se lo studente è iscritto al corso, FALSE altrimenti
	 * @param corso
	 * @param studente
	 * @return
	 */
	
	public boolean isStudenteIscritto(int matricola){
		
		Studente s = new Studente(matricola);
		
		
		return studenteDao.isStudenteIscritto(s);
		
	}

}
