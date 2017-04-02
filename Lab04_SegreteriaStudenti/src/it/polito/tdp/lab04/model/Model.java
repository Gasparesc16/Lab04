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
	
	
	public List<Studente> getStudentiIscrittiAlCorso(String codins) {
		
		
		Corso corso = new Corso(codins);
		corsoDao.getStudentiIscrittiAlCorso(corso);
		return corso.getStudenti();
		
		
	}

}
