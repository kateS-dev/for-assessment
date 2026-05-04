package ransomnote;

public class Main {
    public static void main(String[] args) {
        Solution so = new Solution();

        boolean res1 = so.canConstruct("a", "b");
        boolean res2 = so.canConstruct("aa", "ab");
        boolean res3 = so.canConstruct("aa", "aab");

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
