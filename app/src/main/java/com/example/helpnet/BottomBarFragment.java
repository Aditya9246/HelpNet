package com.example.helpnet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

public class BottomBarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_bar, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View createPostButton = view.findViewById(R.id.createPostButton);
        View donateButton = view.findViewById(R.id.donateButton);
        View orgDirectoryButton = view.findViewById(R.id.orgDirectoryButton);

        createPostButton.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), CreatePostActivity.class));
        });

        donateButton.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), DonateActivity.class));
        });

        orgDirectoryButton.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), OrgDirectoryActivity.class));
        });
    }
}