package arland;

/**
 * @author xiangchaolei
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        return integerReplacement((long)n,0);
    }

    public int integerReplacement(long n, int c) {
        if(1==n){
            return c;
        }
        if(n%2==0){
            return integerReplacement(n/2, c+1);
        }
        else{
            return Math.min(integerReplacement(n+1, c+1), integerReplacement(n-1, c+1));
        }
    }


    public static void main(String[] args) {
        // write your code here

        IntegerReplacement a = new IntegerReplacement();
        System.out.println(a.integerReplacement(7));
        System.out.println(a.integerReplacement(1));
        System.out.println(a.integerReplacement(8));
        System.out.println(a.integerReplacement(Integer.MAX_VALUE));
    }

}
