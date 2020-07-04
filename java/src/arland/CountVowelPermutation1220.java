package arland;

/**
 * @author xiangchaolei
 */
public class CountVowelPermutation1220 {

    /*
    字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
    每个元音 'a' 后面都只能跟着 'e'
    每个元音 'e' 后面只能跟着 'a' 或者是 'i'
    每个元音 'i' 后面 不能 再跟着另一个 'i'
    每个元音 'o' 后面只能跟着 'i' 或者是 'u'
    每个元音 'u' 后面只能跟着 'a'
     */

    char[] c = new char[]{'a', 'e', 'i', 'o', 'u'};
    private long mod = 1000000007;

    public int countVowelPermutation(int n) {
        long a=1,e=1,i=1,o=1,u=1;
        for (int j = 1; j < n; j++) {
            long aa=a,ee=e,ii=i,oo=o,uu=u;
            a = uu+ee+ii;
            e = aa+ii;
            i = ee+oo;
            o = ii;
            u = oo+ii;
            a%=mod;
            e%=mod;
            i%=mod;
            o%=mod;
            u%=mod;
        }
        return (int)((a+e+i+o+u)%mod);
    }

//    public int countVowelPermutation(int n) {
//        char[] vowels = new char[n];
//        return inner(n, 0, vowels);
//    }

    public int inner(int n, int pos, char[] vowels){
        long count = 0;
        if(pos==n){
            return 1;
        }
        if(pos==0){
            for (int i = 0; i < c.length; i++) {
                vowels[pos] = c[i];
                count += inner(n, pos+1, vowels);
            }
        }
        else{
            char prev= vowels[pos-1];
            if(prev=='a'){
                vowels[pos] = 'e';
                count += inner(n, pos+1, vowels);
            }
            if(prev=='e'){
                vowels[pos] = 'a';
                count += inner(n, pos+1, vowels);
                vowels[pos] = 'i';
                count += inner(n, pos+1, vowels);
            }
            if(prev=='i'){
                vowels[pos] = 'a';
                count += inner(n, pos+1, vowels);
                vowels[pos] = 'e';
                count += inner(n, pos+1, vowels);
                vowels[pos] = 'o';
                count += inner(n, pos+1, vowels);
                vowels[pos] = 'u';
                count += inner(n, pos+1, vowels);
            }
            if(prev=='o'){
                vowels[pos] = 'i';
                count += inner(n, pos+1, vowels);
                vowels[pos] = 'u';
                count += inner(n, pos+1, vowels);
            }
            if(prev=='u'){
                vowels[pos] = 'a';
                count += inner(n, pos+1, vowels);
            }
        }
        return (int)(count%mod);
    }


    public static void main(String[] args) {
        // write your code here
        CountVowelPermutation1220 a = new CountVowelPermutation1220();
        System.out.println(a.countVowelPermutation(1));//5
        System.out.println(a.countVowelPermutation(2));//10
        System.out.println(a.countVowelPermutation(5));//68
        System.out.println(a.countVowelPermutation(144));//68
    }
}
