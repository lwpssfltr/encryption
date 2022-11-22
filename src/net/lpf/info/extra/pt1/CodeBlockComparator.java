package net.lpf.info.extra.pt1;

import java.util.Comparator;

public class CodeBlockComparator implements Comparator<CodeBlock> {
    
    @Override
    public int compare(CodeBlock c1, CodeBlock c2) {
        if (c1.getPassLetter() == c2.getPassLetter()) {
            return 0;
        }
        else if (c1.getPassLetter() < c2.getPassLetter()) {
            return -1;
        }
        else return 1;
    }
}
