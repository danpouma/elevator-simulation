package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class Elevator
{
    int capacity;
    ArrayList<Person> people;
    ArrayList<ElevatorButton> buttons;
    
    public Elevator()
    {
        this.capacity = Config.elevatorCapacity;
        this.people = new ArrayList<>();
        this.buttons = new ArrayList<>();
        for (int i = 1; i <= Config.maxFloor; i++)
        {
            buttons.add(new ElevatorButton(i + ""));
        }
    }

    void addPerson(Person person)
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
    
    boolean isFull()
    {
        return people.size() == this.capacity;
    }
    
    boolean isEmpty()
    {
        return people.isEmpty();
    }
}
