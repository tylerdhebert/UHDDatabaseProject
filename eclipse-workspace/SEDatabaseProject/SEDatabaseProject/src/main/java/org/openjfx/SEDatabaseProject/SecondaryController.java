package org.openjfx.SEDatabaseProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SecondaryController {
	
	private final String FILENAME = "src\\main\\resources\\images\\peopleList.txt";
	private String currentPersonName;
	private Boolean labelSet = false;
	@FXML
	TextField courseOne = new TextField();
	@FXML
	TextField courseTwo = new TextField();
	@FXML
	TextField courseThree = new TextField();
	@FXML
	TextField courseFour = new TextField();
	@FXML
	TextField courseFive = new TextField();
	@FXML
	TextField courseOneTestOne = new TextField();
	@FXML
	TextField courseOneTestTwo = new TextField();
	@FXML
	TextField courseOneTestThree = new TextField();
	@FXML
	TextField courseOneTestFour = new TextField();
	@FXML
	TextField courseTwoTestOne = new TextField();
	@FXML
	TextField courseTwoTestTwo = new TextField();
	@FXML
	TextField courseTwoTestThree = new TextField();
	@FXML
	TextField courseTwoTestFour = new TextField();
	@FXML
	TextField courseThreeTestOne = new TextField();
	@FXML
	TextField courseThreeTestTwo = new TextField();
	@FXML
	TextField courseThreeTestThree = new TextField();
	@FXML
	TextField courseThreeTestFour = new TextField();
	@FXML
	TextField courseFourTestOne = new TextField();
	@FXML
	TextField courseFourTestTwo = new TextField();
	@FXML
	TextField courseFourTestThree = new TextField();
	@FXML
	TextField courseFourTestFour = new TextField();
	@FXML
	TextField courseFiveTestOne = new TextField();
	@FXML
	TextField courseFiveTestTwo = new TextField();
	@FXML
	TextField courseFiveTestThree = new TextField();
	@FXML
	TextField courseFiveTestFour = new TextField();
	@FXML
	Button searchButton = new Button();
	@FXML
	TextField searchBox = new TextField();
	@FXML
	TextField nameField = new TextField();
	@FXML
	TextField idField = new TextField();
	@FXML
	Hyperlink editName = new Hyperlink();
	@FXML
	Hyperlink editID = new Hyperlink();
	@FXML
	Hyperlink dropCourseOne = new Hyperlink();
	@FXML
	Hyperlink dropCourseTwo = new Hyperlink();
	@FXML
	Hyperlink dropCourseThree = new Hyperlink();
	@FXML
	Hyperlink dropCourseFour = new Hyperlink();
	@FXML
	Hyperlink dropCourseFive = new Hyperlink();
	@FXML
	TextField gpaField = new TextField();
	@FXML
	Hyperlink acceptName = new Hyperlink();
	@FXML
	Hyperlink cancelName = new Hyperlink();
	@FXML
	Label scoresLabel = new Label();
	@FXML
	Label facultyLabel = new Label();
	@FXML
	Label studentLabel = new Label();
	@FXML
	AnchorPane anchorPane = new AnchorPane();
	@FXML 
	Hyperlink logoutButton = new Hyperlink();
	
	@FXML
	private void setLoggedInAsLabel(MouseEvent e)
	{
		if (labelSet == false)
		{
			if(App.username.startsWith("1") || App.username.toLowerCase().startsWith("admin"))
	    	{
	    		facultyLabel.setVisible(true);
	    		studentLabel.setVisible(false);
	    		labelSet = true;
	    	}
	    	else
	    	{
	    		studentLabel.setVisible(true);
	    		facultyLabel.setVisible(false);
	    		labelSet = true;
	    	}
		}
	}
	
	
	@FXML
	private void fillFields(ActionEvent e) throws IOException
	{
		String desiredID = searchBox.getText();
		Scanner txtReader = new Scanner(new File(FILENAME));
		ArrayList<String> classList = new ArrayList();
		Boolean isID;
		
		try
		{
			Integer.parseInt(desiredID);
			isID = true;
		} catch(NumberFormatException ex)
		{
			isID = false;
		}
		
		String line = null;
		String[] currentLine = new String[7];
		Arrays.fill(currentLine, " ");
		
		while(txtReader.hasNext())
		{
			line = txtReader.nextLine();
			currentLine = line.split("-|\\.");
			
			if(currentLine[0].compareTo(desiredID) == 0 && isID)
				break;
			
			if(currentLine[1].toLowerCase().compareTo(desiredID.toLowerCase()) == 0 && !isID)
				break;
			
			if(!txtReader.hasNext() && currentLine[0].compareTo(desiredID) != 0 && isID)
			{
				searchBox.setText("INVALID ID OR NAME");
				gpaField.setText("INVALID");
				nameField.setText("INVALID");
				idField.setText("INVALID");
				courseOne.setVisible(false);
				courseTwo.setVisible(false);
				courseThree.setVisible(false);
				courseFour.setVisible(false);
				courseFive.setVisible(false);
				courseOneTestOne.setVisible(false);
				courseOneTestTwo.setVisible(false);
				courseOneTestThree.setVisible(false);
				courseOneTestFour.setVisible(false);
				courseTwoTestOne.setVisible(false);
				courseTwoTestTwo.setVisible(false);
				courseTwoTestThree.setVisible(false);
				courseTwoTestFour.setVisible(false);
				courseThreeTestOne.setVisible(false);
				courseThreeTestTwo.setVisible(false);
				courseThreeTestThree.setVisible(false);
				courseThreeTestFour.setVisible(false);
				courseFourTestOne.setVisible(false);
				courseFourTestTwo.setVisible(false);
				courseFourTestThree.setVisible(false);
				courseFourTestFour.setVisible(false);
				courseFiveTestOne.setVisible(false);
				courseFiveTestTwo.setVisible(false);
				courseFiveTestThree.setVisible(false);
				courseFiveTestFour.setVisible(false);
				scoresLabel.setVisible(false);
				return;
			}
			
			if(!txtReader.hasNext() && currentLine[1].toLowerCase().compareTo(desiredID.toLowerCase()) != 0 && !isID)
			{
				searchBox.setText("INVALID ID OR NAME");
				gpaField.setText("INVALID");
				nameField.setText("INVALID");
				idField.setText("INVALID");
				courseOne.setVisible(false);
				courseTwo.setVisible(false);
				courseThree.setVisible(false);
				courseFour.setVisible(false);
				courseFive.setVisible(false);
				courseOneTestOne.setVisible(false);
				courseOneTestTwo.setVisible(false);
				courseOneTestThree.setVisible(false);
				courseOneTestFour.setVisible(false);
				courseTwoTestOne.setVisible(false);
				courseTwoTestTwo.setVisible(false);
				courseTwoTestThree.setVisible(false);
				courseTwoTestFour.setVisible(false);
				courseThreeTestOne.setVisible(false);
				courseThreeTestTwo.setVisible(false);
				courseThreeTestThree.setVisible(false);
				courseThreeTestFour.setVisible(false);
				courseFourTestOne.setVisible(false);
				courseFourTestTwo.setVisible(false);
				courseFourTestThree.setVisible(false);
				courseFourTestFour.setVisible(false);
				courseFiveTestOne.setVisible(false);
				courseFiveTestTwo.setVisible(false);
				courseFiveTestThree.setVisible(false);
				courseFiveTestFour.setVisible(false);
				scoresLabel.setVisible(false);
				return;
			}
			
		}
		
		for(int i=0; i < currentLine.length;i++) {
			System.out.println(currentLine[i]);
		}
		
		idField.setText(currentLine[0]);
		nameField.setText(currentLine[1]);
		currentPersonName = currentLine[1];
		
		if (currentLine[2].compareTo("Faculty")==0)
		{
			gpaField.setText("FACULTY");
			courseOne.setVisible(false);
			courseTwo.setVisible(false);
			courseThree.setVisible(false);
			courseFour.setVisible(false);
			courseFive.setVisible(false);
			courseOneTestOne.setVisible(false);
			courseOneTestTwo.setVisible(false);
			courseOneTestThree.setVisible(false);
			courseOneTestFour.setVisible(false);
			courseTwoTestOne.setVisible(false);
			courseTwoTestTwo.setVisible(false);
			courseTwoTestThree.setVisible(false);
			courseTwoTestFour.setVisible(false);
			courseThreeTestOne.setVisible(false);
			courseThreeTestTwo.setVisible(false);
			courseThreeTestThree.setVisible(false);
			courseThreeTestFour.setVisible(false);
			courseFourTestOne.setVisible(false);
			courseFourTestTwo.setVisible(false);
			courseFourTestThree.setVisible(false);
			courseFourTestFour.setVisible(false);
			courseFiveTestOne.setVisible(false);
			courseFiveTestTwo.setVisible(false);
			courseFiveTestThree.setVisible(false);
			courseFiveTestFour.setVisible(false);
			scoresLabel.setVisible(false);
		}
		else
		{
			courseOne.setVisible(true);
			courseOne.setText(currentLine[2]);
			courseTwo.setVisible(true);
			courseTwo.setText(currentLine[3]);
			courseThree.setVisible(true);
			courseThree.setText(currentLine[4]);
			courseOneTestOne.setVisible(true);
			courseOneTestTwo.setVisible(true);
			courseOneTestThree.setVisible(true);
			courseOneTestFour.setVisible(true);
			courseTwoTestOne.setVisible(true);
			courseTwoTestTwo.setVisible(true);
			courseTwoTestThree.setVisible(true);
			courseTwoTestFour.setVisible(true);
			courseThreeTestOne.setVisible(true);
			courseThreeTestTwo.setVisible(true);
			courseThreeTestThree.setVisible(true);
			courseThreeTestFour.setVisible(true);
			courseFourTestOne.setVisible(false);
			courseFourTestTwo.setVisible(false);
			courseFourTestThree.setVisible(false);
			courseFourTestFour.setVisible(false);
			courseFiveTestOne.setVisible(false);
			courseFiveTestTwo.setVisible(false);
			courseFiveTestThree.setVisible(false);
			courseFiveTestFour.setVisible(false);
			dropCourseOne.setVisible(true);
			dropCourseTwo.setVisible(true);
			dropCourseThree.setVisible(true);
			classList.add(currentLine[2]);
			classList.add(currentLine[3]);
			classList.add(currentLine[4]);
			
			if (currentLine.length >= 6)
			{
				courseFour.setVisible(true);
				courseFour.setText(currentLine[5]);
				classList.add(currentLine[5]);
				courseFourTestOne.setVisible(true);
				courseFourTestTwo.setVisible(true);
				courseFourTestThree.setVisible(true);
				courseFourTestFour.setVisible(true);
				dropCourseFour.setVisible(true);
			}
			else
			{
				courseFour.setVisible(false);
			}
			if (currentLine.length == 7)
			{
				courseFive.setVisible(true);
				courseFive.setText(currentLine[6]);
				classList.add(currentLine[6]);
				courseFiveTestOne.setVisible(true);
				courseFiveTestTwo.setVisible(true);
				courseFiveTestThree.setVisible(true);
				courseFiveTestFour.setVisible(true);
				dropCourseFive.setVisible(true);
			}
			else
			{
				courseFive.setVisible(false);
			}
		}
		if (!classList.isEmpty())
		{
			fillExamScores(classList, idField.getText());
		}
		txtReader.close();
	}
	
	private void fillExamScores(ArrayList arr, String id) throws FileNotFoundException
	{
		scoresLabel.setVisible(true);
		String line = null;
		String[] currentLine = new String[6];
		ArrayList<Integer> grades = new ArrayList();
		switch(arr.size())
		{
			case 5:
				Scanner classFive = new Scanner(new File("src\\main\\resources\\images\\" + arr.get(4) + ".txt"));
				while (classFive.hasNext())
				{
						line = classFive.nextLine();
						currentLine = line.split("-");
						if (currentLine[0].compareTo(id) == 0)
						{
							courseFiveTestOne.setText(currentLine[1]);
							courseFiveTestTwo.setText(currentLine[2]);
							courseFiveTestThree.setText(currentLine[3]);
							courseFiveTestFour.setText(currentLine[4]);
							grades.add((Integer.parseInt(currentLine[1]) + Integer.parseInt(currentLine[2])
							+ Integer.parseInt(currentLine[3]) + Integer.parseInt(currentLine[4]))/4);
						}
				}
			case 4:
				Scanner classFour = new Scanner(new File("src\\main\\resources\\images\\" + arr.get(3) + ".txt"));
				while (classFour.hasNext())
				{
						line = classFour.nextLine();
						currentLine = line.split("-");
						if (currentLine[0].compareTo(id) == 0)
						{
							courseFourTestOne.setText(currentLine[1]);
							courseFourTestTwo.setText(currentLine[2]);
							courseFourTestThree.setText(currentLine[3]);
							courseFourTestFour.setText(currentLine[4]);
							grades.add((Integer.parseInt(currentLine[1]) + Integer.parseInt(currentLine[2])
							+ Integer.parseInt(currentLine[3]) + Integer.parseInt(currentLine[4]))/4);
						}
				}
			case 3:
				Scanner classThree = new Scanner(new File("src\\main\\resources\\images\\" + arr.get(2) + ".txt"));
				while (classThree.hasNext())
				{
						line = classThree.nextLine();
						currentLine = line.split("-");
						if (currentLine[0].compareTo(id) == 0)
						{
							courseThreeTestOne.setText(currentLine[1]);
							courseThreeTestTwo.setText(currentLine[2]);
							courseThreeTestThree.setText(currentLine[3]);
							courseThreeTestFour.setText(currentLine[4]);
							grades.add((Integer.parseInt(currentLine[1]) + Integer.parseInt(currentLine[2])
							+ Integer.parseInt(currentLine[3]) + Integer.parseInt(currentLine[4]))/4);
						}
				}
			case 2:
				Scanner classTwo = new Scanner(new File("src\\main\\resources\\images\\" + arr.get(1) + ".txt"));
				while (classTwo.hasNext())
				{
						line = classTwo.nextLine();
						currentLine = line.split("-");
						if (currentLine[0].compareTo(id) == 0)
						{
							courseTwoTestOne.setText(currentLine[1]);
							courseTwoTestTwo.setText(currentLine[2]);
							courseTwoTestThree.setText(currentLine[3]);
							courseTwoTestFour.setText(currentLine[4]);
							grades.add((Integer.parseInt(currentLine[1]) + Integer.parseInt(currentLine[2])
							+ Integer.parseInt(currentLine[3]) + Integer.parseInt(currentLine[4]))/4);
						}
				}
			case 1:
				Scanner classOne = new Scanner(new File("src\\main\\resources\\images\\" + arr.get(0) + ".txt"));
				while (classOne.hasNext())
				{
						line = classOne.nextLine();
						currentLine = line.split("-");
						if (currentLine[0].compareTo(id) == 0)
						{
							courseOneTestOne.setText(currentLine[1]);
							courseOneTestTwo.setText(currentLine[2]);
							courseOneTestThree.setText(currentLine[3]);
							courseOneTestFour.setText(currentLine[4]);
							grades.add((Integer.parseInt(currentLine[1]) + Integer.parseInt(currentLine[2])
							+ Integer.parseInt(currentLine[3]) + Integer.parseInt(currentLine[4]))/4);
						}
				}
		}
		calculateGPA(grades);
	}
	
	private void calculateGPA(ArrayList<Integer> arr)
	{
		double gpa = 0;
		for (int i = 0; i < arr.size(); i++)
		{
			if (arr.get(i)/10 >= 9)
				gpa += 4;
			else if(arr.get(i)/10 >=8 && arr.get(i)/10 < 9)
				gpa += 3;
			else if(arr.get(i)/10 >=7 && arr.get(i)/10 < 8)
				gpa += 2;
			else if(arr.get(i)/10 >=6 && arr.get(i)/10 < 7)
				gpa += 1;			
		}
		gpa = gpa/arr.size();
		gpaField.setText(Double.toString(gpa));
	}

	@FXML
	private void editPersonName(ActionEvent e)
	{
		if (App.username.compareTo("admin") == 0
				|| App.username.startsWith("1"))
		{
			acceptName.setVisible(true);
			nameField.setEditable(true);
			cancelName.setVisible(true);
		}
		else return;
	}
	
	@FXML
	private void cancelName(ActionEvent e)
	{
		acceptName.setVisible(false);
		nameField.setEditable(false);
		cancelName.setVisible(false);
		nameField.setText(currentPersonName);
	}
	
	@FXML 
	private void acceptName(ActionEvent e) throws IOException
	{
		if (!nameField.getText().isEmpty()) {
			Scanner txtReader = new Scanner(new File(FILENAME));
			String line = "";
			
			
			while(txtReader.hasNext())
			{
				line += txtReader.nextLine() + "\r\n";
			}
			System.out.println(line);
			txtReader.close();
			
			
			String newName = nameField.getText();
			System.out.println(currentPersonName + " " + newName);
			String replaced = line.replace("" + currentPersonName, "" + newName);
			System.out.println(replaced);
			FileWriter writer = new FileWriter(new File(FILENAME));
			writer.write(replaced);
			writer.close();
		}
		nameField.setEditable(false);
		acceptName.setVisible(false);	
		cancelName.setVisible(false);
		Scanner txtReader = new Scanner(new File(FILENAME));

		while(txtReader.hasNext())
		{
			String line = txtReader.nextLine();
			String[] currentLine = line.split("-\\.");
			for (int i = 0; i < currentLine.length; i++)
			{
				if (currentLine[i].compareTo(nameField.getText()) == 0)
				{
					currentPersonName = currentLine[i];
					return;
				}
			}
		}
	}
    @FXML
    private void logoutButton(ActionEvent e) throws IOException {
    	logoutButton.getScene().getWindow().hide();
        App.showLoginScreen();
    }
}