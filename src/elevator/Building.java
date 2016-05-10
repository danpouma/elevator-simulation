package elevator;

import java.util.Stack;

/**
 *
 * @author dpoumakis
 */
public class Building
{

    private Elevator[] elevators;
    private ElevatorController elevatorController;
    private FloorArray floors;

    // Default building
    public Building()
    {
        elevators = new Elevator[Config.numberOfElevators];
        for (int elevator = 0; elevator < Config.numberOfElevators; elevator++)
        {
            elevators[elevator] = new Elevator();
        }
        elevatorController = new ElevatorController();
        floors = new FloorArray();
    }

    // Building generated with people
    public Building(Stack<Person> people)
    {
        elevators = new Elevator[Config.numberOfElevators];
        for (int elevator = 0; elevator < Config.numberOfElevators; elevator++)
        {
            elevators[elevator] = new Elevator();
        }
        elevatorController = new ElevatorController();
        floors = new FloorArray();

        for (Person person : people)
        {
            floors.getFloor(person.getStartFloor()).addPerson(person);
        }
    }

    // Get the elevators
    public Elevator[] getElevators()
    {
        return elevators;
    }

    // Get the floors
    public FloorArray getFloors()
    {
        return floors;
    }

    // Get the elevator controller
    public ElevatorController getElevatorController()
    {
        return elevatorController;
    }

    // Fill this eventually.
    public void moveElevators()
    {
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            int currentFloor = elevators[0].getCurrentFloor();

            FloorQueue upQueue = floors.getFloor(currentFloor).getUpQueue();
            FloorQueue downQueue = floors.getFloor(currentFloor).getDownQueue();

            while (!upQueue.isEmpty() && !elevators[0].isFull())
            {
                elevatorController.elevatorGetUpQueue(floors, elevators);
            }

            while (!downQueue.isEmpty() && !elevators[0].isFull())
            {
                elevatorController.elevatorGetDownQueue(floors, elevators);
            }

            while (elevators[0].peopleGettingOff())
            {
                elevatorController.removePeopleStopFloor(floors, elevators);
            }

            elevators[0].elevate();
        }

        // Reset the floor
        elevators[0].setCurrentFloor(0);

    }
}
