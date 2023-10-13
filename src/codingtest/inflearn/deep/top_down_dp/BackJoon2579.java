package codingtest.inflearn.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon2579 {
    public static int n;
    public static boolean[] visited;

    public static int[] dp;
    public static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n+1];
        // 시작점
        stairs[0] = 0;
        dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            stairs[i+1] = Integer.parseInt(br.readLine());
        }
        dp[0] = stairs[0];
        dp[1] = stairs[1];
        if(n >= 2)
            dp[2] = stairs[1]+stairs[2];

        System.out.println(recursion(n));
    }
    public static int recursion(int idx){
        // 베이스조건
        if(idx == 0)
            return 0;
        // 백트래킹
        if(dp[idx] > 0)
            return dp[idx];
        // (2칸 전 값, 3칸전 값 + 1칸전 값) 비교하여 현재값을 더함
        return dp[idx] = Math.max(recursion(idx-2),recursion(idx-3)+stairs[idx-1])+stairs[idx];
    }
}
