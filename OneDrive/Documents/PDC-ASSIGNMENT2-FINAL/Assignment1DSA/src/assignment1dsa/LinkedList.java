package assignment1dsa;

/**
 *
 * @author Luke McLeod
 */
public class LinkedList<E> {
//refers to the first node 

    public int size;
    private Node<E> head;

//adds data at the end.
    public LinkedList() {
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

    public int size() {
        return size;
    }

    public void addInOrder(E data) {
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

            if (current.next.next == null) {
                current.next = current;
                current.next =null;
                size--;
            }

        }

    }

    public static void main(String[] args) {

        Node<Integer> node1 = new Node(3, null);
        Node<Integer> node2 = new Node(3, node1);
        Node<Integer> node3 = new Node(45, node2);
        Node<Integer> node4 = new Node(11, node3);
        Node<Integer> node5 = new Node(8, node4);
        LinkedList<Integer> l = new LinkedList();

        l.add(8);
        l.add(2);
        l.add(1234123);
        l.contains(node5);
        System.out.println(l.contains(node5));

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

}
