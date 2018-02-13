/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import static brickbreakerstudent.BrickBreakerIO.writeProfiles;
import brickbreakerstudent.GameProfiles;
import brickbreakerstudent.Level;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Gary Allen
 */
public class GameBoard extends BorderPane {

    private PlayArea playArea; // The play Area
    private GameProfiles profiles; //All gamer profiles
    private int currentLevel; //The current level, which starts at 0
    private Level[] levels; //All game level information from the config file
    private String profilesFilename; //The profiles file name
    private PaddleHandler paddleHandler; //Object of the inner class PAddleHandler that implements EventHAndler<MouseEvent>
    private ScorePane scorePane;
    Ball ball;
    Timer timer = new Timer();

    public GameBoard(Level[] levels, GameProfiles profiles, String profilesFilename) {
        this.timer = new Timer();
        paddleHandler = new PaddleHandler();
        this.currentLevel = 0;
        this.profiles = profiles;
        this.levels = levels;
        this.profilesFilename = profilesFilename;
        scorePane = new ScorePane();
        playArea = new PlayArea(600, 700, levels[currentLevel], scorePane); //scorePane
        paddleHandler = new PaddleHandler();
        setCenter(playArea); //playArea added to the center of the borderPane
        setTop(scorePane); // ScorePane added to the top section of BorderPane
        timer.start(); //starts AnimationTimer and calls its handle method
        this.setOnMouseMoved(paddleHandler); //when the mouse is moved 
        this.setOnMouseClicked(new EventHandler<MouseEvent>() { //when the mouse is clicked
            @Override
            public void handle(MouseEvent event) { //gives instructions on what should happen
                if (playArea.getBallVisibility() == false) { //if the ball is not visible in the play area
                    playArea.newBall(); // a new ball is created
                    timer.start(); //AnimationTimer begins
                }
            }

        });
        profiles.getSelectedProfile().setNumGamesPlayed(profiles.getSelectedProfile().getNumGamesPlayed() + 1); //adds one to amount of games played

        Label playerName = new Label(profiles.getSelectedProfile().getName()+ "'s High Score: "); //get the name of the player
        Label highScore = new Label(profiles.getSelectedProfile().getHighScore() + ""); //get player's high score
        Label ballCountName = new Label("Amount of Balls: "); //amount of "lives" in the game
        Label ballCountNum = new Label(playArea.getBallCount() + ""); //label to get the amount of balls
        Label space = new Label(" " + " " + " "); //extra spacing between labels at bottom of BorderPane 
        HBox hbox = new HBox(playerName, highScore, space, ballCountName, ballCountNum); //controls put into HBox
        hbox.setAlignment(Pos.CENTER); //Centers the elements of HBox
        hbox.setSpacing(2);
        setBottom(hbox); //Hbox and its elements put into bottom section of BorderPane
        writeProfiles(profiles, profilesFilename); 
    }

    private class PaddleHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            playArea.movePaddle(event.getX());
        }

    }

    private class Timer extends AnimationTimer {

        private long previous = 0;

        @Override
        public void handle(long now) {
            if (now - previous >= 200000) {

                playArea.moveBall(); //moves the ball
                playArea.handleCollisions(); //action that occurs when collision occurs
                playArea.checkCollisions(this); //check if there's a collision

                if (playArea.getBallCount() == 0) { //if there is no balls left
                    Stage stage = new Stage(); 
                    Label gameOver = new Label("LOSER! LOL! SORRY, TRY AGAIN!"); //a message to tease and encourage user to play again
                    gameOver.setFont(new Font("Times New Roman", 30)); //font of text
                    gameOver.setTextFill(Color.BLACK); //text color

                    Scene scene = new Scene(gameOver); //adds game over text to the scene
                    stage.setScene(scene); //sets the scene to the stage window
                    stage.show(); //show the created window
                    timer.stop(); //stop the AnimationTimer

                    if (scorePane.getScore() > profiles.getSelectedProfile().getHighScore()) { //writes new high score for current player
                        profiles.getSelectedProfile().setHighScore(scorePane.getScore());
                    }
                    writeProfiles(profiles, profilesFilename);
                }

                if (playArea.getBrickCounter() == 0) { //next level if there are no bricks left
                    currentLevel++;
                    if (scorePane.getScore() > profiles.getSelectedProfile().getHighScore()) {
                        profiles.getSelectedProfile().setHighScore(scorePane.getScore());
                    }
                    writeProfiles(profiles, profilesFilename);
                    if (currentLevel < levels.length) { //if the current level is less than the total amount of levels
                        playArea = new PlayArea(600, 700, levels[currentLevel], scorePane);
                        setCenter(playArea);
                    } else { //lets the user know they have completed the game and stops the game
                        Stage s = new Stage();
                        Label winner = new Label("YOU WIN");
                        winner.setFont(new Font("Times New Roman", 50));
                        winner.setTextFill(Color.GOLD);
                        Scene scene = new Scene(winner);
                        s.setScene(scene);
                        s.show();
                        timer.stop();

                    }
                }

                previous = now;
            }

        }

    }
}
