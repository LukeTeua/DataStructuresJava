package assignment1dsa;

/**
 *
 * @author lukey
 */
public class Node<E> {

    public E data;
    public Node next = null;

    public Node() {
    }

    public Node(E element) {
        this.data = element;
        next = null;
    }

    public Node(E data, Node next) {

        this.data = data;
        next = null;
    }

    public Node next(Node E) {
        return E;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        next = next;
    }

    public boolean equals(Node next) {
        return (this == next);
    }

    public int compareTo(Node next) {

        if (this.getData() == next.getData()) {
            return 0;
        } else {
            return 1;
        }

    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node(3, null);
        Node<Integer> node2 = new Node(3, node1);
        Node<Integer> node3 = new Node(45, node2);
        Node<Integer> node4 = new Node(11, node3);
        Node<Integer> node5 = new Node(8, node4);

        //this gets the second item in the linked list.
        System.out.println("Printing Node 1:" + node1.getData());
        System.out.println("Printing Node 2:" + node2.getData());
        System.out.println("Printing Node 3:" + node3.getData());
        System.out.println("Printing Node 4:" + node4.getData());
        System.out.println("Printing Node 5:" + node5.getData());
        System.out.println("Node 1 equals node 2 should return true:" + node1.getData().equals(node2.getData()));
        System.out.println("Comparing node 1 to node 2 return 0 if the node values are using equals method equal:" + node1.getData().compareTo(node2.getData()));
        System.out.println("Node 1 comparing to node 2 should return 0:" + node2.getData().compareTo(node1.getData()));
        System.out.println("Since the value at node 3 is larger than node 5 should return a positive number:" + node3.getData().compareTo(node5.getData()));
        System.out.println("Since node 1 is smaller than node 4 the number returned should be negative:" + node1.getData().compareTo(node4.getData()));

        Node<String> stringNode1 = new Node("A", null);
        Node<String> stringNode2 = new Node("A", null);
        Node<String> stringNode3 = new Node("B", null);
        System.out.println("Printing String node:" + stringNode1.getData());
        System.out.println("Printing String node:" + stringNode2.getData());
        System.out.println("Printing String node:" + stringNode3.getData());
        System.out.println("StringNode1 equals node 2 should return false ,integer vs String:" + stringNode3.getData().equals(node4.getData()));
        System.out.println("Comparing the two stringnodes stringNode1 and stringNode2:" + stringNode1.getData().compareTo(stringNode2.getData()));
        System.out.println("Equals method on stringNode1 and stringNode3:" + stringNode1.getData().compareTo(stringNode3.getData()));

    }

}
