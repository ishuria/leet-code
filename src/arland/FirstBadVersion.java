package arland;

/**
 * @author xiangchaolei
 */
public class FirstBadVersion {


    public int firstBadVersion(int n) {
        long low= 1;
        long high = n;
        while(low<=high){
            long mid = (low+high)/2;
            if(isBadVersion((int) mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (int) low;
    }

    private boolean isBadVersion(int n){
        if(n>=1702766719){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        // write your code here
        FirstBadVersion a = new FirstBadVersion();
        System.out.println(a.firstBadVersion(2126753390));
    }
}
