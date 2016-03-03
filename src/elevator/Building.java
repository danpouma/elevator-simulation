package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class Building
{
    private int currentFloor;
    
    // Will need to have a better idea
    // of how the direction will be implemented
    private int currentDirection;
    
    private Elevator[] elevators;
    private ElevatorController elevatorController;
    private FloorArray floors;
    
    public Building()
    {
         //currentFloor = Config.startFloor; // have  0 by default
        currentFloor = 0;
        
        // Figure out how to use enum for this
        // also could be determined by gui
        currentDirection = 0;
        
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
    
    // Probably could rename to startElevator
    public void moveElevator() //int direction, int id)
    {
        
        // use controller to move elevator
        // add enums for up, down and none
        
        // Maybe pass elevator id?
        elevatorController.moveElevator(floors, elevators);
        
    }
    
    public void addPerson(Person person, int floor)
    {
        // Hand person to the floor array
        // By default user currentFloor
        //floors.addPerson(person, currentFloor);
        
        // Need to use this for now. How can i change currentFloor
        // from within the elevatorController?
        floors.addPerson(person, floor);
    }
    
    public FloorArray getFloors()
    {
        return floors;
    }
    
    // Lets increment floors this way for now...
    public void nextFloor()
    {
        currentFloor++;
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
        return floors.getNumberOfFloors();
    }
}
