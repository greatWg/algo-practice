package algo.List;

public class ReverseSubPart {

    class Node {
        int data;
        Node next;

        public Node(int v) {
            this.data= v;
            this.next= null;
        }
    }

    Node reverseSub(Node head, Node start, Node end ){
        Node temp;
       // while()
        temp = start.next; // 2
        start.next=end;  //  1 -> 8
        temp.next  = end.next; // 9
        end = temp ;
        end.next = temp ;
        return head;
    }
    Node reverse(Node head) {
        // Write your code here

        // 1 2 8 9 12 16
        //   s e 9 s e
        // 1  e s 9 e s
        // 1 -> 8 2


        // 2, 18, 24, 3, 5, 7, 9, 6, 12
        // 24  18 2,  3 , 5 7 9  12 6


        Node start = null;
        Node end = null;
        Node node = head ;
        while (node.next != null){
            if (node.next.data %2 == 0 && start == null){
                start = node;
            }
            if (node.next.data %2 != 0 && start != null){
                end = node;
                reverseSub ( head , start , end );
            }
            node = node.next ;
        }
        return head;


    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }
    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        Node tempExpectedHead = expectedHead;
        Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }
    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);
        Node output_1 = reverse(head_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ReverseSubPart().run();
    }

}
