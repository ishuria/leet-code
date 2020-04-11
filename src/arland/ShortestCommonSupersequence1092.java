package arland;

/**
 * @author xiangchaolei
 */
public class ShortestCommonSupersequence1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if(n==0&&m==0){
            return "";
        }
        if(n==0){
            return str2;
        }
        if(m==0){
            return str1;
        }

        String[][] dp = new String[n+1][m+1];
        dp[0][0] = "";

        for (int i = 1; i <= n; i++) {
            dp[i][0] = str1.substring(0, i);
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i] = str2.substring(0, i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+str1.charAt(i-1);
                }
                else{
                    String subI = dp[i][j-1];
                    String subJ = dp[i-1][j];

                    boolean isSubI = isSubStr(subI, str2, j);
                    boolean isSubJ = isSubStr(subJ, str1, i);

                    String strI = subI;
                    String strJ = subJ;

                    if(!isSubI){
                        strI += str2.charAt(j-1);
                    }

                    if(!isSubJ){
                        strJ += str1.charAt(i-1);
                    }

                    if(strI.length()>=strJ.length()){
                        dp[i][j] = strJ;
                    }
                    else{
                        dp[i][j] = strI;
                    }
                }
            }
        }
        return dp[n][m];
    }

    private boolean isSubStr(String main, String str, int index){
        if((index)>main.length()){
            return false;
        }
        if(index==main.length()&&!main.contains(str.substring(0, index))){
            return false;
        }
        int n = main.length();

        int subCount = 0;
        int mainIndex = 0;

        while(mainIndex<n){
            if(main.charAt(mainIndex)==str.charAt(subCount)){
                subCount++;
                if(subCount==index){
                    return true;
                }
            }
            mainIndex++;
        }
        return subCount==index;
    }


    public static void main(String[] args) {
        // write your code here
        ShortestCommonSupersequence1092 a = new ShortestCommonSupersequence1092();


//        String str11 = "abac", str12 = "cab";
//        System.out.println(a.shortestCommonSupersequence(str11, str12));
//
//        String str21 = "bbbaaaba" , str22 = "bbababbb";
//        System.out.println(a.shortestCommonSupersequence(str21, str22));//bbababbaaba
//
//        String str31 = "bbabacaa" , str32 = "cccababab";
//        System.out.println(a.shortestCommonSupersequence(str31, str32));//输出："cccabababcaa"预期："bbcccababcaab"
//
//        String str41 = "aaaaaaaa" , str42 = "aaaaaaaa";
//        System.out.println(a.shortestCommonSupersequence(str41, str42));



        String str51 = "atdznrqfwlfbcqkezrltzyeqvqemikzgghxkzenhtapwrmrovwtpzzsyiwongllqmvptwammerobtgmkpowndejvbuwbporfyroknrjoekdgqqlgzxiisweeegxajqlradgcciavbpgqjzwtdetmtallzyukdztoxysggrqkliixnagwzmassthjecvfzmyonglocmvjnxkcwqqvgrzpsswnigjthtkuawirecfuzrbifgwolpnhcapzxwmfhvpfmqapdxgmddsdlhteugqoyepbztspgojbrmpjmwmhnldunskpvwprzrudbmtwdvgyghgprqcdgqjjbyfsujnnssfqvjhnvcotynidziswpzhkdszbblustoxwtlhkowpatbypvkmajumsxqqunlxxvfezayrolwezfzfyzmmneepwshpemynwzyunsxgjflnqmfghsvwpknqhclhrlmnrljwabwpxomwhuhffpfinhnairblcayygghzqmotwrywqayvvgohmujneqlzurxcpnwdipldofyvfdurbsoxdurlofkqnrjomszjimrxbqzyazakkizojwkuzcacnbdifesoiesmkbyffcxhqgqyhwyubtsrqarqagogrnaxuzyggknksrfdrmnoxrctntngdxxechxrsbyhtlbmzgmcqopyixdomhnmvnsafphpkdgndcscbwyhueytaeodlhlzczmpqqmnilliydwtxtpedbncvsqauopbvygqdtcwehffagxmyoalogetacehnbfxlqhklvxfzmrjqofaesvuzfczeuqegwpcmahhpzodsmpvrvkzxxtsdsxwixiraphjlqawxinlwfspdlscdswtgjpoiixbvmpzilxrnpdvigpccnngxmlzoentslzyjjpkxemyiemoluhqifyonbnizcjrlmuylezdkkztcphlmwhnkdguhelqzjgvjtrzofmtpuhifoqnokonhqtzxmimp";
        String str52 = "xjtuwbmvsdeogmnzorndhmjoqnqjnhmfueifqwleggctttilmfokpgotfykyzdhfafiervrsyuiseumzmymtvsdsowmovagekhevyqhifwevpepgmyhnagjtsciaecswebcuvxoavfgejqrxuvnhvkmolclecqsnsrjmxyokbkesaugbydfsupuqanetgunlqmundxvduqmzidatemaqmzzzfjpgmhyoktbdgpgbmjkhmfjtsxjqbfspedhzrxavhngtnuykpapwluameeqlutkyzyeffmqdsjyklmrxtioawcrvmsthbebdqqrpphncthosljfaeidboyekxezqtzlizqcvvxehrcskstshupglzgmbretpyehtavxegmbtznhpbczdjlzibnouxlxkeiedzoohoxhnhzqqaxdwetyudhyqvdhrggrszqeqkqqnunxqyyagyoptfkolieayokryidtctemtesuhbzczzvhlbbhnufjjocporuzuevofbuevuxhgexmckifntngaohfwqdakyobcooubdvypxjjxeugzdmapyamuwqtnqspsznyszhwqdqjxsmhdlkwkvlkdbjngvdmhvbllqqlcemkqxxdlldcfthjdqkyjrrjqqqpnmmelrwhtyugieuppqqtwychtpjmloxsckhzyitomjzypisxzztdwxhddvtvpleqdwamfnhhkszsfgfcdvakyqmmusdvihobdktesudmgmuaoovskvcapucntotdqxkrovzrtrrfvoczkfexwxujizcfiqflpbuuoyfuoovypstrtrxjuuecpjimbutnvqtiqvesaxrvzyxcwslttrgknbdcvvtkfqfzwudspeposxrfkkeqmdvlpazzjnywxjyaquirqpinaennweuobqvxnomuejansapnsrqivcateqngychblywxtdwntancarldwnloqyywrxrganyehkglbdeyshpodpmdchbcc";
        System.out.println(a.shortestCommonSupersequence(str51, str52));
//        System.out.println(a.isSubStr("dcdadd", "cab"));
    }

}
