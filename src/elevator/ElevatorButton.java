package elevator;

/**
 *
 * @author dpoumakis
 */
public class ElevatorButton
{
    public boolean isOn;
    private String label;
    
    public ElevatorButton()
    {
        this.label = "";
        this.isOn = false;
    }
    
    public ElevatorButton(String label)
    {
        this.label = label;
        this.isOn = false;
    }
    
    public void turnOn()
    {
        this.isOn = true;
    }
    
    public void turnOff()
    {
        this.isOn = false;
    }
    
    
    public boolean isOn()
    {
        return this.isOn;
    }
    
    public void setLabel(String label)
    {
        this.label = label;
    }
    
    public String getLabel()
    {
        return this.label;
    }
}
