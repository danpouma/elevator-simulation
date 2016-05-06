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
        PeopleGenerator peopleGen = new PeopleGenerator();
        peopleGen.generatePeople();
        // Create building
        Building building = new Building(peopleGen.getPeople());
        
        /*
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = building.getFloors().getFloor(floor);
            
            for (int people = 0; people < 10; people++)
            {
      
                currentFloor.addPerson(peopleGen.generatePerson());

            }
        }
        */
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = building.getFloors().getFloor(floor);
    
            //building.moveElevators();        
            
            System.out.println("Floor " + floor + ": " + currentFloor.numberOfPeopleOnFloor());
        }
    }
}
