package codingtest.addition.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BaekJoon11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] graph = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int node = Integer.parseInt(s1[0])-1;
            int linkedNode = Integer.parseInt(s1[1])-1;
            graph[node][linkedNode] = 1;
        }
        // graph에는 연결된 노드들만 있음
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(i);
            while(!q.isEmpty()){
                Integer poll = q.poll();
                for (int j = 0; j < n; j++) {
                    if(graph[poll][j] == 1) {
                        if (!visited[poll][j]) {
                            q.offer(j);
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
