package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import application.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VehicleListController {
	@FXML
    private AnchorPane mainPane;
	
	@FXML
	private Button showList;
	
	@FXML
	private ListView<String> printList = new ListView<String>();
	
	
	@FXML
    public void showVehicleList() throws FileNotFoundException {
    	Model.getVehicleList(printList);
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