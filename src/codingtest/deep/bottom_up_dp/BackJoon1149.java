package codingtest.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 건물 RGB 그리기
 * 이전 건물과 동일한 RGB를 사용하지 않고 최소값의 RGB를 그리는 방법
 * 바텀업 DP를 이용해서 풀이.
 */
public class BackJoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] dp = new int[n][3];
        int [][] RGB = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            RGB[i][0] = Integer.parseInt(s[0]);
            RGB[i][1] = Integer.parseInt(s[1]);
            RGB[i][2] = Integer.parseInt(s[2]);
        }
        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][1],dp[i-1][2])+RGB[i][j];
                }else if(j == 1){
                    dp[i][j] = Math.min(dp[i-1][0],dp[i-1][2])+RGB[i][j];
                }else if(j==2){
                    dp[i][j] = Math.min(dp[i-1][1],dp[i-1][0])+RGB[i][j];
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if(dp[n-1][i] < answer){
                answer = dp[n-1][i];
            }
        }
        System.out.println(answer);

    }
}
