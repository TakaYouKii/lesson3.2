package com.example.lesson32;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDateTime;
public class CounterFragment extends Fragment {

    TextView txtScore;
    int score;
    Button btnPlus, btnMinus, btnSave;


    LocalDateTime localDateTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtScore = requireActivity().findViewById(R.id.tv_score);
        btnPlus = requireActivity().findViewById(R.id.btn_plus);
        btnMinus = requireActivity().findViewById(R.id.btn_minus);
        btnSave = requireActivity().findViewById(R.id.btn_save);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            score = Integer.parseInt(txtScore.getText().toString());
            txtScore.setText(String.valueOf(score + 1));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = Integer.parseInt(txtScore.getText().toString());
                txtScore.setText(String.valueOf(score - 1));
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    localDateTime = LocalDateTime.now();
                }
                Bundle bundle = new Bundle();
                bundle.putString("score", localDateTime+" Score: " + txtScore.getText().toString());
                ScoreListFragment scoreListFragment = new ScoreListFragment();
                scoreListFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.counter_list_container, scoreListFragment).commit();


                txtScore.setText("0");
            }
        });

    }



}