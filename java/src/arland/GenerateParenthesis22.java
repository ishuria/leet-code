package arland;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiangchaolei
 */
public class GenerateParenthesis22 {

    public List<String> generateParenthesis(int n) {
        List<String> l = new LinkedList<>();
        inner(new char[n*2], 0, l);
        return new ArrayList<>(new HashSet<String>(l));
    }

    private void inner(char[] c, int pos, List<String> l){
        if(pos==c.length){
            if(isValid(new String(c))){
                l.add(new String(c));
            }
            return;
        }
        c[pos] = '(';
        inner(c, pos+1, l);
        c[pos] = ')';
        inner(c, pos+1,l);
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else {
                //not empty
                if(s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                }
                else {
                    if(stack.peek()!='('){
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private void print(List<String> r){
        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i));
        }
    }

    public static void main(String[] args) {
        // write your code here
        GenerateParenthesis22 a = new GenerateParenthesis22();
        a.print(a.generateParenthesis(4));
//        System.out.println(a.isValid("(()(()))"));
//        System.out.println(a.isValid(")(()(())"));
        //["()()()()","(()())()","(()(()))","()()(())","(())()()","(((())))","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"]
        //["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
    }
}
