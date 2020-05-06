package com.example.navigationdrawer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity  {
     private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * DrawerLayout used for Drawer views
         * ActionBarDrawerToggle used for adding listener to NavigationDrawer and indirectly,
         * used for showing NavigtaionDrawerIcon
         * syncState used for knowing state of NavigationDawer
         * if you don't use toggle.syncState() then , you will found that NavigationDrawer icon not showing,
         * but only Up icon is show. By using syncState(), it will changes state of icon or you can show both
         */
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * onOptionsItemSelected(MenuItem item) used for adding listener to NavigationDrawerIcon
     * and up button ,if you don't use this method,then you cannot use or click that icons on
     * actionBar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
