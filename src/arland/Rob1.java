package arland;

/**
 * @author xiangchaolei
 */
public class Rob1 {

    public int rob(int[] nums) {
        int n = nums.length;
        if(0 == n){
            return 0;
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            if(0 == i){
                d[i] = nums[i];
            }
            else if(1 == i){
                d[i] = Math.max(nums[0], nums[1]);
            }
            else{
                d[i] = Math.max(d[i-1], d[i-2]+nums[i]);
            }
        }
        return d[n-1];
    }

    public static void main(String[] args) {
        // write your code here
        int[] a1 = new int[]{1,2,3,1};
        int[] a2 = new int[]{2,7,9,3,1};
        Rob1 a = new Rob1();
        System.out.println(a.rob(a1));
        System.out.println(a.rob(a2));
    }
}
