package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        /**
         * dp[i] = 제곱수 합의 최소 개수
         * 점화식
         * 13은
         * (13 - 1) 의 최소 제곱수의 합 +1
         *
         * (13 - 4) 의 최소 제곱수의 합 +1
         *
         * (13 - 9) 의 최소 제곱수의 합 +1
         *
         * 이후 13보다 큰 제곱값이 없음
         *
         * 중 가장 작은 값
         */

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i ; j++) {
                if(dp[i] > dp[i - j * j] +1)
                    dp[i] = dp[i - j * j] +1;
            }
        }
        System.out.println(dp[n]);
    }
}
