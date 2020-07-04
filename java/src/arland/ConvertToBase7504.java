package arland;

/**
 * @author xiangchaolei
 */
public class ConvertToBase7504 {

    public String convertToBase7(int num) {
        StringBuilder s = new StringBuilder();
        while(Math.abs(num)>=7){
            int mod = num % 7;
            s.insert(0, Math.abs(mod));
            num = num / 7;
        }
        s.insert(0, num);
        return s.toString();
    }

    public static void main(String[] args) {
        // write your code here
        ConvertToBase7504 a = new ConvertToBase7504();
        System.out.println(a.convertToBase7(100));
        System.out.println(a.convertToBase7(-7));
        System.out.println(a.convertToBase7(-8));
    }
}
