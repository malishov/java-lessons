import java.util.ArrayList;
import java.util.List;

import model.Book;

public class Main {
    public static void main(String[] args) {

        Book myBook = new Book("Name", "Author", 1900, 600);

        System.out.println(myBook.toString());
        System.out.println();
        System.out.println(myBook.getDetails());

    }
}