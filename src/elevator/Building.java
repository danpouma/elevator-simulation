package elevator;

import java.util.LinkedList;
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
            
            FloorQueue upQueue = floors.getFloor(floor).getUpQueue();
            FloorQueue downQueue = floors.getFloor(floor).getDownQueue();
            
            for (int person = 0; person < upQueue.getSize(); person++ )
            {
                elevatorController.elevatorGetUpQueue(floors, elevators, currentFloor);
            }
            
            for (int person = 0; person < downQueue.getSize(); person++)
            {
                elevatorController.elevatorGetDownQueue(floors, elevators, currentFloor);
            }

            elevators[0].elevate();
        }
        

        LinkedList<Person>[] destinations = elevators[0].getDesitnations();

        for (LinkedList<Person> dest : destinations)
        {
            //System.out.println(dest.size());
        }
        
    }
}
