
import java.util.*;

public class CloneGraph {

    static class Node {
        int val;
        List<Node> neighbors;
        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // Test 1: 1--2
        //         |  |
        //         4--3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n3);

        Node clone1 = cloneGraph(n1);
        System.out.println(clone1.val);                        // 1
        System.out.println(clone1.neighbors.get(0).val);       // 2
        System.out.println(clone1.neighbors.get(1).val);       // 4
        System.out.println(clone1 != n1);                       // true (different object)
        System.out.println(clone1.neighbors.get(0) != n2);     // true

        // Test 2: single node, no neighbors
        Node single = new Node(1);
        Node cloneSingle = cloneGraph(single);
        System.out.println(cloneSingle.val);                   // 1
        System.out.println(cloneSingle.neighbors.size());      // 0
        System.out.println(cloneSingle != single);             // true

        // Test 3: null
        System.out.println(cloneGraph(null));                  // null
    }

    // ============================================
    // GRAPHS — PROBLEM 5: Clone Graph
    // ============================================
    // Given a node in a connected undirected graph,
    // return a DEEP COPY of the entire graph.
    //
    // Each node has a val and a list of neighbors.
    // You must create NEW nodes, not reuse old ones.
    //
    // Approach:
    //   - Use a HashMap<Node, Node> to map original → clone
    //   - DFS through the graph
    //   - For each node: if already cloned, return the clone
    //   - Otherwise: create clone, recurse on neighbors
    //
    // Rules:
    //   - O(V + E) time
    //   - Return new nodes, not references to old ones
    // ============================================
    static Node cloneGraph(Node node) {
        // your code here
        if(node == null) return node;
        return dfs(node, new HashMap<>());
    }

    static Node dfs(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)) return  map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }
        return clone;
    }
}
