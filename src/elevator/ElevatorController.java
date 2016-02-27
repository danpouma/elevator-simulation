package elevator;

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
        for (int elevator = 0; elevator < elevators.length; elevator++)
        {
            Elevator currentElevator = elevators[elevator];
            for (int floor = 0; floor < floors.getSize(); floor++)
            {
                Floor currentFloor = floors.getFloor(floor);
                
                currentElevator.addPerson(currentFloor.getFromUpQueue());
            }
        }
    }
    
}
