package codingtest.inflearn.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 바텀업 DP ( 점화식 )
 * 상담원 퇴사일 까지 언제 일해야지 최대금액을 받을 수 있는지
 */
public class BackJoon14501 {
    public static int[] dp;
    public static int n;
    public static int[][] interview;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        interview = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            interview[i][0] = Integer.parseInt(s[0]);
            interview[i][1] = Integer.parseInt(s[1]);
        }
        dp = new int[n+1];

        for (int i = n-1; i >=0; i--) {
            // 퇴사일보다 이후에 있는경우,
            if(i + interview[i][0] > n){
                dp[i] = dp[i+1];
            }else{
                // 상담을 받거나 안받거나 max로 체크
                // 끝에서부터 상담을 받았을때 안받았을때 dp테이블에 데이터를 확인하면서 추가해줌
                dp[i] = Math.max(dp[i + interview[i][0]] + interview[i][1],dp[i+1]);
            }
        }

        System.out.println(dp[0]);
    }
}
