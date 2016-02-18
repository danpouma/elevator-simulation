/*
floor

upQ //queue class
downQ //queue class
upButton //ebutton class
downButton //ebutton class

void addPerson(Person)
Person removePerson(boolean direction)
boolean isUpEmpty()
boolean isDownEmpty()
boolean isUpOn()
boolean isDownOn()

*/
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
        
    }
    
    public Person removePerson(boolean direction)
    {
        return null;
    }
    
    // Up/down isOn
}
