package codingtest.programmers;

public class QuardZip {
    static int[] answer = new int[2];
    public static int[] solution(int[][] arr) {
        int totalSize = arr.length;
        dp(0,0,totalSize,arr);
        return answer;
    }

    private static boolean check(int x, int y, int size, int[][] arr){
        for(int i= x; i< x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[x][y] != arr[i][j]){ // 값이 하나라도 같지 않는다면
                    return false; // false 리턴
                }
            }
        }
        return true; // 값이 모두 다 같으면 true 리턴
    }


    // 상태 : 시작점 , 변의 길이 (x,y,size)
    // 부분문제 : 해당 상태가 나타내는 정사각형 범위를 압축 할 때, 남은 0의 개수와 1의 개수
    // 베이스 조건 : 범위 안 원소들이 모두 0이거나 1인경우 하나의 숫자로 압축
    // 점화식
    //  -  큰 정사각형을 4개의 작은 정사각형으로 나누고, 작은 정사각형을 압축한 결과를 모두 더한것이 큰 정사각형의 결과가 됨
    //  - 하나의 정사각형을 압축하려면, 4개의 작은 정사각형으로 나누고, 각 정사각형을 압축한 결과를 모두 더함(0과 1의 각각 개수)
    //  -
    private static void dp(int startX, int startY, int size, int[][] arr){
        if(check(startX,startY,size,arr)){ //모두 같은 값이면
            answer[arr[startX][startY]]++; // answer배열에 추가
            return;
        }
        dp(startX,startY,size/2,arr);
        dp(startX+(size/2),startY,size/2,arr);
        dp(startX,startY+(size/2),size/2,arr);
        dp(startX+(size/2),startY+(size/2),size/2,arr);
    }

    public static void main(String[] args) {
        int[][] input = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[] solution = solution(input);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
