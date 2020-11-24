package pl.matuszewski.hasloporzadnie;

import android.content.Context;

import pl.matuszewski.hasloporzadnie.crypto.Hash;

public class PasswordUtils {
    private static File file = new File("pass.txt");
    private static String password = "c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec";

    public static String getPassword(Context context) {
        getPasswordFromFile( context );

        return password;
    }

    public static void setPassword( String password, Context context ) {
        String hashedPassword = Hash.encrypt(password);
        setPasswordToFile(hashedPassword, context);
        PasswordUtils.password = hashedPassword;
    }

    public static boolean isPasswordCorrect(String passwordEditText, Context context){
        return Hash.encrypt( passwordEditText )
                .equals( PasswordUtils.getPassword( context ) );
    }

    private static void getPasswordFromFile(Context context ){
        String readedFromFile = file.readFromFile( context );
        if( readedFromFile.length() != 0 ){
            password = readedFromFile;
        }
    }

    private static void setPasswordToFile( String password, Context context ){
        file.writeToFile(password, context);
    }

}
