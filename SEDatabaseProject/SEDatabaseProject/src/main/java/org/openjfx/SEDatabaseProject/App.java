package org.openjfx.SEDatabaseProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;
    public static String username;
    public static String password;

    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Student Database");
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void showDatabaseScreen() throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	fxmlLoader.setLocation(App.class.getResource("secondary.fxml"));
    	AnchorPane dbScreen = fxmlLoader.load();
    	
    	Stage databaseEditorStage = new Stage();
    	databaseEditorStage.setTitle("Database Viewer");
    	databaseEditorStage.initModality(Modality.WINDOW_MODAL);
    	databaseEditorStage.initOwner(primaryStage);
    	databaseEditorStage.setResizable(false);
    	
    	Scene scene = new Scene(dbScreen);
    	databaseEditorStage.setScene(scene);
    	databaseEditorStage.show();
    }
    
    public static void showLoginScreen() throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	fxmlLoader.setLocation(App.class.getResource("primary.fxml"));
    	AnchorPane loginScreen = fxmlLoader.load();
    	
    	Stage loginStage = new Stage();
    	loginStage.setTitle("Student Database");
    	loginStage.initModality(Modality.NONE);
    	loginStage.initOwner(null);
    	loginStage.setResizable(false);
    	
    	Scene scene = new Scene(loginScreen);
    	loginStage.setScene(scene);
    	loginStage.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}