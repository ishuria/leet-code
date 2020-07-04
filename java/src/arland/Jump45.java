package arland;

/**
 * @author xiangchaolei
 */
public class Jump45 {


    public int jump(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 0;
        }
        int n = nums.length;
        int step = 1;
        for (int i = 0; i < nums.length-1; i++) {
            //i ~ nums[i] + i
            if(i+nums[i]>=n-1){
                return step;
            }
            int maxPos = i;
            int max = i+nums[i];
            for (int j = i+1; j <= nums[i]+i ; j++) {
                if(j+nums[j]>=n-1){
                    return ++step;
                }
                if(j+nums[j]>max){
                    max = j+nums[j];
                    maxPos = j;
                }
            }
            i = maxPos;
            i--;
            step++;
        }
        return step;
    }



    public static void main(String[] args) {
        // write your code here
        Jump45 a = new Jump45();
        System.out.println(a.jump(new int[]{2,3,1,1,4}));
        System.out.println(a.jump(new int[]{2,1,1,1,4}));
        System.out.println(a.jump(new int[]{0}));
        System.out.println(a.jump(new int[]{1,1}));
        System.out.println(a.jump(new int[]{1,1,1,1}));
    }
}
