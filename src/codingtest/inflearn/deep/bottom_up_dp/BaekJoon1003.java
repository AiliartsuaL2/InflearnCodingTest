package codingtest.inflearn.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n>2){
                int[] dp = new int[n + 1];
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                for (int j = 3; j <= n; j++) {
                    dp[j] = dp[j-1]+dp[j-2];
                }
                System.out.println(dp[n-2]+" "+dp[n-1]);
            }
            else if(n == 0)
                System.out.println("1 0");
            else if(n == 1)
                System.out.println("0 1");
            else if(n == 2)
                System.out.println("1 1");
        }
    }
}
