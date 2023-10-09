package codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11054 {
    static int[] data;
    static int n;
    static Integer[] rDp;
    static Integer[] lDp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        data = new int[n];
        // LIS DP
        rDp = new Integer[n];
        // LDS DP
        lDp = new Integer[n];

        String[] readData = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(readData[i]);
        }

        for (int i = 0; i < n; i++) {
            LIS(i);
            LDS(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(rDp[i] + lDp[i], max);
        }
        System.out.println(max-1);

    }
    // LIS(가장 긴 증가하는 부분 수열)
    public static int LIS(int index){
        // 베이스조건
        if(index == n)
            return 1;
        // 백트래킹
        if(rDp[index] != null)
            return rDp[index];
        rDp[index] = 1;
        for (int i = index-1; i >= 0; i--) {
            // 이전의 노드 중 data[N]의 값보다 작은 걸 발견했을 경우
            if(data[i] < data[index])
                rDp[index] = Math.max(rDp[index],LIS(i)+1);
        }
        return rDp[index];
    }

    // LDS(가장 긴 감소하는 부분 수열)
    public static int LDS(int index){
        // 베이스조건
        if(index == n)
            return 1;
        // 백트래킹
        if(lDp[index] != null)
            return lDp[index];
        lDp[index] = 1;
        // index 이후 노드들을 탐색
        for (int i = index+1; i < lDp.length; i++) {
            // 이전의 노드 중 data[N]의 값보다 작은 걸 발견했을 경우
            if(data[i] < data[index])
                lDp[index] = Math.max(lDp[index],LDS(i)+1);
        }
        return lDp[index];
    }
}
