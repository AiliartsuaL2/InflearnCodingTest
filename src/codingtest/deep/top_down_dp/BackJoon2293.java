package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 동전의 가지수와 목표 금액을 찾는경우
 *  - 누적합..
 *   dp[i] = dp[i] + dp[i - coin]이다.
 *   문제와 같은 입력이 주어졌을 때
 *      1원 짜리 동전으로 1원 부터 10원까지 만들 수 있는 가짓수를 구한다.
 *      2원 짜리 동전으로 2원 부터 10원까지 만들 수 있는 가짓수를 구한다. (1원으로 구한 값을 이용하여 구한다.)
 *      5원 짜리 동전으로 5원 부터 10원까지 만들 수 있는 가짓수를 구한다. (2원으로 구한 값을 이용하여 구한다.)
 */
public class BackJoon2293 {
    private static int n, k;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        arr = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        //
        for(int i = 1 ; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= k; j++)
                dp[j] += dp[j - arr[i]];
        }

        System.out.println(dp[k]);
    }
}
