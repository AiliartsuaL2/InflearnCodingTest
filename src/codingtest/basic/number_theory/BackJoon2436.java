package codingtest.basic.number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int gcd = gcd(a, b);
        int lcm = lcm(a, b);
        System.out.println(gcd+" "+lcm);

    }
    /**
     * 최대공약수
     * GCD (12,8)은
     * GCD (8, 12-8)로 다시 정의 할 수 있다.
     * >> GCD (A,B) 는 GCD(A-(B-A),B-A) 로 설정 가능
     * 1. 두 수의 최대공약수는 간격을 최소한까지 줄여도 동일하다.
     * 2. 최대 공약수라는 말은 두 수중 하나로 나누어 나머지가 생기지 않는 작은 수
     *      작은수로 큰 수를 나눌 때 나머지가 생기지 않는 수
     * 3. 한 수를 가능한 만큼 갭을 줄인다.
     *     하나의 수를 작은수로 되는 만 큼 뺀다,, 나누고 나서 나머지 !
     *     121-7-7-7-7-7-7-7....
     *     121 % 7이 됨.
     */
    public static int gcd(int a,int b){
        // 나머지가 0이 되는순간 종료,, 최대 공약수가 되는순간 ! break
        while(a%b > 0){
            // a를 b로 나눈 나머지값을 찾아서( 갭을 줄이면서)
            // a와 b의 위치를 바꾸는 것을 반복
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return b;
    }
    /**
     * 최소공배수
     * A*B를 최대공약수로 나눠주면, 최소공배수가 된다.
     */
    public static int lcm(int a,int b){
       return (a*b) / gcd(a,b);
    }
}
