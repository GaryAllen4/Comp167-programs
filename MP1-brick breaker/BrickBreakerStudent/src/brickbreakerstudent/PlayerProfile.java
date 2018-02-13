/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

import java.util.ArrayList;

/**
 *
 * @author Gary Allen
 */
public class PlayerProfile { // Encapsulates the data for a single player

    private String name;
    private int numGamesPlayed;
    private int highScore;
    private ArrayList<String> savedGames;

    public PlayerProfile() {
        name = "John";
        numGamesPlayed = 0;
        highScore = 0;
        savedGames = new ArrayList<String>();

    }

    public PlayerProfile(String name) {
        this.name = name;
        numGamesPlayed = 0;
        highScore = 0;
        savedGames = new ArrayList<String>();
    }

    @Override
    public String toString() {
        String format = getName() + System.lineSeparator();
        format += getNumSavedGames() + System.lineSeparator();
        format += getHighScore() + System.lineSeparator();
        format += getSavedGames().size() + System.lineSeparator();

        for (int i = 0; i < getSavedGames().size(); i++) {

            format += getSavedGames().get(i) + System.lineSeparator();
        }

        return format;
    }

    public int getNumSavedGames() {
        return getSavedGames().size();
    }

    public String getSavedGameFile(int index) {
        return getSavedGames().get(index);
    }

    public void setSavedGameFile(int index, String item) {
        getSavedGames().set(index, item);

    }

    public void addGame(String item) {
        getSavedGames().add(item);

    }

    public String deleteGame(int index) {
        return getSavedGames().remove(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumGamesPlayed() {
        return numGamesPlayed;
    }

    public void setNumGamesPlayed(int numGamesPlayed) {
        this.numGamesPlayed = numGamesPlayed;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public ArrayList<String> getSavedGames() {
        return savedGames;
    }

    public void setSavedGames(ArrayList<String> saveGames) {

    }

}
