package users;

import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Registration {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    String name;
    int age;

    double balance = 0;

    String login;
    int pass;

    //actual register, run it also
    public void register(){
        System.out.print("Enter Your Name: ");
        name = scanner.nextLine();

        System.out.print("Enter Your Age: ");
        age = scanner.nextInt();

        login = id_GENERATOR.generate(name);
        pass = random.nextInt(1000, 9999);

        System.out.println("**************************");
        System.out.println("Your Info Here!\n" +
                           "Name-->" + name + "\n" +
                           "Age-->" + age + "\n" +
                           "Balance-->" + balance + "\n" +
                           "Login-->" + login + "\n" +
                           "Pass-->" + pass);
        System.out.println("**************************");

    }

    //file filler, run this for your program to work
    public void register_run(){
        //name and age
        try(FileWriter writer = new FileWriter("users_info_name_age.txt", true)) {
            writer.write(name + "\n");
            writer.write(age + "\n");
        }catch (Exception e){
            System.out.println("Error While Reading A File(Registration)");
        }
        //balance
        try(FileWriter writer = new FileWriter("users_info_balance.txt", true)) {
            writer.write(balance + "\n");
        }catch (Exception e){
            System.out.println("Error While Reading A File(Registration)");
        }
        //login and pass
        try(FileWriter writer = new FileWriter("users_info_login_pass.txt", true)) {
            writer.write(login + "\n");
            writer.write(pass + "\n");
        }catch (Exception e){
            System.out.println("Error While Reading A File(Registration)");
        }

    }
}
