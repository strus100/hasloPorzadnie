package pl.matuszewski.hasloporzadnie;

import android.widget.EditText;

public class PasswordUtils {
    private static String password = "admin";

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        PasswordUtils.password = password;
    }

    public static boolean isPasswordCorrect(String passwordEditText){
        return passwordEditText
                .equals( PasswordUtils.getPassword() );
    }

}
