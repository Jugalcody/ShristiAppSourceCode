package com.example.shristi2k24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    boolean back = false;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        toolbar = findViewById(R.id.toolbar_home);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navigationView = findViewById(R.id.navigation_drawer);

        drawerLayout = findViewById(R.id.home_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
openFragment(new HomeFragment(),"homenav");
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                if(item.getItemId()==R.id.bottom_home){
                    openFragment(new HomeFragment(),"bottom_home");
                    toolbar.setTitle("Shristi 2K24");
                    navigationView.getMenu().getItem(0).setChecked(true);
                }
                else if(item.getItemId()==R.id.bottom_schedule){
                    openFragment(new ScheduleFragment(),"bottom_schedule");
                    toolbar.setTitle("Day Schedule");
                }
                else if(item.getItemId()==R.id.bottom_result){
                    openFragment(new ResultFragment(),"result");
                    overridePendingTransition(R.anim.fadesin, R.anim.fadesin);
                    navigationView.getMenu().getItem(1).setChecked(true);
                }
                else if(item.getItemId()==R.id.bottom_about){
                    openFragment(new AboutFragment(),"bottom_about");
                    toolbar.setTitle("About Shristi");
                    navigationView.getMenu().getItem(3).setChecked(true);
                }
                return true;
            }
        });

        this.getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment currentFragment=getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (currentFragment != null) {
                    if (currentFragment instanceof HomeFragment) {
                        getSupportActionBar().setTitle("Shristi 2K24");
                        navigationView.getMenu().getItem(0).setChecked(true);
                        bottomNavigationView.getMenu().getItem(0).setChecked(true);
                    } else if (currentFragment instanceof ResultFragment) {
                        unchecknav();
                        bottomNavigationView.getMenu().getItem(2).setChecked(true);
                        getSupportActionBar().setTitle("Results");
                    }
                    else if (currentFragment instanceof ContactUsFragment) {
                        navigationView.getMenu().getItem(3).setChecked(true);
                        getSupportActionBar().setTitle("Help and Support");
                        bottomNavigationView.getMenu().getItem(0).setChecked(false);
                        bottomNavigationView.getMenu().getItem(1).setChecked(false);
                        bottomNavigationView.getMenu().getItem(2).setChecked(false);
                        bottomNavigationView.getMenu().getItem(3).setChecked(false);
                    }
                    else if (currentFragment instanceof MemberFragment) {
                        navigationView.getMenu().getItem(2).setChecked(true);
                        getSupportActionBar().setTitle("Shristi Members");
                    }

                    else if (currentFragment instanceof ScheduleFragment) {
                        bottomNavigationView.getMenu().getItem(1).setChecked(true);
                        navigationView.getMenu().getItem(1).setChecked(true);
                        unchecknav();
                        getSupportActionBar().setTitle("Day Schedule");
                    }

                    else if (currentFragment instanceof AboutFragment) {
                        bottomNavigationView.getMenu().getItem(3).setChecked(true);
                        navigationView.getMenu().getItem(4).setChecked(true);
                        getSupportActionBar().setTitle("About Shristi");
                    }

                    // Add more else-if conditions for other fragments if needed
                }

            }
        });


    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        bottomNavigationView.getMenu().getItem(0).setChecked(false);
        bottomNavigationView.getMenu().getItem(1).setChecked(false);
        bottomNavigationView.getMenu().getItem(2).setChecked(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(false);
        int itemId = item.getItemId();
        if (itemId == R.id.home_desc) {
            openFragment(new HomeFragment(), "homenav");
            toolbar.setTitle("Shristi 2k24");


        }else if (itemId == R.id.events_desc) {
            openFragment(new ScheduleFragment(),"bottom_schedule");
            toolbar.setTitle("Events");
        } else if (itemId == R.id.member_desc) {

            openFragment(new MemberFragment(), "membernav");
            toolbar.setTitle("Shristi Members");
        } else if (itemId == R.id.about_desc) {

            openFragment(new AboutFragment(), "aboutnav");
            toolbar.setTitle("About Shristi");
        } else if (itemId == R.id.contact_desc) {

            openFragment(new ContactUsFragment(), "contactnav");
            toolbar.setTitle("Contact Us");
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void unchecknav() {
        navigationView.getMenu().getItem(0).setChecked(false);
        navigationView.getMenu().getItem(1).setChecked(false);
        navigationView.getMenu().getItem(2).setChecked(false);
        navigationView.getMenu().getItem(3).setChecked(false);
        navigationView.getMenu().getItem(4).setChecked(false);
    }

    private void startActivityWithZoomAnimation(Intent intent) {
        // Start zoom out animation
        Animation zoomOut = AnimationUtils.loadAnimation(this, R.anim.fadesout);
        zoomOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Start the activity after zoom out animation completes
                startActivity(intent);

                // Start zoom in animation for the newly started activity
                overridePendingTransition(R.anim.fadesin, R.anim.fadesout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        findViewById(android.R.id.content).startAnimation(zoomOut);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else if(this.getSupportFragmentManager().getBackStackEntryCount()>1){
            this.getSupportFragmentManager().popBackStack();
        }
        else if(this.getSupportFragmentManager().getBackStackEntryCount()==1 && !back){
            back=true;
            Toast.makeText(getApplicationContext(),"Press back again to exit",Toast.LENGTH_SHORT).show();

        }
        else if(this.getSupportFragmentManager().getBackStackEntryCount()==1 && back){

            finishAffinity();
        }
        else {
            super.onBackPressed();
        }
    }



    // Assuming you have a method to replace a fragment
    public void openFragment(Fragment fragment, String tag) {
        back = false;
        FragmentManager fragmentManager = getSupportFragmentManager();


            String curr = "";
            try {
                curr = getSupportFragmentManager().getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
                if (!tag.equals(curr)) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .addToBackStack(tag) // Add to back stack to allow popping
                            .commit();
                }
            } catch (NullPointerException e) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new HomeFragment())
                        .addToBackStack(tag) // Add to back stack to allow popping
                        .commit();
            }

        }


    public void setAlert(String msg, String pos, String neg, String flag) {

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage(msg);
        b.setPositiveButton(pos, (DialogInterface.OnClickListener) (dialog, which) -> {
            if (flag.equals("exit"))
                finishAffinity();
            else if (flag.equals("logout")) {
                Toast.makeText(this, "logging out", Toast.LENGTH_SHORT).show();
            }

        });
        b.setNegativeButton(neg, (DialogInterface.OnClickListener) (dialog, which) -> {

            dialog.cancel();
        });
        AlertDialog ad = b.create();
        ad.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

                ad.getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.black));
            }
        });

        ad.show();

    }
}

