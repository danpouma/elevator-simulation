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
        // Start from bottom go to top
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = floors.getFloor(floor);
            
            elevators[0].removePeople(floor);
            System.out.println(elevators[0].getNumberOfOccupants());
            while (currentFloor.upIsOn() && !elevators[0].isFull())
            {
                elevators[0].addPerson(currentFloor.getFromUpQueue());
                System.out.println(elevators[0].getNumberOfOccupants());
            }
        }
        
        // Start from top go to bottom
        for (int floor = Config.maxFloor-1; floor >= 0; floor--)
        {
            Floor currentFloor = floors.getFloor(floor);
            
            elevators[0].removePeople(floor);
            
            while (currentFloor.downIsOn() && !elevators[0].isFull())
            {
                elevators[0].addPerson(currentFloor.getFromUpQueue());
            }
        }
    }
    
    public Elevator addPeople(Floor floor, Elevator elevator)
    {
        // Will need to implement the isFull() method eventually
        while (!floor.isEmpty() && !elevator.isFull())
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
