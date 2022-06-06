package Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class MyQueue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();
    private E[] e;

    public MyQueue(){}

    public MyQueue(E[] e) {
        this.e = e;
        for(int i=0; i<e.length;i++){
            list.addLast(e[i]);
        }
    }

    public void enqueue(E e){
        list.addLast(e);
    }

    public E dequeue(){
        return list.removeFirst();
    }

    public E getElement(int i){
        if(i< 0 || i>= list.getSize()) return null;
        return list.get(i);
    }

    public E peek(){
        return list.getFirst();
    }

    public int getSize(){
        return list.getSize();
    }

    public boolean contains(E e){
        return list.contains(e);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "list=" + list +
                ", e=" + Arrays.toString(e) +
                '}';
    }
}
