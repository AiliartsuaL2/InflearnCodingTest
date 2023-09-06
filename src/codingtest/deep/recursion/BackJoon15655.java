package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon15655 {
    public static int n;
    public static int m;
    public static int[] arr;
    public static int[] answerArr;
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
        recursion(0,0);
        System.out.println(sb.toString());
    }
    public static void recursion(int count, int prevIndex){
        // 베이스 조건 추가
        if(count == m){
            for (int i = 0; i < m; i++) {
                sb.append(answerArr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = prevIndex; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                answerArr[count] = arr[i];
                recursion(count+1,i);
                visited[i] = false;
            }
        }


    }
}
