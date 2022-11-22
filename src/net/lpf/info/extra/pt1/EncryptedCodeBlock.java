package net.lpf.info.extra.pt1;

public class EncryptedCodeBlock {
        
        private PassLetter passLetter;
        private char[] column;
        
        public EncryptedCodeBlock(PassLetter passLetter, char[] column) {
            this.column = column;
            this.passLetter = passLetter;
        }
        public PassLetter getPassLetter() {
            return this.passLetter;
        }
        public char getCharAt(int i) {
            return this.column[i];
        }
    }
