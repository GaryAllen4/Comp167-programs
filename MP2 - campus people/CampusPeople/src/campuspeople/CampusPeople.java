/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campuspeople;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gary Allen
 */
public class CampusPeople {

   
    public static void main(String[] args) {
        Faculty faculty = new Faculty();
        faculty.setFirstname("Joseph");
        faculty.setLastname("Whittaker");
        faculty.setStudentId("8649231");
        faculty.setBirthDate(stringToDate("12/11/1960"));
        faculty.setPhoneNumber("336-444-7573");
        faculty.setHireDate(stringToDate("06/28/2010"));
        faculty.setStatus("FT");
        faculty.setDepartment("Biology");
        faculty.setRank("Professional");
        faculty.setResearchArea("CTE in Former Athletes");
        faculty.addWidget("BIO201");
        faculty.addWidget("BIO119");

        Staff staff = new Staff();
        staff.setFirstname("Kelvin");
        staff.setLastname("Bryant");
        staff.setStudentId("8574945");
        staff.setBirthDate(stringToDate("09/26/1964"));
        staff.setPhoneNumber("336-444-4444");
        staff.setHireDate(stringToDate("08/15/2007"));
        staff.setStatus("FT");
        staff.setDepartment("Computer Science");
        staff.setJobTitle("Director of Gaming and Fun Activities");
        staff.setSupervisor("Patrice Bryant");
        staff.setCareerBand("Advanced");

        Student school = new Student("Gary", "Allen", "950331858", "10/13/1997", "678-478-1919", "Computer Engineering", 31, 4.00f);
        school.addWidget("COMP167");
        school.addWidget("ECEN200");

        GraduateStudent grad = new GraduateStudent();
        grad.setFirstname("Felisha");
        grad.setLastname("Bowie");
        grad.setStudentId("9090909");
        grad.setBirthDate(stringToDate("10/10/1975"));
        grad.setPhoneNumber("678-499-8000");
        grad.setMajor("Applied Mathematics");
        grad.setCreditHours(44);
        grad.setGpa((float) 3.00);
        grad.addWidget("MATH131");
        grad.addWidget("MATH132");
        grad.setThesis("Applying Math Principles to Real World Activities");
        grad.setConcentration("Accounting");
        grad.setAssistanceType("TA");

        Department department = new Department();
        if (args.length > 0) {
            department.readDepartment(args[0]);
        }
        department.addEmployees(staff);
        department.addStudents(school);
        department.addEmployees(faculty);
        department.addStudents(grad);
        System.out.println("Enter a name for the created file: ");
        Scanner input = new Scanner(System.in);
        String filename = input.next();
        department.writeDepartment(filename);

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
}

 /**
     * @param args the command line arguments
     */
    /*private static Date stringToDate(String sDate) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return df.parse(sDate);
        } catch (java.text.ParseException ex) {
            System.err.println("Could not convert input date to Date object: " + sDate);
            System.exit(-1);
        }
        return null;
    }


    public static void main(String[] args) {
        Faculty f = new Faculty();
        f.setFirstname("Gary");
        f.setLastname("Allen");
        f.setStudentId("950331858");
        f.setBirthDate(stringToDate("10/13/1997"));
        f.setPhoneNumber("678-478-1926");
        f.setHireDate(stringToDate("10/19/2017"));
        f.setRank("Manager");
        f.setDepartment("Computer Engineering");
        f.setResearchArea("Computer Architecture");
        f.setStatus("PT");

        Staff member = new Staff();
        member.setFirstname("John");
        member.setLastname("Kelly");
        member.setStudentId("950331858");
        member.setBirthDate(stringToDate("10/13/1997"));
        member.setPhoneNumber("678-478-1926");
        member.setHireDate(stringToDate("10/19/2017"));
        member.setDepartment("Computer Engineering");
        member.setJobTitle("Professor");
        member.setSupervisor("Dr.John");
        member.setCareerBand("Professional");
        member.setStatus("PT");

        Student child = new Student("Jenae", "Allen", "123456789", "09/25/1998", "678-455-2391", "Computer Science", 70, 3.8f);

        GraduateStudent gradS = new GraduateStudent();
        gradS.setFirstname("Julio");
        gradS.setLastname("Jones");
        gradS.setStudentId("950335901");
        gradS.setBirthDate(stringToDate("5/10/1985"));
        gradS.setAssistanceType("TA");
        gradS.setThesis("Generic Register Allocation on CISC Architectures");
        gradS.setGpa((float) 3.99);
        gradS.setMajor("Computer Engineering");
        gradS.setCreditHours(86);
        gradS.setConcentration("Software Development");

        JOptionPane.showMessageDialog(null, f);
        JOptionPane.showMessageDialog(null, member);
        JOptionPane.showMessageDialog(null, child);
        JOptionPane.showMessageDialog(null, gradS);
    }*/