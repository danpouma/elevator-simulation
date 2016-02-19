package elevatorTest;

import elevator.Config;
import elevator.Elevator;
import elevator.Person;

/**
 *
 * @author dpoumakis
 */
public class ElevatorTest
{
    public static void main(String[] args) 
    {
        // Probably get rid of this
        Config.maxFloor = 10;
        Config.elevatorCapacity = 10;
        
        // Default uses config for elevator capacity
        Elevator elevator = new Elevator();
        
        // Initialize test riders
        Person me = new Person(0, Config.maxFloor - 1);
        Person you = new Person(Config.maxFloor - 1, 0);
        elevator.setCurrentFloor(0);
        
        // This line is really stupid, removing it.
        //System.out.println(elevator.hasRidersGoingUp());

        // Put people on the elevator
        elevator.addPerson(me);
        elevator.addPerson(you);
        
        // Set the current floor
        elevator.setCurrentFloor(Config.maxFloor - 2);
        
        // This line seems stupid too.
        //System.out.println(elevator.hasRidersGoingUp());

        // Will need to add this function
        elevator.elevate();
        
        // This line seems stupid too.
        //System.out.println(elevator.hasRidersGoingUp());
    }
}
