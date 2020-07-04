package arland;

/**
 * @author xiangchaolei
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] d = new  int[nums.length];
        d[0] = nums[0];
        int max = d[0];
        for (int i = 1; i < nums.length; i++) {
            if(d[i-1] + nums[i]< nums[i]){
                d[i] = nums[i];
            }
            else{
                d[i] = d[i-1] + nums[i];
            }
            if(max < d[i]){
                max = d[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray a = new MaxSubArray();
        System.out.println(a.maxSubArray(nums));
    }
}
