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
        
        // Buttons are off by default
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
    
    public Person removePerson(boolean direction)
    {
        return null;
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
