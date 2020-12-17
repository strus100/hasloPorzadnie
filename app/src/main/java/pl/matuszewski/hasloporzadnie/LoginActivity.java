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

public class LoginActivity extends AppCompatActivity {
        Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.button);

        File file = new File(PasswordUtils.fileName);
        if( file.isPasswordCreated( getApplicationContext() ) ){
            loginButton.setEnabled( true );
        } else {
            loginButton.setEnabled( false );
        }

    }

    public void goToNoteActivity(View view) {
        loginButton = (Button)findViewById(R.id.button);
        EditText passwordEditText   = (EditText)findViewById(R.id.editTextTextPassword);

        Intent intent = new Intent(this, NoteActivity.class);

        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        if( passwordEditText.getText().toString().equals("")  ){
                            return;
                        }

                        if( PasswordUtils.isPasswordCorrect( passwordEditText.getText().toString(), getApplicationContext() )){
                            startActivity(intent);
                        } else {
                            Snackbar.make(view, "Wrong password!",1000)
                                    .show();
                            System.out.println("Wrong password!");
                        }
                    }
                });
    }

    public void goToPasswordChangerActivity(View view) {
        Button passwordChangerButton = (Button)findViewById(R.id.button2);

        Intent intent = new Intent(this, PasswordChangerActivity.class);

        passwordChangerButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View view)
                    {
                        startActivity(intent);
                    }
                });
    }

}