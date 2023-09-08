package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaekJoon1010 {
    public static int n,m;
    public static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            dp = new Integer[30][30];
            int combi = combi(m, n);
            System.out.println(combi);
        }
    }

    /**
     * 조합의 성질
     * 1. n+1 C r+1 = n C r + n C r+1
     * 2. nC0 = nCn = 1
     */

    public static int combi(int n, int r) {

        // 이미 탐색했던 경우 바로 반환
        if(dp[n][r] != null) {
            return dp[n][r];
        }

        // 2번 성질
        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }
        // 1번 성질
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
