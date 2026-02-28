package restorearray;

import java.util.*;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        // 1. build the graph
        for(int[] pair : adjacentPairs) {
            int num1 = pair[0];
            int num2 = pair[1];

            map.computeIfAbsent(num1, k -> new HashSet<>()).add(num2);
            map.computeIfAbsent(num2, k -> new HashSet<>()).add(num1);
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
        int len = adjacentPairs.length + 1;
        int[] res = new int[len];
        HashSet<Integer> check = new HashSet<>();

        res[0] = startNode;
        check.add(startNode);
        for (int i = 1; i < len; i++) {
            for (int num : map.get(startNode)) {
                if (!check.contains(num)) {
                    res[i] = num;
                    check.add(num);
                    startNode = num;
                }
            }
        }

        return res;
    }
}
