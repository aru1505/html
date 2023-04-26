import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker {

    private HashSet<String> dictionary;

    public SpellChecker(String filename) {
        dictionary = new HashSet<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line.trim().toLowerCase());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkWord(String word) {
        return dictionary.contains(word.toLowerCase());
    }

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker("dictionary.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word to check: ");
        String word = scanner.nextLine();
        if (spellChecker.checkWord(word)) {
            System.out.println("Correct spelling.");
        } else {
            System.out.println("Incorrect spelling.");
}
}
}
