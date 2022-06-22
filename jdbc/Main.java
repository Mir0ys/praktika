package main.java;

//import main.java.controllers.Database_Provider;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[]args) throws InterruptedException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);

        Main mainProvider = new Main();
        Database_provider Provider_db = new Database_provider();

        ArrayList<User> userList = new ArrayList<User>();
        User users = new User();

        try {
                userList = Provider_db.GetFromDb();
                System.out.println("Input new user(id, number_phone, technique, name, surname, address)");
            users.setId(check());
            users.setNumber_phone(check1());
            users.setTechnique(check1());
            users.setName(check1());
                //in.next();
            users.setSurname(check1());
                //in.next();
            users.setAddress(check1());


                Provider_db.AddUser(users);

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        try {
            System.out.printf("Input user Id");
            users.setId(check());
            System.out.printf("Input Number_phone");
            users.setNumber_phone(check1());
            System.out.printf("Input Technique");
            users.setTechnique(check1());
            System.out.printf("Input username");
            users.setName(check1());
            System.out.printf("Input surname");
            users.setSurname(check1());
            System.out.printf("Input address");
            users.setAddress(check1());
            Provider_db.UpdateUser(users);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        try {
            System.out.printf("Input id of deleting user");
            users.setId(check());
            Provider_db.DeleteUser(users);
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }


    public static int check(){
        int id=0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (scan.hasNextDouble()) {

                return scan.nextInt();
            } else {
                scan.next();
                System.out.println("input id");
                String s = scan.nextLine();
            }
        }
    }
    public static String check1(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (scan.hasNextLine()) {

                return scan.nextLine();
            } else {
                scan.next();
                System.out.println("input number!");
                String s = scan.nextLine();
            }
        }
    }
}
