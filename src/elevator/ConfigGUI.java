package elevator;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author dpoumakis
 */
public class ConfigGUI extends Frame implements ActionListener
{
    private Button btnButton;

    private TextField tfTextField = new TextField(20);
   
    public ConfigGUI ( )
    {
        setTitle ("Configuration -- Elevator Simulation");
        setResizable(false);
        setSize(new Dimension(1000, 1000));
        setLayout ( new FlowLayout( ));
        
        

        add(new Label("Label for Text Field"));
        add( tfTextField);
       
    
        btnButton = new Button("A Button");
        add (btnButton);
        btnButton.addActionListener(new ButtonHandler(this));

	addWindowListener( new CloseWindow( ));
    }


    class ButtonHandler implements ActionListener
    {
        ConfigGUI f;
        ButtonHandler(ConfigGUI pf)
        { f = pf;}
        public void actionPerformed (ActionEvent event)
        {
              f.buttonMethod( );
              f.repaint( );
        }// actionPerformed (ActionEvent event)
    }// CalculateHandler


    void buttonMethod( )
    {
        //What button does
        tfTextField.setText("Button Works");
    }// buttonMethod( )

    public void actionPerformed (ActionEvent event)
    {
        repaint( );
    }// actionPerformed

    //-----------------------------------------------
    public static void main (String[] args)
    {
        Frame SimpleWindow1 = new ConfigGUI( );
        SimpleWindow1.setSize(200,300);
        SimpleWindow1.setVisible( true );
    }// main
    
    public class CloseWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }// CloseWindow
}// class Degrees