package elevator;

/**
 *
 * @author dpoumakis
 */
public class Building
{
    private int currentFloor;
    private Elevator[] elevators;
    private ElevatorController elevatorController;
    private FloorArray floors;
    
    public Building()
    {   
        currentFloor = 0;
        elevators = new Elevator[Config.numberOfElevators];
        for (int elevator = 0; elevator < Config.numberOfElevators; elevator++)
        {
            elevators[elevator] = new Elevator();
        }
        elevatorController = new ElevatorController();
        floors = new FloorArray();
    }
    
    public FloorArray getFloor()
    {
        return floors;
    }
    
    public Elevator[] getElevators()
    {
        return elevators;
    }
    
    // Eventually remove this
    public void moveElevator() 
    {
        elevatorController.moveElevator(floors, elevators);
    }
    
    public void addCurrentFloorToElevator(int direction)
    {
        Floor floor = floors.getFloor(currentFloor);
        
        if (direction == Config.UP)
        {
            while (!floor.getUpQueue().isEmpty())
            {
                Person personFromUpQueue = floor.getFromUpQueue();

                elevators[0].addPerson(personFromUpQueue);
            }
        }
        else if (direction == Config.DOWN)
        {
            while (!floor.getDownQueue().isEmpty())
            {
                Person personFromDownQueue = floor.getFromDownQueue();

                elevators[0].addPerson(personFromDownQueue);
            }
            floor.getFromDownQueue();
        }
        else
        {
            // Do nothing
        }
    }
    
    public void moveElevator(int direction)
    {
        // Get people from current floor before moving
        if (elevators[0].getNumberOfOccupants() < Config.elevatorCapacity )
        {
            addCurrentFloorToElevator(direction);
        
            if (direction == Config.UP && currentFloor < Config.maxFloor-1)
            {
                moveElevatorUp();
            }
            else if (direction == Config.DOWN && currentFloor >= 1)
            {
                moveElevatorDown();
            }
            else
            {
                // Do nothing, invalid direction
            }
        }
        else
        {
            // Do nothing
        }

    }
    
    public void moveElevatorUp()
    {
        currentFloor++;
        elevatorController.moveElevatorUp(floors, elevators, currentFloor);
    }
    
    public void moveElevatorDown()
    {
        currentFloor--;
        elevatorController.moveElevatorDown(floors, elevators, currentFloor);
    }
    
    public void addPerson(Person person)
    {
        floors.addPerson(person, person.getStartFloor());
    }
    
    public void addPerson(Person person, int floor)
    {
        floors.addPerson(person, floor);
    }
    
    public FloorArray getFloors()
    {
        return floors;
    }
    
    public boolean hasPeopleInQueue()
    {
        boolean hasPeopleInQueue = false;
        
        Floor thisFloor;
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            thisFloor = floors.getFloor(floor);
            
            if (!thisFloor.isEmpty())
            {
                hasPeopleInQueue = true;
            }
        }
        
        return hasPeopleInQueue;
    }
    
    public int getNumberOfPeople()
    {
        return floors.getNumberOfPeople();
    }
}
