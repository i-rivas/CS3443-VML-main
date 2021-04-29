package model;
/*
 * Vehicle Test Ideas
 * Change oil every 7,500 miles
 * Change Transmission fluid every 30,000 miles
 * Rotate tires every 5,000 miles
 * Check vehicle every 6 months
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.ListView;

public class Model {
	
	
    public static ArrayList<Vehicle> listofVehicles = new ArrayList<Vehicle>();

    public static Vehicle getVehicle(String vehicleKey) throws FileNotFoundException, IOException 
    {
    	Boolean inList = false;
    	File inFile = new File("VehicleList3.txt");
		Scanner read = new Scanner(inFile);
		String[] arr;
    	ArrayList<String> textList = new ArrayList<String>();
    	while (read.hasNextLine()) {
			textList.add(read.nextLine());
    	}
    	read.close();
    	System.out.println(textList);

    	for(String line: textList)
    	{
    		// Split 1 line of text into 3 parts, vehicleName at arr[0], date at arr[1], issue at arr[2]
    		arr = line.split("	");
    		int year = Integer.parseInt(arr[2]);
    		int mileage = Integer.parseInt(arr[3]);
    		int mileageSince =   Integer.parseInt(arr[5]);
    		Vehicle newVehicle = new Vehicle(arr[0], arr[1], year, mileage, arr[4], mileageSince );
    		listofVehicles.add(newVehicle);
    	}
    	
    	for(Vehicle veh: listofVehicles)
    	{
    		if( vehicleKey.equals(veh.getVehicleName()) )
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

    public static String[] checkVehicle(String vehicleMake, String vehicleModel, int vehicleYear, int totalMileage, String date, int mileageSinceMT) 
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
        
        int currYear = currentDate.getYear();
        int yearOfVeh = Integer.parseInt(date.substring(6));
        int monthOfVeh = Integer.parseInt(date.substring(0,2));
        int dayOfVeh = Integer.parseInt(date.substring(3,5));
		int yeardiff = currYear - yearOfVeh;
		//int monthdiff = todaymonth - Integer.parseInt(date.substring(0,2));
		int monthdiff = (currYear - yearOfVeh) * 12 + ( todaymonth - monthOfVeh ) + 1;
		
        // Print statements for checking
		/*
      System.out.println("Day: " + day);
       System.out.println("Month: " + month);
       System.out.println("Year: " + currYear);
              System.out.println("YearOfVeh: " + yearOfVeh);
        System.out.println("month substring = " + date.substring(0,2) );
		System.out.println("monthdiff = " + monthdiff);
		System.out.println("monthval = " + todaymonth);
        */
        LocalDate vehDate = LocalDate.of(yearOfVeh, monthOfVeh, dayOfVeh);
        System.out.println("Day: " + vehDate.getDayOfMonth());
       System.out.println("Month: " + vehDate.getMonth());
       System.out.println("Year: " + vehDate.getYear());
		Period diff = Period.between(vehDate, currentDate);
		yeardiff = diff.getYears();
		monthdiff = diff.getMonths();
		System.out.println("yeardiff = " + yeardiff);
		System.out.println("monthdiff = " + monthdiff);

		if( yeardiff > 0 )
		{
			messages[i] = "It has been " + yeardiff + " years and " + monthdiff + " months since your last maintenance\n";
			i++;
		}
		else if ( monthdiff >= 6 )
		{
			messages[i] = "It has been " + monthdiff + " months since your last maintenance\n";
			i++;
		}
		else 
		{
			messages[i] = "Your last maintenance was already done within the last 6 months\n";
			i++;
		}
		
		if ( mileageSinceMT >= 7500 )
		{
			messages[i] = "Your vehicle needs an oil change\n";
			i++;
		}
		if ( mileageSinceMT >= 30000 )
		{
			messages[i] = "Your vehicle needs an transmission fluid change\n";
			i++;
		}
		if ( mileageSinceMT >= 5000)
		{
			messages[i] = "Your vehicle needs its tires rotated";
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
