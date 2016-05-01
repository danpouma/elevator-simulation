package elevator;

/**
 *
 * @author dpoumakis
 */
public class Clock extends Thread
{

    static int ticks;
    static boolean isTicking;

    public Clock()
    {
        ticks = 0;
        isTicking = false;
    }

    public static void tick()
    {
        ticks++;
    }
    
    public static int getTicks()
    {
        return ticks;
    }

    @Override
    public void run()
    {
        isTicking = true;

        while (isTicking)
        {
            try
            {
                if (isTicking)
                {
                    Thread.sleep(1000);
                    tick();
                }
            } catch (InterruptedException e)
            {
                isTicking = false;
            }
            System.out.println(Clock.getTicks());
        }
    }
}
