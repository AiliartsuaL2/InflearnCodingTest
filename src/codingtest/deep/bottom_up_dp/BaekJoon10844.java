package codingtest.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [] dp= new long[n+1];
        long answer = 0;
        if(n == 1)
            answer = 9;
        else if(n == 2)
            answer = 17;
        else{
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i < n+1; i++) {
                dp[i] = dp[i-2]+dp[i-1];
            }
            answer = (dp[n] * 9) % 1000000000;
        }
        System.out.println(answer);

    }
}
