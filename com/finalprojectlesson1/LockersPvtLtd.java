package com.finalprojectlesson1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LockersPvtLtd {
	
	private static ArrayList<String> arrlist = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.print("-------------WELCOME TO LOCKERS PVT. LTD.------------------");
		System.out.println("\nAPPLICATION NAME  :-VIRTUAL KEY REPOSITORY");
		System.out.println("\n-------------DEVELOPERS DETAILS ------------------");
		System.out.println("\nNAME        - SHASHANK");
		System.out.println("DESIGNATION - SOFTWARE DEVELOPER");
		System.out.println("DATE        - 07-MAY-2022");
		optionSelection();
	}

	public static void optionSelection() {
		String[] arr = { "\n1. GET FILE IN ASCENDING ORDER", "2. FOR BUSINESS LEVEL OPREATION",
				"3. CLOSE APPLICATION" };

		arrlist.add("shashank.txt");
		arrlist.add("bug.txt");
		arrlist.add("asuna.txt");
		Scanner sc = new Scanner(System.in);
		while (true) 
		{
			
			for (String opt : arr) {
				System.out.println(opt);
			}
			System.out.println("\n\nENTER THE SELECTION = ");
			int opreation = sc.nextInt();

			switch (opreation) {
			case 1:
				Collections.sort(arrlist);
				System.out.println("FILES ARE SORTED IN ASCENDING ORDER !\n" + arrlist + "\n");
				break;
			case 2:
				performBussinessOperation(sc, arrlist);
				break;
			case 3:
				System.out.println("closing application....\nThank you!");
				System.exit(0);
			default:
				System.out.println("enter correct option!");
				break;

			}
		}

	}

	private static void performBussinessOperation(Scanner sc, ArrayList<String> arrlist) {
		String[] arr = { "\n1. ADD FILE", "2. DELETE FILE", "3. SEARCH FILE", "4. GO BACK" };
		for (String opt : arr) 
		{
			System.out.println(opt);
		}
		System.out.println("please select any of the above option:");
		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			addFile(sc, arrlist);
			break;
		case 2:
			deleteFile(sc);
			break;
		case 3:
			searchFile(sc, arrlist);
			break;
		case 4:
			optionSelection();
			break;

		default:
			System.out.println("please select proper option!");
			break;
		}

	}

	private static void searchFile(Scanner sc, ArrayList<String> arrlist) {
		System.out.println("please enter file name : ");
		String fileName = sc.next();
		String result = "\nnot found!";
		for (String item : arrlist) {
			if (item.equals(fileName)) {
				result = "\nfile found !";
				break;
			}

		}
		System.out.println(result);

	}

	private static void deleteFile(Scanner sc) {
		System.out.println("please enter file name : ");
		String fileName = sc.next();
		File file = new File(
				"C:\\Users\\acer\\Documents\\FULL STACK JAVA DEVELOPER\\Implement OOPS using JAVA with Data Structures and Beyond - LESSON 1\\FINAL PROJECT-LESSON-1\\src\\com\\finalprojectlesson1\\files\\"
						+ fileName + ".txt");
		if (file.delete()) {
			System.out.println("\nfile deleted successfully!");
		} else {
			System.out.println("\nUnable to delete file!");

		}

	}

	private static void addFile(Scanner sc, ArrayList<String> arrlist) {
		System.out.println("please enter file name : ");
		String fileName = sc.next();

		File file = new File(
				"C:\\Users\\acer\\Documents\\FULL STACK JAVA DEVELOPER\\Implement OOPS using JAVA with Data Structures and Beyond - LESSON 1\\FINAL PROJECT-LESSON-1\\src\\com\\finalprojectlesson1\\files\\"
						+ fileName + ".txt");
		try {
			if (file.createNewFile()) {
				System.out.println("file created successfully!");
				arrlist.add(fileName + ".txt");
				System.out.println(arrlist);
			} else {
				System.out.println("file already exist");
			}
		} catch (IOException e) {
			System.out.println("unable to create file");
			e.printStackTrace();
		}

	}
}
