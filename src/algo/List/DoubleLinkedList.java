package algo.List;

public class DoubleLinkedList {

    Node head = null;
    Node tail = null;

    /**
     * Empty: head/end  in list // start the list
     * middle // insert (Node1, Node2)   ---Node1 -Node3)  =====>  Node 1 --Node2 - Node3
     * end of list - // insert (Node2, Node3)  ===> (---Node1 -Node2)
     *
     * // 1<-->2<-->3<-->4<-->5<-->6 ====After===>  1<-->2<-->3<-->4<-->30<-->5<--> 6
     * @param searchNode : represent the position if exist else set up new list
     * @param current : Node that needed to insert
     */
    void insert ( Node searchNode, Node current ){ // searchNode - represent the position if exist else not
        if (current != null ) {
            if (searchNode != null) {  //
                //insert in the middle : insert (Node1, Node2) , Exist before: (Node1--Node3), After: (Node1--Node2--Node3)
                if (searchNode.next != null) { //
                    Node temp = searchNode.next;
                    searchNode.next = current;
                    current.prev = searchNode;
                    current.next = temp;

                } else {
                    //insert at the end : insert (Node2, Node3), Exist before: (Node1 -Node2), After: (Node1--Node2--Node3)
                    searchNode.next = current;
                    current.prev = searchNode;
                    tail = current;
                }
            } else {  // If position node is not present == null then it will be empty list
                head = current;
                tail = current;
            }
        }
        else{
            // if current node is null
            System.out.println ( "Invalid insert request" + current);
        }
    }
}
