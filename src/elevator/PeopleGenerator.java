package elevator;

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
        // Need to update variations of people generators
        
        //Random randGen = new Random(System.currentTimeMillis());
        // create person who will ascend from floor 0 to top floor
        Person person = new Person(0, Config.maxFloor - 1);
        
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
