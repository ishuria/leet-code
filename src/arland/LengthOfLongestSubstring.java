package arland;

/**
 * @author xiangchaolei
 */
public class LengthOfLongestSubstring {

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

    public static void main(String[] args) {
        // write your code here
        LengthOfLongestSubstring a = new LengthOfLongestSubstring();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(a.lengthOfLongestSubstring("bbbbb"));
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
        System.out.println(a.lengthOfLongestSubstring("dvdf"));
    }
}
