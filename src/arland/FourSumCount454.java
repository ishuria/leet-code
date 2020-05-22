package arland;

import java.util.HashMap;

/**
 * @author xiangchaolei
 */
public class FourSumCount454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                if(map.get(C[i]+D[i1])!=null){
                    map.put(C[i]+D[i1], map.get(C[i]+D[i1])+1);
                }
                else{
                    map.put(C[i]+D[i1], 1);
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                if(map.containsKey(((A[i]+B[i1]))*-1)){
                    count+=map.get(((A[i]+B[i1]))*-1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // write your code here
        FourSumCount454 a = new FourSumCount454();
        System.out.println(a.fourSumCount(
                new int[]{1, 2},
                new int[]{-2,-1},
                new int[]{-1,2},
                new int[]{0,2}));
    }
}
