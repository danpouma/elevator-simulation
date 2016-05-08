package elevator;

/**
 *
 * @author dpoumakis
 */
public class Simulation
{
    private Building building;
    private PeopleGenerator peopleGen;
    private Clock clock;
    private Thread timer;
    
    public Simulation()
    {
        clock = new Clock();
        timer = new Thread(clock);
        timer.start();
        peopleGen = new PeopleGenerator();
        peopleGen.generatePeople();
        building = new Building(peopleGen.getPeople());
    }
    
    public Building getBuilding()
    {
        return building; 
    }
    
    public int numberOfPeople()
    {
        int numberOfPeople = 0;
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = building.getFloors().getFloor(floor);
            
            numberOfPeople += currentFloor.numberOfPeopleOnFloor();
        }
        
        return numberOfPeople;
    }
    
    public void moveElevator()
    {   
        while ( numberOfPeople() > 0 )
        {
            building.moveElevators(); 
            
            try
            {
                // Make clock data visible
                Thread.sleep(250);
            }
            catch (Exception e)
            {
                // Do nothing
            }
        }
    }
}