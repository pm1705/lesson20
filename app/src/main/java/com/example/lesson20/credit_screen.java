/**
 *
 * @author pazy
 * credit screen.
 *
 */
package com.example.lesson20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class credit_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_screen);
    }

    /**
     * closes credit screen and goes back
     * @param view
     */
    public void back_back(View view) {
        finish();
    }
}