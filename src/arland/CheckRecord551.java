package arland;

/**
 * @author xiangchaolei
 */
public class CheckRecord551 {

    public boolean checkRecord(String s) {
        int n = s.length();
        int p=0,a=0;
        boolean l = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c=='P'){
                p++;
            }
            else if(c=='A'){
                a++;
            }
            else if(c=='L'){
                if(i>1&&s.charAt(i-1)=='L'&&s.charAt(i-2)=='L'){
                    l=true;
                }
            }
        }
        return a<=1&&!l;
    }

    public static void main(String[] args) {
        CheckRecord551 a = new CheckRecord551();
        System.out.println(a.checkRecord("PPALLP"));
        System.out.println(a.checkRecord("PPALLL"));
        System.out.println(a.checkRecord("LALL"));
    }
}
