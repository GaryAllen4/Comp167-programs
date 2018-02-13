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
public class GameProfiles {

    private PlayerProfile selectedProfile;
    private PlayerProfile highGameProfile;
    private ArrayList<PlayerProfile> profiles;
    private String pName;

    public GameProfiles() {
        selectedProfile = new PlayerProfile();
        highGameProfile = new PlayerProfile();
        profiles = new ArrayList<PlayerProfile>();
        pName = "brickbreakerprofiles.txt";
    }

    public PlayerProfile getSelectedProfile() {
        return selectedProfile;
    }

    public PlayerProfile getHighGameProfile() {
        return highGameProfile;
    }

    public void setHighGameProfile(PlayerProfile prof) {
        highGameProfile = prof;
    }

    public int getNumProfiles() {
        return profiles.size();
    }

    public PlayerProfile getProfile(int index) {
        return profiles.get(index);
    }

    public void setProfile(int index, PlayerProfile item) {
        profiles.set(index, item);
    }

    public void addProfile(PlayerProfile item) {
        profiles.add(item);
    }

    public PlayerProfile deleteProfile(int index) {
        PlayerProfile delete = getProfile(index);
        return delete;
    }

    @Override
    public String toString() {
        String format = "";
        for (int i = 0; i < profiles.size(); i++) {
            format += profiles.get(i);
        }
        return format;
    }

    public String getProfileFilename() {
        return pName;
    }

    public void setProfileFilename(String pName) {
        this.pName = pName;
    }

    /**
     * @param selectedProfile the selectedProfile to set
     */
    public void setSelectedProfile(PlayerProfile selectedProfile) {
        this.selectedProfile = selectedProfile;
    }
}
