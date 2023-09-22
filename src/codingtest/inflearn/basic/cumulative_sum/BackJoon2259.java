package codingtest.inflearn.basic.cumulative_sum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 누적합 (기억)
 * 이전에 풀었던 작업을 저장해서 꺼내서 추가하는 연산을 통해 최적화를 한다.
 * prefix라는 배열을 만들어 해당 배열에 연산에대한 결과를 추가해줌.
 */
public class BackJoon2259 {
    /**
     * 길이와 간격이 주어지면, 해당 간격의 합 중 최대값을 출력하는 문제
     *
     * A와 B사이의 간격간의 크기를 구하기 위해서는
     * 1부터 B까지의 거리에서 1부터 A-1까지의 거리를 빼주면 A와 B사이의 크기가 나옴.
     */
    public static void main(String[] args) throws IOException {
        // prefix를 우리가 알고있는 크기보다 1칸 크게 만들고, 0 이후부터 넣어줌
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] condition = br.readLine().split(" ");
        int length = Integer.parseInt(condition[0]);
        int interval = Integer.parseInt(condition[1]);
        String[] s = br.readLine().split(" ");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] prefix = new int[length+1];
        for (int i = 0; i < length; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }
        List<Integer> answerList = new ArrayList<>();
        for (int i = interval; i < length+1 ; i++) {
            answerList.add(prefix[i]-prefix[i-interval]);
        }
        Integer maxValue = answerList.stream().max(Integer::compareTo).get();
        System.out.println("maxValue = " + maxValue);
    }
}
