package elevatorTest;

import elevator.*;
import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class ElevatorTest
{
    public static void main(String[] args) 
    {
        // Set configurations
        Config.maxFloor = 10;
        Config.elevatorCapacity = 10;
        
        
        Elevator elevator = new Elevator();
        
        Person person = new Person(0, Config.maxFloor - 1);
        
        elevator.setCurrentFloor(0);
        
        System.out.println(elevator.peopleGoingUp());

        elevator.addPerson(person);
        
        elevator.setCurrentFloor(Config.maxFloor - 2);
        System.out.println(elevator.peopleGoingUp());

        
        System.out.println(elevator.peopleGoingUp());
    }

}
