package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> buttonCorsi;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextArea txtMessage;

    @FXML
    void greenButton(ActionEvent event) {
    	
    	txtMessage.clear();
    	Integer matricola;
    	Studente s;
    	try {
    		matricola = Integer.valueOf(txtMatricola.getText());
    	}
    	catch (NumberFormatException nfe) {
    		txtMessage.appendText("Non è stato inserito un codice numerico.\n");
    		throw new RuntimeException ("Errore di input.\n");
    	}
    	
    	s = model.getStudenteByMatricola(matricola);
    	
    	if (s.getNome() == null) {
    		txtNome.clear();
    		txtCognome.clear();
    		txtMessage.appendText("Il codice inserito non corrisponde a nessuna matricola.\n");
    		return;
    	}
    	
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	

    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {
    	
		txtNome.clear();
		txtCognome.clear();
    	
    	List<Corso> corsi = new ArrayList<>();
    	Integer matricola;
    	
    	try {
    		matricola = Integer.valueOf(txtMatricola.getText());
    	}
    	catch (NumberFormatException nfe) {
    		txtMessage.setText("Non è stato inserito un codice numerico.\n");
    		throw new RuntimeException ("Errore di input.\n");
    	}
    	
    	corsi = model.getCorsiByMatricola(matricola);
    	
    	if (corsi.size() == 0) {
    		txtMessage.setText("Il codice inserito non corrisponde a nessuna matricola.\n");
    		return;
    	}
    	
    	txtMessage.setText(String.format("%-11s", "CODINS") + String.format("%-10s", "CREDITI") + String.format("%-55s", "NOME DEL CORSO") + String.format("%-3s", "PD") + "\n\n");
    	
    	for (Corso c: corsi) {
    		txtMessage.appendText(String.format("%-11s", c.getCodins()) + String.format("%-10d", c.getCrediti()) + String.format("%-55s", c.getNome()) + String.format("%-3d", c.getPd()) + "\n");
    	}
    	
    }

    @FXML
    void handleCercaIscritti(ActionEvent event) {

    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	List<Studente> studenti = new ArrayList<> ();
    	
    	if (buttonCorsi.getValue() == null) {
    		txtMessage.setText("Prima ci cliccare questo bottone occorre selezionare un corso.\n");
    		return;
    	}
    	
    	studenti = model.getStudentiIscrittiAlCorso(buttonCorsi.getValue());
    	
    	
    	if (studenti.size() == 0) {
    		txtMessage.setText("Non è stato selezionato nessun corso.\n");
    		return;
    	}
    	
    	txtMessage.setText(String.format("%-15s", "MATRICOLA") + String.format("%-25s", "COGNOME") + String.format("%-25s", "NOME") + String.format("%-10s", "CORSO DI STUDIO") + "\n\n");
    	
    	for (Studente s: studenti) {
    		txtMessage.appendText(String.format("%-15s", s.getMatricola()) + String.format("%-25s", s.getCognome()) + String.format("%-25s", s.getNome()) + String.format("%-10s", s.getCds()) + "\n");
    	}

    }

    @FXML
    void handleCorsi(ActionEvent event) {

    }

    @FXML
    void handleIscrivi(ActionEvent event) {

    }

    @FXML
    void handleReset(ActionEvent event) {
    	
    	buttonCorsi.getSelectionModel().clearSelection();
    	
    	//Il seguente comando funziona (inspiegabilmente)
    	//solo se il bottone Reset viene cliccato due volte...
    	
    	buttonCorsi.setEditable(true);
    	buttonCorsi.setPromptText("Corsi");
    	buttonCorsi.setEditable(false);
    	
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtMessage.clear();
    	
    }

    @FXML
    void initialize() {
        assert buttonCorsi != null : "fx:id=\"buttonCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	buttonCorsi.getItems().addAll(model.getTuttiICorsi());
    	buttonCorsi.getItems().add(new Corso (null, null, null, null));
    }
}


