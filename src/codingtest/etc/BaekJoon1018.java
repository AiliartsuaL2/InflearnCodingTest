package codingtest.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1018 {
    public static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if(s1[j].equals("W"))
                    map[i][j] = true;
                else
                    map[i][j] = false;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < n-7; x++) {
            for (int y = 0; y < m-7; y++) {
                Math.min(min,checkBoard(y,x));
            }
        }
        System.out.println(min);
    }
    public static int checkBoard(int y, int x){
        int count = 0;
        int ex = x+8;
        int ey = y+8;
        // 첫번째 칸의 색
        boolean TF = map[y][x];
        for (int i = y; i < ey; i++) {
            for (int j = x; j < ex; j++) {
                // 올바른 색이 아니면 count 증가
                if(map[i][j] != TF)
                    count ++;
                // 다음칸은 색이 바뀌기 때문에 TF 변경
                TF = !TF;
            }
            // 마찬가지로 변경해줌
            TF = !TF;
        }
        // 64개가 최소값이기 때문에
        return Math.min(count,64-count);
    }

}
