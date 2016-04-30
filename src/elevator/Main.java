package elevator;

/**
 *
 * @author dpoumakis
 */
public class Main
{
    public static void main(String[] args)
    {
        // Have entire setup in the config moved to simulation class
        // not good programming to have it in there.
        
        // Setup clock and begin timer
        Clock clock = new Clock();
        Thread timer = new Thread(clock);
        timer.start();
        
        // Simulation loop is kicked off in gui
        ConfigGui simulation = new ConfigGui();
    }
   
}
