package codingtest.dp;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for (int j = 0; j < 2; j++) {
                String[] s = br.readLine().split(" ");
                for (int k = 1; k <= n; k++) {
                    sticker[j][k] = Integer.parseInt(s[k-1]);
                }
            }
            // 첫번째 줄은 자기 자신이 최댓값이므로 자기 자신으로 초기화
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for (int j = 2; j <= n; j++) {
                // 윗줄
                dp[0][j] = Math.max(dp[1][j-1],dp[1][j-2])+sticker[0][j];
                // 아랫줄
                dp[1][j] = Math.max(dp[0][j-1],dp[0][j-2])+sticker[1][j];
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }
    }

}
