package codingtest.basic.cumulative_sum;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackJoon1912 {
    /**
     * 수열의 길이 N과 수열이 주어졌을 때
     * 연속된 n개의 수를 자유롭게 선택하여 가장 큰 합을 출력하는 문제
     * DP로도 풀 수있지만, 누적합으로 풀 수 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] prefix = new int[n+1];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        for (int i = 0; i < n; i++) {
            // 더해가면서 새로나온값이 기존 누적값보다 큰지 체크해서 큰 값으로 넣음
            prefix[i+1] = Math.max(prefix[i]+arr[i],arr[i]);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 1; i < prefix.length; i++) {
            answerList.add(prefix[i]);
        }
        Integer result = answerList.stream().max(Integer::compareTo).get();
        System.out.println(result);
    }
}
