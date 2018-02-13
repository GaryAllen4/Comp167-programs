/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.BrickRow;
import brickbreakerstudent.Level;

import java.util.Random;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

/**
 *
 * @author Gary Allen
 */
public class PlayArea extends Pane {

    private Brick[][] bricks; // 2D Array of Brick objects
    Paddle paddle;

    private int BASE_Y; //The yloc in the playArea where the first row of bricks will start
    private int paHeight; // The height of the play area in pixels
    private int paWidth; // The width of the play area in pixels
    Ball ball;
    Timer timer = new Timer();
    private Random rand = new Random();
    private double direction;
    ScorePane scorePane;
    private int brickCounter = 0;
    private int ballCount = 3;
    int bounceCounter = 0;

    public PlayArea(int paHeight, int paWidth, Level level, ScorePane score) { // create the bricks and the paddle and add to the PlayArea

        this.paHeight = paHeight;
        this.paWidth = paWidth;
        this.setPrefWidth(paWidth);
        this.setPrefHeight(paHeight);
        this.scorePane = score;
        BASE_Y = 0;
        paddle = new Paddle(paHeight, paWidth);
        this.getChildren().add(paddle); // add paddle to play area
        bricks = new Brick[level.getNumBrickRows()][level.getBricksPerRow()];
        createBricks(level); // create the bricks for the game
        ball = new Ball(0, 0, 0);
        this.getChildren().add(ball);
        newBall();

    }

    private void createBricks(Level level) { // Creating the bricks and filling the 2d array
        bricks = new Brick[level.getNumBrickRows()][level.getBricksPerRow()];
        for (int i = 0; i < level.getNumBrickRows(); i++) {
            BrickRow brickrow = level.getBrickRow(i);

            for (int j = 0; j < level.getBricksPerRow(); j++) {
                if (brickrow.getBrickMaskValue(j)) {
                    Brick bric = new Brick(j * Brick.BRICK_WIDTH, i * Brick.BRICK_HEIGHT);
                    bric.setFill(brickrow.getColor());
                    bric.setPointValue(brickrow.getPointValue());
                    bricks[i][j] = bric;
                    this.getChildren().add(bric);
                    setBrickCounter(getBrickCounter() + 1);
                }
            }
        }
    }

    public void movePaddle(double xLoc) { // Moves the paddle to the given xLoc
        paddle.move(xLoc);

    }

    public void handleCollisions() {
        if (ball.getCenterY() - ball.getRadius() <= 0) {
            ball.setCenterY(ball.getRadius() + 1);
            ball.setDirection(360 - ball.getDirection());//ball is given direction after collision
        }

        if (ball.getCenterX() - ball.getRadius() <= 0) {
            ball.setCenterX((ball.getRadius() + 1));
            if (ball.getDirection() < 180) {
                ball.setDirection(90 + (90 - ball.getDirection()));//ball is given direction after collision
            } else {
                ball.setDirection(270 + (270 - ball.getDirection()));//ball is given direction after collision
            }
        }

        if (ball.getCenterX() + ball.getRadius() >= paWidth) {
            ball.setCenterX(paWidth - (ball.getRadius() + 1));
            if (ball.getDirection() < 180) {
                ball.setDirection(90 + (90 - ball.getDirection()));//ball is given direction after collision
            } else {
                ball.setDirection(270 + (270 - ball.getDirection()));//ball is given direction after collision
            }

        }

        for (int i = 0; i < bricks.length; i++) { //
            for (int j = 0; j < bricks[i].length; j++) {

                if (bricks[i][j] == null || !bricks[i][j].isVisible()) { // if there are no bricks at the location and they are not visible
                    continue; // jumps to next iteration of the loop
                }
                if ((ball.getBottomEdge() >= bricks[i][j].getY() && ball.getBottomEdge() <= (bricks[i][j].getY() + bricks[i][j].getHeight()))
                        || ball.getTopEdge() >= bricks[i][j].getY() && ball.getTopEdge() <= (bricks[i][j].getY() + bricks[i][j].getHeight())) {
                    if (ball.getRightEdge() >= bricks[i][j].getX() && ball.getLeftEdge() <= bricks[i][j].getX() + bricks[i][j].getWidth()) { //if ball hits brick
                        bricks[i][j].setVisible(false); //brick is "broken"
                        ball.setDirection(360 - ball.getDirection()); //ball is given direction after collision
                        scorePane.incrementScore(bricks[i][j].getPointValue()); //score for hitting a specific brick
                        setBrickCounter(getBrickCounter() - 1);
                        return;
                    }
                }
            }
        }

    }

    public void moveBall() { // make the ball move
        ball.move();
    }

    public void newBall() { //instantiate a new visible ball
        if (ballCount > 0) {
            Random random = new Random();

            ball.setCenterX(paddle.getX() + paddle.PADDLE_WIDTH / 2);

            ball.setCenterY(paddle.getY() - ball.getRadius());

            double x = random.nextInt(101) + 40;
            ball.setDirection(x);

            bounceCounter = 0;

            setBallVisibility(true);
        }

    }

    public void setBallVisibility(Boolean visibility) { // makes the ball visible or invisible
        ball.setVisible(visibility);
    }

    public boolean getBallVisibility() { //gets value of ball visibility
        return ball.isVisible();
    }

    public void checkCollisions(AnimationTimer timer) { // check if a collision occurs
        if (((ball.getBottomEdge() >= paddle.getY())
                && (ball.getBottomEdge() <= paddle.getY() + paddle.PADDLE_HEIGHT))
                && ((ball.getRightEdge() > paddle.getX())
                && (ball.getLeftEdge() < paddle.getX() + paddle.PADDLE_WIDTH))) {

            ball.setCenterY(paddle.getY() - ball.getRadius());
            ball.setDirection(360 - ball.getDirection());//ball is given direction after collision
            bounceCounter++;

            if (bounceCounter == 5) {
                bounceCounter = 0;
                Random random = new Random();
                double dir = random.nextInt(101) + 40;
                ball.setDirection(dir);//ball is given direction after collision

            }
        } else if (ball.getTopEdge() > paddle.getY() + paddle.PADDLE_HEIGHT) { //if the ball goes out of bounds then make it invisible, stop the Animation, and decrement the total balls left
            ballCount--;
            ball.setVisible(false);
            timer.stop();
        }

    }

    /**
     * @return the paHeight
     */
    public int getPaHeight() {
        return paHeight;
    }

    /**
     * @param paHeight the paHeight to set
     */
    public void setPaHeight(int paHeight) {
        this.paHeight = paHeight;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    /**
     * @return the brickCounter
     */
    public int getBrickCounter() {
        return brickCounter;
    }

    /**
     * @param brickCounter the brickCounter to set
     */
    public void setBrickCounter(int brickCounter) {
        this.brickCounter = brickCounter;
    }

}
