package codingtest.inflearn.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 물건 n, 배낭 무게 k
 * 물건 무게 , 물건 가치
 * 배낭 무게에 들어갈 수 있으면서 물건 가치를 가장 크게 담을 수 있는,,
 * 일반 재귀로 풀면 시간제한 때문에 안풀리기 때문에 일단 완탐으로 접근 , 시간제한 확인 후 dp로 풀어준다.
 */
public class BackJoon12865 {
    public static int n;
    public static int k;
    public static int answer = Integer.MIN_VALUE;
    public static int[][] backArr;
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
        recursion(0,0,0);
        System.out.println(answer);
    }
    public static void recursion(int index, int weight, int value){
        // 베이스 조건, 현재 들고있는게 최대값보다 큰경우
        if(weight > k){
            return;
        }
        // 베이스 조건, 물건들 전부 탐색하는경우
        if(index == n){
            answer = Math.max(answer,value);
            return;
        }
        // 짐을 넣었을경우
        recursion(index+1,weight+backArr[index][0],value+backArr[index][1]);
        // 짐을 안넣었을경우
        recursion(index+1,weight,value);
    }
}
