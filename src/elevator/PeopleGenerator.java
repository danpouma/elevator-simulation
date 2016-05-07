package elevator;

/*
 TODO:
 -Make different types of generators



 // nextInt is normally exclusive of the top value,
 // so add 1 to make it inclusive

 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

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

        // Bottom to up
        if (Config.assentType == 0)
        {
            person = new Person(0, Config.maxFloor - 1);
        } // Top to down
        else if (Config.assentType == 1)
        {
            person = new Person(Config.maxFloor - 1, 0);
        } // Random
        else if (Config.assentType == 2)
        {
            int randomStart;
            int randomStop;
            boolean valid = false;

            do
            {
                randomStart = ThreadLocalRandom.current().nextInt(0, 9 + 1);
                randomStop = ThreadLocalRandom.current().nextInt(0, 9 + 1);

                if (randomStart != randomStop)
                {
                    valid = true;
                }
                else
                {
                    valid = false;
                }
            } while (!valid);

            System.out.print("Start-> " + randomStart);
            System.out.println(" Stop-> " + randomStop);
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
