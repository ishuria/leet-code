package arland;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiangchaolei
 */
public class LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(0==n){
            return 0;
        }
        if(1==n){
            return 1;
        }
        int[] d = new int[n];
        d[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int index = s.substring(i-d[i-1], i).indexOf(s.charAt(i));
            if(index>=0){
                d[i] = d[i-1] - index;
            }
            else{
                d[i] = d[i-1]+1;
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        char[] c = s.toCharArray();
        int i=0,j=0;
        int max = 0;
        Set<Character> cs = new HashSet<>();
        cs.add(c[0]);
        while(j<c.length-1){
            while(j<c.length-1&&!cs.contains(c[j+1])){
                j++;
                cs.add(c[j]);
            }
            max = Math.max(max, j-i+1);
            if(j>=c.length-1){
                return max;
            }
            cs.remove(c[i++]);
        }
        return max;
    }

    public static void main(String[] args) {
        // write your code here
        LengthOfLongestSubstring3 a = new LengthOfLongestSubstring3();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(a.lengthOfLongestSubstring("bbbbb"));
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
        System.out.println(a.lengthOfLongestSubstring("dvdf"));

        System.out.println();

        System.out.println(a.lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(a.lengthOfLongestSubstring1("bbbbb"));
        System.out.println(a.lengthOfLongestSubstring1("pwwkew"));
        System.out.println(a.lengthOfLongestSubstring1("dvdf"));
    }
}
