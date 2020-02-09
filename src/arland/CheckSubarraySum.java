package arland;

/**
 * @author xiangchaolei
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i-1; j >=0; j--) {
                sum +=nums[j];
                if(k!=0&&sum%k==0){
                    return true;
                }
                if(k==0&&sum==0){
                    return true;
                }
            }

        }
        return false;
    }


    public static void main(String[] args) {
        // write your code here
        int[] a1 = {23,2,4,6,7};
        int k1 = 6;

        int[] a2 = {23,2,6,4,7};
        int k2 = 6;

        int[] a3 = {23,2,6,4,7};
        int k3 = 0;

        int[] a4 = {0,0};
        int k4 = 0;

        CheckSubarraySum a = new CheckSubarraySum();
        System.out.println(a.checkSubarraySum(a1,k1));//t
        System.out.println(a.checkSubarraySum(a2,k2));//t
        System.out.println(a.checkSubarraySum(a3,k3));//f
        System.out.println(a.checkSubarraySum(a4,k4));//t
    }
}
