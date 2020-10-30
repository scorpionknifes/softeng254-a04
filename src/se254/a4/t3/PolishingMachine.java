package se254.a4.t3;

/**
 * Class represents a polishing machine with it's capability and cost efficiency
 * 
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 */
public class PolishingMachine {
    /**
     * @return capability
     */
    public int getCapability() {
        // capability defines the efficiency of polisher calculated out of 100
        return 82;
    }

    /**
     * @return cost per unit electricity
     */
    public double costPerUnitElectricity() {
        // cost per unit of electricity consumed by the polisher
        return 4.5;
    }

}
