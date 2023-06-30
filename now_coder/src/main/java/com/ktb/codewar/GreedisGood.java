package com.ktb.codewar;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class GreedisGood {

    public static void main(String[] args) {
        int[] dice = new int[]{3, 3, 3, 5, 1};
        int greedy = greedy(dice);
        System.out.println("greedy:" + greedy);
    }

    public static int greedy(int[] dice1) {
        HashMap standard = new HashMap<String, Integer>();
        standard.put("1_3", 1000);
        standard.put("6_3", 600);
        standard.put("5_3", 500);
        standard.put("4_3", 400);
        standard.put("3_3", 300);
        standard.put("2_3", 200);
        Arrays.sort(dice1);
        List<Integer> dice_list = Arrays.stream(dice1).boxed().collect(Collectors.toList());
        int n = 0;
        while (n <2){
            if(dice_list.get(0) !=  dice_list.get(1) || dice_list.get(1) !=  dice_list.get(2)){
                Integer remove = dice_list.remove(0);
                dice_list.add(remove);
            }
            n ++;
        }
        Integer[] dice = dice_list.toArray(new Integer[dice_list.size()]);
        System.out.println("dice:"+Arrays.toString(dice));
        int sum = 0;
        boolean is_including_three = false;
        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            String key = dice[0] + "_" + 3;
            sum += (int) standard.get(key);
            is_including_three = true;
        }

        System.out.println("sum1:"+sum);

        if (!is_including_three) {
            for (int i = 0; i < 3; i++) {
                if (dice[i] == 1) {
                    sum += 100;
                }
                if (dice[i] == 5) {
                    sum += 50;
                }
            }
        }
        System.out.println("sum2:"+sum);
        for (int i = 3; i < 5; i++) {
            if (dice[i] == 1) {
                sum += 100;
            }
            if (dice[i] == 5) {
                sum += 50;
            }
        }
        System.out.println("sum3:"+sum);
        return sum;
    }

}
