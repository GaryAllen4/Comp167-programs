/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleinheritance;

/**
 *
 * @author G-Smoove
 */
class House extends Dwelling{
     private double acreage;

    private int garageSize;



    public House() {

        super();

        acreage = 0.0;

        garageSize = 0;

    }

    

    /**

     * @return the acreage

     */

    public double getAcreage() {

        return acreage;

    }



    /**

     * @param acreage the acreage to set

     */

    public void setAcreage(double acreage) {

        this.acreage = acreage;

    }



    /**

     * @return the garageSize

     */

    public int getGarageSize() {

        return garageSize;

    }



    /**

     * @param garageSize the garageSize to set

     */

    public void setGarageSize(int garageSize) {

        this.garageSize = garageSize;

    }

    

    @Override

    public String toString() {

        return super.toString() + "|" + acreage + "|" + garageSize;

    }
}
