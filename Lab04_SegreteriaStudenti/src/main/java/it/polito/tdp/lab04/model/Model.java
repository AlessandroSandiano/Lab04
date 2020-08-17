package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO cDAO;
	private StudenteDAO sDAO;
	
	public Model() {
		cDAO = new CorsoDAO ();
		sDAO = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi() {
		return cDAO.getTuttiICorsi();
	}

	public Studente getStudenteFromMatricola (int matricola) {
		return sDAO.getStudenteFromMatricola(matricola);
	}
	
}
