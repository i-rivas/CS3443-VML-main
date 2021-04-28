package application.model;
/*
 * Vehicle Test Ideas
 * Change oil every 7,500 miles
 * Change Transmission fluid every 30,000 miles
 * Rotate tires every 7,000 miles
 * Check vehicle every 6 months
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

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

	public static String[] checkVehicle(String vehicleName, String date, String issue)
	{
		String[] messages = new String[5];
		int i = 0;
		// Date format: mm/dd/yyyy
		 // Get an instance of LocalTime
        // from date
        LocalDate currentDate = LocalDate.now();
        // Get day from date
        int day = currentDate.getDayOfMonth();
        // Get month from date
        Month month = currentDate.getMonth();
        int todaymonth = month.getValue();
        // Get year from date
        int year = currentDate.getYear();
  
        // Print the day, month, and year
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
		int yeardiff = 2021 - Integer.parseInt(date.substring(6));
		int monthdiff = todaymonth - Integer.parseInt(date.substring(0,2));
		System.out.println("month substring = " + date.substring(0,2) );
		System.out.println("monthdiff = " + monthdiff);
		System.out.println("monthval = " + todaymonth);
		//int daydiff;
		if( yeardiff > 0 )
		{
			messages[i] = "It has been " + yeardiff + " years since your last maintenance\n";
			i++;
		}
		else if ( monthdiff > 6 )
		{
			messages[i] = "It has been " + monthdiff + " months since your last maintenance\n";
			i++;
		}
		else 
		{
			messages[i] = "Your last maintenance was already done within the last 6 months\n";
			i++;
		}
	
		if( issue.equals("Engine Repair") )
		{
			messages[i] = "You need a engine repair\n";
			i++;
		}
		if( issue.equals("Vehicle Maintenance") )
		{
			messages[i] = "You need vehicle maintenance\n";
			i++;
		}
		if( issue.equals("Oil Leak Repair") )
		{
			messages[i] = "You need an oil leak repaired\n";
			i++;
		}
		if( issue.equals("Broken Windowshield") )
		{
			messages[i] = "You need a windowshield replacement\n";
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
