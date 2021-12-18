package com.ktb.codewar;

import java.util.ArrayList;
import java.util.List;

public class SupermarketQueue {

    public static void main(String[] args) {
        int[] customers = new int[]{10, 2, 3, 3};
        int i = solveSuperMarketQueue(customers, 2);
        System.out.println("i:" + i);
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        ArrayList<ArrayList> result = new ArrayList<ArrayList>();
        for (int i = 0; i < n; i++) {
            ArrayList item = new ArrayList<Integer>();
            result.add(item);
        }
        System.out.println("length:"+result.size());
        for (int i = 0; i < customers.length; i++) {
            int k = customers[i];
            int index = i % n;
            ArrayList list = result.get(index);
            if (list.isEmpty()) {
                list.add(k);
            } else {
                int target_index = getSamllIndex(result);
                list = result.get(target_index);
                list.add(k);
            }
        }
        return getBigIndex(result);
    }

    private static int getSamllIndex(ArrayList<ArrayList> result) {
        int index = 0;
        int sum = sum(result.get(0));
        for (int i = 0; i < result.size(); i++) {
            ArrayList list = result.get(i);
            if (sum(list) < sum) {
                sum = sum(list);
                index = i;
            }
        }
        return index;
    }

    private static int getBigIndex(ArrayList<ArrayList> result) {
        int sum = sum(result.get(0));
        for (int i = 0; i < result.size(); i++) {
            ArrayList list = result.get(i);
            if (sum(list) > sum) {
                sum = sum(list);
            }
        }
        return sum;
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list)
            sum = sum + i;
        return sum;
    }


}
