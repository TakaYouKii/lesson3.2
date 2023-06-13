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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;




public class ScoreListFragment extends Fragment {
    ScrollView scoreList ;
    LinearLayout linearLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score_list, container, false);

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scoreList = requireActivity().findViewById(R.id.counter_list_container);

        linearLayout = requireActivity().findViewById(R.id.score_list);

        if(getArguments() != null){
            TextView textView = new TextView(getActivity());
            textView.setText(getArguments().getString("score"));
            textView.setTextSize( 24);
            linearLayout.addView(textView);
        }



    }


}