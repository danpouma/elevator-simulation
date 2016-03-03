package elevator;

/**
 *
 * @author dpoumakis
 */
public class Simulation
{
    public static void main(String[] args)
    {
        boolean done = false;
        
        // might need to make constructor
        Config config = new Config();
        
        Building building = new Building();
        PeopleGenerator peopleGen = new PeopleGenerator();
        
        ConfigGui configGui = new ConfigGui();
        
        while (!done)
        {
            building.addPerson(peopleGen.generatePerson());
        }
            building.moveElevator();//Buidling will decide where elevator goes, move it,
            //get people on & off
            //decide if you should continue
        }
}