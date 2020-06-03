package arland;

import java.util.*;

/**
 * @author xiangchaolei
 */
public class LenLongestFibSubseq873 {

    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> index = new HashMap<>(A.length);
        for (int i = 0; i < A.length; i++) {
            index.put(A[i], i);
        }

        Map<Integer, Integer> m = new HashMap<>(A.length*A.length);
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                //check if A[j]-A[i] is in A
                int d = A[j]-A[i];
                Integer id = index.get(d);
                if(null==id){
                    continue;
                }
                if(id<i){
                    int lastKey = id*A.length+i;
                    int thisKey = i*A.length+j;
                    if(m.get(lastKey)==null){
                        max = Math.max(max, 3);
                        m.put(thisKey, 3);
                    }
                    else{
                        max = Math.max(max, m.get(lastKey)+1);
                        m.put(thisKey, m.get(lastKey)+1);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // write your code here
        LenLongestFibSubseq873 a = new LenLongestFibSubseq873();
        System.out.println(a.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
}
