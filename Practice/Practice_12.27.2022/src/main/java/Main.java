package main.java;

import java.util.*;

public class Main {

//    static List<User> userList = new ArrayList<>();
    static Set<User> userSet = new HashSet<>();
    public static void main(String[] args) throws UserExistException {

        userSet.add(new User("Murad", "Alishov"));

        while(true) {
            run();
        }
    }

    public static void addUser(String name, String surname) throws UserExistException {

        if (userExist(name, surname))
            throw new UserExistException("User is exist");

        userSet.add(new User(name, surname));
    }

    public static boolean userExist(String name, String surname) {

        for (User e : userSet) {
            if (e.getName().equals(name) && e.getSurname().equals(surname))
                return true;
        }

        return false;
    }

    public static void run() throws UserExistException {

        System.out.println("- 1. Add new User\n" +
                "- 2. Get All Users\n" +
                "- 3. Exit");

        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case 1:
                try {
                    enterUserData();
                } catch (UserExistException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                getAllUsers();
                break;
            case 3:
                System.exit(1);
        }
    }

    public static void getAllUsers() {

        for (User e : userSet)
            System.out.println(e.toString());

    }

    public static void enterUserData() throws UserExistException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input name and surname:");
        String name = scanner.nextLine();
        String surname = scanner.nextLine();

        addUser(name, surname);
    }
}