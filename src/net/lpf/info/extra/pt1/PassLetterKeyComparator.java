package net.lpf.info.extra.pt1;

import java.util.Comparator;

public class PassLetterKeyComparator implements Comparator<PassLetter>{

        @Override
        public int compare(PassLetter t1, PassLetter t2) {
            if (t1.getKey() == t2.getKey()){
                return 0;
            }
            else if (t1.getKey() < t2.getKey()){
                return -1;
            }
            else return 1;
        }      
    }
