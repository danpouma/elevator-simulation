package elevatorTest;

import elevator.Building;
import elevator.Person;

/**
 *
 * @author dpoumakis
 */
public class BuildingTest
{
    public static void main(String[] args)
    {
        // Create person
        Person person = new Person();
        
        // Create building
        Building building = new Building();
        
        
        // This fails... verify building has no people initially
        // is this even valid
        if (building.hasPerson())
        {
            System.out.println("Test: Building has no people initially - Pass");
        }
        else
        {
            System.out.println("Test: Building has no people initially - Fail");
        }
        
        // Add person to building
        building.addPerson(person);
        
        if (building.hasPerson())
        {
            System.out.println("Test: Adding person to building passed - Pass");
        }
        else
        {
            System.out.println("Test: Adding person to building passed - Fail");
        }
        
        
        
    }
}
