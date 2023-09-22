package codingtest.inflearn.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n >= 2){
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-2]+dp[i-1]) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
