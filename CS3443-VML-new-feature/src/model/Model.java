package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class Model {
	
	private static ArrayList<String> items;
	public static ArrayList<Vehicle> listofVehicles = new ArrayList<Vehicle>();
	
	public static void getVehicleList(ListView<String> printList) throws FileNotFoundException {
    	File inFile = new File("VehicleList.txt");
		Scanner read = new Scanner(inFile);
		items = new ArrayList<String>();
    	
    	while (read.hasNextLine()) {
			items.add(read.nextLine());
    	}
    	for (String inv: items) {
    		printList.getItems().add(inv);
    	}
        read.close();
	}

	public static void getVehicleListAlpha(ListView<String> printList) throws FileNotFoundException {
		File inFile = new File("VehicleList.txt");
		Scanner read = new Scanner(inFile);
		items = new ArrayList<String>();
    	
    	while (read.hasNextLine()) {
			items.add(read.nextLine());
    	}
    	Collections.sort(items);
    	for (String inv: items) {
    		printList.getItems().add(inv);
    	}
        read.close();
	}
	
	public static void getVehicleListDate(ListView<String> printList) throws FileNotFoundException {
		File inFile = new File("VehicleList.txt");
		Scanner read = new Scanner(inFile);
		HashMap<String, String> dates = new HashMap<String, String>();
		Pattern pattern = Pattern.compile("([0-9]{2}/[0-9]{2}/[0-9]{4})");
		Matcher matcher;
		int count = 0;
		items = new ArrayList<String>();
    	
    	while (read.hasNextLine()) {
			items.add(read.nextLine());
			matcher = pattern.matcher(items.get(count));
			if (matcher.find()) {
				dates.put(matcher.group(), items.get(count));
			}
			count++;
    	}
    	System.out.println(dates);
    	
    	SortedSet<String> keys = new TreeSet<>(dates.keySet());
    	for (String key : keys) { 
    	   printList.getItems().add(dates.get(key));
    	}
        read.close();
	}
	
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
	
	//Method that adds vehicle into the VehicleList.txt file @Isai
	public static void addVehicle(String makeModel, String mileage, String lastServiceMileage) throws IOException {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("VehicleList.txt", true));
			out.newLine();
			out.write(makeModel + "	" + mileage + " " + lastServiceMileage);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}