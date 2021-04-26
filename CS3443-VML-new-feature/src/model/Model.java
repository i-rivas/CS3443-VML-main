package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javafx.scene.control.ListView;

public class Model {
	
	private static ArrayList<String> items = new ArrayList<String>();
	
	public static void getVehicleList(ListView<String> printList) throws FileNotFoundException {
    	File inFile = new File("VehicleList.txt");
		Scanner read = new Scanner(inFile);
    	
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
    	
    	while (read.hasNextLine()) {
			items.add(read.nextLine());
    	}
    	for (String inv: items) {
    		printList.getItems().add(inv);
    	}
        read.close();
	}
}
