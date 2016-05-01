package elevatorTest;

import elevator.Clock;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class ClockTest
{
    public static void main(String[] args)
    {
        Clock clock = new Clock();
        Thread timer = new Thread(clock);
        
        timer.start();
      
       
    }
}
