package net.lpf.info.extra.pt3;

public class SquaresTable {
    
    private final String ruChars = "абвгдеёжзиклмнопрстуфхцчшщьыъэюя .,";
    private final String[][] squares = {
        {
            "жщнюр", 
            "итьцб", 
            "яме.с", 
            "выпч ", 
            "ёдуок", 
            "зэфпш", 
            "ха,лъ"
        }, 
        {
            "ичгят", 
            ",жьмо", 
            "зюрвщ", 
            "цёпел", 
            "ъан.х", 
            "эксшд", 
            "бфуы "
        }
    };

    private String checkCyrillicLowercase(String in) {
        String out = "";
        for (char c : in.toLowerCase().toCharArray()) {
            if (ruChars.contains("" + c)) {
                out += c;
            }
        }
        return out;
    }
    // filter non-cyrillic and make the string length even
    public String binaryPrepare(String openText) {
        String binaryOut = checkCyrillicLowercase(openText);
        String out = binaryOut.length() % 2 == 0 ? binaryOut : binaryOut + " ";
        return out;
    }
    public String[][] getSquares() {
        return this.squares;
    }
}
