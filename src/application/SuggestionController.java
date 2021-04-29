package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Model;
import model.Vehicle;

public class SuggestionController {
	AnchorPane mainPane;
	
	@FXML
    private TextField timeField;
	
	@FXML
	private TextField repairShop;
	
	@FXML
    private TextField searchBar;
	
	@FXML
    private TextArea message = new TextArea();

	@FXML 
    public void handleClearButton(ActionEvent event) {
    	searchBar.clear();
    	message.clear();
    }
	
	@FXML
    private Button exportButton;
	
	 @FXML
    private DatePicker appointDatePicker;
	
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
    	Vehicle foundVeh = Model.getVehicle(vehicleToSearch);
    	if ( foundVeh == null )
    	{
    		Alert a = new Alert(AlertType.NONE);
    		// set alert type
    		a.setAlertType(AlertType.ERROR); 
    		// show the dialog 
    		a.show();
    		a.setContentText("Vehicle not found in log, please try again");
    		return;
    	}
    	String[] newText = Model.checkVehicle(foundVeh.getVehicleMake(), foundVeh.getVehicleModel(), foundVeh.getVehicleYear(), foundVeh.getTotalMileage(), foundVeh.getlastMaintenanceDate(), foundVeh.getMileageSinceMT() );
    	message.setText(vehicleToSearch + "\n");
    	for(int i = 0; i < newText.length; i++ )
    	{
    		if( newText[i] == null )
    		{
    			return;
    		}
    		message.appendText(newText[i]);
    	}
	}
	
	//Export method
	@FXML
	private void exportAppointment(ActionEvent event) throws IOException {
		//Note for later: Get the vehicle name from search bar!!!
		LocalDate date = appointDatePicker.getValue();
		String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
		String shop = repairShop.getText();
		String time = timeField.getText();
		String appointment = formattedDate + ", " + time + ", " + shop;
		try {
			File file = new File("Schedule.txt");
			FileWriter myWriter = new FileWriter(file, true);
			BufferedWriter bufferWrite = new BufferedWriter(myWriter);
			bufferWrite.write(appointment);
			bufferWrite.newLine();
			bufferWrite.close();
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    public void clearFields(ActionEvent event) {
		appointDatePicker.setValue(null);
		timeField.clear();
		repairShop.clear();
    }
	
    @FXML
    public void createAppointment(ActionEvent event) {
    	Alert a = new Alert(AlertType.NONE);
    	// set alert type
    	a.setAlertType(AlertType.CONFIRMATION); 
    	// show the dialog 
    	a.show();
    	a.setContentText("Do you want to schedule the appointment?");
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
