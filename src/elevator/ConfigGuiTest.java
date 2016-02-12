package elevator;

import java.awt.Frame;

/**
 *
 * @author dpoumakis
 */
public class ConfigGuiTest 
{
    public static void main (String[] args)
    {
        Frame SimpleWindow1 = new ConfigGUI( );
        // LOL this was unsetting my set in the constructor
        //SimpleWindow1.setSize(200,300);
        SimpleWindow1.setVisible( true );
    }// main
}
