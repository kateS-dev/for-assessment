package isIsomorphic;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Different lengths cannot be isomorphic.
        if(s.length() != t.length()) {
            return false;
        }

        // map stores the mapping from chars in s -> chars in t.
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if(!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i))) {
                return false;
            }

            map.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }

    // Refactored O(n) two-map version:
    //
    // public boolean isIsomorphic(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //
    //     Map<Character, Character> sToT = new HashMap<>();
    //     Map<Character, Character> tToS = new HashMap<>();
    //
    //     for (int i = 0; i < s.length(); i++) {
    //         char a = s.charAt(i);
    //         char b = t.charAt(i);
    //
    //         Character mappedB = sToT.get(a);  // what a maps to, or null
    //         Character mappedA = tToS.get(b);  // what maps to b, or null
    //
    //         if (mappedB == null && mappedA == null) {
    //             // First time seeing both — record mapping in both directions.
    //             sToT.put(a, b);
    //             tToS.put(b, a);
    //         } else if (mappedB == null || mappedA == null || mappedB != b) {
    //             // One side is mapped but not the other (collision), or
    //             // a is already mapped to a different char.
    //             return false;
    //         }
    //         // else: both already consistent, do nothing.
    //     }
    //
    //     return true;
    // }
}
