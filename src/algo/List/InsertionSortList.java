package algo.List;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            remove(head, current );
            insert(head, current);
            current = next;
        }
        return current;

    }

    public void remove(ListNode head, ListNode node){
        if (head.val == node.val){
            head= node.next;
        }
        ListNode current = head;
        while(current.next!=null){
            if (current.next.val== node.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }


    public void insert(ListNode head, ListNode  node){
        if (head.val > node.val){
            node.next=head;
            head= node;
            return;
        }else {
            ListNode current = head;
            while (current.next != null && current.next.val>node.val) {
                if (current.next.val > node.val) {
                    ListNode prev= current;
                    ListNode future = current.next;
                    prev.next= node;
                    node.next= future;
                    return;
                } else {
                    current = current.next;
                }
            }
        }

    }
}
