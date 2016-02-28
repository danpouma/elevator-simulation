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
        people.add(person);
        
        // hmm button is causing elevator controller test to fail..
        // the fix for now is to correct the offset by 1.
        // there is probably other areas impacted by it too.
        // do a full investigation! may need to re-implemnet person class
        buttons.get(person.getStopFloor() - 1).turnOn();
        
        numberOfOccupants++;
    }

    public ArrayList<Person> removePeople(int floor)
    {
        boolean stillRemoving = true;
        ArrayList<Person> peopleRemoved = new ArrayList<>();
        
        while (stillRemoving)
        {
            for (int person = 0; person < people.size(); person++)
            {
                Person currentPerson = people.get(person);
                
                int personStopFloor = currentPerson.getStopFloor();
                
                if (floor == personStopFloor)
                {
                    peopleRemoved.add(currentPerson);
                    people.remove(currentPerson);
                    numberOfOccupants--;
                }
            }
            
            stillRemoving = false;
            for (int person = 0; person < people.size(); person++)
            {
                Person currentPerson = people.get(person);
                
                int personStopFloor = currentPerson.getStopFloor();
                
                if (floor == personStopFloor)
                {
                    stillRemoving = true;
                }
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
