package elevator;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author dpoumakis
 */
public class PeopleGenerator
{
    private Stack<Person> people;
    
    public PeopleGenerator() 
    {
        people = new Stack<>();
    }
    
    public Stack<Person> getPeople()
    {
        return people;
    }
    
    public Person generatePerson()
    {
        Random randGen = new Random(System.currentTimeMillis());
        
        // create person who will ascend from floor 0 to top floor
        Person person = new Person(0,randGen.nextInt(Config.maxFloor));
        
        return person;
    }
    
    public void generatePeople()
    {
        // create people who are going to ascend from floor 0 to top floor
        for (int person = 0; person < Config.numberOfPeople; person++)
        {
            // Double check if offsets are needed
            people.push(generatePerson());
        }
    }
    
}
