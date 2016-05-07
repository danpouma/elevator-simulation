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
        }
        else
        {
            downQueue.enqueue(person);
        }
        manageButton();
    }
    
    public Person getFromUpQueue()
    {
        Person person = null;
        
        if (!upQueue.isEmpty())
        {
            person = upQueue.dequeue();
        }
        else
        {
            System.out.println("did nothing");
            // Do nothing
        }
        
        manageButton();
        
        return person;
    }
    
    public Person getFromDownQueue()
    {
        Person person = null;
        
        if (!downQueue.isEmpty())
        {
            person = downQueue.dequeue();
        }
        else
        {
            // Do nothing
        }
        
        manageButton();
        
        return person;
    }
    
    public void manageButton()
    {
        // Handle upButton
        if (upQueue.isEmpty())
        {
            upButton.setOn(false);
        }
        else
        {
            upButton.setOn(true);
        }
        
        // Handle downButton
        if (downQueue.isEmpty())
        {
            downButton.setOn(false);
        }
        else
        {
            downButton.setOn(true);
        }
    }
    
    public FloorQueue getUpQueue()
    {
        return upQueue;
    }
    
    public FloorQueue getDownQueue()
    {
        return downQueue;
    }

    public int getFloorNumber()
    {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber)
    {
        this.floorNumber = floorNumber;
    }
    
    public int numberOfPeopleOnFloor()
    {
        return upQueue.getSize() + downQueue.getSize();
    }
}
