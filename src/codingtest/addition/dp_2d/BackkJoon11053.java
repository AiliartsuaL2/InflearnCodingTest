package codingtest.addition.dp_2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackkJoon11053 {
    public static int[] graph ;
    public static Integer[] dp ;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(s[i]);
        }
        dp = new Integer[n];

        // 0 ~ N-1 까지 모든 부분수열 탐색
        for(int i = 0; i < n; i++) {
            recursion(i);
        }
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
    public static int recursion(int idx){
        // 탐색하지 않은 위치의 경우
        if(dp[idx] == null){
            // 1로 초기화
            dp[idx] = 1;

        // idx-1부터 0까지 graph[idx]보다 작은 graph[i]를 찾으며 재귀 호출을 한다.
        for (int i = idx-1; i >= 0; i--) {
            if(graph[idx] > graph[i])
                dp[idx] = Math.max(dp[idx],recursion(i)+1);
            }
        }
        return dp[idx];
    }
}
