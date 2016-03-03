package elevator;

/**
 *
 * @author dpoumakis
 */
public class Floor
{
    private int floorNumber;
    private FloorQueue upQueue;
    private FloorQueue downQueue;
    private ElevatorButton upButton;
    private ElevatorButton downButton;
    
    public Floor()
    {
        upQueue = new FloorQueue();
        downQueue = new FloorQueue();
        upButton = new ElevatorButton("Up");
        downButton = new ElevatorButton("Down");
    }
    
    public Floor(int floorNumber)
    {
        this.floorNumber = floorNumber;
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
    
    public Person getFromUpQueue()
    {
        // This is the null being returned
        Person person = null;
        
        person = upQueue.dequeue();

        if (upQueue.isEmpty())
        {
            upButton.turnOff();
        }
        
        return person;
    }
    
    public Person getFromDownQueue()
    {
        Person person = null;
        
        if (downIsOn())
        {
            person = downQueue.dequeue();
            
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
    
    public int getFloorNumber()
    {
        return floorNumber;
    }
    
    public boolean isEmpty()
    {
        boolean isEmpty = false;
        
        if (upQueue.isEmpty() && downQueue.isEmpty())
        {
            isEmpty = true;
        }
        
        return isEmpty;
    }
    
    public FloorQueue getUpQueue()
    {
        return upQueue;
    }
    
    public FloorQueue getDownQueue()
    {
        return downQueue;
    }
    
    public void addToUpQueue(Person person)
    {
        upQueue.enqueue(person);
        upButton.turnOn();
    }
    
    public void addToDownQueue(Person person)
    {
        // implement this function
    }
    
    public int numberOfPeople()
    {
        return upQueue.getPersonCount() + downQueue.getPersonCount();
    }
}
