package codingtest.inflearn.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2775 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        /**
         * 점화식 : k층 n호의 주민은 바로 전 집 주민값 + 바로 아래층집 주민값
         */
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[k+1][n+2];
            for (int j = 1; j <=n; j++) {
                dp[0][j] = j;
            }
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <=n; l++) {
                    dp[j][l] = dp[j-1][l]+dp[j][l-1];
                }
            }
            System.out.println(dp[k][n]);
        }

    }

}
