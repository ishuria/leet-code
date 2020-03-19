package arland;

/**
 * @author xiangchaolei
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int origin = x;
        int reverse = 0;


        long i = 1;
        while(origin!=0){
            origin /= 10;
            i *= 10;
        }
        origin = x;
        i/=10;
        while(origin!=0){
            reverse += (origin % 10) * i;
            origin /= 10;
            i /= 10;
        }
        System.out.println(reverse);
        return reverse == x;
    }


    public static void main(String[] args) {
        // write your code here
        IsPalindrome a = new IsPalindrome();
//        System.out.println(a.isPalindrome(121));
//        System.out.println(a.isPalindrome(10));
        System.out.println(a.isPalindrome(1000000001));
    }

}
