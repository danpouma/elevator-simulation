package elevator;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author dpoumakis
 */
public class ElevatorSimulationGui
{

    private Frame mainFrame;

    // This panel will have text fields to store the configs
    // may have the options controled by sliders or up down buttons
    // so there wont need to be error handling?
    private Panel configPanel;

    // will have to convert labels to text fields possibly...
    private TextField capacityLabel;
    private TextField maxFloorLabel;

    private Label statusLabel;
    private Panel controlPanel;
    
    // Might move this to simulation method
    // since its only used there
    private Label msglabel;

    public ElevatorSimulationGui()
    {
        // For two notes... Planning to split constructor
        // into multiple functions rather than just "prepareGUI"
        prepareGUI();
        
        // Moved this from main function, makes more sense for it to be here
        // will properly move it next time
        showSimulation();
    }



    // Considerring to split this up into multiple functions
    private void prepareGUI()
    {
        mainFrame = new Frame("Elevator Simulation!");
        // Might be able to remove this since min dimension is set!
        mainFrame.setSize(500, 400);
        // Don't let user resize the window
        // Why does this cause the window to drop to bottom????
        // just make min size and max size until i find fix...
        mainFrame.setResizable(false);
        
        // Temp fix for setResizable dropping window to bottom
        // this should put window to center
        mainFrame.setLocationRelativeTo(null);

        // Does this mean 3 rows? So each add is a row?
        // how can i add to column?
        mainFrame.setLayout(new GridLayout(3, 2));
        mainFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });

        //controlPanel.add(headerLabel);
        
        // START CODE FOR CONFIG PANEL ********
        //*************************************
        configPanel = new Panel();
        configPanel.setLayout(new FlowLayout()); // horiztonal, vert

        // Max floor...
        maxFloorLabel = new TextField("Enter max floor of building...");
        maxFloorLabel.setSize(250, 100);
        Button maxFloorButton = new Button("button for max floor");
        maxFloorButton.setSize(10, 10);
        maxFloorButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("max floor button pressed...");
                System.out.println(maxFloorLabel.getText());
                
                // Will need to verify input 
                Config.maxFloor = Integer.parseInt(maxFloorLabel.getText());
                System.out.println(Config.maxFloor);
                // Maybe make this a message saying if the 
                // simulation was successful or not, figure it out. 
                //frame.setVisible(true);
            }
        });

        configPanel.add(maxFloorLabel);
        configPanel.add(maxFloorButton);

        // Capacity...
        capacityLabel = new TextField("Enter capacity of elevator...");
        //headerLabel.setAlignment(Label.CENTER);
        capacityLabel.setSize(250, 100);
        Button capacityButton = new Button("button for capacity");
        capacityButton.setSize(10, 10);
        capacityButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("capacity button pressed...");
                System.out.println(capacityLabel.getText());
                
                // Will need to verify input
                Config.elevatorCapacity = Integer.parseInt(capacityLabel.getText());
                System.out.println(Config.elevatorCapacity);
                // Maybe make this a message saying if the 
                // simulation was successful or not, figure it out. 
                //frame.setVisible(true);
            }
        });

        configPanel.add(capacityLabel);
        configPanel.add(capacityButton);

        // END CODE FOR CONFIG PANEL **********
        //*************************************
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

       

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        // Should I set a background color?? hmmm
        // could just be a fun capability for final program
        // user preference. Maybe store prefs? A prefs file
        //mainFrame.setBackground(Color.blue);
        //mainFrame.add(headerLabel);
        mainFrame.add(configPanel);

        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    // This method will be where the code that powers the simulation
    // will be stored.
    private void showSimulation()
    {
        final Frame frame = new Frame();
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        
        msglabel = new Label();
        msglabel.setAlignment(Label.CENTER);
        msglabel.setText("This frame will show the simulation.");
        
        
        frame.add(msglabel);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                // is dispose proper way to close window?
                frame.dispose();
            }
        });
        Button launchSimulationButton = new Button("Launch simulation");

        launchSimulationButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Maybe make this a message saying if the 
                // simulation was successful or not, figure it out. 
                statusLabel.setText("You pushed the button.");
                frame.setVisible(true);
            }
        });
        controlPanel.add(launchSimulationButton);

        mainFrame.setVisible(true);
    }
}