package arland;

/**
 * @author xiangchaolei
 */
public class RemoveDuplicates1209 {

    public String removeDuplicates(String s, int k) {

        boolean needDel = true;
        do {
            int n = s.length();
            char[] c = new char[n];
            int j = 0;
            needDel = false;
            for (int i = 0; i < n; i++) {
                if(isDup(s,i,k)){
                    i+=k;
                    if(i<n){
                        c[j]=s.charAt(i);
                    }
                    needDel = true;
                }
                else{
                    c[j] = s.charAt(i);
                }
                j++;
            }
            s = new String(c).trim();
        }while(needDel);
        return s;
    }

    private boolean isDup(String s, int i, int k){
        if(i+k>s.length()){
            return false;
        }
        char c = s.charAt(i);
        for (int i1 = i; i1 < i+k; i1++) {
            if(s.charAt(i1)!=c){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here

        RemoveDuplicates1209 a = new RemoveDuplicates1209();
        System.out.println(a.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(a.removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(a.removeDuplicates("abcd", 2));
        System.out.println(a.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
    }
}
