package elevator;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class Clock extends Thread
{

    static private int ticks;
    private boolean isTicking;

    public Clock()
    {
        ticks = 0;
        isTicking = false;
    }

    public void tick()
    {
        ticks++;
    }

    public void reset()
    {
        ticks = 0;
    }

    public static int getTicks()
    {
        return Clock.ticks;
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
            } 
            catch (Exception e)
            {
                isTicking = false;
            }
            System.out.println(getTicks());
        }
    }
}
