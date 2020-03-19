package arland;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

class MedianFinder {


    /** initialize your data structure here. */

    ArrayList<Integer> l;
    int m,n;

    public MedianFinder() {
        l = new ArrayList<Integer>();
        m=0;
        n=0;
    }

    public void addNum(int num) {
        l.add(num);
        l.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        m = (int) Math.floor(((double)(l.size()-1))/2);
        n = (int) Math.ceil(((double)l.size()-1)/2);
    }

    public double findMedian() {
        return ((double)l.get(m)+(double)l.get(n))/2;
    }

    public static void main(String[] args){
        MedianFinder obj = new MedianFinder();
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
    }
}



/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */