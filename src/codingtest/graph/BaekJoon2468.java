package codingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2468 {
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int h = Integer.parseInt(s[j]);
                graph[i][j] = h;
                if(h > maxHeight)
                    maxHeight = h;
            }
        }
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i <= maxHeight; i++) {
            int count = 0;
            boolean[][] visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Queue<Point> q = new LinkedList<>();
                    Point point = new Point(j, k);
                    // 방문하지않고, 잠기지 않았으면
                    if(!visited[point.y][point.x] && (graph[point.y][point.x]>i)){
                        q.offer(point);
                        count++;
                    }
                    while(!q.isEmpty()){
                        Point nowPoint = q.poll();
                        int x = nowPoint.x;
                        int y = nowPoint.y;
                        for (int l = 0; l < 4; l++) {
                             int ex = x+dx[l];
                             int ey = y+dy[l];
                             // 그래프의 범위 안에 있을 때,
                             if(0 <= ex && ex < n && 0 <= ey && ey < n){
                                 // 방문하지 않고, 잠기지 않았으면 방문.
                                 if(!visited[ey][ex] && (graph[ey][ex]>i)){
                                     visited[ey][ex] = true;
                                     Point nextPoint = new Point(ey, ex);
                                     q.offer(nextPoint);
                                 }
                             }
                        }
                    }
                }
            }
            if(count > maxCount)
                maxCount = count;
        }
        System.out.println(maxCount);
    }
}
class Point{
    int x;
    int y;
    public Point(int y, int x){
        this.x = x;
        this.y = y;
    }

}
