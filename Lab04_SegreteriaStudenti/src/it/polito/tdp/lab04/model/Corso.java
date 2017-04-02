package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

public class Corso {
	
	private List<Studente> studenti;
	private String codins;
	private int crediti;
	private String nome;
	private int pd;
	
	
	
	public Corso(String codins) {
		
		this.codins = codins;
	}

	public Corso(String codins, int crediti, String nome, int pd) {
		
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}

	/**
	 * @return the codins
	 */
	public String getCodins() {
		return codins;
	}

	/**
	 * @return the crediti
	 */
	public int getCrediti() {
		return crediti;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the pd
	 */
	public int getPd() {
		return pd;
	}

	/**
	 * @param codins the codins to set
	 */
	public void setCodins(String codins) {
		this.codins = codins;
	}

	/**
	 * @param crediti the crediti to set
	 */
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param pd the pd to set
	 */
	public void setPd(int pd) {
		this.pd = pd;
	}
	
	public List<Studente> getStudenti() {
		if (studenti == null) {
			return new ArrayList<Studente>();
		}
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}
	
	
	
	

}
