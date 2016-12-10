package getresult.example.asus.nottspark;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mNav_username;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        LayoutInflater factory = getLayoutInflater();
        View setUserNameView = factory.inflate(R.layout.nav_header_main, null);
        mNav_username = (TextView) setUserNameView.findViewById(R.id.nav_username);
        mNav_username.setText(username);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onNavigationItemSelected(navigationView.getMenu().getItem(0));

        View parkerView = getLayoutInflater().inflate(R.layout.fragment_parker, null);
        Button mSearchLeaverButton = (Button) parkerView.findViewById(R.id.btnSearchLeaver);
        mSearchLeaverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Parker();
                searchParking(fragment);
            }
        });

        Button mSearchParkerButton = (Button) parkerView.findViewById(R.id.btnSearchParker);
        mSearchParkerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Leaver();
                searchParking(fragment);
            }
        });
    }

    public void searchParking(Fragment fragment) {
        try {
             // Insert the fragment by replacing any existing fragment
            FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
            fragTransaction.replace(R.id.userMap, fragment);
            fragTransaction.addToBackStack(null);
            fragTransaction.commit();

            // Set action bar title
            setTitle("Search Leaver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        Class fragmentClass;
        switch (item.getItemId()) {
            case R.id.nav_requestParking:
                fragmentClass = MapActivity.class;
                break;
            case R.id.nav_profile:
                fragmentClass = UserProfile.class;
                break;
            case R.id.nav_history:
                fragmentClass = UserHistory.class;
                break;
            case R.id.nav_setting:
                fragmentClass = AccSetting.class;
                break;
            case R.id.nav_help:
                fragmentClass = UserHelp.class;
                break;
            case R.id.nav_aboutus:
                fragmentClass = AboutUs.class;
                break;
            case R.id.nav_feedback:
                fragmentClass = Feedback.class;
                break;
            case R.id.nav_logout:
                fragmentClass = LogOut.class;
                break;
            default:
                fragmentClass = MapActivity.class;
        }

        try {

            fragment = (Fragment) fragmentClass.newInstance();

            // Insert the fragment by replacing any existing fragment
            FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
            fragTransaction.replace(R.id.userMap, fragment);
            fragTransaction.addToBackStack(null);
            fragTransaction.commit();

            // Set action bar title
            setTitle(item.getTitle());
            // Close the navigation drawer
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
