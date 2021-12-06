package algo.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryNumberinaLinkedListtoIntegerSolution {

    public int getDecimalValue(ListNode head) {

        List<Integer> list = new ArrayList<>();
        int i=0;
        while(head!=null){
            list.add(head.val);
            head= head.next;
        }
        int sum= 0;
        int n= list.size();
        for(int j=n-1 ; j>=0; j--){ // 101 --> read from last start
            sum = (int) (sum +
                    (list.get(j)*
                            Math.pow(2,
                                    Math.abs(j-(n-1))
                            )
                    )
                );
        }
        return sum;
    }



    public static void main(String[] args) {

        ConvertBinaryNumberinaLinkedListtoIntegerSolution BToN= new ConvertBinaryNumberinaLinkedListtoIntegerSolution();
        ListNode head= new ListNode(1);
        head.next= new ListNode(0);
        head.next.next= new ListNode(1);

        System.out.println("Expected: 5 and actual : "+ BToN.getDecimalValue(head));

        ListNode head0= new ListNode(0);
        System.out.println("Expected: 0 and actual : "+ BToN.getDecimalValue(head0));

        ListNode head1= new ListNode(1);
        System.out.println("Expected: 1 and actual : "+ BToN.getDecimalValue(head1));


        ListNode head2= new ListNode(0);
        head2.next= new ListNode(0);
        System.out.println("Expected: 0 and actual : "+ BToN.getDecimalValue(head2));

        ListNode head3= new ListNode(1);
        head3.next= new ListNode(0);
        head3.next.next= new ListNode(0);

        head3.next.next.next= new ListNode(1);
        head3.next.next.next.next= new ListNode(0);
        head3.next.next.next.next.next= new ListNode(0);

        head3.next.next.next.next.next.next= new ListNode(1);
        head3.next.next.next.next.next.next.next= new ListNode(1);
        head3.next.next.next.next.next.next.next.next= new ListNode(1);

        ListNode node = head3.next.next.next.next.next.next.next.next;
        node.next= new ListNode(0);
        node.next.next= new ListNode(0);
        node.next.next.next= new ListNode(0);

        ListNode node1 = node.next.next.next;
        node1.next= new ListNode(0);
        node1.next.next= new ListNode(0);
        node1.next.next.next= new ListNode(0);

        System.out.println("Expected: 18880 and actual : "+ BToN.getDecimalValue(head3));


    }
}
