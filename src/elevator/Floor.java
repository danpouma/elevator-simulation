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
        this.upQueue = new FloorQueue();
        this.downQueue = new FloorQueue();
        
        this.upButton = new ElevatorButton("Up");
        this.downButton = new ElevatorButton("Down");
    }
    
    public void addPerson(Person person)
    {
        // Where do I determine if up or down queue? ask them?
    }
    
    public Person removePerson(boolean direction)
    {
        return null;
    }
    
    public boolean upIsOn()
    {
         
    }
    
    public boolean downIsOn()
    {
        
    }
}
