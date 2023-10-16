package com.example.unity3d.dfm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button change = view.findViewById(R.id.start_dfm);
        change.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(getContext(), "com.lge.dynamicunity3d.DynamicActivity");
            startActivity(intent);
        });
        return view;
    }
}
