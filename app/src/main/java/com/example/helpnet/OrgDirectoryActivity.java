package com.example.helpnet;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class OrgDirectoryActivity extends Activity {

    private ListView orgListView;
    private OrgAdapter orgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_directory);

        // Initialize ListView
        orgListView = findViewById(R.id.orgListView);

        // Sample data
        String[] orgNames = {"Red Cross", "Doctors Without Borders"};
        String[] orgDescriptions = {
                "Provides emergency assistance and disaster relief.",
                "Provides medical aid in conflict zones and natural disasters."
        };
        int[] orgLogos = {R.drawable.red_cross_logo, R.drawable.red_cross_logo};

        // Set the adapter
        orgAdapter = new OrgAdapter(this, orgNames, orgDescriptions, orgLogos);
        orgListView.setAdapter(orgAdapter);
    }
}