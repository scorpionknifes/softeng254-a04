package se254.a4.t3;

/**
 * Class represents a floor. A floor has a length, width and condition.
 * 
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 *
 * Fix Feature Envy by moving rent calculation from CleaningJob and
 * PolishingJob to Floor. Feature Envy smell because the method relies
 * extensively on floor to operate. also fixes Duplciated code from
 *
 */

public class Floor {

    public int length() {
        // length of the floor
        return 21;
    }

    public int width() {
        // width of the floor
        return 45;
    }

    public int getCondition() {
        // Current condition of the floor rated on the scale of 1 (worst) to 10 (best)
        return 5;
    }

    public double rent(int capability, double costPerUnitElectricity) {
        double floorArea = length() * width();
        double electricityPerUnitArea = getCondition() * capability;
        double energyConsumption = electricityPerUnitArea * floorArea;

        return energyConsumption * costPerUnitElectricity;
    }

}
