package elevatorTest;

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
        Person person = new Person();
    
        person.setStartFloor(0);
        person.setStopFloor(2);

        if (person.isGoingUp())
        {
            System.out.println("Person going up-PASS");
        }
        else
        {
            System.out.println("Person going up-FAIL");
        }
        
        person.setStartFloor(2);
        person.setStopFloor(1);
        
        if (!person.isGoingUp())
        {
            System.out.println("Person going down-PASS");
        }
        else
        {
            System.out.println("Person going down-FAIL");
        }
    }
}
