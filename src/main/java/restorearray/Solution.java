package restorearray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        Stack<Integer> res = new Stack<>();

        // 1. build the graph
        for(int[] pair : adjacentPairs) {
            int num1 = pair[0];
            int num2 = pair[1];

            if (map.containsKey(num1)) {
                Set<Integer> set = map.get(num1);
                if (!set.contains(num2)) {
                    set.add(num2);
                }
                map.put(num1, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(num2);
                map.put(num1, set);
            }

            if (map.containsKey(num2)) {
                Set<Integer> set = map.get(num2);
                if (!set.contains(num1)) {
                    set.add(num1);
                }
                map.put(num2, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(num1);
                map.put(num2, set);
            }
        }

        // 2. find the start node
        Set<Integer> start = map.keySet();
        int startNode = -1;
        for (int num : start) {
            if (map.get(num).size() == 1) {
                startNode = num;
                break;
            }
        }

        // 3. restore the array
        res.add(startNode);
        int len = (adjacentPairs.length - 1) * 2;
        while (res.size() < len) {
            for (int num : map.get(startNode)) {
                if (!res.contains(num)) {
                    res.add(num);
                    startNode = num;
                }
            }
        }

        // 4. to int[] array
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
