package arland;

/**
 * @author xiangchaolei
 */
public class CanJump55 {

    public boolean canJump(int[] nums) {
        Boolean[] d = new Boolean[nums.length];
        return inner(nums, nums.length-1, d);
    }

    private boolean inner(int[] nums, int pos, Boolean[] d){
        if(pos<=0){
            return true;
        }
        for (int i = 0; i < pos; i++) {
            boolean b = false;
            if(d[i]!=null){
                b = d[i];
            }
            else{
                b = inner(nums, i, d);
                d[i] = b;
            }
            if(nums[i]>=pos-i&&b){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here
        CanJump55 a = new CanJump55();
        System.out.println(a.canJump(new int[]{2,3,1,1,4}));
        System.out.println(a.canJump(new int[]{3,2,1,0,4}));
        System.out.println(a.canJump(new int[]{2,0}));
        System.out.println(a.canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
    }
}
