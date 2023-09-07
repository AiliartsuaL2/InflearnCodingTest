package codingtest.deep.top_down_dp;

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
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int recursion = recursion(0, 0);
        System.out.println(recursion);
    }
    public static int recursion(int idx, int prevIdx){
        if(idx >= n){
            return stairs[n];
        }
        if(visited[idx])
            return dp[idx];
        visited[idx] = true;

        // 시작지점인경우
        if(idx == 0){
            if(idx+1==n-2)
                dp[idx] = Math.max(recursion(idx+1,idx),recursion(idx+2,idx+2));
            else
                dp[idx] = Math.max(recursion(idx+1,idx+1),recursion(idx+2,idx+2));
        }
        else{
            // 이전에서 한칸만 올라운경우
            if(idx - prevIdx == 1){
                // 마지막에서 한칸 전이면 연달아 세번 올라가는 경우가 되어버리기 때문에
                if(idx == n-1){
                    return 0;
                }
                dp[idx] = recursion(idx+2,idx);
            }
            // 이전에서 두칸 올라간 경우 한칸 혹은 두칸 올라갈 수 있는데 큰 값으로 저장한다.
            else{
                dp[idx] = Math.max(recursion(idx + 1, idx), recursion(idx + 2, idx));
            }
        }

        return dp[idx]+stairs[idx];
    }
}
