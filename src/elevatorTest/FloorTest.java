package elevatorTest;

import elevator.*;
/**
 *
 * @author dpoumakis
 */
public class FloorTest
{
    public static void main(String[] args) 
    {
        // Create the floor
        Floor floor = new Floor();

        // I will start at bottom floor and get off at top
        Person me = new Person(0, Config.maxFloor - 1);
        
        // You will start at top floor and get off at top
        Person you = new Person(Config.maxFloor - 1, 0);

        if (floor.getUpQueue().isEmpty() && floor.getDownQueue().isEmpty())
        {
            System.out.println("Initially empty -> Pass");
        }
        else
        {
            System.out.println("Initially empty -> Fail");
        }
        
        // Add people to the floor queues and test that they were added
        floor.addPerson(me);
        floor.addPerson(you);
        
        if (!floor.getUpQueue().isEmpty() && !floor.getDownQueue().isEmpty())
        {
            System.out.println("Filled -> Pass");
        }
        else
        {
            System.out.println("Filled -> Fail");
        }

        
        // Remove people from the floor queues and test that they were removed
        floor.getFromUpQueue();
        floor.getFromDownQueue();
        
        if (floor.getUpQueue().isEmpty() && floor.getDownQueue().isEmpty())
        {
            System.out.println("Empty -> Pass");
        }
        else
        {
            System.out.println("Empty -> Fail");
        }

    }
}
