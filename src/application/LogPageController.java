package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class LogPageController {
	
	@FXML
	private void loadMain(ActionEvent event) throws IOException {
		Parent main = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene mainScene = new Scene(main);
        mainStage.setScene(mainScene);
        mainStage.show();
	}
	
	@FXML
	ListView<String> LogList;
	
	@FXML
	private void readVehicleList(ActionEvent event ) throws IOException {
		File VehicleInfo = new File("VehicleList.txt");
		try (Scanner read = new Scanner(VehicleInfo)) {
			ArrayList<String> info = new ArrayList<String>();
			
			while (read.hasNextLine()) {
				info.add(read.nextLine());
			}
			for (String cars: info) {
				LogList.getItems().add("Make/Model: " + cars);
			}
		}
		
	}
	
	@FXML
	private void exportVehicle(ActionEvent event) throws IOException {

				String currentVehicle = LogList.getSelectionModel().getSelectedItem();
				
				try {
					FileWriter myWriter = new FileWriter("VehicleExport.txt");
					myWriter.write(currentVehicle);
					myWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	
}