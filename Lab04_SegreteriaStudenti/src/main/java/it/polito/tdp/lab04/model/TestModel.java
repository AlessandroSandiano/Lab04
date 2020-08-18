package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		
		Studente s = model.getStudenteByMatricola(146101);
		System.out.println(s.getNome() + " " + s.getCognome());
		
		List<Corso> corsi = new ArrayList<>();
		corsi = model.getCorsiByMatricola(146101);
		
		for (Corso c: corsi) {
			System.out.println(c.getCodins() + " " + c.getCrediti() + " " + c.getNome() + " " + c.getPd());
		}

	}

}
