package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11057 {
    public static Long[][] dp;
    public static int n ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // N 자리의 자릿값(0~9)
        dp = new Long[n+1][10];
        long answer = 0;
        // 첫번째 자리수는 모두 1으로 (경우의수는 1개씩밖에 없음)
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }
        // 마지막 자리수인 1~9까지 모든 경우의 수를 더해준다.
        for (int i = 1; i <= 9; i++) {
            answer += recursion(n,i);
        }
        answer += 1;
        System.out.println(answer%10007);

    }
    public static long recursion(int digit, int val){
        if(digit == 1)
            return dp[digit][val];
        if(dp[digit][val] != null)
            return dp[digit][val];
        long count = 0;
        for (int i = 0; i <= val; i++) {
            count += recursion(digit-1,i);
        }
        return (dp[digit][val] = count) % 10007 ;
    }
}
