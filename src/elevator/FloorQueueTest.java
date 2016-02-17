/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class FloorQueueTest
{
    public static void main(String[] args)
    {
        FloorQueue queue = new FloorQueue();
        
        ArrayList<Person> people = new ArrayList<>();
        
        for (int person = 0; person < 10; person++)
        {
            people.add(new Person());
            queue.enqueue(people.get(person));
        }
        
        System.out.println("********************************");
        
        for (int person = 0; person < 5; person++)
        {
            queue.dequeue().getId();
        }
        
        for (int person = 10; person < 15; person++)
        {
            people.add(new Person());
            queue.enqueue(people.get(person));
        }
        
        for (int person = 0; person < 10; person++)
        {
            System.out.println(queue.dequeue().getId());
        }
    }
}
