package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Model;


public class AddPageController extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
	}
	
	//We initialize a Label and TextFields that will hold the user's input and display a success message.
	@FXML
	Label txtDisplay;
	@FXML	
	TextField txt1;
	@FXML	
	TextField txt2;
	@FXML	
	TextField txt3;
	@FXML	
	TextField txt4;
	@FXML	
	TextField txt5;
	@FXML	
	TextField txt6;
	
	//This method gets the user input from the 6 TextFields, it then calls the Model.addVehicle method in order to write the user's
	//entries into a text file. The method then displays a success message and clears all fields.
	//This method is assigned to the "Add Car" button.
	@FXML
	void addVehicle(ActionEvent event) throws IOException {
		
		String Make = txt1.getText().toString();
		String CarModel = txt2.getText().toString();
		String Year = txt3.getText().toString();
		String TotalMileage = txt4.getText().toString();
		String DateOfLastMaintenance = txt5.getText().toString();
		String MileageOfLastMaintenance = txt6.getText().toString();
			
		Model.addVehicle(Make, CarModel, Year, TotalMileage, DateOfLastMaintenance, MileageOfLastMaintenance);
		
		txtDisplay.setText("Successfully added car!");
		txt1.clear();
		txt2.clear();
		txt3.clear();
		txt4.clear();
		txt5.clear();
		txt6.clear();
		
	}
	
	//This method is assigned to the "Vehicle Log" button and is used to return to the LogPage scene.
	@FXML
	private void logPage(ActionEvent event) throws IOException {
		
		Parent main = FXMLLoader.load(getClass().getResource("LogPage.fxml"));
        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene mainScene = new Scene(main);
        mainStage.setScene(mainScene);
        mainStage.show();
       
	}

}
