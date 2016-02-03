package elevator;

/**
 *
 * @author dpoumakis
 */
public class ClockTest
{
    public static void main(String[] args)
    {
        int numberOfResets = 0;
        Clock myClock = new Clock();
        
        while (numberOfResets < 4)
        {
            for (int i = 0; i < 100; i++)
            {
                myClock.tick();
                if (myClock.getTicks() % 10 == 0)
                {
                    System.out.println(myClock.getTicks());
                }
            }
            numberOfResets++;
        }
        
    }
}
