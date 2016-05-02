
package elevator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**

 *
 * @author dpoumakis
 */
public class ConfigGUI2 extends JFrame {

    public ConfigGUI2() {

        setTitle("Elevator Configuration");
        setSize(500, 500);
        setLayout(new GridLayout(8, 2));
        setLocationRelativeTo(null);
                       
        JLabel sliderLabel = new JLabel("Number of Elevators");
        sliderLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        JSlider elevatorSlider = new JSlider(1, 10, 1);
        elevatorSlider.setMajorTickSpacing(1);
        elevatorSlider.setPaintLabels(true);
        elevatorSlider.setPaintTicks(true);
        elevatorSlider.addChangeListener(new NumberOfElevatorsAdjustmentListener());
        add(sliderLabel);
        add(elevatorSlider);

        JLabel floorsLabel = new JLabel("Number of Floors");
        floorsLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        JSlider floorsSlider = new JSlider(0, 101, 1);
        floorsSlider.setMajorTickSpacing(10);
        floorsSlider.setPaintLabels(true);
        floorsSlider.setPaintTicks(true);
        floorsSlider.addChangeListener(new FloorCountAdjustmentListener());
        add(floorsLabel);
        add(floorsSlider);

        JLabel riderLabel = new JLabel("Number of People");
        riderLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        JSlider riderSlider = new JSlider(0, 500, 5);
        riderSlider.setMajorTickSpacing(50);
        riderSlider.setPaintLabels(true);
        riderSlider.setPaintTicks(true);
        riderSlider.addChangeListener(new PeopleAdjustmentListener());
        add(riderLabel);
        add(riderSlider);
                       
        JButton button = new JButton("Launch Simulation");
        button.addActionListener(new ActionListener() {

            //States are already saved just need to sucessfully exit
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                // Run simulation
                Simulation sim = new Simulation();
                
                // Start clock
                Clock clock = new Clock();
                Thread timer = new Thread(clock);
                timer.start();
                  
                sim.generatePeople();
                System.out.println("Number of people at start: " + sim.numberOfPeople());
                
                //while (sim.numberOfPeople() != 0)
                //{
               
           
                
                
                
                    
                //}
                
                System.out.println("Number of people at end: " + sim.numberOfPeople());
                System.out.println("Simulation took " + Clock.getTicks() + " ticks.");
                System.exit(0);
            }
        });
        add(button);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        JFrame gonfigGUI = new ConfigGUI2();
    }

    class PeopleAdjustmentListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider source = (JSlider) ce.getSource();
            if (!source.getValueIsAdjusting()) {
                Config.numberOfPeople = (int) source.getValue();
                System.out.println(Config.numberOfPeople + " people");
            }
        }
    }

    class FloorCountAdjustmentListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider source = (JSlider) ce.getSource();
            if (!source.getValueIsAdjusting()) {
                Config.maxFloor = (int) source.getValue();
                if (Config.maxFloor < 2) {
                    Config.maxFloor = 2;
                }
                System.out.println(Config.maxFloor + " floors");
            }
        }
    }
}

class NumberOfElevatorsAdjustmentListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider source = (JSlider) ce.getSource();
        if (!source.getValueIsAdjusting()) {
            Config.numberOfElevators = (int) source.getValue();
            System.out.println(Config.numberOfElevators + " elevators");
        }
    }
}
