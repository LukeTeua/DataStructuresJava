package assignment1dsa;

/**
 *
 * @author lukey
 */
public class Node <E extends Comparable <E>>{

    public E data;
    public Node next;

    public Node() {
        this.next = null;
        this.data = null;
    }

    public Node(E element) {
        this.data = element;
        next = null;
    }

    public Node (E data, Node next) {

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
        this.data = data;
    }

    public boolean equals(Node node) {
        return this.data == node.data;
    }
    
    
 public int compareTo(Node node)
    {
        return this.data.compareTo((E)node.data);
    }
}
