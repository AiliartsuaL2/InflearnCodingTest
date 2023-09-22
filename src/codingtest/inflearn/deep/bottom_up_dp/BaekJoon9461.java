package codingtest.inflearn.deep.bottom_up_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] triangle = new long[101];
        triangle[0] = 0;
        triangle[1] = 1;
        triangle[2] = 1;
        triangle[3] = 1;
        triangle[4] = 2;
        triangle[5] = 2;
        for (int i = 6; i <= 100; i++) {
            triangle[i] = triangle[i-1]+triangle[i-5];
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(triangle[n]);
        }
    }
}
