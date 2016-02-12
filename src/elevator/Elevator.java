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
    // Capacity of elevator
    int capacity;
    
    // Array of people
    LinkedList<Person> people;
    
    // Array of buttons
    LinkedList<ElevatorButton> buttons;
    
    public Elevator()
    {
        // Default gets capacity from config file
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
    
    int getCapacity()
    {
        return this.capacity;
    }
    
    void getCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    
    Person getPerson(int index)
    {
        // best way to do this? may be an easier way
        return this.people.get(index);
    }
    
    Person[] getPeopleByStopFloor(int floor)
    {
        // Maybe make this stuff a seperate function
        int numberOfPeople = 0;
        for (int person = 0; person < people.size(); person++)
        {
            if (people.get(person).getStopFloor() == floor)
            {
                numberOfPeople++;
            }
        }
        // figure out how to get number of people
        Person[] peopleOnFloor = new Person[numberOfPeople];
        
        //this isnt getting accurate people... work to fix this later...
        for (int person = 0; person < numberOfPeople; person++)
        {
            peopleOnFloor[person] = this.people.get(person);
        }
        
        // doesnt work correct so return null instead of peopleOnFloor
        return null;
    }
}
