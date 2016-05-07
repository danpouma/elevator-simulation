package elevatorTest;

import elevator.*;
import java.util.Stack;

/**
 *
 * @author dpoumakis
 */
public class PeopleGeneratorTest
{
    public static void main(String[] args)
    {
        Config.assentType = 1;
        
        PeopleGenerator peopleGen = new PeopleGenerator();
        
        Stack<Person> people = new Stack<>();
        
        peopleGen.generatePeople();
        
        peopleGen.generatePerson();
        
        people = peopleGen.getPeople();
        
        for (Person person : people)
        {
            System.out.println(person);
        }
        
        
    }
}
