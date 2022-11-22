package net.lpf.info.extra.pt1;

public class PassLetter {
        
        private char passLetter;
        private int key;
        
        public PassLetter(int key, char passLetter) {
            this.key = key;
            this.passLetter = passLetter;
        }

        int getKey() {
            return this.key;
        }
        
        char getLetter() {
            return this.passLetter;
        }
    }
