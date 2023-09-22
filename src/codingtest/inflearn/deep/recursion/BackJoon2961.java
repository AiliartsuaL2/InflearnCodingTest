package codingtest.inflearn.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 재귀함수의 경우의
 * 요리사
 * 신맛은 곱하기
 * 쓴맛은 더하기
 * 신맛과 쓴맛의 차이를 적게
 */
public class BackJoon2961 {
    public static int n;
    public static int answer;
    public static int[] sourArr ;
    public static int[] bitterArr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sourArr = new int[n];
        bitterArr = new int[n];
        for (int i = 0; i < n; i++) {
            String[] taste = br.readLine().split(" ");
            int sour = Integer.parseInt(taste[0]);
            int bitter = Integer.parseInt(taste[1]);
            sourArr[i] = sour;
            bitterArr[i] = bitter;
        }
        answer = Integer.MAX_VALUE;

        recursion(0,1,0,0);
        System.out.println(answer);
    }
    // 재귀함수
    // 재료의 맛만큼 신맛은 곱해지고, 짠맛은 더해진다.
    // 모든 경우의 수를 탐색해서 최소값을 도출
    // 단, 재료가 하나도 안 쓴 경우는 빼줘야함
    public static void recursion(int idx, int sour, int bitter, int use){
        // 재료를 다 쓰면 return
        if(idx == n){
            // 아무 재료도 사용하지 않았다면? 그냥 return
            if(use == 0){
                return;
            }
            int result = Math.abs(sour-bitter);
            answer = Math.min(answer,result);
            return;
        }
        // 재료를 사용한다면
        recursion(idx+1,sour * sourArr[idx],bitter+bitterArr[idx],use+1);

        // 재료를 사용하지 않는다면
        recursion(idx+1,sour,bitter,use);
    }
}
