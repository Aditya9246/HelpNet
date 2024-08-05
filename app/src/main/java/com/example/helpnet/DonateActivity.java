package com.example.helpnet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DonateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        Button donateButton1 = findViewById(R.id.donateButton1);
        donateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement what happens when the donate button is clicked
                // For example, you might open a web page for donations
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://example.com/donate")); // Replace with your donation link
                startActivity(intent);
            }
        });
    }
}