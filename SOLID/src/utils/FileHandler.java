package utils;

import beans.Key;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    public void write(String username, Key key) {
        try {
            FileWriter myWriter = new FileWriter(username + ".txt");
            myWriter.write(key.getAlgNum().toString() + "\n");
            myWriter.write(key.getSecretKey() + "\n");
            myWriter.write(key.getPassword() + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Key read(String fileName) {
            FileInputStream fis= null;
            try {
                fis = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Scanner sc = new Scanner(fis);
            Integer alg = Integer.valueOf(sc.nextLine());
            String secretKey = sc.nextLine();
            String password = sc.nextLine();
            Key key = new Key(secretKey, password, alg);
            return key;
    }

}
