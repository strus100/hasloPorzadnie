package pl.matuszewski.hasloporzadnie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToLoginActivity(View view) {
        Button loginButton = (Button)findViewById(R.id.button);
        EditText passwordEditText   = (EditText)findViewById(R.id.editTextTextPassword);

        Intent intent = new Intent(this, NoteActivity.class);

        loginButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if( isPasswordCorrect(passwordEditText )){
                            startActivity(intent);
                        }
                    }
                });
    }

    public void goToPasswordChangerActivity(View view) {
        Button passwordChangerButton = (Button)findViewById(R.id.button2);

        Intent intent = new Intent(this, PasswordChangerActivity.class);

        passwordChangerButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        startActivity(intent);
                    }
                });
    }

    private boolean isPasswordCorrect( EditText passwordEditText ){
        return passwordEditText.getText().toString()
                .equals("admin");
    }
}