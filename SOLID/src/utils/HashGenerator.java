package utils;

import beans.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class HashGenerator {

    public static Map<Integer, String> idToAlgo = new HashMap<>();

    private static SecretKeySpec secretKey;
    private static byte[] key;


    static {
        idToAlgo.put(1, Constants.AES);
        idToAlgo.put(2, Constants.HmacSHA1);
        idToAlgo.put(3, Constants.HmacSHA256);
    }

    public SecretKey generateHashKey(String ALGO) {
        SecureRandom securerandom
                = new SecureRandom();
        KeyGenerator keygenerator
                = null;
        try {
            keygenerator = KeyGenerator.getInstance(ALGO);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        keygenerator.init(256, securerandom);
        SecretKey key
                = keygenerator.generateKey();

        return key;
    }

    public void setKey(final String myKey, final String algo) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, algo);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String encryptString(final String strToEncrypt, final String secret, final String algo) {
        try {
            setKey(secret, algo);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decryptString(final String strToDecrypt, final String secret, final String algo) {
        try {
            setKey(secret, algo);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder()
                    .decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public Key encrypt(String password) {
        Random rand = new Random();
        int algNum = (int) ((Math.random() * 2) + 1);
        String alg = idToAlgo.get(algNum);
//        byte[] array = new byte[16];
//        new Random().nextBytes(array);
//        String myKey = new String(array, Charset.forName("UTF-8"));
        String myKey = "shhhhhhh";
        String encryptedPassword = encryptString(password, myKey, alg);
        Key key = new Key(myKey, encryptedPassword, algNum);
        return key;
    }

}
