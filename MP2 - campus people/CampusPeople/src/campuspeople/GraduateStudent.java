/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campuspeople;

/**
 *
 * @author Gary Allen
 */
public class GraduateStudent extends Student {

    private String thesis;
    private String concentration;
    private String assistanceType;

    public GraduateStudent() {
        thesis = "";
        concentration = "";
        assistanceType = "";

    }

    @Override
    public String toString() {

        return super.toString() + System.lineSeparator() + thesis + "," + concentration + "," + assistanceType;

    }

    /**
     * @return the thesis
     */
    public String getThesis() {
        return thesis;
    }

    /**
     * @param thesis the thesis to set
     */
    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    /**
     * @return the concentration
     */
    public String getConcentration() {
        return concentration;
    }

    /**
     * @param concentration the concentration to set
     */
    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    /**
     * @return the assistanceType
     */
    public String getAssistanceType() {
        return assistanceType;
    }

    /**
     * @param assistanceType the assistanceType to set
     */
    public void setAssistanceType(String assistanceType) {
        this.assistanceType = assistanceType;
    }
}
