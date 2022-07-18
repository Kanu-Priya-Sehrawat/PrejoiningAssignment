package utils;

import beans.Key;

import java.io.File;
import java.util.Scanner;

public class Register {

    HashGenerator hashGenerator = new HashGenerator();

    public void register(){

        boolean a = true;
        String username = null;
        Scanner sc = new Scanner(System.in);

        while(a){
            System.out.println("Enter the username : ");
            username = sc.next();

            String filename = username + ".txt";
            File file = new File(username + ".txt");
            if (file.exists()) {
                System.out.println("Username already exists. Try another one.");
            }
            else{
                a = false;
            }
        }

        System.out.println("Enter the password : ");
        String password = sc.next();

        Key encryptedKeyAndPassword = hashGenerator.encrypt(password);

        FileHandler fileHandler = new FileHandler();
        fileHandler.write(username, encryptedKeyAndPassword);


    }






}
