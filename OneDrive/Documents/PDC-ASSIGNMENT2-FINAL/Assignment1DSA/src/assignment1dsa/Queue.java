package assignment1dsa;

import java.util.NoSuchElementException;

/**
 *
 * @author LukeTeua
 * @param <E>
 */
public class Queue <E> extends LinkedList{

   
    
    public Queue (){}

    @Override
    public int getSize() {
        return size;
    }

    public void enqueue(E data) {
        Node newNode = new Node((Comparable) data);
//checks to see if the tail is null. 
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E dequeue() throws NoSuchElementException {
        //returns a node from the queue.
        if (head != null) {
            E headElement = (E) head.data;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return headElement;
        } else {
            throw new NoSuchElementException();
        }
    }
    public void printQueue() {
        Node current = new Node();
        while (current != null) {
            System.out.print(" " + current.data + " ");
            if (current.next != null) {
                current = current.next;
            }
        }
    }

}
