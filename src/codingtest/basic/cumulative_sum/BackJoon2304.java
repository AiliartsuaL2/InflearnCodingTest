package codingtest.basic.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 완탐
 * 누적합
 * 투포인터
 * 를 이용해서 풀 수 있음
 */
public class BackJoon2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);
            Point point = new Point(l, h);
            pointList.add(point);
        }
        List<Point> sortedList = pointList.stream().sorted(Comparator.comparing(Point::getL)).collect(Collectors.toList());
        Point maxPoint = pointList.stream().max(Comparator.comparing(Point::getH)).get();
        int start = sortedList.get(0).getL();
        int end = sortedList.get(sortedList.size() - 1).getL();
        int[] prefix = new int[maxPoint.getL()-start+1];
        int[] suffix = new int[end-maxPoint.getL()+1];
        int listIdx = 0;
        int maxH = 0;
        int arrIdx = start;
        // start부터 중간값 왼쪽앞까지 누적합 추가
        for (int i = 0; i < prefix.length-1; i++) {
            // 실제로 있는 값
            if(sortedList.get(listIdx).getL() == arrIdx){
                // 새로운 값이 이전 값보다 크면 maxH로 설정
                if(maxH < sortedList.get(listIdx).getH()){
                    maxH = sortedList.get(listIdx).getH();
                }
                listIdx++;
            }
            int h = maxH;
            prefix[i+1] = prefix[i]+h;
            arrIdx ++;
        }

        // end부터 중간값 왼쪽미포함까지
        maxH = 0;
        listIdx = sortedList.size()-1;
        arrIdx = end;
        for (int i = 0; i < suffix.length-1; i++) {
            // list의 index가 탐색하는 배열의 index와 같다면
            if(sortedList.get(listIdx).getL() == arrIdx){
                if(maxH < sortedList.get(listIdx).getH()){
                    maxH = sortedList.get(listIdx).getH();
                }
                listIdx--;
            }
            int h = maxH;
            suffix[i+1] = suffix[i] + h;
            arrIdx --;
        }
        int prefixResult = prefix[prefix.length - 1];
        int suffixResult = suffix[suffix.length - 1];
        int result = prefixResult+suffixResult+ maxPoint.getH();
        System.out.println(result);
    }

}
class Point{
    private int l;
    private int h;

    public Point(int l, int h) {
        this.l = l;
        this.h = h;
    }

    public int getL() {
        return l;
    }

    public int getH() {
        return h;
    }
}
