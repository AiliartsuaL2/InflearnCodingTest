package codingtest.addition.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon14502 {
    public static int n;
    public static String[] words;
    public static String[] targetArr;
    public static String target;
    public static int min;
    public static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String begin = s[0];
        target = s[1];

        words = br.readLine().split(" ");
        int answer = 0;
        n = words.length;
        visited = new boolean[n];
        targetArr = target.split("");
        recursion(0, begin,0);
        System.out.println(min);

    }
    public static void recursion(int index,String nowWord,int count){
        if(nowWord.equals(target)){
            if(min > count)
                min = count;
            return;
        }
        if(index == n)
            return;
        if(visited[index]){
            return;
        }
        visited[index] = true;
        String[] wordsArr = words[index].split("");
        for(int i=0; i<nowWord.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(nowWord.substring(0,i));
            sb.append(wordsArr[i]);
            sb.append(nowWord.substring(i+1,nowWord.length()));
            String nextWord = sb.toString();
            if(checkOneDefference(nowWord,nextWord)){
                recursion(index+1,nowWord,count);
                recursion(index+1,nextWord,count+1);
            }else{
                recursion(index+1,nowWord,count);
            }
        }
    }
    public static boolean checkOneDefference(String a, String b){
        if(a.length() != b.length())
            return false;
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1;
    }
}
