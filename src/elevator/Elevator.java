package elevator;

import java.util.LinkedList;

/**
 *
 * @author dpoumakis
 */
public class Elevator
{

    private int capacity;
    private int currentFloor;
    private int numberOfPeople;
    private ElevatorButton[] buttons;
    private LinkedList<Person>[] destinations;

    // Elevator id
    private final int id;
    private static int idGenerator = 0;

    public Elevator()
    {
        id = idGenerator++;
        capacity = Config.elevatorCapacity;
        currentFloor = 0;
        numberOfPeople = 0;
        buttons = new ElevatorButton[Config.maxFloor];
        destinations = new LinkedList[Config.maxFloor];
        for (int i = 0; i < Config.maxFloor; i++)
        {
            destinations[i] = new LinkedList<>();
            buttons[i] = new ElevatorButton(i + "");
        }
        manageButtons();
    }

    public void addPerson(Person person)
    {
        try
        {
            destinations[person.getStopFloor()].add(person);

        }
        catch (Exception e)
        {
            System.out.println("Error in adding person");
        }
        manageButtons();

        numberOfPeople++;
    }

    public Person removePerson()
    {
        Person person = null;

        try
        {
            person = destinations[currentFloor].removeLast();
        }
        catch (Exception e)
        {
            System.out.println("error in removing person");
        }
        manageButtons();
        if (person != null)
        {
            person.setStopTime(Clock.getTicks());
            DataCollector.addPerson(person);
        }

        numberOfPeople--;

        return person;
    }

    private void manageButtons()
    {
        for (int i = 0; i < Config.maxFloor; i++)
        {
            if (destinations[i].isEmpty())
            {
                buttons[i].setOn(false);
            }
            else
            {
                buttons[i].setOn(true);
            }
        }
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
        if (currentFloor < Config.maxFloor - 1)
        {
            currentFloor++;
        }

    }

    public void descend()
    {
        if (this.currentFloor > 0)
        {
            this.currentFloor--;
        }
    }

    public boolean peopleGoingUp()
    {
        boolean peopleGoingUp = false;

        for (int floor = this.currentFloor; floor < Config.maxFloor; floor++)
        {
            if (buttons[floor].isOn())
            {
                peopleGoingUp = true;
            }
        }

        return peopleGoingUp;
    }

    public boolean peopleGoingDown()
    {
        boolean peopleGoingDown = false;

        for (int floor = this.currentFloor; floor >= 0; floor--)
        {
            if (buttons[floor].isOn())
            {
                peopleGoingDown = true;
            }
        }

        return peopleGoingDown;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public boolean isFull()
    {
        boolean isFull = false;

        if (capacity <= numberOfPeople)
        {
            isFull = true;
        }

        return isFull;
    }

    public boolean isEmpty()
    {
        boolean isEmpty = true;

        if (numberOfPeople > 0)
        {
            isEmpty = false;
        }

        return isEmpty;
    }

    public int getNumberOfPeople()
    {
        return numberOfPeople;
    }

    public ElevatorButton[] getButtons()
    {
        return buttons;
    }

    public LinkedList<Person>[] getDesitnations()
    {
        return destinations;
    }

    public boolean peopleGettingOff()
    {
        return !destinations[currentFloor].isEmpty();
    }
}
