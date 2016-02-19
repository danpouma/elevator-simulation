package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class Elevator
{
    private int capacity;
    private int currentFloor;
    ArrayList<Person> people;
    ArrayList<ElevatorButton> buttons;
    
    public Elevator()
    {
        this.capacity = Config.elevatorCapacity;
        this.currentFloor = 0;
        this.people = new ArrayList<>();
        this.buttons = new ArrayList<>();
        for (int i = 1; i <= Config.maxFloor; i++)
        {
            buttons.add(new ElevatorButton(i + ""));
        }
    }

    public void addPerson(Person person)
    {
        people.add(person);
        buttons.get(person.getStopFloor()).turnOn();
    }

    public ArrayList<Person> removePerson(int floor)
    {
        ArrayList<Person> peopleRemoved = new ArrayList<>();
        
        for (int person = 0; person < people.size(); person++)
        {
            int personStopFloor = people.get(person).getStopFloor();
            
            if (personStopFloor == floor)
            {
                peopleRemoved.add(people.get(person));
                people.remove(person);
            }
        }
        
        return peopleRemoved;
    }
    
    public boolean isFull()
    {
        return people.size() == capacity;
    }
    
    public boolean isEmpty()
    {
        return people.isEmpty();
    }
    
    public int getCurrentFloor()
    {
        return currentFloor;
    }
    
    public void setCurrentFloor(int currentFloor)
    {
        this.currentFloor = currentFloor;
    }
    
    public void elevate()
    {
        // Will need to put in an if to make sure its valid
        currentFloor++;
    }
    
    public void descend()
    {
        // Will need to put in an if to make sure its valid
        currentFloor--;
    }
}
