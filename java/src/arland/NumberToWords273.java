package arland;

/**
 * @author xiangchaolei
 */
public class NumberToWords273 {

    private String[] eng1 = new String[]{"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    private String[] eng = new String[]{"","", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    private String[] unit = new String[]{"","Thousand", "Million","Billion"};

    public String numberToWords(int num) {
        if(0==num){
            return "Zero";
        }

        String num_s = String.valueOf(num);

        if(num_s.length()<3){
            return innerNumberToWords(num_s).trim();
        }


        int n = num_s.length();
        int i = 1;

        int l = 0;

        int m = 0;

        String r = "";
        for (; i < n; i++) {
            if((i+1)%3==0){
                if("".equals(innerNumberToWords(num_s.substring(n-i-1, n-i+2)).trim())){
                    r =   r;
                    m++;
                    l = n-i-1;
                }
                else {
                    r = innerNumberToWords(num_s.substring(n-i-1, n-i+2)).trim() + " "+ unit[m++]+" " + r;
                    l = n-i-1;
                }
            }
        }
        if(l>0){
            if("".equals(innerNumberToWords(num_s.substring(0, l)).trim())){
                r = r;
                m++;
            }
            else {
                r = innerNumberToWords(num_s.substring(0, l)).trim()+ " "+unit[m++]+" " + r;
            }
        }
        return r.trim();
    }

    public String innerNumberToWords(String a){

        if(Integer.valueOf(a)==0){
            return "";
        }

        int n = a.length();
        if(n==1){
            return eng1[Integer.valueOf(a)];
        }
        else if(n==2){
            int b = Integer.valueOf(a);
            if(b<=19){
                return eng1[Integer.valueOf(a)];
            }
            else{
                return eng[a.charAt(0) - '0'] + " "+ eng1[a.charAt(1) - '0'];
            }
        }
        else{
            int b = a.charAt(0) - '0';
            int c = Integer.valueOf(a.substring(1));
            if(c<=19){
                if("".equals(eng1[b])){
                    return eng1[Integer.valueOf(a.substring(1))];
                }
                return eng1[b] + " Hundred " + eng1[Integer.valueOf(a.substring(1))];
            }
            else{
                if("".equals(eng1[b])){
                    return  eng[a.substring(1).charAt(0) - '0'] +" "+ eng1[a.substring(1).charAt(1) - '0'];
                }
                return eng1[b] + " Hundred " + eng[a.substring(1).charAt(0) - '0'] +" "+ eng1[a.substring(1).charAt(1) - '0'];
            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        NumberToWords273 a = new NumberToWords273();


        System.out.println(a.numberToWords(1001));
        System.out.println(a.numberToWords(1000000));
        System.out.println(a.numberToWords(1));
        System.out.println(a.numberToWords(12));
        System.out.println(a.numberToWords(21));
        System.out.println(a.numberToWords(20));
        System.out.println(a.numberToWords(1000));

        System.out.println(a.numberToWords(123));//"One Hundred Twenty Three"
        System.out.println(a.numberToWords(12345));//"Twelve Thousand Three Hundred Forty Five"
        System.out.println(a.numberToWords(1234567));//"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        System.out.println(a.numberToWords(1234567891));//"One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
    }

}
