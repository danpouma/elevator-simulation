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
                building.getFloors().getFloor(floor).addPerson(peopleGen.generatePerson());
            }            
        }
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
        building.moveElevtors();
    }
}