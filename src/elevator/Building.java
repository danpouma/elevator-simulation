package elevator;

/**
 *
 * @author dpoumakis
 */
public class Building
{
    private Elevator[] elevators;
    private FloorArray floors;
    
    // Many ways to structure the controller, work on it
    private ElevatorController elevatorController;
    
    private int currentFloor;
    
    // Can probably use enum for this
    private int currentDirection;
    
    public Building()
    {
        // Initialize the elevators
        elevators = new Elevator[Config.numberOfElevators];
        for (int elevator = 0; elevator < Config.numberOfElevators; elevator++)
        {
            // Create elevator in each null element
            elevators[elevator] = new Elevator();
        }
        
        // Initialize the floors
        floors = new FloorArray();
        
        // Initialize the controller (might require more info
        elevatorController = new ElevatorController();
        
        // Could be determined by gui
        currentFloor = 0;
        
        // Figure out how to use enum for this
        // also could be determined by gui
        currentDirection = 0;
        
    }
    
    public void moveElevator(int direction)
    {
        // use controller to move up
    }
    
    public void addPerson(Person person)
    {
        // Hand person to the floor array
    }
    
}
