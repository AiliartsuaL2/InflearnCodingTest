package codingtest.inflearn.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N과 M이 주어질경우, 1부터 N까지 중복없이 길이가 M인 수열
 */
public class BackJoon15650 {
    static int n;
    static int m;
    static List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        recursion(0,1);

    }
    public static void recursion(int count,int nextIndex){
        // 베이스조건
        if(count == m){
            for (int i = 0; i < answerList.size(); i++) {
                System.out.print(answerList.get(i)+" ");
            }
            System.out.println("");
            return;
        }
        // 재귀 호출
        for (Integer i = nextIndex; i < n + 1; i++) {
            if(answerList.contains(i))
                continue;
            answerList.add(i);
            recursion(count+1,i);
            answerList.remove(i);
        }
    }
}
