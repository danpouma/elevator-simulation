package elevator;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author dpoumakis
 */
public class ConfigGUI extends Frame implements ActionListener
{
    private Button btnFloors;
    private Button btnCapacity;

    private TextField tfFloors = new TextField(20);
    private TextField tfCapacity = new TextField(20);
   
    public ConfigGUI()
    {
        
        setTitle ("Configuration -- Elevator Simulation");
        setSize(new Dimension(500, 350)); // (width, height)
        setResizable(false);
        
        setLayout ( new FlowLayout( ));

        add(new Label("Number of floors:"));
        add( tfFloors);
       
        btnFloors = new Button("Set");
        add (btnFloors);
        btnFloors.addActionListener(new ButtonHandler(this));

	addWindowListener(new CloseWindow( ));
    }


    class ButtonHandler implements ActionListener
    {
        ConfigGUI f;
        
        ButtonHandler(ConfigGUI pf)
        { 
            f = pf;
        }
        
        @Override
        public void actionPerformed (ActionEvent event)
        {
              f.buttonMethod( );
              f.repaint();
        }// actionPerformed (ActionEvent event)
    }// CalculateHandler


    void buttonMethod( )
    {
        //What button does
        tfFloors.setText("Button Works");
    }// buttonMethod( )

    @Override
    public void actionPerformed (ActionEvent event)
    {
        repaint();
    }// actionPerformed

    //-----------------------------------------------
    
    
    public class CloseWindow extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }// CloseWindow
}// class Degrees