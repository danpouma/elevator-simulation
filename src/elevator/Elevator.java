/*
elevator
-array of people
-array of button
-void addPerson(Person)
-Person removePerson(int floor) //what if none is on floor? have method handle a null.
-boolean isFull()
-boolean isOn(int floor)

### make sure you functions can handle errors. Russ was very specific about different cases.
###asserstions..something you can enable and disable for tests
***********************
Building...
{
FloorArray -> Floor -> (upQueue, downQueue, upButton, downButton)

Elevator -> Person(s) an array
	     -> Button(s) an array
}

*/
package elevator;

import java.util.LinkedList;

/**
 *
 * @author dpoumakis
 */
public class Elevator
{
    // Capacity of elevator
    int capacity;
    
    // Array of people
    LinkedList<Person> people;
    
    // Array of buttons
    LinkedList<ElevatorButton> buttons;
    
    public Elevator()
    {
        // Set capacity to 15 for now
        // might set via config file?
        this.capacity = 15;
        
        
        this.people = new LinkedList<>();
        this.buttons = new LinkedList<>();
        
        // Initialize the buttons...
        for (int i = 1; i <= Config.maxFloor; i++)
        {
            buttons.add(new ElevatorButton(i + ""));
        }
    }

    void addPerson(Person person)
    {
        // make sure to setOn persons floor via button
        //buttonArray[addPerson.getStopFloor()].setOn();
        people.add(person);
    }

    Person removePerson(int floor)
    {
        Person personToRemove = null;
        
        for (int person = 0; person < people.size(); person++)
        {
            int personStopFloor = people.get(person).getStopFloor();
            
            if (personStopFloor == floor)
            {
                personToRemove = people.get(person);
                people.remove(person);
            }
        }
        
        // make sure to handle if it stays null
        return personToRemove;
    }

    // There may be a better way to do this
    // that is quicker/simple
    boolean isFull()
    {
        boolean isFull = false;
        
        if (people.size() == this.capacity)
        {
            isFull = true;
        }
        
        return isFull;
    }
}
