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
        return (this.data.equals(next.data));
    }
    
    
    public int compareTo(Node node){
    
        String a = this.data.toString();
        String b = node.data.toString();
        return a.compareTo(b);
    }

}
