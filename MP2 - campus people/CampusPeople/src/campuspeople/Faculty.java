/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campuspeople;

import java.util.ArrayList;

/**
 *
 * @author Gary Allen
 */
public class Faculty extends Employee {

    private String rank;
    private String researchArea;
    protected ArrayList<String> currentCourses;

    public Faculty() {
        rank = "";
        researchArea = "";
        currentCourses = new ArrayList<>();
    }

    @Override
    public String toString() {
        String courses = "";
        for (int i = 0; i < currentCourses.size(); i++) {
            courses += currentCourses.get(i);
            if (i < currentCourses.size() - 1) {
                courses += ",";
            }
        }

        return super.toString() + System.lineSeparator() + rank + "," + researchArea + System.lineSeparator() + courses;

    }

    public int getNumWidgets() {
        return currentCourses.size();
    }

    public String getWidget(int index) {
        return currentCourses.get(index);
    }

    public void setWidget(int index, String item) {
        currentCourses.set(index, item);
    }

    public void addWidget(String item) {
        currentCourses.add(item);
    }

    public String deleteWidget(int index) {
        return currentCourses.remove(index);

    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return the researchArea
     */
    public String getResearchArea() {
        return researchArea;
    }

    /**
     * @param researchArea the researchArea to set
     */
    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

}
