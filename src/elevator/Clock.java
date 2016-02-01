package elevator;

/**
 *
 * @author dpoumakis
 */
public class Clock
{
    private int ticks;
    
    public Clock()
    {
        this.ticks = 0;
    }
    
    public void tick()
    {
        this.ticks++;
    }
    
    public void reset()
    {
        this.ticks = 0;
    }
    
    public int getTicks()
    {
        return this.ticks;
    }
}
