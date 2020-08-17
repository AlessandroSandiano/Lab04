package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		
		Studente s = model.getStudenteFromMatricola(146101);
		System.out.println(s.getNome() + " " + s.getCognome());
		
		

	}

}
