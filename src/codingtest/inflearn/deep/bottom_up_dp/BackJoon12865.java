package codingtest.inflearn.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon12865 {
    public static int n;
    public static int k;
    public static int[][] dp;
    public static int[][] backArr;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);
        backArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            backArr[i][0] = Integer.parseInt(s[0]);
            backArr[i][1] = Integer.parseInt(s[1]);
        }

        dp = new int[n+1][k];
        visited = new boolean[n+1][k];

        for (int index = 0; index < n; index++) {
            for (int weight = 0; weight < k + 1; weight++) {
                if(visited[index][weight]){
                    dp[index][weight] = dp[index-1][weight];
                }
                if(weight > k){
                    dp[index][weight] = dp[index-1][weight];
                }
                else{
                    // 짐을 넣었을경우
                    int yesBack = dp[index-1][weight+backArr[index][0]];
                    // 짐을 안넣었을경우
                    int noBack = dp[index-1][weight];
                    int value = backArr[index][1];

                    // 짐을 넣은경우엔 value값을 넣어주며 return 해준다.
                    dp[index][weight] = Math.max(yesBack + value, noBack);
                }
            }
        }
    }
}
