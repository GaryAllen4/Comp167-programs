/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Gary Allen
 */
public class Ball extends Circle {

    private int speed = 8;
    private double direction = 0;
    private final static double TWO_PI = 2 * Math.PI;

    public Ball(int paWidth, int paHeight, double dir) {

        this.direction = dir;
        this.setRadius(7);
        this.setCenterX(paWidth / 2);
        this.setCenterY(paHeight / 2);
        this.setFill(Color.RED);
        this.setStroke(Color.WHEAT);

    }

    public void move() {
        this.setCenterX(this.getCenterX() + speed * Math.cos(getDirection() * TWO_PI / 360));
        this.setCenterY(this.getCenterY() + speed * Math.sin(getDirection() * TWO_PI / 360));
    }

    public int getTopEdge() {
        return (int) (this.getCenterY() - this.getRadius());
    }

    public int getBottomEdge() {
        return (int) (this.getCenterY() + this.getRadius()); //
    }

    public int getRightEdge() {
        return (int) (this.getCenterX() - this.getRadius());
    }

    public int getLeftEdge() {
        return (int) (this.getCenterX() + this.getRadius());
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }
}
