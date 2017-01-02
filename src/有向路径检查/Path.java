package 有向路径检查;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}

public class Path {

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        if (a == null || b == null) {
            return false;
        }
        // a -> b
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        q.add(a);
        visited.put(a, true);
        while (!q.isEmpty()) {
            UndirectedGraphNode curNode = q.poll();
            if (curNode == null) {
                continue;
            }
            if (curNode == b) {
                return true;
            } else {
                if (curNode.neighbors != null) {
                    if (curNode.neighbors.size() > 0)
                        for (UndirectedGraphNode node : curNode.neighbors) {
                            if (node != null) {
                                q.add(node);
                                visited.put(node, true);
                            } else {
                                continue;
                            }
                        }
                }
            }
        }
        Queue<UndirectedGraphNode> qb = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, Boolean> visitedb = new HashMap<UndirectedGraphNode, Boolean>();
        qb.add(b);
        visitedb.put(b, true);
        while (!qb.isEmpty()) {
            UndirectedGraphNode curNode = qb.poll();
            if (visitedb.get(curNode) == true)
                continue;
            if (curNode == a) {
                return true;
            } else {
                if (curNode.neighbors != null && curNode.neighbors.size() > 0) {

                    for (UndirectedGraphNode node : curNode.neighbors) {
                        if (node != null) {
                            qb.add(node);
                            visitedb.put(node, true);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode b = new UndirectedGraphNode(2);
        UndirectedGraphNode c = new UndirectedGraphNode(3);
        a.neighbors.add(c);
        b.neighbors.add(a);
        c.neighbors.add(b);

        System.out.println(new Path().checkPath(a, b));

    }

}
