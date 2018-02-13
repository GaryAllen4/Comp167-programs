/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campuspeople;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gary Allen
 */
public class Person {

    private String firstname;
    private String lastname;
    private String studentId;
    private Date birthDate;
    private String phoneNumber;

    public Person() {
        firstname = "";
        lastname = "";
        studentId = "";
        birthDate = new Date();
        phoneNumber = "";
    }

    public Person(String fname, String lname, String sId, String birthDate, String phoneNumber) {
        this.firstname = fname;
        this.lastname = lname;
        this.studentId = sId;
        this.birthDate = stringToDate(birthDate);
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {

        return firstname + "," + lastname + "," + studentId + "," + dateToString(birthDate) + "," + phoneNumber;

    }

    private Date stringToDate(String sDate) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return df.parse(sDate);
        } catch (java.text.ParseException ex) {
            System.err.println("Could not convert input date to Date object: " + sDate);
            System.exit(-1);
        }
        return null;
    }

    private String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(date);
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
