package elevator;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dpoumakis
 */
public class FloorQueue
{
    private int personCount;
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
        Person nextOff;
        
        if (!this.queue.isEmpty())
        {
            nextOff = this.queue.remove();
            
            // Verify that this is the best spot
            personCount--;
        }
        else
        {
            nextOff = null;
        }
        
        return nextOff;
    }
    
    public int getPersonCount()
    {
        return this.personCount;
    }
    
    public void setPersonCount(int personCount)
    {
        this.personCount = personCount;
    }
    
    public int getSize()
    {
        return queue.size();
    }
    
    public void clear()
    {
        while(!queue.isEmpty())
        {
            dequeue();
        }
    }
    
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
    
    public Person peek()
    {
        return queue.peek();
    }
}