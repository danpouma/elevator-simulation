package elevator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dpoumakis
 */

/*
Notes from class for developing this person object...

class Person //data class
  // Properties
  private int id; //track them
  private int startFloor;
  private int stopFloor; // can’t be same as startFloor
  private int time; // don’t care about this yet
  // make sure stop/start floor are less than maxFloor
  private int maxFloor = 10; // random for now until we have more files down the road
  private bool goingUp; // Determine by public interface
  private bool goingDown;  // Determine by public interface  
  //class property
  private static int counter = 0;

  Person()
  {
    id = counter++;
  }

  secondary that will set start, stop and time

  set and gets for all of them except for id

*/
public class Person
{
    private int id;
    
    private int startFloor;
    private int stopFloor;
    
    private int time;
    
    private int maxFloor;
    
    private boolean goingUp;
    private boolean goingDown;
    
    // Is it ok to declare 0 here? double check
    private static int counter = 0;

    public Person()
    {
        this.id = counter++;
        this.maxFloor = Config.maxFloor;
    }

    public int getId()
    {
        return id;
    }

    public int getStartFloor()
    {
        return startFloor;
    }

    public void setStartFloor(int startFloor)
    {
        this.startFloor = startFloor;
    }

    public int getStopFloor()
    {
        return stopFloor;
    }

    public void setStopFloor(int stopFloor)
    {
        this.stopFloor = stopFloor;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public int getMaxFloor()
    {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor)
    {
        this.maxFloor = maxFloor;
    }

    public boolean isGoingUp()
    {
        return goingUp;
    }

    public void setGoingUp(boolean goingUp)
    {
        this.goingUp = goingUp;
    }

    public boolean isGoingDown()
    {
        return goingDown;
    }

    public void setGoingDown(boolean goingDown)
    {
        this.goingDown = goingDown;
    }
    
    @Override
    public String toString()
    {
        // make this type casted
        return id+"";
    }
}