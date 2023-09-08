package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1932 {
    public static int[][] graph;
    public static Integer[][] dp;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new Integer[n+1][n+1];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        int recursion = recursion(0, 0);
        System.out.println(recursion);

    }
    public static int recursion(int hIdx,int wIdx){
        if(hIdx == n)
            return 0;
        // 백트래킹
        if(dp[hIdx][wIdx]!=null)
            return dp[hIdx][wIdx];
        dp[hIdx][wIdx] = Math.max(recursion(hIdx+1,wIdx),recursion(hIdx+1,wIdx+1))+graph[hIdx][wIdx];
        return dp[hIdx][wIdx];
    }
}
