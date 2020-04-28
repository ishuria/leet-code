package arland;

/**
 * @author xiangchaolei
 */
public class DecodeAtIndex880 {

    public static class Node{
        private Node next;
        private long count;
        private String appender;

        private Node prev;

        public long l(){
            return ((prev==null?0:prev.l())+appender.length())*count;
        }

        public String getK(int K){
            long seg = (prev==null?0:prev.l())+appender.length();
            long ind = K % seg;
            if(ind>=seg-appender.length()){
                return String.valueOf(appender.charAt((int) (((ind-seg+appender.length()-1) + seg) % seg)));
            }
            else{
                return prev.getK(K);
            }
        }
    }

    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        int i = 0;
        Node p = new Node();
        StringBuilder sb = new StringBuilder();
        while(i<n){
            if(S.charAt(i)>='2'&&S.charAt(i)<='9'){
                p.count = S.charAt(i) - '0';
                p.next = new Node();
                p.appender = sb.toString();
                sb = new StringBuilder();
                p.next.prev = p;
                p=p.next;
            }
            else{
                sb.append(S.charAt(i));
            }
            i++;
        }
        if(sb.length()>0){
            p.count = 0;
            p.next = new Node();
            p.appender = sb.toString();
            p.next.prev = p;
            p=p.next;
        }
        return p.prev.getK(K);
    }

    public static void main(String[] args) {
        // write your code here
        DecodeAtIndex880 a = new DecodeAtIndex880();
        //leetleetcodeleetleetcodeleetleetcode
//        System.out.println(a.decodeAtIndex("leet2code3", 10));//o
//        System.out.println(a.decodeAtIndex("ha22", 5));//h
//        System.out.println(a.decodeAtIndex("a2345678999999999999999", 1));//a
//        System.out.println(a.decodeAtIndex("abc", 1));//a
//        System.out.println(a.decodeAtIndex("abc", 3));//c
        System.out.println(a.decodeAtIndex("a2b3c4d5e6f7g8h9", 3));//b
    }

}
