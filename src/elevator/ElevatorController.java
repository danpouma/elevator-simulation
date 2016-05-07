package elevator;

import java.util.LinkedList;

/**
 *
 * @author dpoumakis
 */
public class ElevatorController
{
    // Empty default contructor
    public ElevatorController() {}
    
    
    public void elevatorGetUpQueue(FloorArray floors, Elevator[] elevators)
    {
        int currentFloor = elevators[0].getCurrentFloor();
        
        Floor floor = floors.getFloor(currentFloor);
        
        LinkedList[] destination = elevators[0].getDesitnations();

        if ( !elevators[0].isFull() ) 
        {
            Person personFromUpQueue = floor.getFromUpQueue();
            
            destination[currentFloor].add(personFromUpQueue);
        }
        else
        {
            System.out.println("full up");
            // Do nothing
        }   
    }
    
    /*
    public void elevatorGetDownQueue(FloorArray floors, Elevator[] elevators)
    {
        Floor floor = floors.getFloor(currentFloor);
        
        if ( elevators[0].getNumberOfPeople() < Config.elevatorCapacity )
        {
            Person personFromDownQueue = floor.getFromDownQueue();
            
            elevators[0].getDesitnations()[currentFloor].add(personFromDownQueue);
        }
        else
        {
            System.out.println("full down");
            // Do nothing
        }
    }
    */
}
