package ransomnote;

// import java.util.HashMap;
// import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            int index = c - 'a';
            freq[index]++;
        }
        for (char c : ransomNote.toCharArray()) {
            int index = c - 'a';
            freq[index]--;
            if (freq[index] < 0) return false;
        }
        return true;
    }

    // HashMap version (same logic, but uses Map instead of int[26])
    // public boolean canConstruct(String ransomNote, String magazine) {
    //     Map<Character, Integer> freq = new HashMap<>();
    //     for (char c : magazine.toCharArray()) {
    //         freq.put(c, freq.getOrDefault(c, 0) + 1);
    //     }
    //     for (char c : ransomNote.toCharArray()) {
    //         int count = freq.getOrDefault(c, 0) - 1;
    //         if (count < 0) return false;
    //         freq.put(c, count);
    //     }
    //     return true;
    // }
}
