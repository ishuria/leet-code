package arland;

/**
 * @author xiangchaolei
 */
public class MinSteps1347 {
    public int minSteps(String s, String t) {
        int[] ss = new int[26];
        int[] ts = new int[26];

        int sn = s.length();
        int tn = t.length();

        for (int i = 0; i < sn; i++) {
            ss[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < tn; i++) {
            ts[t.charAt(i)-'a']++;
        }

        int diff = 0;

        for (int i = 0; i < 26; i++) {
            diff += Math.abs(ss[i]-ts[i]);
        }

        return diff/2;
    }

    public static void main(String[] args) {
        // write your code here
        MinSteps1347 a = new MinSteps1347();
        System.out.println(a.minSteps("bab","aba"));
        System.out.println(a.minSteps("leetcode","practice"));
        System.out.println(a.minSteps("anagram","mangaar"));
        System.out.println(a.minSteps("xxyyzz","xxyyzz"));
        System.out.println(a.minSteps("friend","family"));
    }
}
