package elevator;

/**
 *
 * @author dpoumakis
 */
public class Floor
{
    // Used by FloorArray
    private int floorNumber;
    
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
    
    public Floor(int floorNumber)
    {
        this.floorNumber = floorNumber;
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
    
    public Person getFromUpQueue()
    {
        Person person = null;
        
        if (upIsOn())
        {
            person = upQueue.dequeue();
            
            if (upQueue.isEmpty())
            {
                upButton.turnOff();
            }
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
    
    public void setFloorNumber(int floorNumber)
    {
        this.floorNumber = floorNumber;
    }
}
