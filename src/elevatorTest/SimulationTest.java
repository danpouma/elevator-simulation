package elevatorTest;

import elevator.Building;
import elevator.Config;
import elevator.Floor;
import elevator.Simulation;

/**
 *
 * @author dpoumakis
 */
public class SimulationTest
{
    public static void main(String[] args)
    {
        Config.setMaxFloor(5);
        Config.setNumberOfPeople(70);
        
        Simulation simulation = new Simulation();
        
        simulation.generatePeople();
        
        Building building = simulation.getBuilding();
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = building.getFloors().getFloor(floor);
        }
        
        simulation.moveElevator();
    }
    
}
