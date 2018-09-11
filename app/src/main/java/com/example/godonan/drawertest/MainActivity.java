package com.example.godonan.drawertest;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment fragment = new MainFragment();
        fragmentTransaction.add(R.id.content_frame, fragment);
        fragmentTransaction.commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionbar.setSubtitle("Main");
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // have item get persistent highlighting
                        int id = menuItem.getItemId();
                        mDrawerLayout.closeDrawers();
                        Fragment newFragment = new UniversalFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("ID", Integer.toString(id));
                        newFragment.setArguments(bundle);
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content_frame, newFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        return true;
                    }
                }
        );
    }


    @SuppressWarnings("deprecation")
    public static Spanned fromTheHtml(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeBar(String name) {
        ActionBar actionbar = getSupportActionBar();
        actionbar.setSubtitle(name);
    }

    public static class UniversalFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Bundle bundle = getArguments();
            if (bundle != null) {
                int id = Integer.parseInt(bundle.getString("ID"));
                switch (id) {
                    case R.id.nav_main:
                        return inflater.inflate(R.layout.main_fragment, container, false);
                    case R.id.nav_absorb:
                        return inflater.inflate(R.layout.absorb_fragment, container, false);
                    case R.id.nav_avoid:
                        return inflater.inflate(R.layout.avoid_fragment, container, false);
                    case R.id.nav_barricade:
                        return inflater.inflate(R.layout.barricade_fragment, container, false);
                    case R.id.nav_bombing:
                        return inflater.inflate(R.layout.bombing_fragment, container, false);
                    case R.id.nav_defense:
                        return inflater.inflate(R.layout.defense_fragment, container, false);
                    case R.id.nav_disarm:
                        return inflater.inflate(R.layout.disarm_fragment, container, false);
                    case R.id.nav_disaster:
                        return inflater.inflate(R.layout.disaster_fragment, container, false);
                    case R.id.nav_disease:
                        return inflater.inflate(R.layout.disease_fragment, container, false);
                    case R.id.nav_fire:
                        return inflater.inflate(R.layout.fire_fragment, container, false);
                    case R.id.nav_hazmat:
                        return inflater.inflate(R.layout.hazmat_fragment, container, false);
                    case R.id.nav_medical:
                        return inflater.inflate(R.layout.medical_fragmet, container, false);
                    case R.id.nav_offense:
                        return inflater.inflate(R.layout.offense_fragment, container, false);
                    case R.id.nav_riot:
                        return inflater.inflate(R.layout.riot_fragment, container, false);
                    case R.id.nav_shield:
                        return inflater.inflate(R.layout.shield_fragment, container, false);
                    case R.id.nav_ship:
                        return inflater.inflate(R.layout.ship_fragment, container, false);
                    case R.id.nav_shooter:
                        return inflater.inflate(R.layout.shooter_fragment, container, false);
                    case R.id.nav_signaling:
                        return inflater.inflate(R.layout.signaling_fragment, container, false);
                    case R.id.nav_train:
                        return inflater.inflate(R.layout.train_fragment, container, false);
                    case R.id.nav_trouble:
                        return inflater.inflate(R.layout.trouble_fragment, container, false);
                    case R.id.nav_weakness:
                        return inflater.inflate(R.layout.weakness_fragment, container, false);
                    case R.id.nav_weapon:
                        return inflater.inflate(R.layout.weapon_fragment, container, false);
                }
                return inflater.inflate(R.layout.main_fragment, container, false);
            }
            return inflater.inflate(R.layout.main_fragment, container, false);
        }
    }


    public static class MainFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.main_fragment, container, false);
        }
    }
}