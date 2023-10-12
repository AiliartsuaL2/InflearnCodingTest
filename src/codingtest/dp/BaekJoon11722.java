package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11722 {
    public static int n;
    public static int[] data;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        dp = new int[n+1];
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(s[i]);
        }
        for (int i = n; i >= 0; i--) {
            lds(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n + 1; i++) {
            max= Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
    public static int lds(int idx){
        // 베이스 조건
        if(idx == n)
            return 0;
        // 백트래킹
        if(dp[idx] > 0)
            return dp[idx];
        dp[idx] = 1;
        for (int i = idx -1 ; i >= 0; i--) {
            if(data[i] > data[idx]){
                dp[idx] = Math.max(dp[idx],lds(i)+1);
            }
        }
        return dp[idx];
    }
}
