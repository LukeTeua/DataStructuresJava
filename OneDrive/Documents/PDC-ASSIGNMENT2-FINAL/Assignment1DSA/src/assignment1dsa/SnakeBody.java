/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa;

/**
 *
 * @author lukey
 */
public class SnakeBody {

    private LinkedList<String> body;

    private String move;//UP ,DOWN,LEFT,RIGHT.

    public SnakeBody() {
        //Linked List of snake values;
        body = new LinkedList();
        body.add("@");
        body.add("S");
        body.add("S");
        
        move = "NULL";
    }
    
    //move the snake to the location 
    public void up() {

        move = "UP";

    }

    public void down() {

        move = "DOWN";

    }

    public void left() {

        move = "LEFT";

    }

    public void right() {

        move = "RIGHT";

    }

    /**
     * @return the body
     */
    public LinkedList<String> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(LinkedList<String> body) {
        this.body = body;
    }

}
