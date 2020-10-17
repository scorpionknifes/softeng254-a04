package se254.a4.t3;

/**
 * [ADD COMMENTS] Describe the class
 * 
 * @author Author Name: [YOUR NAME] Author UPI: [YOUR UPI]
 * @version Date: [CURRENT DATE] 
 *
 * Changed Performed: 
 * [Explain the changes made and their rationale. 
 * This description may overlap with the contents of commit messages]
 * 
 * Note: You may create new classes, methods or fields in this package
 *
 */

public class CleaningJob {
	// The method inputs the floor and cleaner objects and
    // calculates the energy consumption cost for cleaning the floor area
	double cleaningRent(Floor floor, CleaningMachine cleaner) {
		
		double floorArea = floor.length() * floor.width();
		double electricityPerUnitArea = floor.getCondition() * cleaner.getCapability();
		double energyConsumption = electricityPerUnitArea * floorArea;
		
		return energyConsumption * cleaner.costPerUnitElectricity();
	}	
}
