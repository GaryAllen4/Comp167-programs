/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

/**
 *
 * @author Gary Allen
 */
public class Level { // 

    private int levelNum; // holds the level number
    private BrickRow[] brickRows; // array to hold the brick rows

    public Level() { 
        levelNum = 0;
        brickRows = new BrickRow[10];
    } // Sets properties in Level constructor to defaults

    public Level(int levelNum, int numBrickRows) {
        brickRows = new BrickRow[numBrickRows];
    }

    public BrickRow getBrickRow(int index) {
        return brickRows[index];
    }

    public void setBrickRow(int index, BrickRow bkRow) {
        brickRows[index] = bkRow;
    }

    @Override
    public String toString() {
        String str;
        str = "";
        str += levelNum + System.lineSeparator();
        str += brickRows.length + System.lineSeparator();

        for (int i = 0; i < brickRows.length; i++) {
            str += brickRows[i] + System.lineSeparator();
        }

        return str;

    } // Formats the output 

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public int getNumBrickRows() {
        return brickRows.length;
    }

    public int getBricksPerRow() {
        return brickRows[0].getBrickMaskLength();
    }

    /**
     *
     * @param brickRows
     */
    public void setBrickRows(BrickRow[] brickRows) {
        this.brickRows = brickRows;
    }
}
