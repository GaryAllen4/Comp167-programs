/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.BrickBreakerIO;
import brickbreakerstudent.GameProfiles;
import brickbreakerstudent.Level;
import brickbreakerstudent.PlayerProfile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Gary Allen
 */
public class ProfilePane extends GridPane {

    private GameProfiles profiles; //Profiles all registered players 
    private String profileFilename; //File containing profiles data
    private String configFilename; //File containing Level data and passed to GameBoard
    private Button choosePlayer = new Button("Choose Player"); // Button used to select a registered player
    private Button newPlayer = new Button("New Player"); // Button used to create a new player
    private TextField player = new TextField("Enter New Player Name"); // Tells the user to enter a name for their profile
    private ComboBox box = new ComboBox(); // Used to list the profiles
    private Label label = new Label(""); //Label used to display messages to the user

    public ProfilePane(String profileFilename, String configFilename) { //default values
        label.setTextFill(Color.RED); // sets the label color to red
        label.setFont(new Font("Times New Roman", 25)); // sets the font of the label

        this.profileFilename = profileFilename;
        this.configFilename = configFilename;
        profiles = new GameProfiles();
        BrickBreakerIO.readProfiles(profiles, profileFilename); //calls the method from the BrickBreakerIO class to
        addRow(0, box, choosePlayer); //first row controls added
        addRow(2, player, newPlayer); //third row controls added 
        addRow(4, label); //fourth row control added

        for (int i = 0; i < profiles.getNumProfiles(); i++) {
            box.getItems().addAll(profiles.getProfile(i).getName());
        }

        choosePlayer.setOnAction(new EventHandler<ActionEvent>() { //choosePlayer button is clicked

            @Override
            public void handle(ActionEvent e) { // gives instructions for handling the action of the user clicking the choosePlayer button
                if (box.getValue() == null) { //if there is no player profile selected, tell the user to choose a current profile
                    label.setText("Select a Player Profile"); //tells the user to select a profile
                    return;
                }
                for (int i = 0; i < profiles.getNumProfiles(); i++) {
                    if (box.getValue().equals(profiles.getProfile(i).getName())) { //if the profile selected exists then set it as the chosen profile and continue to the game
                        profiles.setSelectedProfile(profiles.getProfile(i));
                        break; // stops the loop
                    }
                }
                Stage stage = new Stage();
                String prof = profiles.getSelectedProfile().toString(); //selected profile is turned into a string
                for (int j = 0; j < profiles.getNumProfiles(); j++) {
                    prof += System.lineSeparator() + profiles.getProfile(j); //adds profile to current profile list
                }
                TextArea pList = new TextArea(prof);
                Scene scene = new Scene(pList, 600, 200);

                startGameBoard();

            }

        });

        newPlayer.setOnAction(new EventHandler<ActionEvent>() { // newPlayer button pressed

            @Override
            public void handle(ActionEvent e) { //handle the button action
                for (int j = 0; j < profiles.getNumProfiles(); j++) {
                    if (player.getText().equals(profiles.getProfile(j).getName())) {
                        Alert alert = new Alert(AlertType.ERROR, "Player already exists. Enter a new username");
                        alert.showAndWait();
                        //alert to inform user that the player name exists
                    } else if (player.getText().isEmpty()) { //if there was no text entered into the TextField
                        label.setText("Enter A Player UserName"); // tells the user to enter a new player name for their profile
                        return;

                    }
                }
                PlayerProfile playerP = new PlayerProfile(player.getText());
                profiles.addProfile(playerP);
                BrickBreakerIO.writeProfiles(profiles, profileFilename); // write player profile to file
                label.setText("Your Profile is Created"); //tell the user the profile was created, so they can now play game
                
            }
        });

    }

    public void startGameBoard() { //Game Board is created and shown to user

        this.setVisible(false);
        Level[] levels = BrickBreakerIO.readConfigFile(configFilename);
        GameBoard gameBoard = new GameBoard(levels, profiles, this.profileFilename); // creates new GameBoard obj
        Scene gameScene = new Scene(gameBoard); //place the GameBoard obj into the game scene
        Stage gameStage = new Stage(); // creates a new Stage obj
        gameStage.setScene(gameScene); // places the scene obj into the stage
        gameStage.setTitle("Brick Breaker Game"); // gives the game a title
        gameStage.show(); //shows the game window

    }

}
