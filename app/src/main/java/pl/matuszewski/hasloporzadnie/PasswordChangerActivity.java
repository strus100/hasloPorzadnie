package pl.matuszewski.hasloporzadnie;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PasswordChangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_changer);

    }

    private boolean checkPassword(String oldPassword, String newPassword, String newPasswordRepeated, View view) {
        if( PasswordUtils.isPasswordCorrect(oldPassword, getApplicationContext()) ){
            if( newPassword.equals(newPasswordRepeated) ){
                PasswordUtils.setPassword(newPassword, getApplicationContext());
                return true;
            } else {
                Snackbar.make(view, "Passwords must be same!",1000)
                    .show();
                System.out.println("Passwords must be same!");
            }
        } else {
            Snackbar.make(view, "Password incorrect!",1000)
                    .show();
            System.out.println("Password incorrect!");
        }
        return false;
    }

    public void goToLoginActivity(View view) {
        Button passwordChangerButton = (Button)findViewById(R.id.button3);
        Intent intent = new Intent(this, LoginActivity.class);

        passwordChangerButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        EditText oldPasswordElement = (EditText) findViewById(R.id.oldPassword);
                        EditText newPasswordElement = (EditText) findViewById(R.id.newPassword);
                        EditText newPasswordRepeatedElement = (EditText) findViewById(R.id.newPassword2);

                        boolean conditional = checkPassword(
                                oldPasswordElement.getText().toString(),
                                newPasswordElement.getText().toString(),
                                newPasswordRepeatedElement.getText().toString(),
                                view
                        );

                        if(conditional) {
                            startActivity(intent);
                        }
                    }
                });
    }

}