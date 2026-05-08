package isIsomorphic;

public class Main {
    public static void main(String[] args) {
        Solution so = new Solution();
        String a = "badc";
        String b = "baba";
        boolean check = so.isIsomorphic(a, b);
        System.out.println(check);
    }
}
