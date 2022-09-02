package assignment1dsa;

import java.util.NoSuchElementException;

/**
 *
 * @author Luke McLeod
 */
public class LinkedList<E> {
//refers to the first node 

    public int size;
    public Node head;
    public Node tail;
//adds data at the end.
    
    public LinkedList(){
    head = null;
    size =0;
    tail = null;
    }
    
//adding a value into the linked list. 
    public void add(E data) {
        Node newNode = new Node((Comparable) data);
        
        if (head == null) {
            head = newNode;
            //setting the temporary node to the head;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

   public void addInOrder(E data)
    {
        Node newNode = new Node();
        newNode.setData((Comparable) data);
        
        if((this.head == null) || (newNode.compareTo(this.head) <= 0))
        {
            newNode.next = this.head;
            this.head = newNode;
        }
        else
        {
            Node current = this.head;
            
            while((current.next != null) && (newNode.compareTo(current.next) >= 0))
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        this.size++;
    }

    public boolean contains(Node node) {
        Node current = head;
        boolean found = false;

        while (current != null && !found) {
            if (current.data.equals(node.data)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    public boolean remove(Node node) {

        if (head == null) {
            return false;
        }

        if (head.data.equals(node.data)) {

            head = head.next;
            size--;
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.next.data.equals(node.data)) {
                    current.next = current.next.next;
                    size--;
                    return true;
                } else {
                    current = current.next;
                }
            }
        }
        return false;
    }

    public void removeFromHead() {
        if (head == null) {
            return;
        }
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public void removeFromTail() {
        if (head == null || head.next == null) {
            return;
        } else {
            Node current = head;

            //finds the second to last node.
            while (current.next.next != null) {
                //finds 456 node. 
                current = current.next;
            }
            //collected by garbage collector. 
            if (current.next.next == null) {
                current.next = current;
                current.next = null;
                size--;
            }

        }

    }

    public void printLinkedList() {
        Node current = head;
        System.out.println("LinkedList:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    
    public Node getNode(int i) {
        Node current = null;
        if (i < this.size && i >= 0) {
            current = this.head;
            for (int j = 0; j < this.size; j++) {
                if (i == j) {
                    return current;
                }
                current = current.next;
            }
        }
        return current;
    }
    }

