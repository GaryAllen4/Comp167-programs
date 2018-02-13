/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimp3;

import BrickBreakerEngine.ProfilePane;
import java.awt.Insets;
import java.awt.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class GUIMP3 extends Application {
    
  
    
   
    @Override
    public void start(Stage primaryStage) {
      
        Button newSearchBtn = new Button("search");
        Button newCreateButton = new Button("create");
        TextField playerName = new TextField();
        playerName.setText("Enter A New Player's Name");
                
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("name 1", "name 2", "name 3");
        comboBox.setPromptText("Select Profile");
                   
              
        
        
        GridPane gridPane = new GridPane();
        /*gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.addRow(0, comboBx, newSearchBtn);
        gridPane.addRow(2, playerName, newCreateButton);
        gridPane.setHgap(20);
        gridPane.setVgap(4);*/
        
        BorderPane brderPane = new BorderPane();
        
        Scene scene = new Scene(gridPane, 400, 200);  
        
              
        primaryStage.setTitle("PlayerProfiles");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
