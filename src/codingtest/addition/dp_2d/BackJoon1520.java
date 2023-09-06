package codingtest.addition.dp_2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 좌측 위 좌표에서 우측 하단 좌표까지 도달 할 수 있는 경로의 수
 * 조건
 *  - 현재 숫자보다 낮은 숫자로만 이동이 가능
 */
public class BackJoon1520 {
    public static int m;
    public static int n;
    public static int[][] dp;
    public static boolean[][] visited;
    public static int[][] graph;
    public static final int[] dy={1,-1,0,0};
    public static final int[] dx={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        graph = new int[m][n];
        dp = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(s2[j]);
            }
        }
        int recursion = recursion(0, 0);
        System.out.println(recursion);
    }
    public static int recursion(int y, int x){
        // 우측 하단에 도착하면
        if(y==m-1 && x==n-1){
            return 1;
        }

        // 백트래킹 (이미 계산된 곳은 계싼된 결과를 사용한다)
        if(visited[y][x]){
            return dp[y][x];
        }
        visited[y][x] = true;

        int route = 0;
        for (int i = 0; i < 4; i++) {
            int ey = y+dy[i];
            int ex = x+dx[i];
            // graph 내에서 이동
            if(0 <= ey && ey < m && 0 <= ex && ex < n){
                // 내리막길인 경우에서만
                if(graph[y][x] > graph[ey][ex]){
                    route += recursion(ey,ex);
                }
            }
        }
        dp[y][x] = route;
        return dp[y][x];
    }
}
