package com.example.ej_ud02_dialogos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ej_ud02_dialogos.databinding.ActivityIndexBinding;
import com.google.android.material.tabs.TabLayout;

public class ActivityIndex extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityIndexBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new TabAdapter());

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_index);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    class TabAdapter extends PagerAdapter {
        private ConstraintLayout pestana1;
        private ConstraintLayout pestana2;
        private ConstraintLayout pestana3;
        private final int[] pestanas = {R.string.tab1, R.string.tab2, R.string.tab3};

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getString(pestanas[position]);
        }


        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container,
                                      int position) {
            View page;
            switch (position) {
                case 0:
                    if (pestana1 == null) {
                        pestana1 = (ConstraintLayout)
                                LayoutInflater.from(ActivityIndex.this)
                                        .inflate(R.layout.fragment_inicio, container, false);
                    }
                    page = pestana1;
                    break;
                case 1:
                    if (pestana2 == null) {
                        pestana2 = (ConstraintLayout)
                                LayoutInflater.from(ActivityIndex.this)
                                        .inflate(R.layout.fragment_formulario, container, false);
                    }
                    page = pestana2;
                    break;
                default:
                    if (pestana3 == null) {
                        pestana3 = (ConstraintLayout)
                                LayoutInflater.from(ActivityIndex.this)
                                        .inflate(R.layout.fragment_listado_controller, container, false);
                    }
                    page = pestana3;
                    break;
            }
            container.addView(page, 0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view,
                                        @NonNull Object object) {
            //return false;
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container,
                                int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}