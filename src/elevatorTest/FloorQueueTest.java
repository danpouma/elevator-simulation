package elevatorTest;

import elevator.*;

/**
 *
 * @author dpoumakis
 */
public class FloorQueueTest
{
    public static void main(String[] args) 
    {
        FloorQueue queue = new FloorQueue();
        Person myPerson1 = new Person();
        Person myPerson2 = new Person();
        Person myPerson3 = new Person();
        Person myPerson4 = new Person();
        queue.enqueue(myPerson1);
        queue.enqueue(myPerson2);
        queue.enqueue(myPerson3);
        System.out.println("Count is " + queue.getSize());
        System.out.println("Out of line " + queue.dequeue().toString() );
        System.out.println("Count is " + queue.getSize());
        System.out.println("Out of line " + queue.dequeue().toString() );
        System.out.println("Count is " + queue.getSize());
        queue.enqueue(myPerson4);
        System.out.println("Count is (after enqueue)" + queue.getSize());
        System.out.println("Out of line " + queue.dequeue().toString() );
        System.out.println("Count is " + queue.getSize());
        System.out.println("Out of line " + queue.dequeue().toString() );
        System.out.println("Count is " + queue.getSize());
    }
}
