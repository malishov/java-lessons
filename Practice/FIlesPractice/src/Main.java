import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Murad\\Desktop\\TMP RISK\\report_rus.docx");
//        File folder = new File("C:\\Users\\Murad\\Desktop\\Code Academy\\java-lessons\\HomeWork");

        File folder = new File("C:\\Users\\Murad\\Desktop\\FUzzy");
//        if (!file.exists()) {
//            file.createNewFile();
//        }

//        if (folder.isDirectory()) {
//            Arrays.asList(folder.listFiles())
//                    .stream()
//                    .forEach(a -> System.out.println(a.getName()));
//        }

//        readFiles(folder, "test")/;

        FileInputStream is = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;

//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }

        reader.close();

        System.getProperties().forEach((key, value) -> System.out.println(key + " - " + value));
    }

    public static void readFiles(File folder, String key) {

        if (folder.isDirectory()) {
            Arrays.asList(folder.listFiles())
                    .stream()
                    .forEach(a -> search(a, key));
        }
    }

    public static void search(File file, String key) {

        if (file.getName().contains(key)) {

            System.out.println((file.isDirectory() ? "D: " : "F: ") + file.getName());

            readFiles(file, key);
        }
    }
}