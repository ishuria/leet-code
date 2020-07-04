package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        if(n==0){
            return 0;
        }
        if(1==n){
            return A[0];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        int ans1 = maxSubarraySum(A);
        int ans2 = sum - minSubarraySum(Arrays.copyOfRange(A, 1, n));
        int ans3 = sum - minSubarraySum(Arrays.copyOfRange(A, 0, n-1));
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    public int maxSubarraySum(int[] A){
        int n = A.length;
        int[] d = new int[n];
        d[0] = A[0];
        int max = Integer.MIN_VALUE>>1;
        for (int i = 1; i < n; i++) {
            if(d[i-1]<0){
                d[i] = A[i];
            }
            else{
                d[i] = d[i-1]+A[i];
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }

    public int minSubarraySum(int[] A){
        int n = A.length;
        int[] d = new int[n];
        d[0] = A[0];
        int min = Integer.MAX_VALUE>>1;
        for (int i = 1; i < n; i++) {
            if(d[i-1]>0){
                d[i] = A[i];
            }
            else{
                d[i] = d[i-1]+A[i];
            }
            min = Math.min(min, d[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        // write your code here

        MaxSubarraySumCircular a = new MaxSubarraySumCircular();

        int[] nums1 = new int[]{1,-2,3,-2};
        System.out.println(a.maxSubarraySumCircular(nums1));//3

        int[] nums2 = new int[]{5,-3,5};
        System.out.println(a.maxSubarraySumCircular(nums2));//10

        int[] nums3 = new int[]{3,-1,2,-1};
        System.out.println(a.maxSubarraySumCircular(nums3));//4

        int[] nums4 = new int[]{3,-2,2,-3};
        System.out.println(a.maxSubarraySumCircular(nums4));//3

        int[] nums5 = new int[]{-2,-3,-1};
        System.out.println(a.maxSubarraySumCircular(nums5));//-1
    }
}
