package 最短路径算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Edge 代表两点之前的每一条边
 *
 * @author G.T.M
 */
class Edge {
    public Edge(String to, int cost) {
        // TODO Auto-generated constructor stub
        this.to = to;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    String to;
    int cost;
}

public class Dijkstra {
    /**
     * G 代表问题中的无向图，使用hashmap和arraylist构建邻接表
     */
    private static HashMap<String, ArrayList<Edge>> G = new HashMap<String, ArrayList<Edge>>();
    private static HashMap<String, Integer> d = new HashMap<String, Integer>();
    private static HashMap<String, Boolean> used = new HashMap<String, Boolean>();
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        /**
         * 第一部分：建图
         */
        int N = 0;
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            N = input.nextInt();
            if (-1 == N) {
                break;
            }
            String start = input.next();
            // used.put(start, );
            String end = input.next();
            // used.put(end, false);
            d.put(start, 0);
            d.put(end, INF);
            for (int i = 0; i < N; i++) {
                String first = input.next();
                String second = input.next();
                // set initial distance
                if (d.get(first) == null) {
                    d.put(first, INF);
                }
                if (d.get(second) == null) {
                    d.put(second, INF);
                }
                // set initial used
                if (!used.containsKey(first)) {
                    used.put(first, false);
                }
                if (!used.containsKey(second)) {
                    used.put(second, false);
                }
                int cost = input.nextInt();

                if (G.containsKey(first)) {
                    // first-->second
                    G.get(first).add(new Edge(second, cost));
                    // second-->first
                    if (G.containsKey(second)) {
                        G.get(second).add(new Edge(first, cost));
                    } else {
                        G.put(second, new ArrayList<Edge>());
                        G.get(second).add(new Edge(first, cost));
                    }
                } else {
                    // first-->second
                    G.put(first, new ArrayList<Edge>());
                    G.get(first).add(new Edge(second, cost));
                    // second-->first
                    if (G.containsKey(second)) {
                        G.get(second).add(new Edge(first, cost));
                    } else {
                        G.put(second, new ArrayList<Edge>());
                        G.get(second).add(new Edge(first, cost));
                    }
                }

            }
            dijkstra(start);
            if (d.get(end) != INF) {
                System.out.println(d.get(end));
            } else {
                System.out.println(-1);
            }
            // 每次使用完之后清空，不然影响next time graph
            used.clear();
            G.clear();
            d.clear();
        }
        input.close();
    }

    /**
     * dijkstra 算法
     */
    static void dijkstra(String s) {
        while (true) {
            // boolean update = false;
            String v = null;
            // find the next node needed to relax
            for (String u : used.keySet()) {
                if (!used.get(u) && ((v == null) || d.get(u) < d.get(v)))
                    v = u;
            }

            if (v == null)
                break;
            used.put(v, true);

            // update v --> u
            // 得到从v可以到达的所有节点的链表
            ArrayList<Edge> us = G.get(v);
            for (Edge e : us) {
                if (!used.get(e.to)) {// 如果v可以到达u这个节点
                    int cost = Math.min(d.get(e.to), d.get(v) + e.getCost());
                    d.put(e.to, cost);
                }
            }
        }
    }
}
