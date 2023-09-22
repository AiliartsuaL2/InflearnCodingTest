package codingtest.inflearn.basic.bruteforce;

import java.io.*;

public class BruteForce4 {
    public static void main(String[] args) throws IOException {
        // 엔터로 구분해서 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] hint = new int[n][3];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < 3; j++) {
                String[] record = s.split(" ");
                hint[i][j] = Integer.parseInt(record[j]);
            }
        }
        for (int i = 1; i < 10; i++) { // 100의자리수
            for (int j = 1; j < 10; j++) { // 10의자리수
                for (int k = 1; k < 10; k++) { // 1의자리수
                    if(i == j || j == k || k == i)
                        continue;
                    int cnt = 0;
                    for(int[] arr : hint){
                        int ballCount = 0;
                        int strikeCount = 0;
                        int number = arr[0];
                        int one = number % 10;
                        number /= 10;
                        int ten = number % 10;
                        number /= 10;
                        int hund = number % 10;
                        if(hund == i)
                            strikeCount ++;
                        if(ten == j)
                            strikeCount ++;
                        if(one == k)
                            strikeCount ++;

                        if(hund == j || hund == k)
                            ballCount ++;
                        if(ten == i || ten == k)
                            ballCount ++;
                        if(one == i ||one == j)
                            ballCount ++;

                        int strike = arr[1];
                        int ball = arr[2];
                        if(ball == ballCount && strike == strikeCount){
                            cnt ++;
                        }
                    }
                    if(cnt == n)
                        answer ++;
                }
            }

        }

        System.out.println(answer);
    }
}
