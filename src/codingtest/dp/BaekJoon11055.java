package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11055 {
    public static int n;
    public static int[] dp;
    public static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        dp = new int[n+1];
        data = new int[n+1];
        for (int i = 0; i < n; i++) {
            data[i+1] = Integer.parseInt(s[i]);
        }
        // dp 초항처리
        // i 번 까지의 부분 순열의 합
        for (int i = 1; i < n + 1; i++) {
            dp[i] = data[i];
            for (int j = 1; j < i; j++) {
                // i번째 이전의 값 중 현재 값보다 작은경우
                if(data[i] > data[j]){
                    // 해당값과 부분합의 크기 비교
                    dp[i] = Math.max(dp[i],dp[j]+data[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
