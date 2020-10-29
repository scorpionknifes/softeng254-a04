package se254.a4.t3;

/**
 * Class represents a polishing job on a floor with a polishing machine.
 * 
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 * 
 * Removed duplicated code and moved function into Floor.rent(). Code
 * is duplicated from CleaningJob. Feature envy as rent calculation relies 
 * extensively on floor to operate.
 * 
 * Remove coupling by passing in primitive values instead of polisher class.
 *
 */
public class PolishingJob {
    double polishingRent(Floor floor, PolishingMachine polisher) {
        return floor.rent(polisher.getCapability(), polisher.costPerUnitElectricity());
    }
}