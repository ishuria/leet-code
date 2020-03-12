package arland;

/**
 * @author xiangchaolei
 */
public class ReverseLinkedList {

    private static class ListNode{

        Integer data;

        ListNode next;

        ListNode(Integer data, ListNode next){
            this.data = data;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        // write your code here

        ListNode n4 = new ListNode(4,null);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        ListNode head = new ListNode(null,n1);

        head = reverseList(head);

        while(head.next!=null){
            System.out.println(head.next.data);
            head = head.next;
        }


    }

    public static ListNode reverseList(ListNode head){
        ListNode newHead = new ListNode(null,null);

        while(head.next!=null){
            ListNode t = head.next;
            head.next = t.next;
            t.next = newHead.next;
            newHead.next = t;
        }

        return newHead;
    }
}
