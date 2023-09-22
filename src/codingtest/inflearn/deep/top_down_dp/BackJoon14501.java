package codingtest.inflearn.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 상담사 퇴사
 * 재귀의 모든 경우의 수 로도 풀 수 있지만,
 * Top-Down-DP (메모이제이션) 로 풀 경우 더 효율적으로 풀 수 있음
 */
public class BackJoon14501 {
    public static int n;
    public static int[][] interview;
    public static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        interview = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            interview[i][0] = Integer.parseInt(s[0]);
            interview[i][1] = Integer.parseInt(s[1]);
        }
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int recursion = recursion(0);
        System.out.println(recursion);
    }
    public static int recursion(int index){
        if(index > n){
            return Integer.MIN_VALUE;
        }
        if(index == n){
            return 0;
        }
        // 이미 저장되었다면,, 초기값이 -1로 설정되었으니 방문을 했던 노드인거임,,
        if(dp[index] != -1){
            return dp[index];
        }
        // 재귀가 끝까지 가면, 0을 반환하고, 호출했던 recursion을 돌아오면서 상담을 하며 받은 돈을 더해주며 dp 테이블에 저장
        int interviewY = recursion(index+interview[index][0]);
        int interviewN = recursion(index+1);
        int interviewMoney = interview[index][1];

        dp[index] = Math.max(interviewY+interviewMoney,interviewN);

        return dp[index];
    }

}
