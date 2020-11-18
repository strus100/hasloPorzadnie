package pl.matuszewski.hasloporzadnie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        saveNote();
    }

    public void saveNote() {
        EditText noteEditText   = (EditText)findViewById(R.id.editTextTextMultiLine);
        TextView textView = (TextView) findViewById(R.id.textView2);
        noteEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String note = "";

                note = noteEditText.getText().toString();
                textView.setText(note);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

}