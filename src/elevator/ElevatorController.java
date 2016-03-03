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
        ArrayList<Floor> floorArray = floors.getFloors();

        for (Elevator elevator : elevators)
        {
            for (Floor floor : floorArray)
            {
                for (int people = 0; people < 10; people++)
                {
                    Person personFromUpQueue = floor.getFromUpQueue();

                    elevator.addPerson(personFromUpQueue);
                }
            }
        }
    }
}
