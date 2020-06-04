package arland;

/**
 * @author xiangchaolei
 */
public class CharacterReplacement424 {

    public int characterReplacement(String s, int k) {
        if(s.length()==0){
            return 0;
        }

        if(s.length()==1){
            return 1;
        }

        int[] c = new int[26];

        int start = 0;
        int end = 0;

        c[s.charAt(0)-'A']++;
        int maxChar = 1;

        while(end < s.length()){
            if(end-start+1>maxChar+k){
                //move
                c[s.charAt(start)-'A']--;
                start++;
            }
            end++;
            if(end>=s.length()){
                return end-start;
            }
            c[s.charAt(end)-'A']++;
            maxChar = Math.max(maxChar, c[s.charAt(end)-'A']);
        }
        return end-start;
    }

    public static void main(String[] args) {
        // write your code here
        CharacterReplacement424 a =new CharacterReplacement424();
        //s = "ABAB", k = 2
        System.out.println(a.characterReplacement("ABAB", 2));
        System.out.println(a.characterReplacement("AABABBA", 1));
        System.out.println(a.characterReplacement("AAAA", 0));
        System.out.println(a.characterReplacement("ABAA", 0));
    }
}
