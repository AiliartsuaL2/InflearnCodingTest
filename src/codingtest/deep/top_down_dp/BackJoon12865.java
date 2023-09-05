package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 물건 n, 배낭 무게 k
 * 물건 무게 , 물건 가치
 * 배낭 무게에 들어갈 수 있으면서 물건 가치를 가장 크게 담을 수 있는,,
 * 일반 재귀로 풀면 시간제한 때문에 안풀리기 때문에 일단 완탐으로 접근 , 시간제한 확인 후 dp로 풀어준다.
 */
public class BackJoon12865 {
    public static int n;
    public static int k;
    public static int[][] backArr;
    public static int[][] dp;
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
        // 2차원 dp 테이블 생성 (물건, 무게)
        // 고려해야 할 파라미터가 생긴다면, dp테이블을 3차원으로 만들기만 하면 된다 !
        dp = new int[n+1][100001];
        visited = new boolean[n+1][100001];

        int recursion = recursion(0, 0);
        System.out.println(recursion);
    }
    public static int recursion(int index, int weight){
        // 베이스 조건, 현재 들고있는게 최대값보다 큰경우
        if(weight > k){
            return Integer.MIN_VALUE;
        }
        // 베이스 조건, 물건들 전부 탐색하는경우
        if(index == n){
            return 0;
        }

        // 방문을 이미 한 경우, 필요없는 연산을 하지 않게 해줌 >> 백트래킹
        if(visited[index][weight]){
            return dp[index][weight];
        }
        // 방문처리
        visited[index][weight] = true;

        // 짐을 넣었을경우
        int yesBack = recursion(index+1,weight+backArr[index][0]);
        // 짐을 안넣었을경우
        int noBack = recursion(index+1,weight);
        int value = backArr[index][1];

        // 짐을 넣은경우엔 value값을 넣어주며 return 해준다.
        dp[index][weight] = Math.max(yesBack + value, noBack);
        return dp[index][weight];
    }
}
