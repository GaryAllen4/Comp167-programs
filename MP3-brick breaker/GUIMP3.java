/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimp3;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUIMP3 extends Application { 
    
   
    @Override
    public void start(Stage primaryStage) {
      
        Button newSearchButton = new Button("Search Players");
        Button newCreateButton = new Button("Create Player");
        
        TextField player = new TextField();
        player.setText("Enter New Player Name");
        
       Label error = new Label();
         error.setText("ERROR DISPLAY!");
         error.setTextFill(Color.RED);
         error.setFont(new Font("Times New Roman", 18));
         error.setWrapText(true);
         
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("name #1", "name #2", "name #3", "name #4");
        comboBox.setPromptText("Select Existing Player");
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.addRow(0, comboBox, newSearchButton);
        gridPane.addRow(2, player, newCreateButton);
        gridPane.add(error, 0, 3);
        gridPane.setHgap(20);
        gridPane.setVgap(4);
        
        BorderPane borderPane = new BorderPane();
        
        Scene scene = new Scene(gridPane, 400, 200);  
        
              
        primaryStage.setTitle("Player Profiles");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
  
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
