package com.srb.imagesanimation;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.srb.imagesanimation.databinding.ActivityOnboardingBinding;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    public ActivityOnboardingBinding binding;

    ViewPager2 viewPager;
    OnboardingFragment4 onboardingFragment4;
    OnboardingFragment5 onboardingFragment5;
    List<Fragment> fragList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = binding.viewpager2;

        onboardingFragment4 = new OnboardingFragment4();
        onboardingFragment5 = new OnboardingFragment5();
        fragList.add(onboardingFragment4);
        fragList.add(onboardingFragment5);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, fragList);
        viewPager.setAdapter(viewPagerAdapter);
        binding.onBoarding5NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
    }
}
