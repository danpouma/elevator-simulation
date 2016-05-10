package elevator;

/**
 *
 * @author dpoumakis
 */
public class ElevatorController
{

    // Empty default contructor

    public ElevatorController()
    {
    }

    public void elevatorGetUpQueue(FloorArray floors, Elevator[] elevators)
    {
        int currentFloor = elevators[0].getCurrentFloor();

        Floor floor = floors.getFloor(currentFloor);

        if (!elevators[0].isFull())
        {
            Person personFromUpQueue = floor.getFromUpQueue();

            elevators[0].addPerson(personFromUpQueue);
        }
        else
        {
            // Do nothing
        }
    }

    public void elevatorGetDownQueue(FloorArray floors, Elevator[] elevators)
    {
        int currentFloor = elevators[0].getCurrentFloor();

        Floor floor = floors.getFloor(currentFloor);

        if (!elevators[0].isFull())
        {
            Person personFromDownQueue = floor.getFromDownQueue();

            elevators[0].addPerson(personFromDownQueue);
        }
        else
        {
            // Do nothing
        }
    }

    public void removePeopleStopFloor(FloorArray floors, Elevator[] elevators)
    {
        elevators[0].removePerson();
    }
}
