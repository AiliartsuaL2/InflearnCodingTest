package codingtest.basic.number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        long start = Long.parseLong(numbers[0]);
        long end = Long.parseLong(numbers[1]);
        long startAns = checkBin(start-1);
        long endAns = checkBin(end);
        System.out.println(endAns-startAns);
    }

    /**
     * 2의 제곱의 개수를 구하는 메서드
     *
     */
    public static long checkBin(long n){
        // 2의 0승인 값들을 다 더해줌
        long answer = n;
        // 1부터 n까지의 2의 배수의 개수 구하는 공식은,
        // n(1부터 n까지 2의 0승) + n을 2의 배수만큼 나눠서 몫과 개수를 곱하고 sum.(2는 2의 개수가 1개, 4는 2의 개수가 2개, 8은 2의 개수가 4개 이런식으로 늘어감)
        for (long b = 2; b < n+1; b*=2) {
            answer += (b/2)*(n/b);
        }
        return answer;
    }
}
