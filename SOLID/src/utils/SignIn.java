package utils;

import beans.Key;

import java.io.File;

public class SignIn {

    public Boolean signIn(String username, String password) {
        String filename = username + ".txt";
        File file = new File(filename);
        if(!file.exists()) {
            return false;
        }
        FileHandler fileHandler = new FileHandler();
        HashGenerator hashGenerator = new HashGenerator();
        Key keyFromFile = fileHandler.read(filename);
        String passwordFromFile = hashGenerator.decryptString(keyFromFile.getPassword(), keyFromFile.getSecretKey(), HashGenerator.idToAlgo.get(keyFromFile.getAlgNum()));
        if (password.equals(passwordFromFile)) {
            return true;
        }
        return false;
    }

}
