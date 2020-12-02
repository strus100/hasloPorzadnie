package pl.matuszewski.hasloporzadnie.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;

public class Asymmetric {
    //Creating a Cipher object
    Cipher cipher;
    KeyPair pair;

    public byte[] encrypt(String inputString) throws Exception{
        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withRSA");

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generate the pair of keys
        pair = keyPairGen.generateKeyPair();

        //Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();

        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        //Add data to the cipher
        byte[] input = inputString.getBytes();
        cipher.update(input);

        //encrypting the data
        byte[] cipherText = cipher.doFinal();

        System.out.println( new String(cipherText, "UTF8"));

        return cipherText;
    }

    public String decrypt(byte[] cipherText) throws Exception{

        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing the same cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);
        return new String(decipheredText);

    }
}
