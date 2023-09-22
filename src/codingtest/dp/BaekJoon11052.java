package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11052 {
    public static int n;
    public static int[] card;

    public static int[] dp;

    /**
     * 카드 N개를 구매해야한다.
     * 카드팩에 들어있는 카드가 적은 것부터 산다.
     * 카드 N개를 구매하는데 드는 비용의 최대를 구하는 문제
     *
     *
     * 카드 i개를 구매하는 방법
     * 카드 1개가 들어있는 카드팩을 구매하고, 카드 i-1개를 구입한다.
     * 카드 2개가 들어있는 카드팩을 구매하고, 카드 i-2개를 구입한다.
     * 카드 3개가 들어있는 카드팩을 구매하고, 카드 i-3개를 구입한다.
     * D[i] = P[n] + D[i-n] 이다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        card = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++)
            card[i+1] = Integer.parseInt(s[i]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
