package arland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class PathInZigZagTree {

    public List<Integer> pathInZigZagTree(int label) {

        boolean c = true;

        int level = (int) Math.ceil(log2(label+1));

        int[] d = new int[(int) Math.pow(2, level)];

        for (int i = 1; i <= level; i++) {
            int[]a = next(i, c);
            c = !c;
            System.arraycopy(a, 0, d, (int) Math.pow(2, i-1), a.length);
        }
        List<Integer> l = new ArrayList<>(d.length);

        for (int i = d.length-1; i >=0 ; i--) {
            if(d[i]==label){
                while(i!=0){
                    l.add(0,d[i]);
                    i /=2;
                }
                return l;
            }
        }
        return l;
    }

    public int[] next(int level, boolean dir){

        int first = (int) Math.pow(2,level-1);
        int count = (int) Math.pow(2,level-1);
        int[] d = new int[count];

        if(dir){
            for (int i = 0; i < count; i++) {
                d[i] = first+i;
            }

        }
        else{
            for (int i = count; i >0 ; i--) {
                d[count-i] = first+i-1;
            }
        }
        return d;
    }

    public double log2(double N) {
        return Math.log(N)/Math.log(2);//Math.log的底为e
    }



    public static void main(String[] args) {
        // write your code here

        PathInZigZagTree a = new PathInZigZagTree();

        System.out.println(a.pathInZigZagTree(14));
        System.out.println(a.pathInZigZagTree(26));

//        System.out.println(Arrays.toString(a.next(1,true)));
//        System.out.println(Arrays.toString(a.next(2,false)));
//        System.out.println(Arrays.toString(a.next(3,true)));
//        System.out.println(Arrays.toString(a.next(4,false)));
    }
}
