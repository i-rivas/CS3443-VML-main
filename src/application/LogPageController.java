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
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class LogPageController extends Application{
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("LogPage.fxml"));
			Scene scene = new Scene(root,536,322);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
		
	
	public static void main(String[] args) {
		launch(args);
	}
}
