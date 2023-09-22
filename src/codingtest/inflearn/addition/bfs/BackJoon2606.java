package codingtest.inflearn.addition.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 * DEQUEUE를 통해서 좌측 우측에서 데이터를 꺼내옴
 * 알고리즘
 * - 첫번째 위치에서 갈 수 있는 데이터를 deque에다가 담아줌,
 * - deque를 보면서 갈 수 있는 데이터를 deque에다가 또 담아줌
 * - 담은 데이터들을 왼쪽부터 없애주면서 나아가면 탐색하려는 인자부터 가까운 순서대로 없어짐..
 * - 따라서 removeFirst부터 해주면 됨.
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

        Deque<Integer> q = new LinkedList();
        q.offer(1);
        // q의 사이즈가 0이 될때까지 반복
        while(!q.isEmpty()){
            int node =q.removeFirst();
            // 방문처리
            visited[node] = true;

            for (int i = 1; i < n+1; i++) {
                if(graph[node][i] == 1){
                    if(visited[i])
                        continue;
                    q.offer(i);
                }
            }
        }
        for (boolean b : visited) {
            System.out.println(b);
        }
    }
}
