/**
 *
 * @author paz malul
 * this is the main screen of the app.
 *
 */

package com.example.lesson20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText input_1;
    TextView text_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_1 = (EditText) findViewById(R.id.input_1);
        text_display = (TextView) findViewById(R.id.text_display);

        try {
            FileInputStream fis= openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                sb.append(line+'\n');
                line = br.readLine();
            }
            text_display.setText(sb.toString());
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * save_text
     *
     *save the text inside the edit text to the local file.
     * @param view
     */

    public void save_text(View view) {
        try {
            FileOutputStream fos1 = openFileOutput("text.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos1);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(text_display.getText() + String.valueOf(input_1.getText()));
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text_display.setText(text_display.getText() + String.valueOf(input_1.getText()) + "\n");
    }

    /**
     * reset_text
     *
     * resets text in local file then updates textview to be empty
     * @param view
     */

    public void reset_text(View view) {
        try {
            FileOutputStream fos1 = openFileOutput("text.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos1);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("");
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text_display.setText("");
    }

    /**
     * exit_app
     *
     * saves current text inside edittext using "save_text" function
     * then closes app.
     * @param view
     */

    public void exit_app(View view) {
        save_text(null);
        finish();
    }

    /**
     * option menu create
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * option menu item function
     * @param item
     * @return
     */

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.credits){
            Intent creds = new Intent(this,credit_screen.class);
            startActivity(creds);
        }

        return true;
    }
}