package com.example.fragmentcalismayapisi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentIkinci extends Fragment {
    private Button buttonYap;
    private TextView textViewSonuc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ikinci_layout,container,false);
        buttonYap=rootView.findViewById(R.id.buttonYap);
        textViewSonuc=rootView.findViewById(R.id.textViewSonuc);
        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSonuc.setText("Merhaba Fragment");
            }
        });

        return rootView;
    }
}
