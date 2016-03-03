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
        // Create the elevator
        Elevator elevator = new Elevator();
        
        // I will start at bottom floor and get off at top
        Person me = new Person(0, Config.maxFloor - 1);
        
        // You will start at top floor and get off at top
        Person you = new Person(Config.maxFloor - 1, 0);
        
        // Test if anyone is on the elevator
        if (elevator.isEmpty())
        {
            System.out.println("Test: Initially empty - Pass");
        }
        else
        {
            System.out.println("Test: Initially empty - Fail");
        }
        
        // Test adding people to elevator via startFloor
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            if (me.getStartFloor() == floor)
            {
                elevator.addPerson(me);
            }
            if (you.getStartFloor() == floor)
            {
                elevator.addPerson(you);
            }
        }
        if (elevator.isEmpty())
        {
            System.out.println("Test: Adding people - Fail");
        }
        else
        {
            System.out.println("Test: Adding people - Pass");
        }
        
        // Test peopleGoingUp
        if (elevator.peopleGoingUp())
        {
            System.out.println("Test: People going up - Pass");
        }
        else
        {
            System.out.println("Test: People going up - Fail");
        }
        
        // Test peopleGoingDown
        if (elevator.peopleGoingDown())
        {
            System.out.println("Test: People going down - Pass");
        }
        else
        {
            System.out.println("Test: People going down - Fail");
        }
        
        //Test removing people from elevator via stopFloor
        boolean personRemoved = false;
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            // Need to update/fix function
            ArrayList<Person> person = elevator.removePeople(floor);
            if (person.isEmpty())
            {
                // Uncomment if failing
                //System.out.println("null - " + floor);
            }
            else
            {
                // Uncomment if failing
                //System.out.println("removed");
                personRemoved = true;
            }
        }
        if (personRemoved = false)
        {
            System.out.println("Test: Removing people - Fail");
        }
        else
        {
            System.out.println("Test: Removing people - Pass");
        }   
    }

}
