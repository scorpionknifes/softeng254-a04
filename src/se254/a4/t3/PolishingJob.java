package se254.a4.t3;

/**
 * [ADD COMMENTS] Describe the class
 * 
 * @author Author Name: [YOUR NAME] Author UPI: [YOUR UPI]
 * @version Date: [CURRENT DATE] 
 * 
 * [Explain the changes made and their rationale. 
 * This description may overlap with the contents of commit messages]
 * 
 * Note: You may create new classes, methods or fields in this package
 *
 */

public class PolishingJob{
	double polishingRent(Floor floor, PolishingMachine polisher) {
		double floorArea = floor.length() * floor.width();
		double electricityPerUnitArea = floor.getCondition() * polisher.getCapability();
		double energyConsumption = electricityPerUnitArea * floorArea;
		return energyConsumption * polisher.costPerUnitElectricity();
	}
}