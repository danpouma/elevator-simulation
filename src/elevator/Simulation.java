package elevator;

/*
Building class (has Floor array and elevator and Elevator controller [simplified))

A very simple elevator Controller (i.e. dumb controller). 
One method returns which direction to go in, parameters of current floor, 
current direction and building size. continues in it's current direction until 
it can't - go up to the top, down to the bottom.

Simple simulation loop - put some people in the building, loop to move the 
elevator one floor at a time.

See lab help - simulation
*/

/**
 *
 * @author dpoumakis
 */
public class Simulation
{
    public static void main(String[] args)
    {     
        Building building = new Building();
        
        PeopleGenerator peopleGen = new PeopleGenerator();
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            for (int person = 0; person < Config.numberOfPeople; person++)
            {
                building.addPerson(peopleGen.generatePerson(), floor);
            }
        }
        
        System.out.println(building.getNumberOfPeople());
        
        building.moveElevator();
        
        System.out.println(building.getNumberOfPeople());
    }
}