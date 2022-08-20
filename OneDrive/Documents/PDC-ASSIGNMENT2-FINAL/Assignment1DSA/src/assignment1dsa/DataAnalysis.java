/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa;

/**
 *
 * @author GGPC
 */
public class DataAnalysis<E> {

    E[] data;
    Queue<E> queue;
    Stack<E> stack;

//take an array of type E 
    DataAnalysis(E[] data) {
        this.data = data;
        queue = new Queue<>();
        stack = new Stack<>();
    for(E datas:data){
        queue.enqueue(datas);
        stack.push(datas);
    }
    
    }
    public boolean isSymmetrical() {
        for(int i = 0; i < data.length/2;i++)
        {
            if (!queue.dequeue().equals(stack.pop()))
            {
            return false;
            } 
        }
    return true;    
    }

}
