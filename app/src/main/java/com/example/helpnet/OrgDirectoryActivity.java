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
        String[] orgNames = {"Red Cross", "Doctors Without Borders", "International Rescue Committee", "CARE International", "Habitat for Humanity", "Federal Emergency Management Agency"};
        String[] orgDescriptions = {
                "Provides emergency assistance and disaster relief.\nhttps://www.ifrc.org/",
                "Provides medical aid in conflict zones and natural disasters.\nhttps://www.doctorswithoutborders.org/",
                "Responds to humanitarian crises, including natural disasters, with emergency relief and recovery programs.\nhttps://www.rescue.org/",
                "Focuses on fighting global poverty and providing disaster relief.\nhttps://www.care-international.org/",
                "Habitat for Humanity.\nhttps://www.habitat.org/",
                "Coordinates federal disaster response and provides resources and support for affected communities.\nhttps://www.fema.gov/"
        };
        int[] orgLogos = {R.drawable.ifrc_logo, R.drawable.dwb_logo, R.drawable.irc_logo, R.drawable.care_international_logo, R.drawable.hfh_logo, R.drawable.fema_logo};

        // Set the adapter
        orgAdapter = new OrgAdapter(this, orgNames, orgDescriptions, orgLogos);
        orgListView.setAdapter(orgAdapter);
    }
}