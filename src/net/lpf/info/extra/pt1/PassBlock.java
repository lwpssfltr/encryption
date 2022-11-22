package net.lpf.info.extra.pt1;

import java.util.Arrays;

public class PassBlock {
    
        private PassLetter[] letters;
        
        public PassBlock(char[] pass) {
            initLetters(pass);
        }

        private void initLetters(char[] pass) {
            letters = new PassLetter[pass.length];
            for(int i = 0; i < pass.length; i++) {
                letters[i] = new PassLetter(i, pass[i]);
            }
        }
        public PassLetter getPassLetterAt(int i) {
            return this.letters[i];
        }
        public int length() {
            return letters.length;
        }
        public void sortByChars() {
            Arrays.parallelSort(letters, new PassLetterCharComparator());
        }
        public void sortByKeys() {
            Arrays.parallelSort(letters, new PassLetterKeyComparator());
        }
    }
