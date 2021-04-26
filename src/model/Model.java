package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.ListView;

public class Model {
	
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
