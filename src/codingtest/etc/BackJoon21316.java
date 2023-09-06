package codingtest.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        System.out.println(map);
    }
}
