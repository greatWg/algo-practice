Book:
## scalable Software design model
Repo : https://github.com/checkcheckzz/system-design-interview

Course : https://www.hiredintech.com/classrooms/system-design/lesson/53

## Algorithm
Gayle Macdowell: Video : https://www.youtube.com/results?search_query=gayle+Laakmann

Algorithm book : https://algs4.cs.princeton.edu/10fundamentals/

Course: https://www.hiredintech.com/classrooms/algorithm-design/lesson/77



### Finding Kth smallest element in range  - Segment tree

What is the k-th smallest element in the range a[l…r]. 
This query can be answered using a binary search and a Merge Sort Tree, but the time complexity for a single query would be O(log3n). We will accomplish the same task using a persistent Segment Tree in O(logn).

https://cp-algorithms.com/data_structures/segment_tree.html

Connected component ? DFS

Is Biprtite ? dfs

Is Cycle in Graph ?  DFS

Find a cycle every edge once ? ->  Eulerian tour
   (If connected  graph is Eulerian iff vertices have even degree 

Find a cycle that visits every vertex once ?-> NP complete -Hamiltonian cycle -intractable

Is Graph identical except vertex names? Graph Isomorphisam ? 

Lay out a graph plane without crossing edges ? Linear time DFS Planerity Algorithm -
        Tarjan's algorithm 
 
https://cp-algorithms.com/

https://codeforces.com/contests



Vertex* build(int tl, int tr) {
    if (tl == tr)
        return new Vertex(0);
    int tm = (tl + tr) / 2;
    return new Vertex(build(tl, tm), build(tm+1, tr));
}

Vertex* update(Vertex* v, int tl, int tr, int pos) {
    if (tl == tr)
        return new Vertex(v->sum+1);
    int tm = (tl + tr) / 2;
    if (pos <= tm)
        return new Vertex(update(v->l, tl, tm, pos), v->r);
    else
        return new Vertex(v->l, update(v->r, tm+1, tr, pos));
}

int find_kth(Vertex* vl, Vertex *vr, int tl, int tr, int k) {
    if (tl == tr)
        return tl;
    int tm = (tl + tr) / 2, left_count = vr->l->sum - vl->l->sum;
    if (left_count >= k)
        return find_kth(vl->l, vr->l, tl, tm, k);
    return find_kth(vl->r, vr->r, tm+1, tr, k-left_count);
}

int tl = 0, tr = MAX_VALUE + 1;
std::vector<Vertex*> roots;
roots.push_back(build(tl, tr));
for (int i = 0; i < a.size(); i++) {
    roots.push_back(update(roots.back(), tl, tr, a[i]));
}

// find the 5th smallest number from the subarray [a[2], a[3], ..., a[19]]
int result = find_kth(roots[2], roots[20], tl, tr, 5);