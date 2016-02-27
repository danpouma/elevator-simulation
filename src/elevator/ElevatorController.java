package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class ElevatorController
{
    public ElevatorController()
    {
        // Controller classes shouldn't hold data
        // therefore... empty default constructor
    }
    
    public void moveElevator(FloorArray floors, Elevator[] elevators)
    {
        // Add people
        for (int elevator = 0; elevator < elevators.length; elevator++)
        {
            Elevator currentElevator = elevators[elevator];
            for (int floor = 0; floor < floors.getSize(); floor++)
            {
                Floor currentFloor = floors.getFloor(floor);
                
                currentElevator = addPeople(currentFloor, currentElevator);
            }
            System.out.println(currentElevator.getPeople().size());   
        }
        
        // Remove people
        
        /*
        Figure out how to clear people that's stop floor
        matches the one passed.
        Every is maxFloor and only half were removed....
        */
        elevators[0].removePerson(Config.maxFloor);
        System.out.println(elevators[0].getPeople().size());
    }
    
    public Elevator addPeople(Floor floor, Elevator elevator)
    {
        // Will need to implement the isFull() method eventually
        while (!floor.isEmpty()) //&& !currentElevator.isFull())
        {
            elevator.addPerson(floor.getFromUpQueue());
        }
        
        return elevator;
    }
    
    public Elevator removePeople(Floor floor, Elevator elevator)
    {
        ArrayList<Person> peopleRemoved;
        
        peopleRemoved = elevator.removePerson(floor.getFloorNumber());
        
        System.out.println("Floor "+floor.getFloorNumber() +": " +peopleRemoved.size());
        
        return elevator;
    }
    
}
