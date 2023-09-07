package codingtest.addition.lis_lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LIS 대표 문제
 * 가장 긴 증가하는 부분수열
 * 아이디어
 * - DP 테이블을 만들고
 * - DP[0]에 1을 넣어주고
 * - 다음 인덱스로 넘기면서 자기보다 왼쪽에 있는 모든 값중 자기보다 작은 수의 값 중 가장 큰 DP[idx]를 가져오고 +1을 해주고 아니면 DP[idx]를 1로 둔다
 * -
 */
public class BackJoon11053 {
    public static int[] dp;
    public static int n;
    public static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        graph = new int[n];
        String[] s = br.readLine().split(" ");
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            graph[i] = Integer.parseInt(s[i]);
        }
        int max = dp[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp(i));
        }
        System.out.println(max);


    }
    public static int dp(int index){
        if(index == n){
            return 0;
        }
        dp[index] = 1;
        // 자기보다 왼쪽에 있는 값을 확인해서
        for (int i = index; i >= 0; i--) {
            // 본인보다 작은숫자면 max 값을 가져오며 +1을 해줌
            if(graph[index] > graph[i]){
                dp[index] = Math.max(dp[index],dp[i]+1);
            }
        }
        return dp[index];
    }
}
