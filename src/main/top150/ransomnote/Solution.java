package ransomnote;

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
}
