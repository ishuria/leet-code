package arland;

import java.util.Stack;

/**
 * @author xiangchaolei
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int pushIndex = 0;

        for (int i = 0; i < n; i++) {
            int t = popped[i];
            if(!stack.isEmpty()&&stack.peek()==t){
                stack.pop();
                continue;
            }
            while(pushIndex<n&&pushed[pushIndex]!=t){
                stack.push(pushed[pushIndex++]);
            }
            if(pushIndex>=n){
                return false;
            }
            else{
                pushIndex++;
//                stack.pop();
            }
        }
        return pushIndex == n;
    }

    public static void main(String[] args) {
        // write your code here
        ValidateStackSequences a = new ValidateStackSequences();
        System.out.println(a.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(a.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
