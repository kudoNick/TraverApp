package com.example.travervitnam.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.travervitnam.MainActivity;
import com.example.travervitnam.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class SlideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private WormDotsIndicator dotsIndicator;
    private TextView btnNext;
    private LinearLayout lineNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        lineNext = findViewById(R.id.lineNext);
        viewPager = findViewById(R.id.viewPager);
        dotsIndicator = findViewById(R.id.worm_dots_indicator);

        layouts = new int[]{
               R.layout.silde_1,
               R.layout.silde_2
        };

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        dotsIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == layouts.length - 1) {
                    lineNext.setVisibility(View.VISIBLE);
                } else {
                    lineNext.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        lineNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SlideActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter{

        private LayoutInflater layoutInflater;
        public MyViewPagerAdapter() {
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {


            View view = layoutInflater.from(container.getContext()).inflate(layouts[position],container,false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
}