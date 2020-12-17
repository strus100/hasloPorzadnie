package pl.matuszewski.hasloporzadnie;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import pl.matuszewski.hasloporzadnie.crypto.Hash;

public class PasswordUtils {
    public static final String fileName = "pass.txt";
    private static File file = new File(fileName);
    private static String password = "6Bw5YCoGUw3wFPxzQqSuwh9jWDKiExwnc7kibCbf8I620/6xKFlk3OUqVUDSzy4VZMve+7NkGKSMLvLN0buXxw==";
    private static String salt = "o3dsI+R4UW6XczhKmo1I+A==";

//    public boolean isPasswordChanged(){
//       return password.equals("40Za6oG8Ina3orq+aQlSOg==");
//    }

    public static String getPassword( Context context ) {
        getPasswordFromFile( context );

        return password;
    }

    public static void setPassword( String password, Context context ) {
        salt = Hash.prepareSalt();
        String passwordHashed = Hash.encrypt( password, salt );
        String toFile = passwordHashed + "--BREAK--" + salt;

        file.writeToFile(toFile, context);
    }

    public static boolean isPasswordCorrect( String passwordEditText, Context context ){
        String hashedInput = Hash.encrypt( passwordEditText, salt );
        String hashedSource = PasswordUtils.getPassword(context);
        return hashedInput.equals( hashedSource );
    }

    private static void getPasswordFromFile( Context context ){
        String readedFromFile = file.readFromFile( context, false );
        if( readedFromFile.length() != 0 ){
            splitPasswordAndSalt( readedFromFile );
        }
    }

    private static void splitPasswordAndSalt( String text ){
        String[] splited = text.split("--BREAK--");
        if(splited.length == 2){
            password = splited[0];
            salt = splited[1];
        }
    }
}
