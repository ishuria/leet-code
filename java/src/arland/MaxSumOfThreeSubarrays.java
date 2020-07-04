package arland;

import java.util.Arrays;
//todo 待优化
/**
 * @author xiangchaolei
 */
public class MaxSumOfThreeSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;

        int[][][][] dp = new int[n][n][][];
        for (int i = 0; i < n-k+1; i++) {
            for (int j = i+k-1; j < n; j++) {
                dp[i][j] = findMax(Arrays.copyOfRange(nums, i, j+1), k,i);
            }
        }


        int[] m = new int[k];

        for (int i = 0; i < m.length; i++) {
            m[i] = 10000;
        }

        int max = 0;

        for (int i = k; i <= n-k; i++) {

//            int[][] p1 = findMax(Arrays.copyOfRange(nums, 0, i+k), k);
//            int[][] p2 = maxSumOfTwoSubarrays(Arrays.copyOfRange(nums, i+k, n), k);
            int[][] p1 = dp[0][i];
            int[][] p2 = maxSumOfTwoSubarrays(Arrays.copyOfRange(nums, i, n), k,dp,i);

//            for (int i1 = 0; i1 < p2[1].length; i1++) {
//                p2[1][i1]+=i+k;
//            }

            if(p1==null){
                System.out.println();
            }

            int[] p = merge(p1[0],p2[0]);
            int sum = 0;
            for (int j = 0; j < p.length; j++) {
                sum+=p[j];
            }
            if(max<sum){
                max=sum;
                m=merge(p1[1],p2[1]);
            }
            if(max==sum){
                //对比字典序
                int[] _m = merge(p1[1],p2[1]);
                if(cmp(_m,m)<0){
                    m= _m;
                }
            }
        }
        return m;

    }

    public int[][] maxSumOfTwoSubarrays(int[] nums, int k,int[][][][] dp,int start) {
        int n = nums.length;

        int[] m = new int[2];
        int[][] mm = new int[2][];

        int max = 0;

        for (int i = k; i <= n-k; i++) {

//            int[][] p1 = findMax(Arrays.copyOfRange(nums, 0, i+k),k);
//            int[][] p2 = findMax(Arrays.copyOfRange(nums, i+k, n), k);

            int[][] p1 = dp[start][start+i-1];
            int[][] p2 = dp[start+i][start+n-1];

//            for (int i1 = 0; i1 < p2[1].length; i1++) {
//                p2[1][i1]+=i+k;
//            }

            if(null==p2){
                System.out.println();
            }

            int[] p = merge(p1[0],p2[0]);

            int sum = 0;
            for (int j = 0; j < p.length; j++) {
                sum+=p[j];
            }
            if(max<sum){
                max=sum;
                //保存字典序
                m=merge(p1[1],p2[1]);
                mm[0] = p;
            }

        }
        mm[1] = m;
        return mm;
    }

    private int[] merge(int[]a,int[]b){
        int[] p = new int[a.length+b.length];
        System.arraycopy(a,0,p,0,a.length);
        System.arraycopy(b,0,p,a.length,b.length);
        return p;
    }

    private int[][] findMax(int[] nums, int k,int start){
        int[][] r= new int[2][];
        int n=nums.length;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i <= n-k; i++) {
            int sum = 0;
            for (int j = i; j < i+k; j++) {
                sum += nums[j];
            }
            if(max<sum){
                max=sum;
                maxIndex = i;
            }
        }
        r[0] = Arrays.copyOfRange(nums,maxIndex,maxIndex+k);
        r[1] = new int[]{maxIndex+start};
        return r;
    }

    private int cmp(int[] a, int[] b){
        int n = a.length;
        int m = b.length;
        if(n!=m){
            return n-m;
        }
        for (int i = 0; i < n; i++) {
            if(a[i]>b[i]){
                return 1;
            }
            else if(a[i]<b[i]){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // write your code here
        int[] a1 = {1,2,1,2,6,7,5,1};
        int k1 = 2;

        int[] a2 = {7,13,20,19,19,2,10,1,1,19};
        int k2 = 3;

        MaxSumOfThreeSubarrays a = new MaxSumOfThreeSubarrays();
//        a.print(a.maxSumOfThreeSubarrays(a1,k1));//0,3,5
        a.print(a.maxSumOfThreeSubarrays(a2,k2));//1,4,7

//        a.findMax(new int[]{7,13,20,19},3);
    }


    private void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }



}
