package com.example.helpnet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreatePostActivity extends Activity {

    private EditText postEditText;
    private Button addButton;
    private LinearLayout postsContainer;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // If no user is logged in, redirect to login activity
            Intent intent = new Intent(CreatePostActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // Initialize views
        postEditText = findViewById(R.id.editTextPost);
        addButton = findViewById(R.id.buttonAddPost);
        postsContainer = findViewById(R.id.postsContainer);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postText = postEditText.getText().toString();
                if (!postText.isEmpty()) {
                    addPost(postText);
                } else {
                    Toast.makeText(CreatePostActivity.this, "Post cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addPost(String postText) {
        // Create a new TextView for the post
        TextView postView = new TextView(this);
        postView.setText(postText);
        postView.setPadding(16, 16, 16, 16);
        postView.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        postView.setTextColor(getResources().getColor(android.R.color.black));
        postView.setTextSize(18); // Set the text size to 18sp

        // Set layout parameters to make the box bigger
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, 16); // Add margin to the bottom
        postView.setLayoutParams(params);

        // Add the new post to the container
        postsContainer.addView(postView);

        // Clear the EditText
        postEditText.setText("");
    }
}