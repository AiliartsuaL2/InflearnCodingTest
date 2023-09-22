package codingtest.inflearn.basic.number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 공약수열
 * 1. 완전탐색
 * 2. 정수론
 */
public class BackJoon14252 {
    // 두 수를 비교해서 공약수가 1이면 pass, 아니면 non pass
    // 숫자를 하나 추가하거나 두개를 추가하면됨.
    // - 하나 추가하는경우
    //      완탐으로, 양 옆을 확인하면 가능
    // - 두 개를 추가하는 경우
    //      하나가 아니면 두개추가하면 가능 (귀납법에의해 가능)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        List<Integer> inputList = new ArrayList<>();
        for (String number : numbers) {
            inputList.add(Integer.parseInt(number));
        }

        List<Integer> sortedList = inputList.stream().sorted().collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < sortedList.size()-1; i++) {
            int a = sortedList.get(i);
            int b = sortedList.get(i+1);
            if(gcd(a,b) == 1){
                continue;
            }
            for (int j = a; j <b ; j++) {
                if(gcd(a,j) == 1){
                    if(gcd(b,j) == 1){
                        count ++;
                        break;
                    }
                }
                if(j == b-1)
                    count +=2;
            }
        }
        System.out.println(count);
    }
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

}
