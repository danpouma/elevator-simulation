package elevator;

/*
TODO:
-Make different types of generators
*/
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
        Person person = null;
        
        Random randGen = new Random(System.currentTimeMillis());
        // create person who will ascend from floor 0 to top floor
        
        // Bottom to up
        if (Config.assentType == 0)
        {
            person = new Person(0, Config.maxFloor - 1);
        }
        // Top to down
        else if (Config.assentType == 1)
        {
            person = new Person(Config.maxFloor - 1, 0);
        }
        // Random
        else if (Config.assentType == 2)
        {
            int randomStart;
            int randomStop;
            boolean valid = false;
            
            do
            {
                randomStart = randGen.nextInt(9);
                randomStop = randGen.nextInt(9);
                
                if (randomStart != randomStop)
                {
                    valid = true;
                }
                else
                {
                    valid = false;
                }
            } while (!valid);
            
            person = new Person(randomStart, randomStop);
        }
        else
        {
            // Do nothing
        }
        
        
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
