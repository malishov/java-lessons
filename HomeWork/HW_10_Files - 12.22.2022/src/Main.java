import jdk.dynalink.StandardOperation;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main <T> {


    public static File dir = new File("C:\\Users\\Murad\\Desktop\\Code Academy\\java-lessons\\Files");
    public static void main(String[] args) throws IOException {

        File detailsFile = new File(dir, "Details.txt");

        HashMap<String, List<String>> files = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(detailsFile));

        String line = reader.readLine();

        List<String> id = new ArrayList<>();
        List<String> fullNames = new ArrayList<>();
        List<LocalDateTime> dates = new ArrayList<>();
        List<String> carId = new ArrayList<>();

        List<String> text = new ArrayList<>();

        while (line != null) {
            text.add(line);


//            id.add(str[0]);
//            fullNames.add(str[1]);
//            dates.add(str[2]);
//            carId.add(str[3]);

            line = reader.readLine();
        }

        id = text.stream()
                .filter(x -> x.matches("[0-9]+"))
                .collect(Collectors.toList());


        id.sort((a, b) -> Integer.parseInt(a) - Integer.parseInt(b) < 0 ? 1 : -1);


        fullNames = text.stream()
                .filter(x -> x.matches("[^\\d]+"))
                .collect(Collectors.toList());


        Collections.sort(fullNames);

        dates = text.stream()
                        .filter(x -> x.matches("[\\d]{4}-[\\d]{2}-[\\d]{2} [\\d]{2}:[\\d]{2}:[\\d]{2}"))
                        .map(x -> LocalDateTime.parse(x, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toList());

        carId = text.stream()
                .filter(x -> x.matches("[\\d]{2}[a-zA-Z]{2}[\\d]{3}"))
                .collect(Collectors.toList());

        for (LocalDateTime e : dates)
            System.out.println(e);


        for (String e : carId)
            System.out.println(e);

        reader.close();

//        files.put("Ids", id);
//        files.put("full_Name", fullNames);
//        files.put("dates", dates);
//        files.put("car_ID", carId);

//        saveFiles(files);
    }

    public static void saveFiles (HashMap<String, List<String>> files) throws IOException {

        FileWriter writer;

        for (Map.Entry<String, List<String>> s : files.entrySet()) {

            List<String> str = s.getValue();

            File tmpFile = new File(dir + "\\" + s.getKey() + ".txt");
            
            if (tmpFile.createNewFile()) {
                System.out.println("A");

                writer = new FileWriter(tmpFile);

                for (int i = 0; i < str.size(); i ++) {
                    writer.write(str.get(i));
                }

            } else {
                writer = new FileWriter(tmpFile);

                System.out.println("B");

                for (int i = 0; i < str.size(); i ++) {
                    writer.append(str.get(i)).append("|");
                }
            }



            writer.close();
        }
    }

    public static void readFiles(HashMap<String, List<String>> files) {

    }
}