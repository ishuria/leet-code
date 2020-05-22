package arland;

import java.util.Stack;

/**
 * @author xiangchaolei
 */
public class ScoreOfParentheses856 {

    public int scoreOfParentheses(String S) {

        Stack<String> s = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c=='('){
                s.push(new String(new char[]{c}));
            }
            else if(c==')'){
                String cc = s.pop();
                int count = 0;
                while(!cc.equals("(")){
                    count += Integer.valueOf(cc);
                    cc = s.pop();
                }
                if(count==0){
                    s.push("1");
                }
                else {
                    s.push(String.valueOf(2*count));
                }
            }
            else{
                System.out.println(111);
            }
        }
        int count1 = 0;
        while(!s.isEmpty()){
            count1 += Integer.valueOf(s.pop());
        }
        return count1;
    }

    public static void main(String[] args) {
        // write your code here
        ScoreOfParentheses856 a = new ScoreOfParentheses856();
        System.out.println(a.scoreOfParentheses("(()(()))"));
        System.out.println(a.scoreOfParentheses("()()"));
        System.out.println(a.scoreOfParentheses("(())"));
        System.out.println(a.scoreOfParentheses("()"));
        System.out.println(a.scoreOfParentheses(""));
    }
}
