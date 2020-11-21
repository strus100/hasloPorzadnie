package pl.matuszewski.hasloporzadnie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordChangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_changer);

    }

    private void checkPassword(String oldPassword, String newPassword, String newPasswordRepeated){
        if( PasswordUtils.isPasswordCorrect(oldPassword) ){
            if( newPassword.equals(newPasswordRepeated) ){
                PasswordUtils.setPassword(newPassword);
            } else {
                System.out.println("Passwords must be same!");
            }
        } else {
            System.out.println("Password incorrect!");
        }
    }


    public void goToLoginActivity(View view) {
        Button passwordChangerButton = (Button)findViewById(R.id.button3);

        Intent intent = new Intent(this, LoginActivity.class);

        passwordChangerButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        EditText oldPasswordElement = (EditText) findViewById(R.id.oldPassword);
                        EditText newPasswordElement = (EditText) findViewById(R.id.newPassword);
                        EditText newPasswordRepeatedElement = (EditText) findViewById(R.id.newPassword2);

                        checkPassword(
                                oldPasswordElement.getText().toString(),
                                newPasswordElement.getText().toString(),
                                newPasswordRepeatedElement.getText().toString()
                        );

                        startActivity(intent);
                    }
                });
    }

}