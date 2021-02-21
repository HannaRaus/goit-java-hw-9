import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class ExTwo {
    private static String FILE_PATH =
            "C:\\Users\\Anna\\IT\\GOiT\\goit-java-hw-9\\src\\main\\resources\\ex2.txt";
    private static String TO_GSON_FILE =
            "C:\\Users\\Anna\\IT\\GOiT\\goit-java-hw-9\\src\\main\\resources\\gson.txt";

    public static void main(String[] args) {
        File file = new File(TO_GSON_FILE);
        List<User> usersList = new LinkedList<>();
        addUsersListFromFile(usersList);
        checkIfFileAvailable(file);
        addToGsonFile(usersList);
    }

    private static void addToGsonFile(List<User> usersList) {
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

    private static void addUsersListFromFile(List<User> userList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(" ");
                userList.add(new User(columns[0], Integer.parseInt(columns[1])));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
