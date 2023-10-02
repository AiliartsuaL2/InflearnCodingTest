package codingtest.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] answer = new int[2];

        int zeroCount = removeZero(s);
        int sLength = s.length() - zeroCount;
        int count = 1;

        while(sLength > 1){
            String transedStr = Integer.toString(sLength,2);
            zeroCount += removeZero(transedStr);
            sLength -= zeroCount;
            count ++;
        }
        answer[0] = count;
        answer[1] = zeroCount;
    }
    private static int removeZero(String word){
        int count = 0;
        for(int i=0; i<word.length();i++){
            if(word.charAt(i) == '0')
                count++;
        }
        return count;
    }
}
