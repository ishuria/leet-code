package arland;

import java.util.Iterator;

/**
 * @author xiangchaolei
 */
public class PeekingIterator284 implements Iterator<Integer> {

    private class Node{
        private int v;
        private Node next;

        public Node(int v){
            this.v = v;
        }
    }

    Node head;
    Node rear;

    public PeekingIterator284(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()){
            Node next = new Node(iterator.next());
            if(head==null){
                head = next;
                rear = next;
            }
            else{
                rear.next = next;
                rear = next;
            }
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return head.v;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int v = head.v;
        head = head.next;
        return v;
    }

    @Override
    public boolean hasNext() {
        return head!=null;
    }
}
