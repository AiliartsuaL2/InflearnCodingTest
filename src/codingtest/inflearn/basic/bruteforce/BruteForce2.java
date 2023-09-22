package codingtest.inflearn.basic.bruteforce;

import java.io.*;

public class BruteForce2 {
    public static void main(String[] args) throws IOException {
        // 엔터로 구분해서 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//// 백준 문제는 입력을 띄어쓰기로 구분하는 경우가 있기 때문에 StringTokenizer 사용
//        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        int n = Integer.parseInt(s);
        int cnt = 0;
        for (int a = 1; a < n; a++) {
            for(int i = 2; i < n-a; i++){
                int b = a+i;
                int c = n-a-b;
                if(a+2 <= b && c > 0 && c %2 != 1){
                    cnt++;
                }
            }
        }
        String cntStr = String.valueOf(cnt);
        System.out.println(cntStr);

//        StringTokenizer st = new StringTokenizer(sb.toString(),",");
//        while(st.countTokens()!=0)
//            bw.write(st.nextToken()+"\n");
//        bw.flush();
    }
}
