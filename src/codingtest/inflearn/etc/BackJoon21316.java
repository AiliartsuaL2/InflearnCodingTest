package codingtest.inflearn.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BackJoon21316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            String[] s = br.readLine().split(" ");
            int key = Integer.parseInt(s[0]);
            int value = Integer.parseInt(s[1]);
            List<Integer> keyList = map.getOrDefault(key, new ArrayList<>());
            List<Integer> valueList = map.getOrDefault(value, new ArrayList<>());
            keyList.add(value);
            valueList.add(key);
            map.put(key,keyList);
            map.put(value,valueList);
        }
        int answerNumber = 0;
        for (Integer key : map.keySet()) {
            List<Integer> valueList = map.get(key);
            // value에 인접한 별들의 개수가 3인 number만 뽑아서
            if(valueList.size() == 3){
                // sort한 value가 1,2,3 인경우
                List<Integer> answerList = Arrays.asList(1, 2, 3);
                List<Integer> valueSizeList = new ArrayList<>();
                for (Integer value : valueList) {
                    valueSizeList.add(map.get(value).size());
                }
                List<Integer> sortedList = valueSizeList.stream().sorted().collect(Collectors.toList());
                boolean isRight = true;
                for (int i = 0; i < 3; i++) {
                    if(answerList.get(i) != sortedList.get(i)){
                        isRight = false;
                    }
                }
                if(isRight){
                    answerNumber = key;
                    break;
                }
            }
        }
        System.out.println(answerNumber);

    }
}
