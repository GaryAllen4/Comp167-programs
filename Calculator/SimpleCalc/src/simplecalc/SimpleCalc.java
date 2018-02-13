/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author G-Smoove
 */
public class SimpleCalc extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField txt = new TextField();
        HBox horiz = new HBox();
        GridPane gPane = new GridPane();
        Button sqrt= new Button("Sqrt");
        Button xsquared = new Button("x^2");
        Button clr = new Button("Clr");
        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
BorderPane brderPane = new BorderPane();


int counter =1;

for(int row = 0; row < 3; row++) {
    for(int col = 0; col< 3; col++) {
        CircleButton circlebtn = new CircleButton(counter + "");
        circlebtn.setPrefSize(100, 100);
        //circlebtn.setOnMouseClicked(value);
        gPane.add(circlebtn, col, row);
        counter++;
    }
}

horiz.getChildren().add(sqrt);
horiz.getChildren().add(xsquared);
horiz.getChildren().add(clr);

brderPane.setBottom(horiz);
brderPane.setTop(txt);
brderPane.setCenter(gPane);


        StackPane root = new StackPane();
        root.getChildren().add(brderPane);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
