package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtnumber;

    @FXML
    private TextField txtword;

    @FXML
    private Button btngraph;

    @FXML
    private Button btnvicini;

    @FXML
    private Button btngradomax;

    @FXML
    private TextArea txtoutput;

    @FXML
    private Button btnreset;

    @FXML
    void handlegradomax(ActionEvent event) {
    		txtoutput.appendText(""+model.findMaxDegree()+" "+model.getVertexMax()+"\n");
    }

    @FXML
    void handlegrafo(ActionEvent event) {
    		int n = Integer.parseInt(txtnumber.getText());
    		txtoutput.appendText(""+model.createGraph(n).toString()+"\n");
    }

    @FXML
    void handlereset(ActionEvent event) {
    		txtnumber.clear();
    		txtword.clear();
    		txtoutput.clear();
    }

    @FXML
    void handlevicini(ActionEvent event) {
    		String p = txtword.getText();
    		txtoutput.appendText(""+model.displayNeighbours(p).toString());
    }

    @FXML
    void initialize() {
        assert txtnumber != null : "fx:id=\"txtnumber\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtword != null : "fx:id=\"txtword\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btngraph != null : "fx:id=\"btngraph\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnvicini != null : "fx:id=\"btnvicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btngradomax != null : "fx:id=\"btngradomax\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtoutput != null : "fx:id=\"txtoutput\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnreset != null : "fx:id=\"btnreset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
    }
    
    public void setModel(Model model) {
		this.model = model;
}
    
}
