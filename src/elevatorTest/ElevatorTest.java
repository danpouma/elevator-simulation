package elevatorTest;

import elevator.*;

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
        
        PeopleGenerator peopleGen = new PeopleGenerator();
        Elevator elevator = new Elevator();
        
        boolean validFloor = true;
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            if ( floor == elevator.getCurrentFloor() )
            {
                // Pass
            }
            else
            {
                // Fail
                validFloor = false;
            }
            
            elevator.addPerson(peopleGen.generatePerson());
            elevator.elevate();
            
        }
        
        if (validFloor)
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Fail");
        }

        
        Person person = new Person(0, Config.maxFloor - 1);
        Elevator elevator2 = new Elevator();
        
        elevator2.setCurrentFloor(0);
        
        
        if (elevator2.peopleGoingUp())
        {
            System.out.println("fail");
        }
        else
        {
            System.out.println("pass");
        }
        

        elevator2.addPerson(person);
        
        elevator2.setCurrentFloor(Config.maxFloor - 2);
        
        
        if (elevator2.peopleGoingUp())
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("fail");
        }

        if (elevator2.peopleGoingUp())
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("fail");
        }
    }

}
