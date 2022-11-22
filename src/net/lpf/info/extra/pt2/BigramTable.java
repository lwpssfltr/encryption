package net.lpf.info.extra.pt2;

public class BigramTable {
    
    private final String ruChars = "абвгдежзийклмнопрстуфхцчшщьыъэюя";
    
    private String generateUniqueString(String in) {
        String out = "";
        for (char c : in.toCharArray()) {
            if (out.indexOf(c) < 0) {
                out += c;
            }
        }
        return out;
    }
    // filtering password from repetitions and generating the source table
    public String[] generatePassTab(String pass) {
        String pass0 = generateUniqueString(checkCyrillicLowercase(pass));
        String tmp = pass0.concat(this.ruChars);
        String[] tab0 = new String[4];
        for (int i = 0; i < tab0.length; i++) {
            tab0[i] = "";
        }
        String tab1 = generateUniqueString(tmp);
        for (int i = 0, k = 0; i < tab0.length; i++) {
            for (int j = 0; j < 8; j++, k++) {
                tab0[i] += tab1.charAt(k);
            }
        }
        return tab0;
    }
    // splitting text into letter pairs
    public String binaryPrepare(String openText) {
        String binaryPrepared = "";
        String binaryOut = checkCyrillicLowercase(openText);
        for (int i = 0; i < binaryOut.length() - 1; i += 2) {
            binaryPrepared += binaryOut.charAt(i);
            if (binaryOut.charAt(i) != binaryOut.charAt(i + 1)){
                binaryPrepared += binaryOut.charAt(i + 1);
            }
        }
        String out = binaryPrepared.length() % 2 == 0 ? binaryPrepared : binaryPrepared.substring(0, binaryPrepared.length() - 1);
        return out;
    }

    private String checkCyrillicLowercase(String in) {
        String out = "";
        for (char c : in.toLowerCase().toCharArray()) {
            if (ruChars.contains("" + c)) {
                out += c;
            }
        }
        return out;
    }
    
}
