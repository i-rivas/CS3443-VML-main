package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class Model {
	
	public static ArrayList<String> listofVehicles = new ArrayList<String>();
	
	public static boolean getVehicle(String vehicleKey) throws FileNotFoundException, IOException {
		Boolean inList = false;
    	File inFile = new File("VehicleList.txt");
		Scanner read = new Scanner(inFile);
    	
    	while (read.hasNextLine()) {
			listofVehicles.add(read.nextLine());
    	}
    	read.close();
    	String foundVal;
    	for(String veh: listofVehicles)
    	{
    		if( veh.contains(vehicleKey) )
    		{
    			inList = true;
    			int startIndex = veh.indexOf(vehicleKey);
    			int endIndex = startIndex + vehicleKey.length() - 1;
    			foundVal = veh.substring(startIndex, vehicleKey.length());
    		}
    				
    	}
    	if( inList == false )
    	{
    		Alert a = new Alert(AlertType.NONE);
    		// set alert type
    		a.setAlertType(AlertType.ERROR); 
    		// show the dialog 
    		a.show();
    		a.setContentText("Vehicle does not exist in List");
    	}
    	//String foundVal = listofVehicles.get(listofVehicles.indexOf(vehicleKey));
    	
    	//System.out.println(foundVal);
		return true;
	}
	
	public static void getVehicleList(ListView<String> printList) throws FileNotFoundException {
    	File inFile = new File("VehicleList.txt");
		Scanner read = new Scanner(inFile);
		ArrayList<String> items = new ArrayList<String>();
    	
    	while (read.hasNextLine()) {
			items.add(read.nextLine());
    	}
    	for (String inv: items) {
    		printList.getItems().add(inv);
    	}
        read.close();
	}
}
