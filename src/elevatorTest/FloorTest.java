package elevatorTest;

import elevator.*;
/**
 *
 * @author dpoumakis
 */
public class FloorTest
{
    public static void main(String[] args) 
    {

        Person me = new Person(1, 4);
        Person you = new Person(8, 4);
        
        Floor floor = new Floor();
        
        me.setGoingUp(true);
        you.setGoingDown(true);

        floor.addPerson(me);
        
        // This doesn't seem right
        //floor.setButton();
        
        
        if (floor.upIsOn()) 
        {
            System.out.println("up");
        }

        floor.addPerson(you);
        
        // This doensn't seem right
        //floor.setButton();
        
        // I think there is a bug with this one
        // if I don't set going down it still prints
        // need to look into that..
        if (floor.downIsOn()) 
        {
            System.out.println("down");
        }
    }
}
