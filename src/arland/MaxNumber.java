package arland;


import java.util.Arrays;
//todo 待优化

/**
 * @author xiangchaolei
 */
public class MaxNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[0];
        for (int i = 0; i <= k; i++) {
            int jEnd = k - i;
            //求nums1中长度为i的最大子序列
            int[] max1 = maxSubStr(nums1, i);
            //求nums2中长度为j的最大子序列
            int[] max2 = maxSubStr(nums2, jEnd);


            int[] g = greed(max1,max2, k);
            max = max(max, g);
        }

        return max;

    }

    private int[] maxSubStr(int[] a, int l){
        //dp[i][k]代表a中前i个字符组成的序列中长度为k的最大子序列
        int[] max = new int[0];
        int n = a.length;
        if(n<=l){
            return a;
        }

        if(0==l){
            return max;
        }

        int[][][] dp = new int[n][l+1][];

        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= l; j++) {
                dp[i][j] = new int[0];
            }
        }

        //初始化a中长度为1的最大子序列
        for (int i = 0; i < n; i++) {
            dp[i][1] = new int[0];
            for (int j = 0; j <= i; j++) {
                dp[i][1] = max(dp[i][1],new int[]{a[i]});
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= l; j++) {
                int[] newA = new int[dp[i-1][j-1].length+1];
                System.arraycopy(dp[i-1][j-1],0,newA,0,dp[i-1][j-1].length);
                newA[dp[i-1][j-1].length] = a[i];
                dp[i][j] = max(dp[i-1][j], newA);
            }
        }

        for (int i = 0; i < n; i++) {
            max = max(max, dp[i][l]);
        }

        return max;
    }

    private int[] max(int[] a1,int[]a2){
        int n1 = a1.length;
        int n2=a2.length;
        if(n1>n2){
            return a1;
        }
        if(n1<n2){
            return a2;
        }
        for (int i = 0; i < n1; i++) {
            if(a1[i]>a2[i]){
                return a1;
            }
            if(a1[i]<a2[i]){
                return a2;
            }
        }
        return a1;
    }


    private int[] greed(int[] nums1, int[] nums2, int k){
        int n1 = nums1.length;
        int n2 = nums2.length;


        if(k>n1+n2){
            k=n1+n2;
        }

        int i = 0, j = 0;
        int[] ret = new int[k];
        while(i<n1&&j<n2){
            if(nums1[i]<nums2[j]){
                ret[i+j] = nums2[j];
                j++;
            }
            else if (nums1[i]>nums2[j]){
                ret[i+j] = nums1[i];
                i++;
            }
            //==
            else{

                int[] max = max(
                        greed(Arrays.copyOfRange(nums1, i+1, n1), Arrays.copyOfRange(nums2, j, n2), k -i-j),
                        greed(Arrays.copyOfRange(nums1, i, n1), Arrays.copyOfRange(nums2, j+1, n2), k  -i-j)
                );
                ret[i+j] = nums1[i];
                System.arraycopy(max,0,ret,i+j+1,max.length);
                return ret;
            }
        }
        while(i<n1){
            ret[i+j] = nums1[i];
            i++;
        }

        while(j<n2){
            ret[i+j] = nums2[j];
            j++;
        }
        return ret;
    }

    private static void print(int[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }

    }


    public static void main(String[] args) {
//        // write your code here
        int[] a11 = new int[]{3, 4, 6, 5};
        int[] a12 = new int[]{9, 1, 2, 5, 8, 3};
        int ak1 = 5;
        MaxNumber a = new MaxNumber();






        int[] a21 = new int[]{6,7};
        int[] a22 = new int[]{6,0,4};
        int ak2 = 5;



        int[] a31 = new int[]{3,9};
        int[] a32 = new int[]{8,9};
        int ak3 = 3;


        int[] a41 = new int[]{2,5,6,4,4,0};
        int[] a42 = new int[]{7,3,8,0,6,5,7,6,2};
        int ak4 = 15;

        print(a.maxNumber(a11,a12,ak1));
        System.out.println();
        print(a.maxNumber(a21,a22,ak2));
        System.out.println();
        print(a.maxNumber(a31,a32,ak3));
        System.out.println();
        print(a.maxNumber(a41,a42,ak4));
        System.out.println();


    }

}
