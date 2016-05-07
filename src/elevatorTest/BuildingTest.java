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
        
        FloorArray floors = building.getFloors();
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = floors.getFloor(floor);
            
            FloorQueue upQueue = currentFloor.getUpQueue();
            FloorQueue downQueue = currentFloor.getDownQueue();
            
            System.out.print("upQueue-> " + upQueue.getSize());
            System.out.println(" downQueue-> " + downQueue.getSize());
        }
        
        building.moveElevators();        
    }
}
