package arland;

/**
 * @author xiangchaolei
 */
public class FindDuplicate287 {

    public int findDuplicate(int[] nums) {
        int[] total = new int[32];
        int[] total1 = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                int tt = 1<<j;
                if((nums[i]&tt)==tt){
                    total[j]++;
                }
            }
        }

        for (int i = 1; i <= nums.length-1; i++) {
            for (int j = 0; j < 32; j++) {
                int tt = 1<<j;
                if((i&tt)==tt){
                    total1[j]++;
                }
            }
        }

        int r = 0;
        for (int i = 0; i < 32; i++) {
            if(total[i]>total1[i]){
                r += 1<<i;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        // write your code here
        FindDuplicate287 a = new FindDuplicate287();
        System.out.println(a.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(a.findDuplicate(new int[]{3,1,3,4,2}));
    }
}
