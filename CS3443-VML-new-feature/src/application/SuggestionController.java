package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Model;
import model.Vehicle;

import java.io.IOException;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SuggestionController {
	AnchorPane mainPane;
	
	@FXML
    private TextField searchBar;
	
	@FXML
    private TextArea message;

	@FXML 
    public void handleClearButton(ActionEvent event) {
    	searchBar.clear();
    	message.clear();
    }
	
	@FXML
    public void checkVehicleList(ActionEvent event) throws IOException {
    	String vehicleToSearch = searchBar.getText().toString();
    	if( vehicleToSearch.length() < 3 )
    	{
    		Alert a = new Alert(AlertType.NONE);
    		// set alert type
    		a.setAlertType(AlertType.ERROR); 
    		// show the dialog 
    		a.show();
    		a.setContentText("Invalid name");
    		return;
    	}
    	Vehicle val = Model.getVehicle(vehicleToSearch);
    	message.setText(vehicleToSearch);
    }
	
	@FXML
    public void goToList(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("VehicleList.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
	
	@FXML
    public void switch2Main(ActionEvent event) throws IOException {
        mainPane = FXMLLoader.load(getClass().getResource("Menu.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
}