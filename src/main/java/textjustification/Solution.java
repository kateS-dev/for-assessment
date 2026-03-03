package textjustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String handleSpaceInsertion(int maxWidth, int charactersLen, List<String> eachLine, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        int space = maxWidth - charactersLen;
        int gap = eachLine.size() - 1;
        int spacePer = gap > 0 ? space / gap : 0;
        int extraSpaces = space - spacePer * gap;

        if (eachLine.size() > 1 && !isLastLine) {
            for (int j = 0; j < eachLine.size(); j++) {
                sb.append(eachLine.get(j));

                // insert space
                if (j != eachLine.size() - 1) {
                    int len = spacePer;
                    for (int k = 0; k < len; k++) {
                        sb.append(" ");
                    }

                    if (j < extraSpaces) {
                        sb.append(" ");
                    }
                }
            }
        } else {
            for (int j = 0; j < eachLine.size(); j++) {
                sb.append(eachLine.get(j));
                if (j != eachLine.size() - 1) {
                    sb.append(" ");
                } else {
                    int len = maxWidth - sb.length();
                    for (int i = 0; i < len; i++) {
                        sb.append(" ");
                    }
                }
            }
        }

        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> eachLine = new ArrayList<>();
        int charactersLen = 0;

        for (int i = 0; i < words.length; i++) {
            int spaceLen = eachLine.size();
            if (charactersLen + spaceLen + words[i].length() > maxWidth) {
                String line = handleSpaceInsertion(maxWidth, charactersLen, eachLine, false);
                result.add(line);

                // new a line
                eachLine.clear();
                charactersLen = 0;
            }
            eachLine.add(words[i]);
            charactersLen += words[i].length();

            if (i == words.length - 1) {
                String line = handleSpaceInsertion(maxWidth, charactersLen, eachLine, true);
                result.add(line);
            }
        }

        return result;
    }
}
