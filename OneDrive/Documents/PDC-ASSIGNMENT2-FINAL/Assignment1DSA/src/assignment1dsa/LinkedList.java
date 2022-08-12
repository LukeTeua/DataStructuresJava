package assignment1dsa;

/**
 *
 * @author Luke McLeod
 */
public class LinkedList<E> {
//refers to the first node 

    private int size;
    private Node<E> head;

//adds data at the end.
    public LinkedList() {
    }

//adding a value into the linked list. 
    public void add(E element) {

        //add behind the previous node.
        //creating a new node passing in the element E.
        Node<E> newNode = new Node(element);
        if (head == null) {
            head = newNode;
            //setting the temporary node to the head;
        } else {
            Node<E> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean contains(E element) {

        return true;

    }

    public static void printLinkedList(LinkedList list) {
        Node current = list.head;
        System.out.println("LinkedList:");
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(44);
        list.add(15);

        printLinkedList(list);
        System.out.println(list.size());

    }

}
