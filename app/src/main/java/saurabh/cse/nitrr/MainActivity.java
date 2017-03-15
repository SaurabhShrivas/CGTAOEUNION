package saurabh.cse.nitrr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private String[] pageTitle = {"HOME", "REGISTER", "GALLERY"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        viewPager = (ViewPager)findViewById(R.id.view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);
        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        //setting Tab layout (number of Tabs = number of ViewPager pages)
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //handling navigation view item event
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);





        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //change Tab selection when swipe ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           // super.onBackPressed();
            final AlertDialog ad = new AlertDialog.Builder(this)
                    .create();
            ad.setCancelable(false);
            ad.setTitle("Exit ?");
            ad.setMessage("Do you really want to exit ?");
            ad.setButton(DialogInterface.BUTTON_POSITIVE, "yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ad.cancel();
                    MainActivity.this.finish();

                    // MainActivity.this.onStop();
                }
            });
            ad.setButton(DialogInterface.BUTTON_NEGATIVE, "no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ad.cancel();

                }
            });
            ad.show();

        }
    }

























    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            try{

                Class ourclass=Class.forName("saurabh.cse.nitrr.Contacts");
                Intent ourintent=new Intent(MainActivity.this,ourclass);
                startActivity(ourintent);

            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            try {

                Class ourclass = Class.forName("saurabh.cse.nitrr.MainActivity");
                Intent ourintent = new Intent(MainActivity.this, ourclass);
                startActivity(ourintent);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

            else if (id == R.id.nav_developer) {

                try{

                    Class ourclass=Class.forName("saurabh.cse.nitrr.Developer");
                    Intent ourintent=new Intent(MainActivity.this,ourclass);
                    startActivity(ourintent);

                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }


            }

            else if (id == R.id.nav_contact) {

                try{

                    Class ourclass=Class.forName("saurabh.cse.nitrr.Contacts");
                    Intent ourintent=new Intent(MainActivity.this,ourclass);
                    startActivity(ourintent);

                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }


            }
            else if (id == R.id.nav_about) {


                try{

                    Class ourclass=Class.forName("saurabh.cse.nitrr.About");
                    Intent ourintent=new Intent(MainActivity.this,ourclass);
                    startActivity(ourintent);

                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }


            }

            else if (id == R.id.nav_gallery) {


                try{

                    Class ourclass=Class.forName("saurabh.cse.nitrr.Gallery.Gallery");
                    Intent ourintent=new Intent(MainActivity.this,ourclass);
                    startActivity(ourintent);

                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }


            }
        else if (id == R.id.nav_leadership) {


            try{

                Class ourclass=Class.forName("saurabh.cse.nitrr.Leadership.Leadership");
                Intent ourintent=new Intent(MainActivity.this,ourclass);
                startActivity(ourintent);

            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }


        }

        else if (id == R.id.nav_links) {


            try{

                Class ourclass=Class.forName("saurabh.cse.nitrr.Links");
                Intent ourintent=new Intent(MainActivity.this,ourclass);
                startActivity(ourintent);

            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }


        }




        else if (id == R.id.nav_register) {

                try{

                    Class ourclass=Class.forName("saurabh.cse.nitrr.Register");
                    Intent ourintent=new Intent(MainActivity.this,ourclass);
                    startActivity(ourintent);

                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }


            }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}


