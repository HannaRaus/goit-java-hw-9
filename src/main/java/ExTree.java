import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ExTree {
    private static String PATH =
            "C:\\Users\\Anna\\IT\\GOiT\\goit-java-hw-9\\src\\main\\resources\\ex3.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {

            StringBuilder text = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                text.append(line + " ");
                line = reader.readLine();
            }
            String[] words = text.toString().split(" ");

            Map<String, Integer> uniqueWords = new HashMap<>();
            for (String word : words) {
                Integer counter = uniqueWords.get(word);
                if (counter == null) {
                    counter = 0;
                }
                uniqueWords.put(word, counter + 1);
            }

            Set<String> listOfUniqueWords = uniqueWords.keySet();
            for (String key : listOfUniqueWords) {
                System.out.println(key + " - " + uniqueWords.get(key));
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
