import Repositories.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        UI.run();

        // General Controller =>  new repo => gen
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);

        System.out.println(repository.getItems());

        //---------------------------------------------------------------
        // Add new receipt

        System.out.println("Input :");
        String input = scanner.nextLine();

        repository.addReceipt(input);

        System.out.println(repository.getReceipts());

        //----------------------------------------------------------------
        // Refund 1 Item

        System.out.println("Input item ID and Receipt ID: ");
        input = scanner.nextLine();

        repository.refundItem(input);

        System.out.println(repository.getReceipts());
        System.out.println(repository.getItems());

    }


}