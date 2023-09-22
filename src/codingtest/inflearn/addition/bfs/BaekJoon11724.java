package codingtest.inflearn.addition.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BaekJoon11724 {
    public static boolean[] visited;
    public static List<List<Integer>> linkedList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        visited = new boolean[n+1];
        linkedList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> newList = new ArrayList<>();
            linkedList.add(newList);
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int node = Integer.parseInt(s1[0]);
            int linkedNode = Integer.parseInt(s1[1]);
            linkedList.get(node).add(linkedNode);
            linkedList.get(linkedNode).add(node);
        }
        // graph에는 연결된 노드들만 있음
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
    public static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while(!q.isEmpty()){
            int poll = q.poll();
            int size = linkedList.get(poll).size();
            for (int i = 0; i < size; i++) {
                int newNode = linkedList.get(poll).get(i);
                if(!visited[newNode]){
                    q.offer(newNode);
                    visited[newNode] = true;
                }
            }
        }
    }
}
