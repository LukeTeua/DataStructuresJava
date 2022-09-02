/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa;

import java.util.NoSuchElementException;

/**
 *
 * @author Luke McLeod
 */
public class Stack<E> extends LinkedList<E> {

    int size;
    Node head;

    public Stack(){
    }

//adds an element to the top of the stack.
    public void push(E data) {
        Node newNode = new Node((Comparable) data);
        newNode.next = head;
        head = newNode;
        size++;
    }

//removes and returns the top element from the stack
    public E pop() throws NoSuchElementException {

        if (head != null) {
//set the top of the stack to the head of the list. 
            E stackTop = (E) head.data;
            head = head.next;
            size--;
            return stackTop;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int getSize() {
        return size;

    }

    public void printStack() {
//while loop for the stack. 
        Node current = new Node();
        while (current != null) {
            System.out.print(" " + current.data + " ");
            if (current.next != null) {
                current = current.next;
            }
        }
    }

}
