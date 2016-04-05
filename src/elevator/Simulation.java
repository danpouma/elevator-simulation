package elevator;

/**
 *
 * @author dpoumakis
 */
public class Simulation
{
    private Building building;
    private PeopleGenerator peopleGen;
    
    public Simulation()
    {
        building = new Building();
        peopleGen = new PeopleGenerator();
    }
    
    public void generatePeople()
    {
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            for (int person = 0; person < Config.numberOfPeople; person++)
            {
                building.addPerson(peopleGen.generatePerson(), floor);
            }
            
        }
    }
    
    public int numberOfPeople()
    {
        return building.getNumberOfPeople();
    }
    
    public void moveElevatorUp()
    {
        building.moveElevator(Config.UP);
        
        
        
    }
    
    public void moveElevatorDown()
    {
        building.moveElevator(Config.DOWN);
        
    }
}