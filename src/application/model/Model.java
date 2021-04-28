package application.model;
/*
 * Change oil every 5,000 miles
 * Change Transmission fluid every 30,000 miles
 * Rotate tires every 7,000 miles
 * Check vehicle every 6 months
 */

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
	
	
    public static ArrayList<Vehicle> listofVehicles = new ArrayList<Vehicle>();

    public static Vehicle getVehicle(String vehicleKey) throws FileNotFoundException, IOException 
    {
    	Boolean inList = false;
    	File inFile = new File("VehicleList2.txt");
		Scanner read = new Scanner(inFile);
		String[] arr;
    	ArrayList<String> textList = new ArrayList<String>();
    	while (read.hasNextLine()) {
			textList.add(read.nextLine());
    	}
    	read.close();

    	for(String line: textList)
    	{
    		// Split 1 line of text into 3 parts, vehicleName at arr[0], date at arr[1], issue at arr[2]
    		arr = line.split("	");
    		Vehicle newVehicle = new Vehicle(arr[0], arr[1], arr[2]);
    		listofVehicles.add(newVehicle);
    	}
    	
    	for(Vehicle veh: listofVehicles)
    	{
    		if( vehicleKey.equals(veh.getVehicleMake()) )
    		{
    			inList = true;
    			return veh;
    		}
    	}
    	if( inList == false )
    	{
    		return null;
    	}
    	
    	/*
    	for(Vehicle veh: listofVehicles)
    	{
    		System.out.println("Vehicle Make: " + veh.getVehicleMake());
    		System.out.println("Date: " + veh.getlastCheckedDate());
    		System.out.println("Issue: " + veh.getCurrentIssue());
    	}
    	*/
		return null;
    }
    //public static ArrayList<String> listofVehicles = new ArrayList<String>();
    /*
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
    		System.out.println(veh);
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
	*/
	
	public static String[] checkVehicle(String vehicleName, String date, String issue)
	{
		String[] messages = new String[5];
		int i = 0;
		// Date format: mm/dd/yyyy
		int yeardiff = 2021 - Integer.parseInt(date.substring(6));
		int monthdiff = 12 - Integer.parseInt(date.substring(3,4));
		int daydiff;
		if( yeardiff > 0 )
		{
			messages[i] = "It has been " + yeardiff + " years since your last maintenance";
			i++;
		}
		else if ( monthdiff > 6 )
		{
			messages[i] = "It has been " + monthdiff + " months since your last maintenance";
			i++;
		}
	
		if( issue.equals("Engine Repair") )
		{
			messages[i] = "You need a engine repair";
			i++;
		}
		if( issue.equals("Vehicle Maintenance") )
		{
			messages[i] = "You need vehicle maintenance";
			i++;
		}
		if( issue.equals("Oil Leak Repair") )
		{
			messages[i] = "You need an oil leak repaired";
			i++;
		}
		if( issue.equals("Broken Windowshield") )
		{
			messages[i] = "You need a windowshield replacement";
			i++;
		}
		return messages;
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
