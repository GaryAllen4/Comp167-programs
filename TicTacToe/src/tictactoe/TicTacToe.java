/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author G-Smoove
 */
public class TicTacToe extends Application {
private char move = 'x';
    @Override
    public void start(Stage primaryStage) {
        
        /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        GridPane root = new GridPane();

        
        MouseHandler mouse = new MouseHandler();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                ElementPane ep = new ElementPane();
                ep.setPrefSize(200, 200);
                ep.setOnMouseClicked(mouse);
                root.add(ep, col, row);
            }
        }
        //root.getChildren().add(btn);

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class MouseHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent e) {
           ElementPane ep = (ElementPane) e.getSource();//element that was clicked
           ep.setMove(move);
           if (move == 'x') {
           move = 'o';
           
           
           }
           else {
               move = 'x';
           }
        }
    
    } 
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
