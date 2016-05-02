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
    
    
    public void elevatorGetUpQueue(FloorArray floors, Elevator[] elevators, int currentFloor)
    {
        Floor floor = floors.getFloor(currentFloor);

        if ( elevators[0].getNumberOfPeople() < Config.elevatorCapacity )
        {
            Person personFromUpQueue = floor.getFromUpQueue();

            LinkedList<Person> people = elevators[0].getDesitnations()[currentFloor]; 

            people.add(personFromUpQueue);
        }
        else
        {
            // Do nothing
        }   
    }
    
    public void elevatorGetDownQueue(FloorArray floors, Elevator[] elevators, int currentFloor)
    {
        Floor floor = floors.getFloor(currentFloor);
        
        if ( elevators[0].getNumberOfPeople()< Config.elevatorCapacity )
        {
            Person personFromDownQueue = floor.getFromDownQueue();
            
            LinkedList<Person> people = elevators[0].getDesitnations()[currentFloor]; 
        
            people.add(personFromDownQueue);
        }
        else
        {
            // Do nothing
        }
    }
}
