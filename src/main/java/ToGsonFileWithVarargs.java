import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class ToGsonFileWithVarargs {
    private static String FILE_PATH =
            "C:\\Users\\Anna\\IT\\GOiT\\goit-java-hw-9\\src\\main\\resources\\ex2.txt";
    private static String TO_GSON_FILE =
            "C:\\Users\\Anna\\IT\\GOiT\\goit-java-hw-9\\src\\main\\resources\\toGsonWithVarargs.txt";

    public static void main(String[] args) {
        File file = new File(TO_GSON_FILE);
        List<Person> usersList = new LinkedList<>();
        addUsersListFromFile(usersList);
        checkIfFileAvailable(file);
        addToGsonFile(usersList);
    }

    private static void addToGsonFile(List<Person> usersList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TO_GSON_FILE))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(usersList));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void checkIfFileAvailable(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }

    private static void addUsersListFromFile(List<Person> userList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line = reader.readLine();
            int columns = line.split(" ").length;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" ");
                userList.add(new Person(columns, info));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Person {
    private String[] info;

    public Person(int length, String ...columns) {
        this.info = new String[length];
        for (int i = 0; i < length; i++) {
            this.info[i] = columns[i];
        }
    }

}


