package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class Fraction {
    public int[] fraction(int[] cont) {
        int l = cont.length;
        int[] a = {1,cont[l-1]};

        for (int i = l-2; i >= 0 ; i--) {
            a = next(a, cont[i]);
        }
        return new int[]{a[1],a[0]};
    }

    public int[] next(int[] a, int next){
        return new int[]{a[1], a[1]*next+a[0]};
    }


    public static void main(String[] args) {
        // write your code here
        int[] a1 = {3, 2, 0, 2};


        Fraction a = new Fraction();
        System.out.println(Arrays.toString(a.fraction(a1)));
    }
}
