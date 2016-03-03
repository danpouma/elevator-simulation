package elevator;

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
            
            
            
            // damn u bug!!!
            elevators[0].removePerson(floor);
            
            
            while (!currentFloor.isEmpty()) //&& !elevators[0].isFull())
            {
                elevators[0].addPerson(currentFloor.getFromUpQueue());
                elevators[0].addPerson(currentFloor.getFromDownQueue());
            }
            
        }
    }
}
