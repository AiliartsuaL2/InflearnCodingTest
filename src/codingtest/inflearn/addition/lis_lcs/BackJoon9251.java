package codingtest.inflearn.addition.lis_lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCS : 최장 공통 부분 수열
 * 가장 긴 두 수열에 공통적으로 포함되는 경우를 찾아라,,
 * 완탐 사고 : 각 수열마다 만들 수 있는 모든 부분 수열을 꺼내서 비교
 * Well-Known : 좋은 아이디어로 최적화된 널리 알려진 방법
 *   - 반복
 *      - 끝의 문자가 같다면, 하나씩 떼서 없애주고 +1을 해준다.
 *      - 같지 않다면, 결과에 영향에 주지 않는 맨 마지막 알파벳을 제거한다.
 */
public class BackJoon9251 {
    public static int[][] dp ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");
        String[] M = br.readLine().split("");
        dp = new int[N.length+1][M.length+1];
//        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 1; i <= N.length; i++) {
            for (int j = 1; j <= M.length; j++) {
                // 문자가 일치할경우
                if(N[i-1].equals(M[j-1])){
                    // dp 테이블에 1추가 (일치했으니까)
//                    arrayList.add(N[i-1]);
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    // 일치하지 않을경우, dp 테이블에서 좌측, 위측중 더 큰값을 가져와 업데이트
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < arrayList.size(); i++) {
//            if(i%2 == 0){
//                stringBuilder.append(arrayList.get(i));
//            }
//        }
        System.out.println(dp[N.length][M.length]);
//        System.out.println(stringBuilder.toString());
    }
}
