package codingtest.inflearn.addition.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 만약 최대 용량보다 크거나 같다면 그냥 count +=1
 * 두개의 남은 용량을 합쳐서 x/2 이상이면 두 병을 제거하고 cnt+1
 * 만약 조건에 맞지 않다면 짜투리로 넣어준다.
 * 또한 투포인터가 만났다면.. 그것도 짜투리로 넣어준다.
 * 짜투리가 3개가 만나면 무조건 1병이 되니까 이것도 추가해줘야함.
 */
public class BackJoon22988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long x = Long.parseLong(s[1]);

        String[] s1 = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(s1[i]);
        }
        Arrays.sort(arr);
        int a = 0;
        int b = n-1;
        int count = 0;
        // 남은 용기 수
        int remain = n;
        while(a < b){
            long eA = arr[a];
            long eB = arr[b];
            // 만약 같은 용량이라면 해당 병을 제거해주고 count +1
            if(eB == x){
                count ++;
                b-=1;
                remain -=1;
                continue;
            }
            // 만나는순간 짜투리 추가
            if(a==b){
                break;
            }
            // 만약 합쳐서 한 병이 되면 둘 다 제거
            if(eA+eB+(x/2) >= x){
                count ++;
                a += 1;
                b -= 1;
                remain -=2;
                // 아니면 작은 수를 올려버림
            }else{
                a+=1;
            }
        }
        // 남은 용기가 3병 이상인 경우,, 짜투리 3병을 합치면 무조건 한병이 됨.
        if(remain >= 3){
            count += (remain/3);
        }
        System.out.println(count);


    }
}
