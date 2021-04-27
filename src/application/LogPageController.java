package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class LogPageController  {
	
	@FXML
	ListView<Object> LogList;
	
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
}