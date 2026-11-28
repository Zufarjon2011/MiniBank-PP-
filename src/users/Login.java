package users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Login {
    //paths
    String path1 = "D:\\Zufar's stuff\\MiniBank\\users_info_login_pass.txt";
    String path2 = "D:\\Zufar's stuff\\MiniBank\\users_info_balance.txt";
    String path3 = "D:\\Zufar's stuff\\MiniBank\\users_info_name_age.txt";

    //arraylists to save information
    ArrayList<String> login_pass = new ArrayList<>();
    ArrayList<String> name_age = new ArrayList<>();
    ArrayList<Double> balance = new ArrayList<>();
    
    //user infos
    private String User_name;
    private String User_age;
    private String User_id;
    private double User_balance;

    public void login_reader(){
        try(BufferedReader reader = new BufferedReader(new FileReader(path1))){

            String line;
            while ((line = reader.readLine()) != null){
                login_pass.add(line);
            }

        }catch (Exception e){
            System.out.println("ERROR WHILE READING FILE!");
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(path2))){
            String line;
            while ((line = reader.readLine()) != null){
                balance.add(Double.valueOf(line));
            }
        }catch (Exception e){
            System.out.println("ERROR WHILE READING FILE!");
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(path3))){
            String line;
            while ((line = reader.readLine()) != null){
                name_age.add(line);
            }
        }catch (Exception e){
            System.out.println("ERROR WHILE READING FILE!");
        }
    }

    public void login_start(){

        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        System.out.print("Enter Login: ");
        String user_login = scanner.nextLine();

        System.out.print("Enter Password: ");
        String user_password = scanner.nextLine();

        for(int i = 0; i < login_pass.size(); i++){
            if(user_login.equals(login_pass.get(i)) && user_password.equals(login_pass.get(i+1))){
                success = true;
                if (success){
                    User_name = name_age.get(i);
                    User_age = name_age.get(i+1);
                    
                    User_id = login_pass.get(i);
                    
                    User_balance = balance.get(i / 2);
                }
                break;
            }
        }

        if(success){
            System.out.println("Login Success!");
        }
        else {
            System.out.println("Wrong Password or Login!");
        }
    }
    
    //getters
    public String getUser_name(){
        return User_name;
    }
    public String getUser_age(){
        return User_age;
    }
    public String getUser_id(){
        return User_id;
    }
    public Double getUser_balance(){
        return User_balance;
    }

    public void show(){
        System.out.println(login_pass);
        System.out.println(name_age);
        System.out.println(balance);
    }
}
