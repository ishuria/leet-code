package arland;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * @author xiangchaolei
 */
public class FlipLights {


    /**
     * 现有一个房间，墙上挂有 n 只已经打开的灯泡和 4 个按钮。在进行了 m 次未知操作后，你需要返回这 n 只灯泡可能有多少种不同的状态。

     假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下：

     将所有灯泡的状态反转（即开变为关，关变为开）
     将编号为偶数的灯泡的状态反转
     将编号为奇数的灯泡的状态反转
     将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
     示例 1:

     输入: n = 1, m = 1.
     输出: 2
     说明: 状态为: [开], [关]
     示例 2:

     输入: n = 2, m = 1.
     输出: 3
     说明: 状态为: [开, 关], [关, 开], [关, 关]
     示例 3:

     输入: n = 3, m = 1.
     输出: 4
     说明: 状态为: [关, 开, 关], [开, 关, 开], [关, 关, 关], [关, 开, 开].
     注意： n 和 m 都属于 [0, 1000].

     */


    Set<String> pattern = new HashSet<>();

    public int flipLights(int n, int m) {
        pattern = new HashSet<>();
        char[] c = new char[n];
        for (int i = 0; i < n; i++) {
            c[i] = '1';
        }
        flipLishts(n, m, c);
        return pattern.size();
    }

    public void flipLishts(int n, int m, char[] c){
        if(m<=0){
            if(!pattern.contains(new String(c))){
                pattern.add(new String(c));
            }
            return;
        }
        for (int i = 1; i <= 4; i++) {
            switch (i){
                case 1:
                    action1(c, n);
                    flipLishts(n, m-1, c);
                    action1(c, n);
                    break;
                case 2:
                    action2(c, n);
                    flipLishts(n, m-1, c);
                    action2(c, n);
                    break;
                case 3:
                    action3(c, n);
                    flipLishts(n, m-1, c);
                    action3(c, n);
                    break;
                case 4:
                    action4(c, n);
                    flipLishts(n, m-1, c);
                    action4(c, n);
                    break;
            }
        }
    }

    private void action1(char[] c,int n){
        for (int i = 1; i <= n; i++) {
            if(c[i-1]=='0'){
                c[i-1]='1';
            }
            else{
                c[i-1]='0';
            }
        }
    }

    private void action2(char[] c, int n){
        for (int i = 1; i <= n ; i++) {
            if(i%2==0){
                if(c[i-1]=='0'){
                    c[i-1]='1';
                }
                else{
                    c[i-1]='0';
                }
            }
        }
    }

    private void action3(char[] c, int n){
        for (int i = 1; i <= n; i++) {
            if(i%2!=0){
                if(c[i-1]=='0'){
                    c[i-1]='1';
                }
                else{
                    c[i-1]='0';
                }
            }
        }
    }

    private void action4(char[] c, int n){
        for (int i = 1; i <= n; i++) {
            if((i-1)%3==0){
                if(c[i-1]=='0'){
                    c[i-1]='1';
                }
                else{
                    c[i-1]='0';
                }
            }
        }
    }

    public static void main(String[] args) {
        // write your code here

        FlipLights a = new FlipLights();
        System.out.println(a.flipLights(1,1));
        System.out.println(a.flipLights(2,1));
        System.out.println(a.flipLights(3,1));
    }
}
