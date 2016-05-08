package elevatorTest;

import elevator.Building;
import elevator.Clock;
import elevator.Config;
import elevator.Elevator;
//import elevator.DataCollector;
import elevator.Floor;
import elevator.PeopleGenerator;
import elevator.Person;
import elevator.Simulation;


/**
 *
 * @author dpoumakis
 */
public class SimulationTest
{

    public static void main(String[] args)
    {
        Config.assentType = 0;
        Config.maxFloor = 9;
        Config.setNumberOfPeople(70);
        Config.setElevatorCapacity(15);

        Simulation sim = new Simulation();

        // Start clock
        Clock clock = new Clock();
        Thread timer = new Thread(clock);
        timer.start();

        PeopleGenerator peopleGen = new PeopleGenerator();
        
        peopleGen.generatePeople();
        
        System.out.println("Number of people at start: " + sim.numberOfPeople());
        
        while ( sim.numberOfPeople() > 0 ) 
        {
            sim.moveElevator();
            
            try 
            {
                // This will make it so i see ticks from clock
                Thread.sleep(250);
            }
            catch (Exception e )
            {
                // Do nothing
            }
        }


        //while (DataCollector.howManyFinished() != Config.numberOfPeople)

        System.out.println("Number of people at end: " + sim.numberOfPeople());
        System.out.println("Simulation took " + Clock.getTicks() + " ticks.");
        System.exit(0);
        
    }

}
