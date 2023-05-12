package exerciseList01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CreatingStrings {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        ArrayList<Character> letters = new ArrayList<>();
        char[] charInput = input.toCharArray();
        Arrays.sort(charInput);
        for (char c : charInput) {
            letters.add(c);
        }

        ArrayList<String> combinations = creatingStrings(letters, new ArrayList<>(), new ArrayList<>(), 0);
        System.out.println(combinations.size());
        combinations.forEach(System.out::println);
    }

    private static ArrayList<String> creatingStrings(ArrayList<Character> letters, ArrayList<String> combinations, ArrayList<Character> partialWord, int currentIndex) {

        if (letters.isEmpty()) {
            String newWord = "";
            for (Character c : partialWord) {
                newWord += c;
            }
            combinations.add(newWord);
            return combinations;
        }

        for (int i = 0; i < letters.size(); i++) {
            if (!(i > 0 && letters.get(i) == letters.get(i-1))) {
                Character currentLetter = letters.remove(i);
                partialWord.add(currentIndex, currentLetter);
                combinations = creatingStrings(letters, combinations, partialWord, currentIndex+1);
                letters.add(i, partialWord.remove(currentIndex));
            }
        }
        return combinations;
    }
}
