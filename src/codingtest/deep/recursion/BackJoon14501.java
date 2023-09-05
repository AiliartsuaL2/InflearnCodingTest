package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든날에 상담을 하거나 안하거나 모든 경우의 수를 확인
 */
public class BackJoon14501 {
    public static int n;
    public static int[][] interview;
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        interview = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            interview[i][0] = Integer.parseInt(s[0]);
            interview[i][1] = Integer.parseInt(s[1]);
        }

        recursion(0,0);
        System.out.println(answer);
    }
    public static void recursion(int index, int price){
        if(index > n){
            return;
        }
        if(index == n){
            answer = Math.max(answer,price);
            return;
        }
        // 상담을 한다면
        recursion(index+interview[index][0],price+interview[index][1]);
        // 상담을 안한다면
        recursion(index+1,price);
    }
}
