package assignment1dsa;

import java.util.NoSuchElementException;

/**
 *
 * @author Luke McLeod
 */
public class LinkedList<E> {
//refers to the first node 

    public int size;
    private Node<E> head;
    private Node <E> tail;
//adds data at the end.
    public LinkedList() {
    head = null;
    size =0;
    tail = null;
    }
    
//adding a value into the linked list. 
    public void add(E data) {
        Node<E> newNode = new Node(data);
        if (head == null) {
            head = newNode;
            //setting the temporary node to the head;
        } else {
            Node<E> currentNode = head;
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

    public void addInOrder(E data) {
        //add files in oder
        Node<E> newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else if (head.compareTo(newNode) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            Node<E> temp = null;
            while (current != null) {
                if (current.compareTo(newNode) > 0) {
                    break;
                }
                temp = current;
                current = current.next;
            }
            temp.next = newNode;
            newNode.next = current;
        }
        size++;

    }

    public boolean contains(Node node) {
        Node<E> current = head;
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
            Node<E> current = head;
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
            Node<E> current = head;

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

        public E getNode(int n)throws NoSuchElementException{
        Node <E> current = null;
        
        if(n < 0 || n >= size ){
        throw new NoSuchElementException("index out of bounds");
        }
        else if (n > size/2){
            
          current = tail;
          for(int i = 0 ; i < n; i++){
          
          
          }
        }
        return current.data;
        
        }
    }

