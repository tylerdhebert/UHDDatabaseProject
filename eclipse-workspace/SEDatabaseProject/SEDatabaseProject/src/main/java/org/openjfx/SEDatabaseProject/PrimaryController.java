package org.openjfx.SEDatabaseProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class PrimaryController {
	
	FadeTransition ft = new FadeTransition(Duration.millis(2000));
	private final String FILENAME = "src\\main\\resources\\images\\userpass.txt";
	
	@FXML
	TextField usernameField = new TextField();
	
	@FXML
	PasswordField passwordField = new PasswordField();
	
	@FXML
	Button loginButton = new Button();
	
	@FXML
	Label successText = new Label();
	
	@FXML
	Label failText = new Label();
	
	private Boolean loginVerification(String username, String password) throws FileNotFoundException
	{
		String currentLine[] = new String[2];
		Arrays.fill(currentLine, " ");
		Scanner txtReader = new Scanner(new File(FILENAME));
		String line;
		while(txtReader.hasNext())
		{
			line = txtReader.nextLine();
			currentLine = line.split("\\s+");
			if (username.toLowerCase().compareTo(currentLine[0]) == 0 && password.compareTo(currentLine[1]) == 0)
				return true;
		}
		return false;
	}
	
	@FXML
	private void loginPressed(ActionEvent e) throws IOException, InterruptedException
	{
		if (loginVerification(usernameField.getText(), passwordField.getText()))
		{
			failText.setVisible(false);
			successText.setVisible(true);
			ft.play();
			App.username = usernameField.getText();
			App.password = passwordField.getText();
			switchToSecondary();
		}
		else
		{
			successText.setVisible(false);
			failText.setVisible(true);	
		}
	}
	
	public void initialize() {
    	ft.setNode(successText);
    	ft.setFromValue(1.0);
    	ft.setToValue(0);
    	ft.setCycleCount(0);
    	ft.setAutoReverse(false);
    }

    @FXML
    private void switchToSecondary() throws IOException {
    	usernameField.getScene().getWindow().hide();
        App.showDatabaseScreen();        
    }
}
