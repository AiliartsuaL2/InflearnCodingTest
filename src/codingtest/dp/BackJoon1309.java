package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 3;
        if(n > 1){
            dp[2] = 7;
            for (int i = 3; i <= n; i++) {
                dp[i] = ((2*dp[i-1])+dp[i-2]) % 9901;
            }
        }

        System.out.println(dp[n]);
    }
}
