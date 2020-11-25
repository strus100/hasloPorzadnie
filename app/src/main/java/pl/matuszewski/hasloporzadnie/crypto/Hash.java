package pl.matuszewski.hasloporzadnie.crypto;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import pl.matuszewski.hasloporzadnie.File;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Hash {

/*
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static byte[] setSalt(Context context) {
        File file = new File("salt.txt");
        String saltStr = file.readFromFile(context);
        if(saltStr.isEmpty()){
            return prepareSalt();
        } else {
            return Base64.getDecoder().decode( saltStr );
        }
    }

    private byte[] salt;
*/

    private static byte[] decodeToByte(String s){
        return Base64.getDecoder().decode( s );
    }

    public static String encrypt( String input, String saltStr ){
        byte[] salt = decodeToByte(saltStr);
        byte[] hash = new byte[0];
        try {

            KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, 128);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            hash = factory.generateSecret(spec).getEncoded();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(hash);
    }

    public static byte[] prepareSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

/*
    public static String encryptOLD(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
*/

}
