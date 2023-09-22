package codingtest.inflearn.addition.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1012 {
    public static final int[] dx = {0,0,-1,1};
    public static final int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);

            // 땅 그림
            int [][] map = new int[n][m];

            // 배추를 심음
            for (int j = 0; j < k; j++) {
                String[] s1 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[0]);
                int y = Integer.parseInt(s1[1]);
                map[y][x] = 1;
            }
            boolean[][] visited = new boolean[n][m];
            int count = 0;
            // 땅을 탐색하면서, 인접해있는 땅만 탐색
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if(!visited[y][x]){
                        if(map[y][x] != 0){
                            if(dfs(y,x,map,visited))
                                count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static boolean dfs(int y,int x,int[][] map, boolean[][] visited){
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ey = y+dy[i];
            int ex = x+dx[i];
            if(0 <= ey && ey < map.length && 0<= ex && ex < map[0].length){
                if(!visited[ey][ex]){
                    if(map[ey][ex] == 1){
                        dfs(ey,ex,map,visited);
                    }
                }
            }
        }
        return true;
    }
}
