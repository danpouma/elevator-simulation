package elevator;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dpoumakis
 */
public class FloorQueue
{
    // Use for isEmpty/Full
    // wait.. can queue be full? make certain
    private int personCount;
    
    // Does using interface queue automatically
    // do the front pointer and back pointer?? test
    // to find out
    Queue<Person> queue;
    
    public FloorQueue()
    {
        this.personCount = 0;

        this.queue = new LinkedList<>();
    }
    
    public void enqueue(Person person)
    {
        this.queue.add(person);
        personCount++;
    }
    
    public Person dequeue()
    {
        Person nextOff = null;
        
        // need to catch if its empty
        if (!this.queue.isEmpty())
        {
            nextOff = this.queue.remove();
            
            // Verify that this is the best spot
            personCount--;
        }
        else
        {
            // stay null
        }
        
        return nextOff;
    }
    
    public boolean isEmpty()
    {
        return this.queue.isEmpty();
    }
}
