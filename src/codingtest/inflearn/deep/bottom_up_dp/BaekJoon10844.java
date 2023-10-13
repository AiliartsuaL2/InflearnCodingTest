package codingtest.inflearn.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10844 {
    static Long[][] dp;
    final static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // N 자리의 자릿값(0~9)
        dp = new Long[n+1][10];
        long answer = 0;

        // 첫번째 자릿수는 1로 초기화 (맨 끝 자리수이므로 경우의 수가 1개밖에 없기 때문에)
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }
        // 마지막 자리수인 1~9까지 모든 경우의 수를 더해준다.
        for (int i = 1; i <= 9; i++) {
            answer += recursion(n,i);
        }
        System.out.println(answer%MOD);
    }
    public static long recursion(int digit, int val){
        // 첫째자리에 도착한다면 더이상 탐색 할 필요가 없다.
        if(digit == 1)
            return dp[digit][val];
        // 해당 자리수의 val이 탐색되지 않은경우
        if(dp[digit][val] == null){
            // 0인경우 이전 자리는 1밖에 오지 못함
            if(val == 0)
                dp[digit][val] = recursion(digit -1,1);
            // 9인경우 이전 자리는 8밖에 오지 못함
            else if(val == 9)
                dp[digit][val] = recursion(digit -1 ,8);
            // 그 외의 경우는 val -1과 val+1 값의 경우의 수를 합한 경우의 수
            else
                dp[digit][val] = recursion(digit-1,val-1) + recursion(digit -1,val +1);
        }
        return dp[digit][val] % MOD;
    }
}
