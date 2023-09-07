package codingtest.addition.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 이진탐색
 * - 쉽고 어려운 문제..
 * - sorting해서 가운데 확인하고, 크면 오른쪽 반으로 쪼개서 가운데,, 이렇게
 */
public class BackJoon10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        int m = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");


        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            int purpose = Integer.parseInt(s2[i]);
            int s = 0;
            int e = n-1;
            boolean isRight = false;
            while(s <= e){
                int mid = (s+e)/2;
                if(arr[mid] == purpose){
                    isRight = true;
                    break;
                }
                // 현재 값보다 작다면 좌측 탐색 >> End를 mid-1로
                if(arr[mid] > purpose){
                    e = mid-1;
                    //현재 값보다 크다면 우측 탐색,
                }else if(arr[mid] < purpose){
                    s = mid+1;
                }
            }
            if(isRight)
                stringBuilder.append(1+" ");
            else
                stringBuilder.append(0+" ");
        }
        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1).toString());
    }
}
