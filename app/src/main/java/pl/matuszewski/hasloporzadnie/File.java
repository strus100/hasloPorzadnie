package pl.matuszewski.hasloporzadnie;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import pl.matuszewski.hasloporzadnie.crypto.KeyStoreSymmetric;

public class File {

    private String fileName;
    public File(String fileName) {
        this.fileName = fileName;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String readFromFile(Context context, boolean isNote) {
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString).append("\n");
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        if(ret.length() != 0){
            ret = ret.substring(0,ret.length() - 1);
        }

        if( isNote ) {
            KeyStoreSymmetric keyStoreSymmetric = new KeyStoreSymmetric(fileName);
            return keyStoreSymmetric.decryption(ret);
        } else {
            return ret;
        }
    }

    public void writeToFileNote(String data, Context context) {
        KeyStoreSymmetric keyStoreSymmetric = new KeyStoreSymmetric(fileName);
        data = keyStoreSymmetric.encryption(data);

        writeToFile(data, context);
    }

        @RequiresApi(api = Build.VERSION_CODES.O)
     public void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public boolean  isPasswordCreated( Context context ){
        return readFromFile( context, false ).length() != 0 ;
    }


}
