package pl.camp.it.szyfr.cezara;

import java.util.HashMap;
import java.util.Map;

public class Cezar {

    private static Map<Integer, Character> polishCharacters = new HashMap<Integer, Character>() {{
        put(123, 'ą');
        put(124, 'ć');
        put(125, 'ę');
        put(126, 'ł');
        put(127, 'ń');
        put(128, 'ó');
        put(129, 'ś');
        put(130, 'ź');
        put(131, 'ż');
    }};

    public static String encode(String text, int key) {

        char[] chars = text.toCharArray();

        for(int i = 0; i  < chars.length; i++) {
            /*int ascii = chars[i];
            ascii += key;
            if (ascii > 122) {
                ascii = ascii - 123 + 97;
            }

            if (ascii < 97) {
                ascii = ascii - 96 +122;
            }

            chars[i] = (char) ascii;*/
            if (chars[i] == ' ') {
                continue;
            }

            int ascii = chars[i];
            if (ascii > 122 || ascii <  97) {
                for(Map.Entry<Integer, Character> entry : polishCharacters.entrySet()) {
                    if (entry.getValue() == chars[i]) {
                        ascii = entry.getKey();
                    }
                }
            }

            ascii = (ascii - 97 + key) % 35;
            if (ascii >= 0) {
                ascii += 97;
            } else {
                ascii += 132;
            }


            if (ascii < 123) {
                chars[i] = (char) ascii;
            } else {
                chars[i] = polishCharacters.get(ascii);
            }
        }
        return String.valueOf(chars);
    }

    public static String decode(String text, int key) {

        return encode(text, -key);
    }
}
