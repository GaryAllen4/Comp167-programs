/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campuspeople;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gary Allen
 */
public class Department {

    private String name;
    private String location;
    private ArrayList<Employee> employees;
    private ArrayList<Student> students;

    public Department() {
        name = "";
        location = "";
        employees = new ArrayList<>();
        students = new ArrayList<>();
    }

    public Department(String name, String location) {
        this.name = name;
        this.location = location;

    }

    /**
     *      * @return the name      
     */
    private String getName() {
        return name;
    }

    /**
     *      * @param name the name to set      
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     *      * @return the location      
     */
    private String getLocation() {
        return location;
    }

    /**
     *      * @param location the location to set      
     */
    private void setLocation(String location) {
        this.location = location;
    }

    public void readDepartment(String filename) {
        try {
            Scanner input = new Scanner(new File(filename));
            name = input.nextLine();
            location = input.nextLine();

            while (input.hasNext()) {
                String letter = input.next();
                input.nextLine();
                String[] person = input.nextLine().split(",");
                System.out.println(java.util.Arrays.toString(person));
                if (letter.equals("F")) {
                    Faculty faculty = new Faculty();

                    faculty.setFirstname(person[0].trim());
                    faculty.setLastname(person[1].trim());
                    faculty.setStudentId(person[2].trim());
                    faculty.setBirthDate(stringToDate(person[3].trim()));
                    faculty.setPhoneNumber(person[4].trim());

                    String[] employee = input.nextLine().split(",");
                    faculty.setHireDate(stringToDate(employee[0].trim()));
                    faculty.setStatus(employee[1].trim());
                    faculty.setDepartment(employee[2].trim());

                    String[] worker = input.nextLine().split(",");
                    faculty.setRank(worker[0].trim());
                    faculty.setResearchArea(worker[1].trim());

                    String[] courses = input.nextLine().split(",");

                    for (int i = 0; i < courses.length; i++) {
                        faculty.addWidget(courses[i].trim());
                    }
                    this.employees.add(faculty);
                    
                } else if (letter.equals("S")) {
                    Staff staff = new Staff();

                    staff.setFirstname(person[0].trim());
                    staff.setLastname(person[1].trim());
                    staff.setStudentId(person[2].trim());
                    staff.setBirthDate(stringToDate(person[3].trim()));
                    staff.setPhoneNumber(person[4].trim());

                    String[] employee = input.nextLine().split(",");
                    staff.setHireDate(stringToDate(employee[0].trim()));
                    staff.setStatus(employee[1].trim());
                    staff.setDepartment(employee[2].trim());

                    String[] work = input.nextLine().split(",");
                    staff.setJobTitle(work[0].trim());
                    staff.setSupervisor(work[1].trim());
                    staff.setCareerBand(work[2].trim());
                    this.employees.add(staff);
                    

                } else if (letter.equals("U")) {
                    Student school = new Student();

                    school.setFirstname(person[0].trim());
                    school.setLastname(person[1].trim());
                    school.setStudentId(person[2].trim());
                    school.setBirthDate(stringToDate(person[3].trim()));
                    school.setPhoneNumber(person[4].trim());

                    String[] course = input.nextLine().split(",");
                    school.setMajor(course[0].trim());
                    school.setCreditHours(Integer.parseInt(course[1].trim()));
                    school.setGpa(Float.parseFloat(course[2].trim()));

                    String[] courses = input.nextLine().split(",");

                    for (int i = 0; i < courses.length; i++) {
                        school.addWidget(courses[i].trim());

                    }
                    this.students.add(school);
                    

                } else if (letter.equals("G")) {
                    GraduateStudent grad = new GraduateStudent();

                    grad.setFirstname(person[0].trim());
                    grad.setLastname(person[1].trim());
                    grad.setStudentId(person[2].trim());
                    grad.setBirthDate(stringToDate(person[3].trim()));
                    grad.setPhoneNumber(person[4].trim());

                    String[] course = input.nextLine().split(",");
                    grad.setMajor(course[0].trim());
                    grad.setCreditHours(Integer.parseInt(course[1].trim()));
                    grad.setGpa(Float.parseFloat(course[2].trim()));

                    String[] courses = input.nextLine().split(",");
                    for (int i = 0; i < courses.length; i++) {
                        grad.addWidget(courses[i].trim());
                    }

                    String[] thesis = input.nextLine().split(",");
                    grad.setThesis(thesis[0].trim());
                    grad.setConcentration(thesis[1].trim());
                    grad.setAssistanceType(thesis[2].trim());
                    this.students.add(grad);
                   
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.print("Could not read your file");
        }
    }

    public void writeDepartment(String filename) {
        try {
            PrintWriter writeIt = new PrintWriter(filename);
            writeIt.print(this);
            writeIt.close();
        } catch (FileNotFoundException ex) {
            System.out.print("Could not read your file");
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Faculty) {
                str += "F";
            } else {
                str += "S";
            }
            str += System.lineSeparator() + employees.get(i) + System.lineSeparator();
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) instanceof GraduateStudent) {
                str += "G";
            } else {
                str += "U";
            }
            str += System.lineSeparator() + students.get(i) + System.lineSeparator();
        }

        return name + System.lineSeparator() + location + System.lineSeparator() + str;
    }

    private static Date stringToDate(String sDate) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return df.parse(sDate);
        } catch (java.text.ParseException ex) {
            System.err.println("Could not convert input date to Date object: " + sDate);
            System.exit(-1);
        }
        return null;
    }

    public int getNumEmployees() {
        return employees.size();
    }

    public Employee getEmployees(int index) {
        return employees.get(index);
    }

    public void setEmployees(int index, Employee item) {
        employees.set(index, item);
    }

    public void addEmployees(Employee item) {
        employees.add(item);
    }

    public void deleteEmployees(int index) {
        employees.remove(index);
    }

    public int getNumStudents() {
        return students.size();
    }

    public Student getStudents(int index) {
        return students.get(index);
    }

    public void setCards(int index, Student item) {
        students.set(index, item);
    }

    public void addStudents(Student item) {
        students.add(item);
    }

    public void deleteStudents(int index) {
        students.remove(index);
    }
}
