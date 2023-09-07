package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1463 {
    public static int n;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        int recursion = recursion(n);
        System.out.println(recursion);
    }
    public static int recursion(int n){
        if(n == 1){
            return 0;
        }
        // 백트래킹
        if(dp[n] != 0){
            return dp[n];
        }

        if(n%6 == 0){
            dp[n] = Math.min(Math.min(recursion(n/3),recursion(n/2)),recursion(n-1))+1;
        }
        else if(n%3 == 0){
            dp[n] = Math.min(recursion(n/3),recursion(n-1))+1;
        }
        else if(n%2==0){
            dp[n] = Math.min(recursion(n/2),recursion(n-1))+1;
        }else{
            dp[n] = recursion(n-1)+1;
        }
        return dp[n];
    }
}
