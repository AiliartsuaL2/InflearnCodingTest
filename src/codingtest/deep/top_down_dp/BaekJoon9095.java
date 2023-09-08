package codingtest.deep.top_down_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9095 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            int recursion = recursion(0);
            System.out.println(recursion);
        }


    }
    public static int recursion(int nowNum){
        if(nowNum > n){
            return 0;
        }
        if(nowNum == n)
            return 1;
        int sum = 0;

        sum+=recursion(nowNum+1);
        sum+=recursion(nowNum+2);
        sum+=recursion(nowNum+3);
        return sum;
    }
}
