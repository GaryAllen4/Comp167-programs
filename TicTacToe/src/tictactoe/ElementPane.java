/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author G-Smoove
 */
public class ElementPane extends Pane{

    private char move;

    public ElementPane() {
        move = ' ';
    }

    public ElementPane(char move) {
        this.move = move;
        makeAMove();
    }

    private void makeAMove() {
        this.getChildren().clear();
        if (move == 'o') {
            Circle circle = new Circle(90);
            circle.setStroke(Color.RED);
            circle.setFill(Color.WHEAT);
            circle.setCenterX(100);
            circle.setCenterY(100);
            this.getChildren().add(circle);
            
        } else if (move == 'x') {
            Line line1 = new Line();
            Line line2 = new Line();
            line1.setStroke(Color.RED);
            line1.setStartX(10);
            line1.setStartY(10);
            line1.setEndX(190);
            line1.setEndY(190);

            line2.setStroke(Color.RED);
            line2.setStartX(10);
            line2.setStartY(190);
            line2.setEndX(190);
            line2.setEndY(10);

            this.getChildren().addAll(line1, line2);
        }
    }


    /**
     * @return the move
     */
    public char getMove() {
        return move;
    }

    /**
     * @param move the move to set
     */
    public void setMove(char move) {
        this.move = move;
        makeAMove();
    }

}
