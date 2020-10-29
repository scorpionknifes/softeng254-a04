package se254.a4.t3;

/**
 * Class represents a cleaning job on a floor with a cleaning machine.
 * 
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 *
 * Removed duplicated code and moved function into Floor.rent(). Code
 * is duplicated from PolishingJob. Feature envy as rent calculation relies 
 * extensively on floor to operate.
 * 
 * Remove coupling by passing in primitive values instead of cleaner class.
 *
 */

public class CleaningJob {
    // The method inputs the floor and cleaner objects and
    // calculates the energy consumption cost for cleaning the floor area
    double cleaningRent(Floor floor, CleaningMachine cleaner) {
        return floor.rent(cleaner.getCapability(), cleaner.costPerUnitElectricity());
    }
}
