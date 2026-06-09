package wordPattern;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // false
        System.out.println(solution.wordPattern("aba", "dog cat cat")); // false
    }
}
