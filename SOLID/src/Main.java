import utils.HashGenerator;
import utils.Register;
import utils.SignIn;

import javax.crypto.SecretKey;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice;
        do {

            System.out.println("Enter the choice \n 1. Register \n 2. Login \n 3. Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Register register = new Register();
                    register.register();
                    break;

                case 2:
                    String username, password;
                    System.out.println("Enter the username");
                    username = sc.next();

                    System.out.println("Enter the password");
                    password = sc.next();

                    SignIn signIn = new SignIn();
                    if(signIn.signIn(username, password)) {
                        System.out.println("Login Successful");
                    }
                    else{
                        System.out.println("Username/Password is invalid");
                    }
            }

        }while (choice != 3);


    }
}