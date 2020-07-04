package arland;

/**
 * @author xiangchaolei
 */
public class NumSteps1404 {

    /**
     * 如果当前数字为偶数，则将其除以 2 。
     如果当前数字为奇数，则将其加上 1 。
     * @param s
     * @return
     */
    public int numSteps(String s) {
        char[] c = new char[s.length()];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            c[i] = s.charAt(n-i-1);
        }
        int index = 0;
        int count = 0;
        while(index!=s.length()-1){
            if(c[index]=='0'){
                index++;
            }
            else{
                add(c, index);
            }
            count++;
        }
        return count;
    }

    private void add(char[] c, int i){
        boolean s = true;
        c[i] = '0';
        for (int j = i+1; j < c.length; j++) {
            if(s){
                if(c[j]=='1'){
                    c[j]='0';
                }
                else{
                    c[j]='1';
                    s = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        NumSteps1404 a = new NumSteps1404();
        System.out.println(a.numSteps("1101"));
        System.out.println(a.numSteps("10"));
        System.out.println(a.numSteps("1"));
    }
}
