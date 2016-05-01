package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class ElevatorController
{

    public ElevatorController() {}
    
    public void moveElevator(FloorArray floors, Elevator2[] elevators)
    {
        ArrayList<Floor> floorArray = floors.getFloors();

        for (Elevator2 elevator : elevators)
        {
            int floorCount = 0;
            
            for (Floor floor : floorArray)
            {
                elevator.removePeople(floorCount);
                
                while (!floor.getUpQueue().isEmpty())
                {
                    Person personFromUpQueue = floor.getFromUpQueue();

                    elevator.addPerson(personFromUpQueue);
                }
                
                floorCount++;
            }
        }
    }
    
    public void moveElevatorUp(FloorArray floors, Elevator2[] elevators, int currentFloor)
    {
        Floor floor = floors.getFloor(currentFloor);
        
        while (!floor.getUpQueue().isEmpty() && elevators[0].getNumberOfOccupants() < Config.numberOfPeople)
        {
            if ( elevators[0].getNumberOfOccupants() < Config.numberOfPeople )
            {
                Person personFromUpQueue = floor.getFromUpQueue();
            
                elevators[0].addPerson(personFromUpQueue);
            }
            else
            {
                // Do nothing
            }
            
        }
    }
    
    public void moveElevatorDown(FloorArray floors, Elevator2[] elevators, int currentFloor)
    {
        Floor floor = floors.getFloor(currentFloor);
        
        while (!floor.getDownQueue().isEmpty() && elevators[0].getNumberOfOccupants() < Config.numberOfPeople)
        {
            if ( elevators[0].getNumberOfOccupants() < Config.elevatorCapacity )
            {
                Person personFromDownQueue = floor.getFromDownQueue();
            
                elevators[0].addPerson(personFromDownQueue);
            }
            else
            {
                // Do nothing
            }
            
        }
    }
}
