package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon15656 {
    public static int n;
    public static int m;
    public static int[] inputArr;
    public static int[] outputArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        n = Integer.parseInt(condition[0]);
        m = Integer.parseInt(condition[1]);
        String[] input = br.readLine().split(" ");
        inputArr = new int[n];
        outputArr = new int[m];
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(inputArr);
        recursion(0);
        System.out.println(sb.toString());
    }
    public static void recursion(int count){
        // 베이직 조건
        if(count == m){
            for (int i = 0; i < m; i++) {
                sb.append(outputArr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            outputArr[count] = inputArr[i];
            recursion(count+1);
        }
    }
}
