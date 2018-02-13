/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campuspeople;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gary Allen
 */
public class Student extends Person {

    protected String major;
    protected int creditHours;
    protected float gpa;
    protected ArrayList<String> classSchedule;

    public Student() {
        major = "";
        creditHours = 0;
        gpa = 0;
        classSchedule = new ArrayList<>();
    }

    @Override
    public String toString() {

        String output = "";

        for (int i = 0; i < classSchedule.size(); i++) {
            output += classSchedule.get(i);
            if (i < classSchedule.size() - 1) {
                output += ",";
            }
        }

        return super.toString() + System.lineSeparator() + major + "," + creditHours + "," + gpa + System.lineSeparator() + output;
    }

    public Student(String fname, String lname, String sId, String birthDate, String phoneNumber, String major, int creditHours, float gpa) {
        super(fname, lname, sId, birthDate, phoneNumber);
        this.major = major;
        this.creditHours = creditHours;
        this.gpa = gpa;
        classSchedule = new ArrayList<>();
    }

    public int getNumWidgets() {
        return classSchedule.size();
    }

    /**
     *
     * @param index
     * @return
     */
    public String getWidget(int index) {
        return classSchedule.get(index);
    }

    public void setWidget(int index, String item) {
        classSchedule.set(index, item);
    }

    public void addWidget(String item) {
        classSchedule.add(item);
    }

    public String deletWidget(int index) {
        return classSchedule.remove(index);

    } //Array List Handling

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the creditHours
     */
    public int getCreditHours() {
        return creditHours;
    }

    /**
     * @param creditHours the creditHours to set
     */
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    /**
     * @return the gpa
     */
    public float getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

}
