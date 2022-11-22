package net.lpf.info.extra.pt1;

import java.util.Comparator;

public class PassLetterCharComparator implements Comparator<PassLetter>{

        @Override
        public int compare(PassLetter t1, PassLetter t2) {
            if (t1.getLetter() == t2.getLetter()){
                return 0;
            }
            else if (t1.getLetter() < t2.getLetter()){
                return -1;
            }
            else return 1;
        }      
    }
