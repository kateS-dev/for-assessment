package validAnagram;

public class Main {
    /*
    Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true
    Example 2:
        Input: s = "rat", t = "car"
        Output: false*/
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.isAnagram("anagram", "nagaram"));  //true
        System.out.println(so.isAnagram("rat", "car"));  // false
    }
}
