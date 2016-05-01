package elevator;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class ElevatorButton
{
    private boolean isOn;
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
    
    public void setOn(boolean isOn)
    {
        this.isOn = isOn;
    }
    
    public boolean isOn()
    {
        return isOn;
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
