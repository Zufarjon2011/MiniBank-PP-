import users.Login;
import users.Registration;

class Main{
    public static void main(String[] args){

        Registration registration = new Registration();
        Login login = new Login();


        login.login_reader();
        login.login_start();
        login.show();

    }
}