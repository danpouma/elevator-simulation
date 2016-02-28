package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class ElevatorController
{
    public ElevatorController() {}
    
    public void moveElevator(FloorArray floors, Elevator[] elevators)
    {
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            elevators[0].removePeople(floor);
        }
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
        
        peopleRemoved = elevator.removePeople(floor.getFloorNumber());
        
        System.out.println("Floor "+floor.getFloorNumber() +": " +peopleRemoved.size());
        
        return elevator;
    }
    
}
