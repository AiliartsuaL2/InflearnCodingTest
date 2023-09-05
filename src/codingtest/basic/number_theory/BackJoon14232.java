package codingtest.basic.number_theory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BackJoon14232 {
    public static void main(String[] args) throws IOException {
        /**
         * 해당 수의 최대공약수를 구하면 됨.
         * n의 제곱근만큼만 수를 더해서 확인
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        int c = 2;
        int cnt = 0;
        List<String> list = new ArrayList<>();
        while(k != 1) {
            if (c>=1000000) {
                list.add(k+"");
                cnt++;
                break;
            }
            if (k % c == 0) {
                k/=c;
                cnt++;
                list.add(c+"");
            }
            else {
                c++;
            }
        }


        System.out.println(cnt);
        System.out.println(String.join(" ", list));
    }
}
