/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Gary Allen
 */
public class Brick extends Rectangle {

    private int pointValue; // Bric point value when hit by the ball
    public static int BRICK_WIDTH = 35; // Width of the brick and doesnt change
    public static int BRICK_HEIGHT = 20; // Height of the brick and doesnt change

    public Brick(int xLoc, int yLoc) { // Creates the brick at the given location
        this.setX(xLoc);
        this.setY(yLoc);
        this.setWidth(BRICK_WIDTH);
        this.setHeight(BRICK_HEIGHT);
        this.setStroke(Color.GRAY);
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

}
