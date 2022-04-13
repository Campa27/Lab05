package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	String parola = null;
    	List<String> anagrammi;
    	
    	if(!txtParola.getText().equals("") && !txtParola.getText().equals(" ") && txtParola.getText().matches("[a-zA-Z]+")) {
    		parola = txtParola.getText();
    	} else {
    		txtCorretti.setText("Inserire una parola valida");
    	}
    	
    	anagrammi = this.model.anagramma(parola);
    	
    	for(String s : anagrammi) {
    		if(this.model.isCorrect(s)) {
    			txtCorretti.appendText(s + "\n");
    		}else {
    			txtErrati.appendText(s + "\n");
    		}
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
