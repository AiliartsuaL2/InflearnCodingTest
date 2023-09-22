package codingtest.inflearn.basic.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이모스법
 * 각 레인에 장애물이 몇개인지 확인해서 가장 적은 장애물이 있는 레인의 장애물 개수를 출력
 */
public class BackJoon3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int[] map = new int[h];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            // 석순
            if(i%2==0){
                map[0] = map[0]+1;
                map[height] = map[height]-1;
            }else{ // 종유순
                map[h-height] = map[h-height]+1;
                // 범위 외적이기 때문에 계산 해주지 않음
                //map[h-1] = map[h-1]-1;
            }
        }
        int[] prefix = new int[h];
        prefix[0] = map[0];
        // 누적합 배열 작성
        for (int i = 1; i < h; i++) {
            prefix[i] = prefix[i-1]+map[i];
        }
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        // 최소값 가져오고, 구간의 수 체크
        for (int i = 0; i < h; i++) {
            if(min > prefix[i]){
                min = prefix[i];
                cnt = 1;
            }else if(min == prefix[i]){
                cnt++;
            }
        }
        System.out.println(min+" "+cnt);
    }
}
