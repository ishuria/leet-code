package arland;

/**
 * @author
 */
public class NearestSym {


    public void nearestSym(int input){
        if(input<=0){
            System.out.println("ERROR");
            return;
        }
        if(isSym(input)){
            System.out.println(input);
            return;
        }
        int delta = 1;
        while(true){

            int plus = input + delta;
            boolean plusSym = isSym(plus);
            int minus = input - delta;
            boolean minusSym = isSym(minus);
            if(plusSym&&minusSym){
                System.out.println(minus+","+plus);
                return;
            }
            else if(plusSym){
                System.out.println(plus);
                return;
            }
            else if(minusSym){
                System.out.println(minus);
                return;
            }
            delta++;
        }
    }

    public boolean isSym(int input){
        String a = String.valueOf(input);
        int n = a.length();
        for (int i = 0; i < n/2; i++) {
            if(a.charAt(i)!=a.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // write your code here

        NearestSym a = new NearestSym();
        a.nearestSym(103);
        a.nearestSym(106);
        a.nearestSym(1011);
        a.nearestSym(1010);
    }
}
