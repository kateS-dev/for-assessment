package textjustification;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution so = new Solution();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {"What","must","be","acknowledgment","shall","be"};
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 16;
        List<String> st = so.fullJustify(words, maxWidth);
        System.out.println(st);

       /*
            [
                "This    is    an",
                "example  of text",
                "justification.  "
            ]
        */
    }
}
