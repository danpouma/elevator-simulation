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

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dpoumakis
 */
public class Floor
{
    Queue<Person> upQueue;
    Queue<Person> downQueue;
    
    ElevatorButton upButton;
    ElevatorButton downButton;
    
    public Floor()
    {
        this.upQueue = new LinkedList<>();
        this.downQueue = new LinkedList<>();
        
        this.upButton = new ElevatorButton("Up");
        this.downButton = new ElevatorButton("Down");
    }
    
    public void addPerson(Person person)
    {
        
    }
    
    // Up/down isOn
    // addPerson
    // deletePerson
}
