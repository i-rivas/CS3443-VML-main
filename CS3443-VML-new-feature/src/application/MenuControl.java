package application;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MenuControl {
    @FXML
    private AnchorPane mainPane;
    
    //private String path = "C:\\Users\\diego\\git\\VMLrepository\\CS3443-VML-new-feature\\vibez-lets-go.mp3";
    //private Media media = new Media(new File(path).toURI().toString());
    //private MediaPlayer mediaPlayer = new MediaPlayer(media);
	
    @FXML
    public void goToList(ActionEvent event) throws IOException {
    	//mediaPlayer.play();
		mainPane = FXMLLoader.load(getClass().getResource("VehicleList.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void goToVehicle(ActionEvent event) throws IOException {
    	mainPane = FXMLLoader.load(getClass().getResource("LogPage.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    
    @FXML
    public void goToSuggestions(ActionEvent event) throws IOException {
    	mainPane = FXMLLoader.load(getClass().getResource("VehicleSuggestion.fxml"));// pane you are GOING TO
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