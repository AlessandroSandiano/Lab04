package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
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

    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {
    	
    }

    @FXML
    void handleCercaIscritti(ActionEvent event) {

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
    	
    	/*buttonCorsi.setEditable(true);
    	buttonCorsi.setPromptText("Corsi");
    	buttonCorsi.setEditable(false);*/
    	
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
    	buttonCorsi.getItems().add(new Corso (null, null, "", null));
    }
}


