package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Model;

public class VehicleListController {
	@FXML
    private AnchorPane mainPane;
	
	@FXML
	private SplitMenuButton option_default;

    @FXML
    private MenuItem option1;

    @FXML
    private MenuItem option2;
	
	@FXML
	private ListView<String> printList = new ListView<String>();
	
	@FXML
    public void showVehicleList() throws FileNotFoundException {
		printList.getItems().clear();
		Model.getVehicleList(printList);
    }
	
	@FXML
    public void showVehicleListAlpha() throws FileNotFoundException {
    	printList.getItems().clear();
		Model.getVehicleListAlpha(printList);
    }
	
	@FXML
	public void showVehicleListDate() throws FileNotFoundException {
		printList.getItems().clear();
		Model.getVehicleListDate(printList);
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
