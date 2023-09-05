package codingtest.deep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * (단지탄비)영양소의 일정 이상값을 채우고
 * 비용이 최소가 되는 경우의 수
 * 재료를 탐색하면서 최소값
 */
public class BackJoon19942 {

    public static int n;
    public static int [] minNutrient;
    public static int[][] foodInfo;
    public static int[] costArr ;
    public static boolean[] selectedArr;
    public static boolean isStaisfied = false;
    public static int cost = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        minNutrient = new int[4];
        foodInfo = new int[n][4];
        costArr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            minNutrient[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            foodInfo[i][0] = Integer.parseInt(split[0]);
            foodInfo[i][1] = Integer.parseInt(split[1]);
            foodInfo[i][2] = Integer.parseInt(split[2]);
            foodInfo[i][3] = Integer.parseInt(split[3]);
            costArr[i] = Integer.parseInt(split[4]);
        }

        int[] ints = new int[4];
        boolean [] isSelected = new boolean[n];
        recursion(0,ints,0,0,isSelected);
        if(isStaisfied == true){
            System.out.println(cost);
            for (int i = 0; i < n; i++) {
                if(selectedArr[i])
                    System.out.print(i+1+" ");
            }
        }else{
            System.out.println(-1);
            System.out.println();

        }

    }
    public static void recursion(int idx, int[] nutrient, int nowCost, int use, boolean[] isSelected){
        // 베이스조건
        if(idx == n){
            if(use == 0)
                return;
            if(nutrient[0] >= minNutrient[0] &&
                    nutrient[1] >= minNutrient[1] &&
                    nutrient[2] >= minNutrient[2] &&
                    nutrient[3] >= minNutrient[3]){
                isStaisfied = true;
                int tmpCost = cost;
                cost = Math.min(cost,nowCost);
                if(tmpCost != cost){
                    selectedArr = isSelected;
                }
            }
            return;
        }
        int[] useFood = new int[4];
        for (int i = 0; i < 4; i++) {
            useFood[i] = nutrient[i]+foodInfo[idx][i];
        }
        boolean [] notSelected = isSelected;
        isSelected[idx] = true;
        // 음식을 사용 하는 경우
        recursion(idx+1, useFood,nowCost+costArr[idx], use+1,isSelected);
        // 음식을 사용하지 않는 경우
        recursion(idx+1, nutrient,nowCost, use,notSelected);
    }
}
