package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {

        int n1 = num1.length();
        int n2 = num2.length();

        int n = Math.min(n1,n2);

        char[] r = new char[Math.max(n1,n2)+1];
        r[0] = 'a';

        boolean set = false;
        for (int i = 0; i <n ; i++) {
            char a1 = num1.charAt(n1-i-1);
            char a2 = num2.charAt(n2-i-1);
            int i1 = a1 - '0';
            int i2 = a2 - '0';
            int sum = i1 + i2;
            if(set){
                sum++;
            }
            if(sum>=10){
                set = true;
            }
            else{
                set=false;
            }
            r[r.length-i-1] = (char)((int)'0'+(sum%10));
        }

        if(n1>n){
            for (int i = 0; i < n1-n; i++) {


                char c = num1.charAt(n1-n-i-1);
                if(set){
                    c++;
                }
                if(c>'9'){
                    c='0';
                    set = true;
                }
                else{
                    set=false;
                }

                r[r.length-i-n-1] = c;
            }
        }
        else{
            for (int i = 0; i < n2-n; i++) {
                char c = num2.charAt(n2-n-i-1);
                if(set){
                    c++;
                }
                if(c>'9'){
                    c='0';
                    set = true;
                }
                else{
                    set=false;
                }

                r[r.length-i-n-1] = c;
            }
        }

        if(set){
            r[0] = '1';
        }

        if(r[0]=='a'){
            return new String(Arrays.copyOfRange(r, 1, r.length));
        }
        else{
            return new String(r);
        }
    }


    public static void main(String[] args) {
        // write your code here

        String a11 ="999999";
        String a12 ="125447463243525";
        AddStrings a = new AddStrings();
        System.out.println(a.addStrings(a11,a12));

        System.out.println(999999L+125447463243525L);

        System.out.println(a.addStrings("0","0"));

        System.out.println(a.addStrings("1","9"));
    }


}
