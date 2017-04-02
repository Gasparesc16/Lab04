package it.polito.tdp.lab04.controller;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	List<Corso> corsi = new LinkedList<Corso>();

	@FXML
	private ComboBox<Corso> comboCorso;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnCercaNome;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	public void setModel(Model model) {
		
		this.model = model;
		
		this.comboCorso.getItems().add(new Corso(null, 0, null, 0));
		
		this.comboCorso.getItems().addAll(model.getTuttiICorsi());


	}

	@FXML
	void doReset(ActionEvent event) {
		
		this.txtMatricola.clear();
		this.txtNome.clear();
		this.txtCognome.clear();
		this.txtResult.clear();

	}

	@FXML
	void doCercaNome(ActionEvent event) {
		
		txtResult.clear();
		txtNome.clear();
		txtCognome.clear();
		
		try{
		
		int matricola = Integer.parseInt(this.txtMatricola.getText());
		
		Studente s = model.getStudent(matricola);
		
		if(s == null){
			txtResult.appendText(" Matricola non presente!");
			return;
		}
			
		
		this.txtNome.setText(s.getNome());
		this.txtCognome.setText(s.getCognome());
		} catch (RuntimeException e){
			
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE!");

		}
			
			
		
		

	}

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {
		
		
		Corso corso = this.comboCorso.getValue();
		
		if(corso == null || corso.equals(new Corso(null, 0, null, 0))){
			
			this.txtResult.setText("Corso non scelto!");
			return;
		}
		else{
			
			List<Studente> studenti = model.getStudentiIscrittiAlCorso(corso.getCodins());
			txtResult.clear();
			
			for(Studente s: studenti)
				txtResult.appendText(s.getMatricola() + " " + s.getNome() + " " + s.getCognome() + "\n");
			
			return;
		}
		

	}

	@FXML
	void doCercaCorsi(ActionEvent event) {
		
		txtResult.clear();
		
	try{	
		// Seleziono il corso
		Corso corso = this.comboCorso.getValue();
		
		// seleziono la matricola
		int matricola = Integer.parseInt(this.txtMatricola.getText());
		
		List<Corso> corsi = model.getCorsiDelloStudente(matricola);
		
		
		if(corso == null || corso.equals(new Corso(null, 0, null, 0))){
			
			if(model.isStudenteIscritto(matricola) == false){
				this.txtResult.setText("Matricola non presente");
				return;
				
				} else{
					for(Corso c: corsi)
						txtResult.appendText(c.getCodins() + " " + c.getCrediti() + " " + c.getNome() + " " + c.getPd() + "\n");
					
					return;
					}
			
		} else if(corsi.contains(corso)){
			txtResult.setText("Lo studente é inscritto al corso selezionato! \n");
			return;
			
		} else{
			txtResult.setText("Lo studente non é inscritto al corso selezionato! \n");
			return;
		}
		
	}catch (NumberFormatException e){
		
		txtResult.setText("Errore nell'inserimento della matricola");
		return;
	}
	
	

	}

	@FXML
	void doIscrivi(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		
			}

}
