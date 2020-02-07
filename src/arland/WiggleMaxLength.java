package arland;

/**
 * @author xiangchaolei
 */
public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {


        int n = nums.length;
        if(2>n){
            return n;
        }
        if(2==n){
            return nums[0]==nums[1]?1:2;
        }

        int[] up = new int[n];
        int[] down = new int[n];

        //true代表最后一个值是大于之前的
        //false代表最后一个值是小于之前的
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    up[i] = Math.max(down[j]+1,up[j]);
                }
                else if(nums[i]<nums[j]){
                    down[i] = Math.max(up[j]+1,down[j]);
                }
            }
        }
        return Math.max(up[n-1],down[n-1])+1;
    }

    public static void main(String[] args) {

        int[] a1 = {1,7,4,9,2,5};
        int[] a2 = {1,17,5,10,13,15,10,5,16,8};
        int[] a3 = {1,2,3,4,5,6,7,8,9};
        int[] a4 = {0,0};
        int[] a5 = {0,0,0};
        // write your code here
        WiggleMaxLength a = new WiggleMaxLength();
        System.out.println(a.wiggleMaxLength(a1));
        System.out.println(a.wiggleMaxLength(a2));
        System.out.println(a.wiggleMaxLength(a3));
        System.out.println(a.wiggleMaxLength(a4));
        System.out.println(a.wiggleMaxLength(a5));
    }
}
