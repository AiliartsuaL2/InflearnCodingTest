package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        dp[1] = 1;
        if(n>1)
            dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            long result = (dp[i - 1] + dp[i - 2])%15746;
            dp[i] = result;
        }
        System.out.println(dp[n]);

    }
}
