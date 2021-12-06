package algo.List;

public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = node;
        while (current != null ){
            // Update pointer values
            next = current.next;
            current.next = prev;
            // Update the pointer
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode prev = null;
        int count=0;
        count++;
        while (count<m){
            prev=current ;
            current = current.next;
            count++;
        }
        ListNode con= prev, tail = current;
        ListNode temp= null;
        while (count<=n){
            temp= current.next;
            current.next= prev;
            prev= current;
            current= temp;
            count++;
        }

        if (con!= null){
            con.next= prev;
        }else{
            head= prev;
        }
        tail.next =current;

        return head;
    }

    public static void main(String[] args) {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next= new ListNode(3);
        node.next.next.next = new ListNode(4);

        printLinkedList(node);
        ListNode rNode = reverseLinkedList.reverseList(node);
        System.out.println();
        printLinkedList(rNode);

        ListNode head = new ListNode(7);
        head.next = new ListNode(9);
        head.next.next= new ListNode(2);
        head.next.next.next = new ListNode(10);
        head.next.next.next.next= new ListNode(1);
        head.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next =  new ListNode(6);
        System.out.println();
        printLinkedList(head);
        ListNode rBNode = reverseLinkedList.reverseBetween(head, 3, 6);
        System.out.println( "expected: 7 9 8 1 10 2 6 null" );
        printLinkedList(rBNode);


    }

    private static void printLinkedList(ListNode node) {
        while (node!= null){
            System.out.print( " "+ node.val + " -->");
            node = node.next;
        }
        System.out.print( " null");
    }
}
