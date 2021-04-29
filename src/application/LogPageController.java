package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class LogPageController extends Application{
	
	//Initializing a Label item for use in the Export method.
	@FXML
	Label txt2display;
	
	//Initialized a ListView item that displays the car list.
	@FXML
	ListView<String> loglist;
	
	@Override
	public void start(Stage primaryStage) {
	}
	
	//Method that loads the main menu scene used in the "Home" Button.
	@FXML
	private void loadMain(ActionEvent event) throws IOException {
		Parent main = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene mainScene = new Scene(main);
        mainStage.setScene(mainScene);
        mainStage.show();
	}
	
	//Method that loads the "AddPage.fxml" scene and is assigned to the "Add Car" Button.
	@FXML
	private void loadAddVehicle(ActionEvent event) throws IOException {
		Parent main = FXMLLoader.load(getClass().getResource("AddPage.fxml"));
        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene mainScene = new Scene(main);
        mainStage.setScene(mainScene);
        mainStage.show();
	}
	

	
	//Method that reads the list of Vehicle and displays them to the LogList ListView String variable in order to display the Text file's contents.
	//This method is assigned to the "Refresh Log" button.
	@FXML
	private void readVehicleList(ActionEvent event) throws IOException {
		
		Model.readVehicleList(loglist, txt2display);

	}
	
	

	//This method gets the user's highlighted row and writes it to the "VehicleExport.txt" file. It is assigned to the "Export" button.
	@FXML
	private void exportVehicle(ActionEvent event) throws IOException {

		Model.exportVehicle(loglist, txt2display);

			}
		
}
