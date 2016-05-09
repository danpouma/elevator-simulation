package elevator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpoumakis
 */
public class Simulation
{

    private Building building;
    private PeopleGenerator peopleGen;
    private DataCollector dataCollector;
    private Clock clock;
    private Thread timer;

    public Simulation()
    {
        clock = new Clock();
        timer = new Thread(clock);
        timer.start();
        dataCollector = new DataCollector();
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
        while (numberOfPeople() > 0)
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

    public void printResults()
    {
        try
        {
            dataCollector.writeOutputFile();
            
            System.out.println("Simulation Complete");
            System.out.println("The shortest time was : " + dataCollector.calculateShortestTime());
            System.out.println("The  longest time was : " + dataCollector.calculateLongestTime());
            System.out.println("The   total  time was : " + dataCollector.calculateTotalTime());
            System.out.println("The  average time was : "
                    + dataCollector.calculateTotalTime() / Config.numberOfPeople);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
