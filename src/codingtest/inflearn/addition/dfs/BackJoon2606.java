package codingtest.inflearn.addition.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DFS -> 백트래킹 (반복문, 재귀함수)
 */
public class BackJoon2606 {
    public static int[][] graph;
    public static boolean[] visited ;
    static int n, m;		// 정점, 간선, 시작 정점
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(1);
        int cnt = 0;
        for (boolean b : visited) {
            if(b)
                cnt++;
        }
        System.out.println(cnt-1);
    }
    public static void dfs(int node){
        // 본인과 연결된 노드들을 탐색을 해준다.
        visited[node] = true;
        for (int i = 1; i < n+1; i++) {
            if(graph[node][i] == 1){
                if(visited[i])
                    continue;
                dfs(i);
            }
        }
    }
}
