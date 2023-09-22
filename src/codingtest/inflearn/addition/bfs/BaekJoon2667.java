package codingtest.inflearn.addition.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2667 {
    public static final int [] dx = {0,0,-1,1};
    public static final int [] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }
        List<Integer> countList = new ArrayList<>();
        int groupCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 이미 탐색한곳이면 넘김
                if(visited[i][j] == true || graph[i][j] == 0){
                    continue;
                }
                // 사람사는곳중 방문한 곳 없는곳이 있으면 단지수 체크
                groupCount++;
                Queue<Point2> q = new LinkedList<>();
                Point2 point2 = new Point2(j, i);
                q.offer(point2);
                // 새로운 단지니까 새로운 사람
                int cnt = 0;
                // bfs 탐색
                while (!q.isEmpty()){
                    Point2 node = q.poll();
                    int x = node.getX();
                    int y = node.getY();
                    if(visited[y][x]){
                        continue;
                    }
                    // 방문처리
                    visited[y][x] = true;
                    cnt++;
                    for (int k = 0; k < 4; k++) {
                        int ey = y+dy[k];
                        int ex = x+dx[k];
                        // 그래프 범위 내에서
                        if(0<= ey && ey < n && 0<= ex && ex <n){
                            // 방문하지 않은집
                            if(!visited[ey][ex]){
                                // 사람이 사는곳이면 추가탐색
                                if(graph[ey][ex] == 1){
                                    Point2 next = new Point2(ex, ey);
                                    q.offer(next);
                                }
                            }
                        }
                    }
                }
                countList.add(cnt);
            }
        }
        System.out.println(groupCount);
        Collections.sort(countList);
        for (Integer integer : countList) {
            System.out.println(integer);
        }

    }
}
class Point2{
    private int x;
    private int y;
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Point2(int x, int y){
        this.x = x;
        this.y = y;
    }

}
