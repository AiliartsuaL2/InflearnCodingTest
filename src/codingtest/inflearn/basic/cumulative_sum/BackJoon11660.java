package codingtest.inflearn.basic.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];
        int[][] prefix = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[j][i] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i+1][j+1] = prefix[i+1][j]+prefix[i][j+1]+map[i][j]-prefix[i][j];
            }
        }
        /**
         * x1,y2 좌표에서 x2,y2 좌표까지의 합은
         * 누적합 테이블의(x2,y2) - 누적합 테이블(x1-1,y2) - 누적합 테이블(x2,y1-1) + 누적합 테이블 (x1-1,y1-1) (2번 뺀 교집합)
         */
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            // 배열이기 때문에 -1처리
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);
            int result = prefix[y2][x2] - prefix[y2][x1 - 1] - prefix[y1 - 1][x2] + prefix[y1 - 1][x1 - 1];
            System.out.println(result);
        }
    }
}
