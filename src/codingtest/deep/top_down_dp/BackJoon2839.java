package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 설탕봉지
 * 3키로짜리랑 5키로짜리 봉지가 있음
 * 1. recursion으로 풀기
 * 2. recursion을 Top-Down DP로 바꾸기
 */
public class BackJoon2839 {
    public static int n;
    public static int weight;
    public static int[][] dp ;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 해당 kg을 3키로 봉지로 나눈값이 최대 봉지수
        weight = Integer.parseInt(br.readLine());
        n = weight/3;
        dp = new int[n+1][n*5+1];
        visited = new boolean[n+1][n*5+1];
        int recursion = recursion(0, 0);
        if(recursion == Integer.MAX_VALUE)
            recursion = -1;
        System.out.println(recursion);
    }
    public static int recursion(int index, int backsWeight){
        // 베이스조건, 가방의 개수가 n을 3키로로 나눈 값보다 커지는 순간 return
        if(index  > n){
            return Integer.MAX_VALUE;
        }
        if(backsWeight == weight){
            return index;
        }
        // 백트래킹
        if(visited[index][backsWeight])
            return dp[index][backsWeight];

        visited[index][backsWeight] = true;

        // 3키로짜리 봉지를 사용하는 경우
        int back3 = recursion(index+1,backsWeight+3);
        // 5키로짜리 봉지를 사용하는 경우
        int back5 = recursion(index+1,backsWeight+5);

        dp[index][backsWeight] = Math.min(back3,back5);
        return dp[index][backsWeight];
    }
}
