package Graph;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E> {
    private ArrayList<E> stack = new ArrayList<E>();



    /**
     * method to add objects to the stack
     * @param o
     */
    public void push(E o){
        stack.add(o);
    }


    /**
     * method to remove objects at the top of the stack
     */
    public E pop(){
        if(isEmpty()) throw new EmptyStackException();
        E o = stack.get(getSize()-1);
        stack.remove(o);
        return o;
    }

    /**
     * method to remove objects at the top of the stack
     */
    public E peek(){
        if(isEmpty()) throw new EmptyStackException();
        return stack.get(getSize()-1);
    }

    /**
     * gets the size of the stack
     * @return integer of size
     */
    public int getSize(){
        return stack.size();
    }


    /**
     * checks if stack is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + stack.toString();
    }

    /**
     * search if object exists in stack
     * @param o
     * @return searched object in stack
     */
    public boolean search(E o){
        if(isEmpty()) throw new EmptyStackException();
        if(stack.contains(o)) return true;
        return false;
    }
}
