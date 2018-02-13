/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

import javafx.scene.paint.Color;

/**
 *
 * @author Gary Allen
 */
public class BrickRow {

    private int pointValue;
    private Color color;
    private boolean[] brickmask;

    public BrickRow() {
        pointValue = 0;
        color = Color.RED;
        brickmask = new boolean[15];
    } // Initializes all properties to default values

    public BrickRow(int ptVal, Color clr, String bMask) {
        pointValue = ptVal;
        color = clr;
        brickmask = new boolean[bMask.length()];

        for (int i = 0; i < bMask.length(); i++) {
            if (bMask.charAt(i) == '1') {
                brickmask[i] = true;

            } else {
                brickmask[i] = false;
            }
        }
    } 

    public boolean getBrickMaskValue(int index) {
        return brickmask[index];
    }

    public void setBrickMaskValue(int index, boolean value) {
        brickmask[index] = value;
    }

    public int getBrickMaskLength() {
        return brickmask.length;
    }

    @Override
    public String toString() {
        String str;
        str = pointValue + System.lineSeparator();
        str += (int)(color.getRed()* 255) + " ";
        str += (int)(color.getGreen()* 255) + " ";
        str += (int) (color.getBlue()* 255) + System.lineSeparator();

        for (int i = 0; i < brickmask.length; i++) {
            if (brickmask[i] == (true)) {
                str += "1";
            } else {
                str += "0";

            }

        }

        return str;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
