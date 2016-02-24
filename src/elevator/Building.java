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
        
        // Initialize the floors
        
        // Initialize the controller
        
        currentFloor = 0;
        
        // Figure out how to use enum for this
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
