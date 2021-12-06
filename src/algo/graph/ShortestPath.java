import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    Node root;

    private void initialize() {


    }

    Queue<Node> queue = new LinkedList<>();

//    int getShortestDistance(Node root, Node target) {
//        int distance=0;
//        if (root != null && target != null && root.value == target.value) {
//            return 0;
//        } else {
//            if (root != null) {
//                queue.add(root);
//                while (!queue.isEmpty()) {
//                    Node currentNode = queue.poll();
//                    if (currentNode.adjancies!= null){
//                        for (Edge e : currentNode.adjancies){
//                            e.targetNode.distance = currentNode.distance+ e.weight;
//                            queue.add( e.targetNode);
//                        }
//                    }
//                }
//
//
//            }
//
//
//        }
//        return distance ;
//
//    }
}




// A --5- B -5--- D
//  \--2--C --5--/

//Add root in queue
//if (root != null)
//    current weight = 0
//    For( i in list of edges )
//        getWeight = 1
//        node.distnace == curr.weight+ edge.weight
//        Addtarget node in queue
//
//


class Node {
    int value;
    Node next;

     Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

     Node(int value) {
        this.value = value;
        this.next = null;
    }
}

    class Edge {
        int weight;
        Node sourceNode;
        Node targetNode;
    }
