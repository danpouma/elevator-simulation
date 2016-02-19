package elevator;

/**
 *
 * @author dpoumakis
 */
public class Floor
{
    FloorQueue upQueue;
    FloorQueue downQueue;
    
    ElevatorButton upButton;
    ElevatorButton downButton;
    
    public Floor()
    {
        upQueue = new FloorQueue();
        downQueue = new FloorQueue();
       
        upButton = new ElevatorButton("Up");
        downButton = new ElevatorButton("Down");
    }
    
    public void addPerson(Person person)
    {
        if (person.isGoingUp())
        {
            upQueue.enqueue(person);
            upButton.turnOn();
        }
        else
        {
            downQueue.enqueue(person);
            downButton.turnOn();
        }
    }
    
    public Person removePerson()
    {
        Person person = null;
        
        if (upIsOn())
        {
            person = upQueue.dequeue();
            
            // Check if anyone left to go up
            if (upQueue.isEmpty())
            {
                upButton.turnOff();
            }
        }
        else
        {
            person = downQueue.dequeue();
            
            // Check if anyone left to go  down
            if (downQueue.isEmpty())
            {
                downButton.turnOff();
            }
        }
        
        return person;
    }
    
    public boolean upIsOn()
    {
        return upButton.isOn();
    }
    
    public boolean downIsOn()
    {
        return downButton.isOn();
    }
}
