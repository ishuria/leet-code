package arland;

import java.util.Stack;

/**
 * @author xiangchaolei
 */
public class Find132pattern456 {

    public boolean find132pattern(int[] nums) {

        int[] min = new int[nums.length];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!stack.isEmpty() && stack.peek() <= min[i])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here
        Find132pattern456 a = new Find132pattern456();
        System.out.println(a.find132pattern(new int[]{1,2,3,4}));
        System.out.println(a.find132pattern(new int[]{3,1,4,2}));
        System.out.println(a.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(a.find132pattern(new int[]{-2,1,-1}));
    }
}
