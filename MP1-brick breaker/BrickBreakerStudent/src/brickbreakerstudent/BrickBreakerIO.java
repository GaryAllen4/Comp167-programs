/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.scene.paint.Color;

/**
 *
 * @author Gary Allen
 */
public class BrickBreakerIO {

    public static Level[] readConfigFile(String cFileName) {

        try {

            Scanner input = new Scanner(new File(cFileName));
            int nLevels = input.nextInt();
            Level[] level = new Level[nLevels];

            for (int i = 0; i < nLevels; i++) {
                int readLevelNum = input.nextInt();
                int rowNum = input.nextInt();

                Level levl = new Level(readLevelNum, rowNum);

                for (int j = 0; j < rowNum; j++) {
                    input.next();

                    double red = input.nextDouble() / 255;
                    double green = input.nextDouble() / 255;
                    double blue = input.nextDouble() / 255;
                    Color clrs = Color.color(red, green, blue);
                    int ptVal = input.nextInt();
                    String bMask = input.next();
                    BrickRow bRow = new BrickRow(ptVal, clrs, bMask);
                    levl.setBrickRow(j, bRow);
                    System.out.println(j);
                }

                level[i] = levl;

            }
            return level;
        } catch (FileNotFoundException ex) {
            System.out.print("File was not read, sorry!");
            System.exit(-1);
            return null;
        }
    }

    public static void readProfiles(GameProfiles gmProf, String pFileName) {
        try {
            Scanner input = new Scanner(new File(pFileName));

            while(input.hasNext()) {
                String format = input.nextLine();
                PlayerProfile plyr = new PlayerProfile(format);

                int numGamesPlayed = input.nextInt();
                int highScore = input.nextInt();
                plyr.setNumGamesPlayed(numGamesPlayed);
                plyr.setHighScore(highScore);
               
                int numSavedFiles = input.nextInt();
                if (input.hasNextLine()) {
                    input.nextLine();
                    for (int j = 0; j < numSavedFiles; j++) {
                        String saveFiles = input.nextLine();
                        plyr.addGame(saveFiles);
                    }
                }
                gmProf.addProfile(plyr);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Can't read your file!");
        }
    }

    public static void writeProfiles(GameProfiles gmProf, String pFileName) {
        try {
            PrintWriter writing = new PrintWriter(new File(pFileName));
            writing.print(gmProf.toString());
            writing.close();
        } catch (FileNotFoundException ex) {
            System.out.println("");
            System.exit(-1);
        } 
    }

}
