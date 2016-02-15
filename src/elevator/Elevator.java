/*
elevator
-array of people
-array of button
-void addPerson(Person)
-Person removePerson(int floor) //what if none is on floor? have method handle a null.
-boolean isFull()
-boolean isOn(int floor)
*/
package elevator;

import java.util.LinkedList;

/**
 *
 * @author dpoumakis
 */
public class Elevator
{
    int capacity;
    LinkedList<Person> people;
    LinkedList<ElevatorButton> buttons;
    
    public Elevator()
    {
        this.capacity = Config.elevatorCapacity;
        this.people = new LinkedList<>();
        this.buttons = new LinkedList<>();
        
        // Initialize the buttons...
        for (int i = 1; i <= Config.maxFloor; i++)
        {
            buttons.add(new ElevatorButton(i + ""));
        }
    }
    
    public Elevator(int capacity)
    {
        this.capacity = capacity;
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
    
    boolean isFull()
    {
        return people.size() == this.capacity;
    }
    
    boolean isEmpty()
    {
        return people.isEmpty();
    }
}
