/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa;


/**
 *
 * @author GGPC
 */
public class Main {

    public static void main(String[] args) {
       Node<String> node1 = new Node ("W",null);
       Node<String> node2 = new Node ("O",node1);
       Node<String> node3 = new Node ("w",node2);      
  

       LinkedList list = new LinkedList();
       list.add(node1);
       list.add(node2);
       list.add(node3);
      
  
      System.out.println(node1.next);
}





}
