package elevator;

import java.util.LinkedList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpoumakis
 */
public class DataCollector
{

    static LinkedList<Person> peopleFinished = new LinkedList<>();

    public static void addPerson(Person person)
    {
        peopleFinished.add(person);
    }

    public void writeOutputFile() throws IOException
    {
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter("./output.txt");
        }
        catch (IOException ex)
        {
            Logger.getLogger(DataCollector.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Person person : peopleFinished)
        {
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.write(person.toString());
                    fileWriter.write('\n');
                }
                catch (IOException ex)
                {
                    Logger.getLogger(DataCollector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        fileWriter.close();
    }

    public static int calculateHowManyFinished()
    {
        return peopleFinished.size();
    }

    public int calculateTotalTime()
    {
        int time = 0;

        for (Person person : peopleFinished)
        {
            time += person.getTotalTime();
        }
        return time;
    }

    public int calculateShortestTime()
    {
        int time = Integer.MAX_VALUE;

        for (Person person : peopleFinished)
        {
            if (person.getTotalTime() < time)
            {
                time = person.getTotalTime();
            }
        }
        return time;
    }

    public int calculateLongestTime()
    {
        int time = 0;

        for (Person person : peopleFinished)
        {
            if (person.getTotalTime() > time)
            {
                time = person.getTotalTime();
            }
        }

        return time;
    }
}
