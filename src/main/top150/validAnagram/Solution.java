package validAnagram;

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        if(s.length() != t.length()) {
            return false;
        }

        // store char and frequency
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
        }

        // check char and frequency
        for(int j = 0; j < s.length(); j++) {
            char tChar = t.charAt(j);
            map.put(tChar, map.getOrDefault(tChar, 0) - 1);

            if(map.getOrDefault(tChar, 0) == 0) {
                map.remove(tChar);
            }
        }

        if(!map.isEmpty()) {
            return false;
        }

        return true;
    }
}
