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
        
        // Simulation loop is kicked off in gui
        ConfigGui simulation = new ConfigGui();
    }
   
}
