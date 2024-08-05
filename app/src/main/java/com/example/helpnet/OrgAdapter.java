package com.example.helpnet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrgAdapter extends BaseAdapter {

    private Context context;
    private String[] orgNames;
    private String[] orgDescriptions;
    private int[] orgLogos;

    public OrgAdapter(Context context, String[] orgNames, String[] orgDescriptions, int[] orgLogos) {
        this.context = context;
        this.orgNames = orgNames;
        this.orgDescriptions = orgDescriptions;
        this.orgLogos = orgLogos;
    }

    @Override
    public int getCount() {
        return orgNames.length;
    }

    @Override
    public Object getItem(int position) {
        return orgNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.org_item, parent, false);
        }

        ImageView orgLogo = convertView.findViewById(R.id.orgLogo);
        TextView orgName = convertView.findViewById(R.id.orgName);
        TextView orgDescription = convertView.findViewById(R.id.orgDescription);

        orgLogo.setImageResource(orgLogos[position]);
        orgName.setText(orgNames[position]);
        orgDescription.setText(orgDescriptions[position]);

        return convertView;
    }
}