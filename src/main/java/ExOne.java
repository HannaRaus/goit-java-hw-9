import java.io.*;

public class ExOne {
    private static String PATH =
            "C:\\Users\\Anna\\IT\\GOiT\\goit-java-hw-9\\src\\main\\resources\\ex1.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();
            while (line != null) {

                if (checkIfNumberCorrect(line)) {
                    System.out.println(line);
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    private static boolean checkIfNumberCorrect(String line) {
        String varOne = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
        String varTwo = "\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}";

        return line.matches(varOne) || line.matches(varTwo);
    }
}
