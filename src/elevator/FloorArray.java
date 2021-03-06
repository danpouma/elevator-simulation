package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class FloorArray
{

    private ArrayList<Floor> floors;

    public FloorArray()
    {
        floors = new ArrayList<>();
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            floors.add(new Floor(floor));
        }
    }

    public ArrayList<Floor> getFloors()
    {
        return floors;
    }

    public int getSize()
    {
        return floors.size();
    }

    public Floor getFloor(int floor)
    {
        return floors.get(floor);
    }

    public int getNumberOfFloors()
    {
        return floors.size();
    }

    public void addPerson(Person person, int floor)
    {
        getFloor(floor).addPerson(person);
    }

    // Look into removing these
    public Person getFromUpQueue(int floor)
    {
        return getFloor(floor).getFromUpQueue();
    }

    public Person getFromDownQueue(int floor)
    {
        return getFloor(floor).getFromDownQueue();
    }
}
