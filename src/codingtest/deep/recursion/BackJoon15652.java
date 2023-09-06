package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 중복허용
 * 오름차순의 데이터만 가능
 * - 이전 인덱스부터 시작해서 for문을 돌려 재귀하며 값 저장
 */
public class BackJoon15652 {
    public static int n;
    public static int m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[m];
        recursion(0,1);
        System.out.println(sb.toString());
    }
    public static void recursion(int count, int prevIndex){
        // 베이스 조건
        if(count == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = prevIndex; i < n+1; i++) {
            arr[count] = i;
            recursion(count+1,i);
        }
    }
}

