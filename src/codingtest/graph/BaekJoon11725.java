package codingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BaekJoon11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[n + 1];
        graph[1] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int node1 = Integer.parseInt(s[0]);
            int node2 = Integer.parseInt(s[1]);
            if (graph[node1] == null)
                graph[node1] = new ArrayList<>();
            if (graph[node2] == null)
                graph[node2] = new ArrayList<>();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        for (int i = 1; i < n + 1; i++) {
            List<Integer> integers = graph[i];
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }

        Queue<Integer> q = new LinkedList<>();
        int parent = 1;
        q.offer(parent);
        Integer[] answer = new Integer[n + 1];
        while (!q.isEmpty()) {
            Integer parentNode = q.poll();
            List<Integer> nodeList = graph[parentNode];
            for (Integer node : nodeList) {
                if (answer[node] != null)
                    continue;
                answer[node] = parentNode;
                q.offer(node);
            }
        }
        for (int i = 2; i < n + 1; i++) {
            Integer integer = answer[i];
            System.out.println(integer);
        }
    }

}
