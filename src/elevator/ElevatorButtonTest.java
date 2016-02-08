package elevator;

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
        ElevatorButton button = new ElevatorButton();
        
        System.out.println("Default label " + button.getLabel());
        button.setLabel("Test Label");
        System.out.println("Set label " + button.getLabel());
        System.out.print("Is on... ");
        if (button.isOn())
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
        
}
