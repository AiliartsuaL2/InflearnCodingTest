package codingtest.inflearn.addition.dp_2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 조건
 * - 2차원 맵에서
 * - 현재 좌표 기준 상하좌우만 이동이 가능하고,
 * - 더 큰값으로만 이동이 가능
 * - 최대한 많은 칸을 방문하고싶을 때 이동한 칸의 수 출력
 */
public class BackJoon1937 {
    public static final int[] dy = {1,-1,0,0};
    public static final int[] dx = {0,0,-1,1};
    public static int n;
    public static int[][] graph;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 모든 점 방문해서
        // 이동 할 수 있는 모든 경우의 수를 재귀로 방문
        //      방문했던 곳은 방문하면 안되기 때문에 visited로 체크한다.
        // 재귀로 구현 후 DP로 변경
        int max = Integer.MIN_VALUE;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int recursion = recursion(y, x);
                if(recursion > max)
                    max = recursion;
            }
        }
        // max에서 최초 1칸을 더해준다.
        System.out.println(max+1);
    }
    public static int recursion(int y, int x){
        if(dp[y][x]!=0){
            return dp[y][x];
        }
        for (int i = 0; i < 4; i++) {
            // 상하좌우 좌표
            int ey = y+dy[i];
            int ex = x+dx[i];
            // 그래프의 범위를 벗어나지 않는 한도 내에서
            if(0 <= ey && ey < n && 0 <= ex && ex < n){
                // 첫번째 조건인 더 큰 값으로만 이동 가능하게끔 조건 처리
                if(graph[y][x] < graph[ey][ex]){
                    // 이동이 가능하면 1을 증가시켜서 가져오고 Max값을 체크 (해당 recursion을 불러온 함수에게 전달해줌)
                    dp[y][x] = Math.max(dp[y][x],recursion(ey,ex)+1);
                }
            }
        }
        // 더 갈곳이 없으면 0을 return해주고, 방문을 할 수 있으면 방문한곳을 갔다온 경우의 수를 업데이트 시켜줌,,
        return dp[y][x];

    }
}
