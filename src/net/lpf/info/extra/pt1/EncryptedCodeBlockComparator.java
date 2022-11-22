package net.lpf.info.extra.pt1;

import java.util.Comparator;

public class EncryptedCodeBlockComparator implements Comparator <EncryptedCodeBlock> {

        @Override
        public int compare(EncryptedCodeBlock t1, EncryptedCodeBlock t2) {
            if (t1.getPassLetter().getKey() == t2.getPassLetter().getKey()){
                return 0;
            }
            else if (t1.getPassLetter().getKey() < t2.getPassLetter().getKey()){
                return -1;
            }
            else return 1;
        }
        
    }
