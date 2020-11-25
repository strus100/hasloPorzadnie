package pl.matuszewski.hasloporzadnie;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import pl.matuszewski.hasloporzadnie.crypto.Hash;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PasswordUtils {
    public static final String fileName = "pass.txt";
    private static File file = new File(fileName);
    private static String password = "40Za6oG8Ina3orq+aQlSOg==";
    private static String salt = "o3dsI+R4UW6XczhKmo1I+A==";

    public static String getPassword( Context context ) {
        getPasswordFromFile( context );

        return password;
    }

    public static void setPassword( String password, Context context ) {
        String hashedPassword = Hash.encrypt( password, salt );
        setPasswordToFile( hashedPassword, context );
        PasswordUtils.password = hashedPassword;
    }

    public static boolean isPasswordCorrect( String passwordEditText, Context context ){
        String hashedInput = Hash.encrypt( passwordEditText, salt );
        String hashedSource = PasswordUtils.getPassword(context);
        return hashedInput.equals( hashedSource );
    }

    private static void getPasswordFromFile( Context context ){
        String readedFromFile = file.readFromFile( context );
        if( readedFromFile.length() != 0 ){
            password = readedFromFile;
        }
    }

    private static void setPasswordToFile( String password, Context context ){
        file.writeToFile(password, context);
    }

}
