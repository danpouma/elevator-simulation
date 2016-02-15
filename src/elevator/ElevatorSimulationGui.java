package elevator;

/*
 going to be reworking this code example
 into the main application.

 will have it be config window then
 once you hit the button it will kick off
 the simulation in a new window...
 diplay results and then you can close it..

 reconfigure and kick off... repeat etc
 */
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
    private Label msglabel;

    public ElevatorSimulationGui()
    {
        prepareGUI();
    }

    public static void main(String[] args)
    {
        ElevatorSimulationGui simulation = new ElevatorSimulationGui();
        simulation.showFrameDemo();
    }

    private void prepareGUI()
    {
        mainFrame = new Frame("Elevator Simulation!");
        // Might be able to remove this since min dimension is set!
        mainFrame.setSize(500, 400);
        // Don't let user resize the window
        mainFrame.setResizable(false);

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

        configPanel.add(maxFloorLabel);
        configPanel.add(maxFloorButton);

        // Capacity...
        capacityLabel = new TextField("Enter capacity of elevator...");
        //headerLabel.setAlignment(Label.CENTER);
        capacityLabel.setSize(250, 100);
        Button capacityButton = new Button("button for capacity");
        capacityButton.setSize(10, 10);

        configPanel.add(capacityLabel);
        configPanel.add(capacityButton);

      // END CODE FOR CONFIG PANEL **********
        //*************************************
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

        msglabel = new Label();
        msglabel.setAlignment(Label.CENTER);
        msglabel.setText("This frame will show the simulation.");

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

    private void showFrameDemo()
    {
        //headerLabel.setText("This frame will contain the configurations");   

        final Frame frame = new Frame();
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.add(msglabel);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                frame.dispose();
            }
        });
        Button okButton = new Button("Launch simulation");

        okButton.addActionListener(new ActionListener()
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
        controlPanel.add(okButton);

        mainFrame.setVisible(true);
    }
}