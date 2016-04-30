package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class Elevator
{
    private final int id;
    private int capacity;
    private int currentFloor;
    ArrayList<Person> people;
    ArrayList<ElevatorButton> buttons;
    
    private static int counter = 0;
    
    // Variable for testing number of people on the elevator.
    private int numberOfOccupants;
    
    public Elevator()
    {
        // Test variable..
        numberOfOccupants = 0;
        
        id = counter++;
        capacity = Config.elevatorCapacity;
        currentFloor = 0;
        people = new ArrayList<>();
        buttons = new ArrayList<>();
        for (int i = 1; i <= Config.maxFloor; i++)
        {
            buttons.add(new ElevatorButton(i + ""));
        }
    }

    public void addPerson(Person person)
    {
        if ( people.size() < Config.elevatorCapacity )
        {
            people.add(person);
        
            // Can cause null pointer exception 
            buttons.get(person.getStopFloor()).turnOn();

            numberOfOccupants++;
        }
        else
        {
            // Do nothing
        }
        
    }
    
    public boolean hasPersonGettingOff(int floor)
    {
        boolean hasPersonGettingOff = false;
        
        for (Person person : people)
        {
            if (person.getStopFloor() == floor)
            {
                hasPersonGettingOff = true;
            }
        }
        
        return hasPersonGettingOff;
    }
    
    public Person removePerson(int floor)
    {
        Person personRemoved = null;
        
        for (Person person : people)
        {
            if (person.getStopFloor() == floor)
            {
                personRemoved = person;
                people.remove(person);
                // Not good practice but it works :)
                break;
            }
        }
        
        return personRemoved;
    }
    
    public ArrayList<Person> removePeople(int floor)
    {
        boolean stillRemoving = true;
        ArrayList<Person> peopleRemoved = new ArrayList<>();
        
        while (hasPersonGettingOff(floor))
        {
            peopleRemoved.add(removePerson(floor));
        }
        
        return peopleRemoved;
    }
    
    
    // Utilize this...
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
    
    // Probably going to remove these two functions
    // they are useful for testing for now...
    public boolean peopleGoingUp()
    {
        boolean peopleGoingUp = false;
        
        for (int person = 0; person < people.size(); person++)
        {
            if (people.get(person).isGoingUp())
            {
                peopleGoingUp = true;
            }
        }
        
        return peopleGoingUp;
    }
    
    public boolean peopleGoingDown()
    {
        boolean peopleGoingDown = false;
        
        for (int person = 0; person < people.size(); person++)
        {
            if (people.get(person).isGoingDown())
            {
                peopleGoingDown = true;
            }
        }
        
        return peopleGoingDown;
    }
    
    // Adding this method for testing elevator controller
    public ArrayList<Person> getPeople()
    {
        return people;
    }
    
    public int getNumberOfOccupants()
    {
        return numberOfOccupants;
    }
}
