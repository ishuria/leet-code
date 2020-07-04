package arland;

/**
 * @author xiangchaolei
 */
public class CheckInclusion567 {

    private int search(String t, String s){
        int j = -1;
        int i = 0;
        int[] next = new int[t.length()];
        getNext(t, next);
        while(j<t.length()&&i<s.length()){
            if(j==-1||t.charAt(j)==s.charAt(i)){
                i++;
                j++;
            }
            else{
                j=next[j];
            }
        }
        if(j>=t.length()){
            return i-j;
        }
        return -1;
    }

    private void getNext(String t, int[] next){
        next[0] = -1;
        int i = 0, j = -1;
        int n = t.length();
        while(i<n-1){
            if(j==-1||t.charAt(i)==t.charAt(j)){
                i++;
                j++;
                if(t.charAt(i)!=t.charAt(j)){
                    next[i] = j;
                }
                else{
                    next[i] = next[j];
                }
            }
            else{
                j = next[j];
            }
        }
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Counter = new int[26];
        int[] s2Counter = new int[26];
        int n1 = s1.length();
        int n2 = s2.length();
        for (int i = 0; i < n1; i++) {
            s1Counter[s1.charAt(i)-'a']++;
        }
        //initial s2 window
        for (int i = 0; i < n1; i++) {
            s2Counter[s2.charAt(i)-'a']++;
        }
        if(checkWindows(s1Counter, s2Counter)){
            return true;
        }

        for (int i = n1; i < n2; i++) {
            //remove old char at i-n1
            s2Counter[s2.charAt(i-n1)-'a']--;
            //add new char at i
            s2Counter[s2.charAt(i)-'a']++;
            if(checkWindows(s1Counter, s2Counter)){
                return true;
            }
        }
        return false;
    }

    public boolean checkWindows(int[] s1Counter, int[] s2Counter){
        for (int i = 0; i < s1Counter.length; i++) {
            if(s1Counter[i]!=s2Counter[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // write your code here
        CheckInclusion567 a = new CheckInclusion567();
        System.out.println(a.checkInclusion("ABCDABD".toLowerCase(), "BBCABCDABABCDABCDABDE".toLowerCase()));
        System.out.println(a.checkInclusion("a".toLowerCase(), "ab".toLowerCase()));
    }
}
