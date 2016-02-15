package elevator;

/*
// Queues (first in first out (FIFO)
enqueue(ELement) -- add an element
Element dequeue -- remove an element
clear() -- 
isEmpty()
isFull()

frontPointer
backPointer

^^ both start at 0

backPointer to next available. when you enqueue it increments
frontPointer points to first person. when you dequeue you remove that person then increment frontPointer to next persons whose turn to get off is.

circularCount... when you hit bottom enqueing you just move it to top.
*/


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dpoumakis
 */
public class ElevatorQueue
{
    private int personCount;
    
    // Points to first person to go
    private int frontPointer;
    
    // Points to next available spot
    private int backPointer;
    
    Queue<Person> queue;
    
    public ElevatorQueue()
    {
        this.personCount = 0;
        this.frontPointer = 0;
        this.backPointer = 0;
        this.queue = new LinkedList<>();
    }
    
    public void enqueue(Person person)
    {
        this.queue.add(person);
        //this.backPointer++;
    }
    
    public Person dequeue()
    {
        Person nextOff = null;
        
        // need to catch if its empty
        nextOff = this.queue.remove();
        
        return nextOff;
    }
}
