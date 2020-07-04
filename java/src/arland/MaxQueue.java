package arland;

/**
 * @author xiangchaolei
 */
public class MaxQueue {

    int SIZE = 10001;

    int[] e = new int[SIZE];

    int front = 0;
    int rear = 0;
    int max = -1;

    public MaxQueue() {

    }

    public int max_value() {
        return max;
    }

    public void push_back(int value) {
        e[rear++] = value;
        max = Math.max(max, value);
    }

    public int pop_front() {
        if(isEmpty()){
            return -1;
        }
        else{
            int t = e[front++];
            if(t==max){
                int p = front;
                max = -1;
                while(p!=rear){
                    max = Math.max(max, e[p++]);
                }
            }
            return t;
        }
    }

    private boolean isEmpty(){
        return front==rear;
    }

}
