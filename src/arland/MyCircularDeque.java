package arland;

/**
 * @author xiangchaolei
 */
public class MyCircularDeque {
    int[] e;
    int front = 0, rear = 1;
    int size = 0;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        e = new int[k+2];
        size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        e[front] = value;
        front = (front + e.length - 1) % e.length;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        e[rear] = value;
        rear = (rear+1)%e.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front+1)%e.length;
        e[front] = 0;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear + e.length - 1) % e.length;
        e[rear] = 0;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return e[(front+1)%e.length];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return e[(rear + e.length - 1) % e.length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rear==front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear+1)%e.length==front;
    }
}
