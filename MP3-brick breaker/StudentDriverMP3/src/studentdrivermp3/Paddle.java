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
public class Paddle extends Rectangle {

    private final int BASE_Y; //y location in  playArea where Paddle moves
    int PADDLE_WIDTH = 70; // Width of paddle and doesnt change
    public static int PADDLE_HEIGHT = 10; // Height of paddke and doesnt change
    public static int paHeight; //Height of the play area in pixels
    private int paWidth; // Width of the play area in pixels

    public Paddle(int paWidth, int paHeight) { // Instantiate the paddle in the middle of the play area
        BASE_Y = 560;
        this.paWidth = paWidth;
        this.paHeight = paHeight;
        this.setHeight(PADDLE_HEIGHT);
        this.setWidth(PADDLE_WIDTH);
        move(paWidth / 2);
        this.setFill(Color.RED);
    }

    public void move(double xLoc) { // move the paddle so that the top edge is centered at location xLoc, BASE_Y
        this.setX(xLoc - (PADDLE_WIDTH) / 2);
        setY(BASE_Y);
    }

}
