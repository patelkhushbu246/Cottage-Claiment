package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
   // ListView listViewnews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


       // ArrayList<RentDemoModel> arrayList=new ArrayList<>();
      //  listViewnews=(ListView)findViewById(R.id.news_listview);

       /* ObjectHolder.newsModel=new ArrayList<>();

        NewsModel model2=new NewsModel();
        model2.setTitle("Property News");
        model2.setContent("This is a Property news Activity");
        model2.setTitle("Second news");
        model2.setContent("This is a listview");
        ObjectHolder.newsModel.add(model2);*/

        listView=(ListView)findViewById(R.id.home_listview);
        ObjectHolder.rentDemoModel=new ArrayList<>();
        RentDemoModel model1=new RentDemoModel();
        model1.setImageViewCottage(R.drawable.mybg1);
        model1.setName("Krishna Cottage");
        model1.setLocation("Ahemdabad,Gujrat,India");
        model1.setRating("rating");
        model1.setRank("4.6/5");
        model1.setPrice("Rs.10000");
        //arrayList.add(model);
        ObjectHolder.rentDemoModel.add(model1);

        CustomRentAdapter adapter = new CustomRentAdapter(this,ObjectHolder.rentDemoModel);
        listView.setAdapter(adapter);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
           // return true;
            Intent intent=new Intent(HomeActivity.this,SearchPropertyActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_loginSignup) {
            Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_prnews) {
            Intent intent=new Intent(HomeActivity.this,PropertyNewsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_properties) {

        } else if (id == R.id.nav_searchproperty) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
