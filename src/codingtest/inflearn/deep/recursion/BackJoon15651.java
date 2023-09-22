package codingtest.inflearn.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 중복 허용하는 수열 출력
 */
public class BackJoon15651 {
    public static int n;
    public static int m;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[m];
        recursion(0);
        System.out.println(sb.toString());
    }
    public static void recursion(int count){
        if(count == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < n+1; i++) {
            arr[count] = i;
            recursion(count+1);
        }
    }
}
