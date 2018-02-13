/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gary Allen
 */
public class StudentDriverMP3 extends Application {

    @Override
    public void start(Stage primaryStage) {

        String configFilename = "brickbreaker.txt"; //configuration file for bricks
        String profileFilename = "brickbreakerprofiles.txt"; // player profiles already saved frompreviously played games

        ProfilePane pfPane = new ProfilePane(profileFilename, configFilename);
        Scene scene = new Scene(pfPane, 400, 200);

        primaryStage.setTitle("Brick Breaker"); //game title
        primaryStage.setScene(scene); //game scene added to game window
        primaryStage.show(); //window is shown

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
