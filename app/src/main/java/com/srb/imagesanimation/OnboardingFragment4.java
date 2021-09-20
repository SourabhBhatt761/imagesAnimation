package com.srb.imagesanimation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.srb.imagesanimation.databinding.OnboardingScreen4Binding;

public class OnboardingFragment4 extends Fragment {

    public OnboardingFragment4() {
        // Required empty public constructor
    }

    private OnboardingScreen4Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = OnboardingScreen4Binding.inflate(inflater,container,false);



        return binding.getRoot();
    }
}