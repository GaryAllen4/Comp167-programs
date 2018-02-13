/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;


import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Gary Allen
 */
public class ScorePane extends HBox {

    private int score; // holds game score
    private Label lblScore; // Display for current score

    public ScorePane() { //default values
        score = 0; 
        lblScore = new Label();
        lblScore.setTextFill(Color.BLACK); //color of the label text is black
        lblScore.setFont(new Font("Times New Roman", 30)); //label font and size
        this.getChildren().add(lblScore); //label added to the ScorePane
    }

    public void setScore(int score) { // Set score to given value
        this.score = score;
        lblScore.setText("");
    }

    public int getScore() { // Return current score
        return score;
    }

    public void incrementScore(int pts) { // Increase score by set amount
        score += pts; // Increment the score when a brick is hit
        lblScore.setText("Score: " + score); // The current score total
    }
}
