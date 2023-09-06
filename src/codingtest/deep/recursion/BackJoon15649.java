package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * N과 M이 주어질경우, 1부터 N까지 중복없이 길이가 M인 수열
 */
public class BackJoon15649 {
    static int n;
    static int m;
    static List<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        recursion(0);
    }
    public static void recursion(int cnt){
        if(cnt == m){
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println("");
            return;
        }
        for (Integer i = 1; i < n+1; i++) {
            if(arrayList.contains(i))
                continue;
            arrayList.add(i);
            recursion(cnt+1);
            arrayList.remove(i);
        }
    }
}
