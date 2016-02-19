package elevatorTest;

import elevator.Person;
import elevator.Person;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class PersonTest
{
    public static void main(String[] args)
    {   
        Person[] people = new Person[2];
        
        for (int i = 0; i < 2; i++)
        {
            people[i] = new Person();
            people[i].setStartFloor(1);
            System.out.println("Start floor: " + people[i].getStartFloor());

            people[i].setStopFloor(6);
            System.out.println("Stop floor: " + people[i].getStopFloor());

            System.out.println("ID: " + people[i].getId());
            
            System.out.print("Is going up...");
            if (people[i].isGoingUp())
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
            
            System.out.print("Is going down...");
            if (people[i].isGoingDown())
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
            
            // Clean output
            System.out.println("***************");
        }
    }
}
