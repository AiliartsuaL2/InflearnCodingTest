package codingtest.basic.bruteforce;

import java.io.*;
public class BruteForce3 {
    public static void main(String[] args) throws IOException {
        // 엔터로 구분해서 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] coe = br.readLine().split(" ");
// 백준 문제는 입력을 띄어쓰기로 구분하는 경우가 있기 때문에 StringTokenizer 사용

        int a = Integer.parseInt(coe[0]);
        int b = Integer.parseInt(coe[1]);
        int c = Integer.parseInt(coe[2]);
        int d = Integer.parseInt(coe[3]);
        int e = Integer.parseInt(coe[4]);
        int f = Integer.parseInt(coe[5]);

        StringBuilder sb = new StringBuilder();
        boolean isBreak = false;
        // a와 d의 최소공배수를 구하고 그에 맞추어 각 방정식에 곱셈을 해주고, y값을 도출해낸다.
        for(int x=-999; x < 1000; x++){
            for (int y = -999; y <1000 ; y++) {
                if((a*x + b*y) == c && (d*x + e*y) == f){
                    isBreak = true;
                    sb.append(x+" "+y);
                    break;
                }
            }
            if(isBreak)
                break;
        }

        System.out.println(sb.toString());
    }
}
