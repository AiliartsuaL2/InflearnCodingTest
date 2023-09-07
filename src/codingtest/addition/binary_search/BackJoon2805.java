package codingtest.addition.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        String[] s2 = br.readLine().split(" ");
        Long[] forest = new Long[n];
        for (int i = 0; i < n; i++) {
            forest[i] = Long.parseLong(s2[i]);
        }
        Arrays.sort(forest);
        long s = 1;
        long e = forest[n-1];

        while(s <= e){
            long mid = (s+e) / 2 ;
            int wood = 0;
            // 나무를 몇m 채취했는지 확인
            for (long tree : forest) {
                if( tree >= mid){
                    wood += tree-mid;
                }
            }
            // 나무보다 많다면 s를 증가
            if(wood >= m){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        System.out.println(e);
    }
}
