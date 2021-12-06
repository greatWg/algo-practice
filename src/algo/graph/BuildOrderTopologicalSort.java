package algo.graph;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildOrderTopologicalSort {

    //0:
    //1: 0
    //2: 0
    //3: 1, 2
    //4: 3
    //output: 0, 1, 2, 3, 4
    List<Integer> buildOrder (int[][] processes){
       List<Integer> results = new ArrayList<>();
       Set<Integer> tempMarks= new HashSet<>();
       Set<Integer> permanentMarks= new HashSet<>();

        for (int i=0; i<processes.length; i++){
            if (!permanentMarks.contains(processes[i])) {
                visit(i, processes,tempMarks, permanentMarks, results );
            }
        }
       return results;
    }

    private void visit(int processNum, int[][] processes, Set<Integer> tempMark, Set<Integer> permanentMark, List<Integer> res) {
        if (tempMark.contains(processNum)) throw new RuntimeException("Graph is cyclic");
        if(!permanentMark.contains(processNum)){
            tempMark.add(processNum);
            for (int i: processes[processNum]){
                visit(i, processes, tempMark, permanentMark, res);
            }
            permanentMark.add(processNum);
            tempMark.remove(processNum);
            res.add(processNum);
        }
    }
//               --1<--
//             /       \
//        0<--           <-- 3<--4
//             \       /
//               --2<--
    public static void main(String[] args) {
        BuildOrderTopologicalSort  build= new BuildOrderTopologicalSort();
        int[][] input= {
                {},
                {0},
                {0},
                {1,2},
                {3}
        };
        List<Integer> output= build.buildOrder(input);
        for(int i: output){
            System.out.print( i + " <-- ");
        }
    }
}
