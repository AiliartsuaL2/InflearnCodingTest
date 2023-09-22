package codingtest.inflearn.addition.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 투포인터 : 가능성을 지워주는 방법
 *
 */
public class BackJoon3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int purpose = Integer.parseInt(br.readLine());
        int a = 0;
        int b = n-1;
        Arrays.sort(arr);
        int answer = 0;
        while(a < b){
            int result = arr[a]+arr[b];
            if(result == purpose){
                answer += 1;
                a+=1;
                continue;
            }
            if(result < purpose)
                a+=1;
            else{
                b-=1;
            }
        }
        System.out.println(answer);
    }
}
