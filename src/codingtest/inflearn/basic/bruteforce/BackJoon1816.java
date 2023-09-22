package codingtest.inflearn.basic.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class BackJoon1816 {
    public static void main(String[] args) throws IOException {
        // 엔터로 구분해서 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

// 백준 문제는 입력을 띄어쓰기로 구분하는 경우가 있기 때문에 StringTokenizer 사용
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int n = Integer.parseInt(s);
        for (int i = 0; i < n; i++) {
            long password = Long.parseLong(br.readLine());
            boolean isBreak = true;
            for (int j = 2; j < Math.sqrt(1000000); j++) {
                // j가 password의 소수인경우
                if(password % j == 0){
                    sb.append("NO" + ",");
                    isBreak = false;
                    break;
                }
            }
            if(isBreak)
                sb.append("YES" + ",");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(),",");
        while(st.countTokens()!=0)
            bw.write(st.nextToken()+"\n");
        bw.flush();
    }
}
