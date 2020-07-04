package arland;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class CloneGraph {


    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }



    public Node cloneGraph(Node node) {
        if(null==node){
            return null;
        }
        //记录节点是否访问过
        Node[] visited = new Node[100];
        //对图进行深度优先遍历
        visitNode(node, visited);
        return visited[node.val];
    }

    private void visitNode(Node node, Node[] visited){
        if(visited[node.val]!=null){
            return;
        }
        else{
            visited[node.val] = new Node(node.val);
            visited[node.val].neighbors = new ArrayList<>(node.neighbors.size());
            for (int i = 0; i < node.neighbors.size(); i++) {
                visitNode(node.neighbors.get(i), visited);
                visited[node.val].neighbors.add(visited[node.neighbors.get(i).val]);
            }
        }
    }


    public static void main(String[] args) {
        // write your code here

        CloneGraph a = new CloneGraph();
        //输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
        //输出：[[2,4],[1,3],[2,4],[1,3]]

        Node n11 = new Node(1, new ArrayList<>(2));
        Node n12 = new Node(2, new ArrayList<>(2));
        Node n13 = new Node(3, new ArrayList<>(2));
        Node n14 = new Node(4, new ArrayList<>(2));

        n11.neighbors.add(n12);
        n11.neighbors.add(n14);

        n12.neighbors.add(n11);
        n12.neighbors.add(n13);

        n13.neighbors.add(n12);
        n13.neighbors.add(n14);

        n14.neighbors.add(n11);
        n14.neighbors.add(n13);

        boolean[] visited = new boolean[100];
//        a.printNode(n11, visited);


        a.printNode(a.cloneGraph(n11), visited);
    }

    private void printNode(Node node, boolean[] visited){
        if(visited[node.val]){
            return;
        }
        else{
            visited[node.val] = true;
            System.out.print(node.val);
            for (int i = 0; i < node.neighbors.size(); i++) {
                printNode(node.neighbors.get(i), visited);
            }
        }
    }
}
