package elevator;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author dpoumakis
 */
public class ConfigGui
{

    private Frame mainFrame;

    // This panel will have text fields to store the configs
    // may have the options controled by sliders or up down buttons
    // so there wont need to be error handling?
    private Panel configPanel;

    // will have to convert labels to text fields possibly...
    private TextField capacityLabel;
    private TextField maxFloorLabel;
    private TextField elevatorsLabel;

    private Label statusLabel;
    private Panel controlPanel;
    
    
    private static int numberOfRuns = 0;
    
    public ConfigGui()
    {
        init();
        populateMainFrame();
        showSimulation();
    }
    
    private void init()
    {
        initializeMainFrame();
        initializeConfigPanel();
        initializeMaxFloor();
        initializeCapacity();
        initialzeNumberOfElevators();
        initializeStatus();
        initializeControlPanel();
    }
    
    private void initializeMainFrame()
    {
        mainFrame = new Frame("Elevator Simulation!");
        mainFrame.setSize(500, 400);
        mainFrame.setResizable(false);
        // Keep window center when created
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new GridLayout(3, 2));
        mainFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });
    }

    private void initializeConfigPanel()
    {
        configPanel = new Panel();
        configPanel.setLayout(new FlowLayout());
    }
    
    private void initializeMaxFloor()
    {
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
    }
    
    private void initializeCapacity()
    {
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
    }
    
    private void initialzeNumberOfElevators()
    {
        // Number of elevators...
        elevatorsLabel = new TextField("Enter number of elevators...");
        //headerLabel.setAlignment(Label.CENTER);
        elevatorsLabel.setSize(250, 100);
        Button elevatorsButton = new Button("button for # of elevators");
        elevatorsButton.setSize(10, 10);
        elevatorsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("elevators button pressed...");
                System.out.println(elevatorsLabel.getText());
                
                // Will need to verify input
                Config.numberOfElevators = Integer.parseInt(elevatorsLabel.getText());
                System.out.println(Config.numberOfElevators);
                // Maybe make this a message saying if the 
                // simulation was successful or not, figure it out. 
                //frame.setVisible(true);
            }
        });

        configPanel.add(elevatorsLabel);
        configPanel.add(elevatorsButton);
    }
    
    private void initializeStatus()
    {
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);
    }
    
    private void initializeControlPanel()
    {
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
    }
    
    private void populateMainFrame()
    {
        mainFrame.add(configPanel);

        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }


    // This method will be where the code that powers the simulation
    // will be stored.
    private void showSimulation()
    {
        final Frame frame = new Frame("Elevator Simulation!!!");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        
        /* Add to make the pop up frame go center */
        
        // Don't let user resize the window
        // Why does this cause the window to drop to bottom????
        // just make min size and max size until i find fix...
        frame.setResizable(false);
        
        // Temp fix for setResizable dropping window to bottom
        // this should put window to center
        frame.setLocationRelativeTo(null);
        
        /*******************************************/
        
        // Will need to add panels for better organization!
        Label msgMaxFloor;
        Label msgCapacity;
        
        
        
        msgMaxFloor = new Label();
        msgMaxFloor.setAlignment(Label.CENTER);
        
        // Put this down in launch listener, double check them
        msgMaxFloor.setText("Max floor--> " + Config.maxFloor);
        
        msgCapacity = new Label();
        msgCapacity.setAlignment(Label.CENTER);
        
        // Put this down in launch listener, double check them
        msgCapacity.setText("Elevator capacity --> " + Config.elevatorCapacity);
        
        frame.add(msgMaxFloor);
        frame.add(msgCapacity);
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
                Simulation simulation = new Simulation();
                
                simulation.generatePeople();
                
                msgMaxFloor.setText("Number of people at start: " + simulation.numberOfPeople());
                simulation.moveElevatorTest();
                msgCapacity.setText("Number people after movement: " + simulation.numberOfPeople());
                
                // Maybe make this a message saying if the 
                // simulation was successful or not, figure it out. 
                statusLabel.setText("Number of runs: " + numberOfRuns++);
                frame.setVisible(true);
            }
        });
        controlPanel.add(launchSimulationButton);

        mainFrame.setVisible(true);
    }
}