package net.lpf.info.extra.pt1;

public class CodeBlock {
        
        private final char passLetter;
        private final char[] column;
        
        public CodeBlock(char passLetter, char[] column) {
            this.column = column;
            this.passLetter = passLetter;
        }
        
        public char[] getColumn() {
            return this.column;
        }
        public char getPassLetter() {
            return this.passLetter;
        }
    }
