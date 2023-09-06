package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon15654 {
    public static int n;
    public static int m;
    // input된 수열
    public static int arr[];
    // 정답수열
    public static int[] answerArr;
    // 방문여부
    public static boolean visited[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        String[] inputArr = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(arr);
        answerArr = new int[m];
        visited = new boolean[n];
        recursion(0);
        System.out.println(sb.toString());
    }
    public static void recursion(int count){
        if(count == m){
            for (int i = 0; i < m; i++) {
                sb.append(answerArr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            // 방문여부를 체크해서
            if(!visited[i]){
                // 방문처리
                visited[i]= true;
                answerArr[count] = arr[i];
                recursion(count+1);
                visited[i] = false;
            }
        }
    }
}
