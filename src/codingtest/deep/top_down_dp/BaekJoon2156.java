package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2156 {
    public static int[] wine ;
    public static Integer[] dp ;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wine = new int[n+1];
        dp = new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        //0번은 0이 최대
        dp[0] = 0;
        // 1번은 1이 최대
        dp[1] = wine[1];

        /*
         *  (N이 1로 주어질 수 있으므로 이럴 때를 위해 조건식을 달아둔다.
         *  또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값이다.
         */
        if(n > 1) {
            dp[2] = wine[1] + wine[2];
        }

        int recursion = recursion(n);
        System.out.println(recursion);


    }
    public static int recursion(int idx){
        // 베이스조건
        if(idx < 0)
            return 0;
        // 백트래킹
        if(dp[idx] == null)
            // recursion = 해당 idx까지의 누적합.

            // 큰값(큰값(2번째전까지의 누적와인 / 3번째전까지의 누적와인 + 바로 이전 와인) + 현재 와인) / 1번째 전까지의 누적와인)
            dp[idx] = Math.max(Math.max(recursion(idx - 2), recursion(idx - 3) + wine[idx - 1]) + wine[idx],recursion(idx-1));
        return dp[idx];
    }
}
