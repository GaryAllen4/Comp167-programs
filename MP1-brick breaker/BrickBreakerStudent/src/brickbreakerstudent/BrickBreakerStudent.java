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
public class BrickBreakerStudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GameProfiles obj = new GameProfiles();
        BrickBreakerIO.readProfiles(obj, "brickbreakerprofiles.txt");
        PlayerProfile newProf = new PlayerProfile();
        obj.addProfile(newProf);
        BrickBreakerIO.writeProfiles(obj, "profile.txt");
        /*Level[] readConfigFile = BrickBreakerIO.readConfigFile("brickbreaker.txt");
        System.out.println(readConfigFile.length);
        for(int i = 0;i < readConfigFile.length; i++) {
        System.out.println(readConfigFile[i]);
        }*/

    }
}
