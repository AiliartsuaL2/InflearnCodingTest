package codingtest.addition.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * L로 표시된게 섬인데, 섬에서 점부터 점까지 가장 먼 거리에 보물이 있음
 * 보물과 보물사이에 거리중 최단거리를 구하라.
 */
public class BackJoon2589 {
    public static final int[] dy = {1,-1,0,0};
    public static final int[] dx = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int h = Integer.parseInt(split[0]);
        int w = Integer.parseInt(split[1]);
        String[][] graph = new String[h][w];
        for (int i = 0; i < h; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                graph[i][j] = s[j];
            }
        }
        /**
         * 처음부터 끝까지 다 돌면서 L이면 연결된 L을 탐색해서 채움.
         * 해당 좌표마다 가장 먼 점의 좌표가나오는데, 가장 먼 거리가 몇인지 확인해서 출력
         */
        int max =0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if(graph[y][x].equals("L")){
                    // 좌표를 옮길때마다 방문 기록과 거리를 초기화 시켜줘야함
                    boolean[][] visited = new boolean[h][w];
                    int[][] distance = new int[h][w];

                    // BFS
                    Deque<int[]> q = new LinkedList<>();
                    q.offer(new int[]{y, x});
                    visited[y][x] = true;
                    while(!q.isEmpty()){
                        int[] point = q.removeFirst();
                        int ey = point[0];
                        int ex = point[1];
                        for (int i = 0; i < 4; i++) {
                            int ny = ey+dy[i];
                            int nx = ex+dx[i];
                            // 그래프 범위 안에 있을때
                            if(0 <= ny && ny <h && 0<= nx && nx < w){
                                if(graph[ny][nx].equals("L")){
                                    if(!visited[ny][nx]){
                                        // 백트래킹
                                        visited[ny][nx] = true;
                                        // 이동한 거리는, 지금 있는 거리에다 +1을 해주면 됨.
                                        distance[ny][nx] = distance[ey][ex] +1;
                                        // 최댓값을 업데이트해줌
                                        max = Math.max(max,distance[ny][nx]);
                                        // 현위치를 다시 넣어줌
                                        q.offer(new int[]{ny,nx});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
