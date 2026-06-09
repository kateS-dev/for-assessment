package wordPattern;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> pToS = new HashMap<>();
        HashMap<String, Character> sToP = new HashMap<>();

        if(pattern.length() != s.split(" ").length) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            String word = s.split(" ")[i];

            String mappingS = pToS.get(a);
            Character mappingP = sToP.get(word);

            if(mappingS == null && mappingP == null) {
                pToS.put(a, word);
                sToP.put(word, a);
            } else if(mappingS == null || mappingP == null || !mappingS.equals(word)) {
                return false;
            }
        }

        return true;
    }

    /*
    // Optimized: one HashMap + "last-seen index" trick.
    //
    // Key idea: map.put(key, value) returns the PREVIOUS value associated
    // with that key (or null if it's new). If we record the current index i
    // for both the pattern char and the word at each step, then for a valid
    // bijection they must have been last seen at the SAME index.
    //
    // Because Character and String can never be equal as Map keys, a single
    // Map<Object, Integer> safely holds both sides — no collisions.
    //
    // Time:  O(n + m)  — one split, one pass, O(1) map ops.
    // Space: O(n + m)  — words[] + map entries.
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        java.util.Map<Object, Integer> lastSeen = new java.util.HashMap<>();
        for (Integer i = 0; i < pattern.length(); i++) {
            // Autoboxing matters: Integer (not int) so equals() compares values.
            Object prevChar = lastSeen.put(pattern.charAt(i), i);
            Object prevWord = lastSeen.put(words[i], i);
            if (!java.util.Objects.equals(prevChar, prevWord)) {
                return false;
            }
        }
        return true;
    }
    */
}
