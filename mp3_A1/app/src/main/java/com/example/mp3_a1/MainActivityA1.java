package com.example.mp3_a1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivityA1 extends AppCompatActivity {

    // startup orientations & layouts + action bar + landmark listview fragment visible

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.landscape_layout);
        }
        else {
            setContentView(R.layout.activity_main);
        }

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.landmark_fragment, new LandmarkListFragment()).commit();
        }
    }

    // handle device rotations
    // specific layouts per orientation and what fragments displayed
    // action bar always visible

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.landscape_layout);
        }
        else {
            setContentView(R.layout.activity_main);
        }

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentManager.beginTransaction().replace(R.id.landmark_fragment, new LandmarkListFragment()).commit();
        }
        else {
            LandmarkListFragment landmarkFragment = new LandmarkListFragment();
            fragmentManager.beginTransaction().replace(R.id.landmark_fragment, landmarkFragment).commit();
        }
    }

    // overflow area options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shortcut, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // item shortcut to Launch A2 + two options - item Exit A1 & item Launch A2
    // intent filter in AndroidManifest of mp3_A2
    // shortcut.xml

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.shortcut_launch_A2 || id == R.id.action_launch_A2) {
            Intent launchA2 = new Intent("com.example.mp3_a2.LAUNCH_A2");
            startActivity(launchA2);
            return true;
        } else if(id == R.id.action_exit_A1) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // leave user selected option highlighted

    public void LandmarkHighlighted(String webpage) {
        LandmarkWebFragment landmarkWebFragment = LandmarkWebFragment.newInstance(webpage);
        int orientation = getResources().getConfiguration().orientation;
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentManager.beginTransaction().replace(R.id.web_fragment, landmarkWebFragment).addToBackStack(null).commit();
        }
        else {
            fragmentManager.beginTransaction().replace(R.id.landmark_fragment, landmarkWebFragment).addToBackStack(null).commit();
        }
    }

    // maintain somewhat correct back button functionality

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }

}


