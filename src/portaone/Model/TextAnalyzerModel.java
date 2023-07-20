package portaone.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzerModel {
    public char findFirstUniqueCharacter(String text) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char c : text.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }

    public List<Character> findFirstUniqueCharactersInWords(String text) {
        List<Character> firstUniqueChars = new ArrayList<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            char firstUniqueChar = findFirstUniqueCharacter(word);
            firstUniqueChars.add(firstUniqueChar);
        }

        return firstUniqueChars;
    }

    public char findFirstUniqueCharInList(List<Character> characters) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char c : characters) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (char c : characters) {
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }
}
