package arland;

/**
 * @author xiangchaolei
 */
public class RotateRight61 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }

        ListNode t = head;

        int c = 0;
        while(t!=null){
            c++;
            t=t.next;
        }
        ListNode[] d = new ListNode[c];

        t = head;

        c = 0;
        while(t!=null){
            d[c]=t;
            c++;
            t=t.next;
        }

        d[d.length-1].next=d[0];

        int left = d.length-k;

        left %= d.length;

        d[(left-1+d.length)%d.length].next=null;

        return d[(left+d.length)%d.length];

    }

    private void print(ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        // write your code here
        RotateRight61 a = new RotateRight61();

        //输入: 1->2->3->4->5->NULL, k = 2
        //输出: 4->5->1->2->3->NULL

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        a.print(a.rotateRight(l1, 2));


        System.out.println();

        //[0,1,2]
        //4
        ListNode l21 = new ListNode(0);
        ListNode l22 = new ListNode(1);
        ListNode l23 = new ListNode(2);

        l21.next=l22;
        l22.next=l23;
        a.print(a.rotateRight(l21, 4));
    }
}
