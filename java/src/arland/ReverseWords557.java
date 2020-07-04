package arland;

import java.util.Stack;

/**
 * @author xiangchaolei
 */
public class ReverseWords557 {

    public String reverseWords(String s) {

        Stack<Character> sc = new Stack<>();

        int n = s.length();

        StringBuilder b = new StringBuilder();

        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if(c.equals(' ')){
                while(!sc.isEmpty()){
                    b.append(sc.pop());
                }
                b.append(" ");
            }
            else{
                sc.push(c);
            }
        }
        while(!sc.isEmpty()){
            b.append(sc.pop());
        }
        return b.toString();
    }

    public static void main(String[] args) {
        // write your code here
        ReverseWords557 a = new ReverseWords557();
        System.out.println(a.reverseWords("Let's take LeetCode contest"));//"s'teL ekat edoCteeL tsetnoc"
    }
}
