package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 무게와 가치를 가진 dp 테이블을 생성,
 * 끝까지 갔다가 끝에서부터 0까지 돌아오면서 max value를 찾아서 더해옴
 */
public class BaekJoon12865 {
    public static int[][] dp;
    public static int n,k;
    public static int [][] objectArr;
    public static boolean [][] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        objectArr = new int[n][2];
        visited = new boolean[n+1][100001];
        dp = new int[n+1][100001];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            objectArr[i][0] = Integer.parseInt(s1[0]);
            objectArr[i][1] = Integer.parseInt(s1[1]);
        }
        int recursion = recursion(0, 0);
        System.out.println(recursion);
    }
    public static int recursion(int index, int totalWeight){
        // 베이스조건
        if(index == n)
            return 0;
        if(totalWeight > k)
            return 0;
        // 백트래킹
        if(visited[index][totalWeight])
            return dp[index][totalWeight];
        visited[index][totalWeight] = true;

        int value = objectArr[index][1];
        int weight = objectArr[index][0];

        int noObject = recursion(index+1,totalWeight);
        int yesObject = recursion(index+1,totalWeight+weight);
        dp[index][totalWeight] = Math.max(noObject, yesObject + value);

        return dp[index][totalWeight];
    }
}
