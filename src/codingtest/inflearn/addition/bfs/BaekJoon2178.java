package codingtest.inflearn.addition.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2178 {
    public static int[] dy = {1,0,-1,0};
    public static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(s1[j]);
            }
        }
        Queue<Point> q = new LinkedList<>();
        Point start = new Point(0, 0);
        q.offer(start);
        boolean[][] visited = new boolean[n][m];
        while(!q.isEmpty()){
            Point point = q.poll();
            int x = point.getX();
            int y = point.getY();
            // 방문처리
            visited[y][x] = true;
            if(x==m-1 && y==n-1){
                break;
            }

            // 상하좌우중 이동 가능한 좌표가 방문하지 않았고, 갈 수 있는 길이면 해당 거리로 이동
            for (int i = 0; i < 4; i++) {
                int ey = y+dy[i];
                int ex = x+dx[i];
                // 그래프의 범위 안에서만 탐색
                if(0 <= ex && ex < m && 0<= ey && ey< n){
                    // 방문하지 않았고, 갈 수 있는 길이면 queue에 넣어 탐색한다.
                    if(!visited[ey][ex] && graph[ey][ex]==1) {
                        // 갈 곳에 현재 온 거리의 누적합에 +1을 해줌
                        graph[ey][ex] = graph[y][x]+1;
                        Point linkedPoint = new Point(ex, ey);
                        q.offer(linkedPoint);
                    }
                }
            }
        }
        System.out.println(graph[n-1][m-1]);
    }
}
class Point{
    private int x;
    private int y;
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
