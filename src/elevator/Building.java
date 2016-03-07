package elevator;

/**
 *
 * @author dpoumakis
 */
public class Building
{
    private Elevator[] elevators;
    private ElevatorController elevatorController;
    private FloorArray floors;
    private PeopleGenerator peopleGen;
    
    public Building()
    {   
        elevators = new Elevator[Config.numberOfElevators];
        for (int elevator = 0; elevator < Config.numberOfElevators; elevator++)
        {
            elevators[elevator] = new Elevator();
        }
        elevatorController = new ElevatorController();
        floors = new FloorArray();
        peopleGen = new PeopleGenerator();
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            for (int person = 0; person < Config.numberOfPeople; person++)
            {
                floors.addPerson(peopleGen.generatePerson(), floor);
            }
        }
    }
    
    public FloorArray getFloor()
    {
        return floors;
    }
    
    public Elevator[] getElevators()
    {
        return elevators;
    }
    
    public void moveElevator() 
    {
        elevatorController.moveElevator(floors, elevators);
        
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
        return floors.getNumberOfFloors();
    }
}
