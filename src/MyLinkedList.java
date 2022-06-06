/**
 * Reference
 * https://devwithus.com/implement-linked-list-java/
 */
package Graph;

import Graph.Node;

public class MyLinkedList<E> implements lab4.question1.MyLinkedListAbstract<E> {

    private Node<E> head =null;
    private Node<E> tail = null;
    private int size;

    public MyLinkedList(){
        size=0;
    }

    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        newNode = head;
        setSize(getSize() + 1);
        if(tail==null){
            tail=head;
        }
    }

    public void addLast(E e){
        if(tail==null){
            tail=head=new Node<>(e);
        }
        else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        setSize(getSize() + 1);
    }

    public void add(int index, E e){
        if(index==0) addFirst(e);
        else if (index>= getSize()) addLast(e);
        else{
            Node<E> current = head;
            for (int i=0;i<index;i++){
                current=current.next;
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            setSize(getSize() + 1);
            }
        }
    }

    public E removeFirst(){
        if(getSize() ==0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            setSize(getSize() - 1);
            if(head==null) tail=null;
            return temp.element;
        }
    }

    public E removeLast(){
        if(getSize() ==0) return null;
        else if (getSize() ==1){
            Node<E> temp = head;
            head = tail = null;
            setSize(0);
            return temp.element;
        }
        else {
            Node<E> current = head;
            for(int i = 0; i< getSize() -2; i++)
                current=current.next;
            Node<E> temp = tail;
            tail=current;
            tail.next=null;
            setSize(getSize() - 1);
            return temp.element;
        }
    }

    public E remove(int index){
        if(index<0 || index>= getSize()) return null;
        else if (index==0) return removeFirst();
        else if (index== getSize() -1) return removeLast();
        else {
            Node<E> previous = head;
            for (int i=1;i<index;i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public void add(E e) {
        addLast(e);
    }

    @Override
    public boolean contains(E e) {
       return indexOf(e) >=0;
    }

    @Override
    public E get(int index) {
        if(index<0 || index>= size) return null;
        else if(index==0) return head.element;
        else if(index==size-1) return tail.element;
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        }
    }

    @Override
    public E getFirst() {
        if(head==null) return null;
        return head.element;
    }

    @Override
    public E getLast() {
        if(tail==null) return null;
        return tail.element;
    }

    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        boolean found = false;
        int index = -1;
        while(current!=null){
            index++;
            if((current.element).equals(e))
            {
                found = true;
                break;

            }
            current=current.next;


        }

        return index;
    }

    @Override
    public int lastIndexOf(E e) {
       return getSize();
    }

    @Override
    public E set(int index, E e) {
        if(index<0 || index >= size) return null;
        if (index==0){
            Node<E> tmp = head;
            head.element =e;
            return tmp.element;
        }
        Node<E> current = head;
        for(int i=0;i<index;i++){
            current=current.next;

        }
        Node<E> temp = current;
        current.element = e;

        return temp.element;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
        size =0;

    }

    @Override
    public void print() {
        Node<E> current = head;
        while(current!=null){
            System.out.print(current.element + " ");
            current=current.next;

        }
    }

    @Override
    public void reverse() {
        Node<E> current = head;
        Node<E> enext = null;
        Node<E> previous = null;
        while(current!=null){
            enext = current.next;
            current.next = previous;
            previous = current;
            current = enext;

        }
        head = previous;

    }

    @Override
    public E getMiddle() {
        E middle = get(getSize() /2);
        return middle;
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
