package elevatorTest;

import elevator.ElevatorButton;
import elevator.ElevatorButton;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class ElevatorButtonTest
{
    public static void main(String[] args)
    {
        ElevatorButton elevatorButton = new ElevatorButton();            
        elevatorButton.setOn(true);
        
        if (!elevatorButton.isOn())
        {
            System.out.print("setActive(active) - FAIL\n");
        }
        elevatorButton.setOn(false);
        
        if (elevatorButton.isOn())
        {
            System.out.print("setActive(deactive) - FAIL\n");
        }    
    }    
}
