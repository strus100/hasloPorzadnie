package pl.matuszewski.hasloporzadnie;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NoteActivity extends AppCompatActivity {
    File file = new File("note.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        saveNote();
    }

    public void saveNote() {
        EditText noteEditText = (EditText)findViewById(R.id.editTextTextMultiLine);

        String note = file.readFromFile(getApplicationContext(), true);

        noteEditText.setText(note);

        noteEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String note = noteEditText.getText().toString();
                file.writeToFile(note, getApplicationContext());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


}