import model.Store;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Store> stores = new HashMap();
        Map<String, Double> clients = new HashMap<>();

        try{

            clients = getAllClients();
            stores = getAllStores(clients);
            createExcel(stores);

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("SIZE = " + stores.size());
        System.out.println(clients.size());

        for (Store s : stores.values()) {
            System.out.println(s.toString());
        }
    }

    public static Map<String, Double> getAllClients() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));

        Map<String, Double> clients = new HashMap<>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            String[] values = line.split("\t");

            if (values[0].matches("[0-9]+")) {
                clients.put(values[2], 0.0);
            }
        }

        return clients;
    }

    public static Map<Integer, Store> getAllStores(Map<String, Double> clients) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
        Map<Integer, Store> stores = new HashMap();
        String line;

        while ((line = bufferedReader.readLine()) != null) {

            String[] values = line.split("\t");

            if (values[0].matches("[0-9]+")) {

                Store store = new Store(Integer.parseInt(values[0]), values[1],
                        Double.parseDouble(values[3]) + Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]) * Integer.parseInt(values[6]));

                if (stores.containsValue(store)) {
                    Store tmpStore = stores.get(store.getId());

                    tmpStore.setAmount(store.getAmount() + tmpStore.getAmount());
                    tmpStore.setClients(getStoreClients(tmpStore.getClients(), values));

                } else {
                    store.setClients(getStoreClients(clients, values));
                    stores.put(store.getId(), store);
                }
            }
        }

        bufferedReader.close();

        return stores;
    }


    public static Map<String, Double> getStoreClients(Map<String, Double> allClients, String[] saleDetails) {

        Map<String, Double> clients = new HashMap<>(allClients);
//        47	Ali&Nino	Azerconnect-1	7.5	2.5	50.00	1
//        47	Ali&Nino	Azerconnect-3	7.5	2.5	50.00	1
        clients.put(saleDetails[2], clients.get(saleDetails[2]) + Double.parseDouble(saleDetails[5]) * Integer.parseInt(saleDetails[6]));
        System.out.println(clients.get(saleDetails[2]));

        return clients;
    }

    public static void createExcel(Map<Integer, Store> stores) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sales");


        int rowId = 0;
        Row row = sheet.createRow(rowId++);

        int cellId = 0;
        Cell cell;

        for (String x : setTitle(getAllClients())) {
            cell = row.createCell(cellId++);
            cell.setCellValue(x);
        }

        cellId = 0;

        for (Store e : stores.values()) {
            row = sheet.createRow(rowId++);

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getId());

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getName());

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getPercent());

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getAmount());

            for (Double c : e.getClients().values()) {
                cell = row.createCell(cellId++);
                cell.setCellValue(c);
            }

            cellId = 0;
        }

        FileOutputStream out = new FileOutputStream(
                new File("C:\\Users\\Murad\\Desktop\\Code Academy\\java-lessons\\Practice\\HW_Data\\out.xlsx"));

        workbook.write(out);
        out.close();
    }

    public static List<String> setTitle(Map<String, Double> clients) throws IOException {

        List<String> title = new ArrayList<>();
        title.add("ID");
        title.add("NAME");
        title.add("ALL%");
        title.add("AMOUNT");

        for (String s : clients.keySet()) {
            title.add(s);
        }

        return title;
    }
}