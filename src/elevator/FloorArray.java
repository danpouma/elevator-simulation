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
            // Could add id for each floor? Floor(floor) 
            floors.add(new Floor(floor));
        }   
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
    
    
    public Person getFromUpQueue(int floor)
    {
        return getFloor(floor).getFromUpQueue();
    }
    
    public Person getFromDownQueue(int floor)
    {
        return getFloor(floor).getFromDownQueue();
    }
    
    public int numberOfPeople()
    {
        int numberOfPeople = 0;
        
        for (int floor = 0; floor < Config.maxFloor; floor++)
        {
            Floor currentFloor = floors.get(floor);
            
            System.out.println(currentFloor.getUpQueue().getSize());
            System.out.println(currentFloor.getDownQueue().getSize());
            
            numberOfPeople += currentFloor.getUpQueue().getSize();
            numberOfPeople += currentFloor.getDownQueue().getSize();
        }
        
        return numberOfPeople;
    }
}
