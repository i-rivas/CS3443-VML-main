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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class Model {
	
	public static ArrayList<String> listofVehicles = new ArrayList<String>();
	
	public static boolean getVehicle(String vehicleKey) throws FileNotFoundException, IOException {
		Boolean inList = false;
		String foundVeh = null;
		String lastDate = null;
		String vehIssue = null;
    	File inFile = new File("VehicleList.txt");
		Scanner read = new Scanner(inFile);
    	
    	while (read.hasNextLine()) {
			listofVehicles.add(read.nextLine());
    	}
    	read.close();
    	
    	for(String veh: listofVehicles)
    	{
    		
    		if( veh.contains(vehicleKey) )
    		{
    			inList = true;
    			// Create a Pattern object
    			String pattern = "([a-zA-Z0-9 ]+)[ \\t]+([0-9]{2}/[0-9]{2}/[0-9]{4})[ \\t]+([a-zA-Z0-9 ]+)";
    			Pattern r = Pattern.compile(pattern);

    			// Now create matcher object.
    			Matcher m = r.matcher(veh);
    			if (m.find( )) {
    				System.out.println("Found value: " + m.group(0) );
    				System.out.println("Found value: " + m.group(1) );
    				System.out.println("Found value: " + m.group(2) );
    			}else {
    				System.out.println("NO MATCH");
    			}
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
    	//System.out.println(foundVeh);
		return true;
	}
	
	public static void checkVehicle(String vehicleName, String date, String issue)
	{
		
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
