package arland;

/**
 * @author xiangchaolei
 */
public class SwapPairs24 {

      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummy = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        boolean firstChange = false;
        ListNode first = head;
        ListNode second = head.next;
        while(second!=null){
            first.next = second.next;
            second.next=first;
            first=second;
            second=first.next;

            pre.next=first;


            if(!firstChange){
                dummy=first;
                firstChange = true;
            }

            print(dummy);

            first=first.next;
            second=second.next;
            pre=pre.next;
            if(second==null){
                return dummy;
            }
            first=first.next;
            second=second.next;
            pre=pre.next;
        }
        return dummy;
    }

    private void print(ListNode head){
          while(head!=null){
              System.out.println(head.val);
              head=head.next;
          }
        System.out.println();
    }

    public static void main(String[] args) {
        // write your code here
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        SwapPairs24 a = new SwapPairs24();
        a.print(a.swapPairs(n1));
    }
}
