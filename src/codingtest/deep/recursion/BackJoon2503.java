package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자야구 재귀함수 버전
 * - 완전탐색
 *      strike , ball 카운트를 A라는 친구가 생각 할 수 있는 정답의 범위를 모두 때려박았음
 * - 재귀함수
 *
 */
public class BackJoon2503 {
    public static int answer;
    public static int n;
    public static int[] hintArr;
    public static int[] strikeArr;
    public static int[] ballArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hintArr = new int[n];
        strikeArr = new int[n];
        ballArr = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int hint = Integer.parseInt(s[0]);
            int strikeCount = Integer.parseInt(s[1]);
            int ballCount = Integer.parseInt(s[2]);
            hintArr[i] = hint;
            strikeArr[i] = strikeCount;
            ballArr[i] = ballCount;
        }

        answer = 0;
        // 100번부터 탐색시작 힌트는 0번부터 탐색시작
        recursion(0,100);
        System.out.println(answer);

    }

    /**
     * 힌트 순서와 몇번째 숫자를 확인하고있는지 넘겨줌
     */
    public static void recursion(int hintIdx,int number){
        // 이전에 호출한 recursion이 마지막 힌트였다면 (다 통과했기 때문에) return해줌
        if(hintIdx == n){
            answer += 1;
            // 힌트에 통과하더라도, 다음수를 확인해줘야함(count를 세라고했으니)
            recursion(0,number+1);
            return;
        }
        // 전체를 확인했는데 없었으면 루프 종료
        if(number == 1000){
            return;
        }
        // 만약 힌트에 통과했다면, 재귀함수 호출
        // 스트라이크, 볼카운트가 동일하다면 재귀함수 호출하여 다음 힌트로 넘어감
        if(strikeCheck(hintArr[hintIdx],number,strikeArr[hintIdx]) &&
                ballCheck(hintArr[hintIdx],number,ballArr[hintIdx])){
            recursion(hintIdx+1,number);
        }else{
            // 만약 힌트에 통과하지 않았다면 다음 숫자를 확인하여 힌트를 처음으로 체크하여 확인.
            recursion(0,number+1);
        }
    }
    public static boolean strikeCheck(int number, int compareNumber,int strikeCount){
        int count = 0;
        int one = number % 10;
        number /= 10;
        int ten = number % 10;
        number /= 10;
        int hund = number % 10;

        int compareOne = compareNumber % 10;
        compareNumber /= 10;
        int compareTen = compareNumber % 10;
        compareNumber /= 10;
        int compareHund = compareNumber % 10;
        if(one == compareOne){
            count++;
        }if(ten == compareTen){
            count++;
        }if(hund == compareHund){
            count++;
        }
        return strikeCount==count;
    }
    public static boolean ballCheck(int number, int compareNumber, int ballCount){
        int count = 0;
        int one = number % 10;
        number /= 10;
        int ten = number % 10;
        number /= 10;
        int hund = number % 10;

        int compareOne = compareNumber % 10;
        compareNumber /= 10;
        int compareTen = compareNumber % 10;
        compareNumber /= 10;
        int compareHund = compareNumber % 10;

        if(one == compareTen || one == compareHund){
            count++;
        }
        if(ten == compareOne || ten == compareHund){
            count++;
        }
        if(hund == compareTen || hund == compareOne){
            count++;
        }
        return ballCount == count;
    }
}
