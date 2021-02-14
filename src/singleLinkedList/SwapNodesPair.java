package singleLinkedList;

public class SwapNodesPair {

    public static final int swapCount=2;

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        ListNode.printList(head);
       ListNode.printList(swapPairs(head));
    }
    public static ListNode swapPairs(ListNode head) {

        ListNode newHead=null,present=null,preTail=null;

        present=head;
        while(present!=null && present.next!=null){
            ListNode temp=present.next.next;
            ListNode loophead=present.next;
            loophead.next=present;
            if(preTail!=null){
                preTail.next=loophead;
            }
            preTail=present;
            present=temp;
            preTail.next=null;

            if(newHead==null){
                newHead=loophead;
            }

        }
        return newHead;


    }
}
