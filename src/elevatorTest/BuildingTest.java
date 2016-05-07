package elevatorTest;

import elevator.*;

/**
 *
 * @author dpoumakis
 */
public class BuildingTest
{
    public static void main(String[] args)
    {
        // set config type
        Config.setAssentType(1);
        
        PeopleGenerator peopleGen = new PeopleGenerator();
        peopleGen.generatePeople();
        // Create building
        Building building = new Building(peopleGen.getPeople());
        
        building.moveElevators();        
    }
}
