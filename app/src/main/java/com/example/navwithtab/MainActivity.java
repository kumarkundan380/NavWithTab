package com.example.navwithtab;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager fm;
    FragmentTransaction ft;
    ImageView popup_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        popup_menu = findViewById(R.id.popup_menu);

        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.containerview,new TabFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                drawerLayout.closeDrawers();
                if(item.getItemId()==R.id.nav_home)
                {
                    FragmentTransaction fragmentTransaction1=fm.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerview,new TabFragment()).commit();

                }

                if(item.getItemId()==R.id.nav_message)
                {
                    FragmentTransaction fragmentTransaction=fm.beginTransaction();
                    fragmentTransaction.replace(R.id.containerview,new MessageFragment()).commit();
                }
                if(item.getItemId()==R.id.nav_chat)
                {
                    FragmentTransaction fragmentTransaction1=fm.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerview,new ChatFragment()).commit();
                }
                if(item.getItemId()==R.id.nav_profile)
                {
                    FragmentTransaction fragmentTransaction1=fm.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerview,new ProfileFragment()).commit();

                }
                return false;
            }
        });

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        toggle.syncState();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void popUpMenu(View view)
    {

        PopupMenu popupMenu=new PopupMenu(this,popup_menu);
        popupMenu.getMenuInflater().inflate(R.menu.options,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem)
            {
                int id=menuItem.getItemId();

                if (id == R.id.action_settings)
                {
                    Toast.makeText(MainActivity.this,"Settings",Toast.LENGTH_SHORT).show();
                    return true;
                }
                //noinspection SimplifiableIfStatement
                if (id == R.id.action_view)
                {
                    Toast.makeText(MainActivity.this,"View",Toast.LENGTH_SHORT).show();
                    return true;
                }
                //noinspection SimplifiableIfStatement
                if (id == R.id.action_edit)
                {
                    Toast.makeText(MainActivity.this,"Edit",Toast.LENGTH_SHORT).show();
                    return true;
                }
                //noinspection SimplifiableIfStatement
                if (id == R.id.action_new)
                {
                    Toast.makeText(MainActivity.this,"New",Toast.LENGTH_SHORT).show();
                    return true;
                }
                //noinspection SimplifiableIfStatement
                if (id == R.id.action_logout)
                {
                    Toast.makeText(MainActivity.this,"Logout",Toast.LENGTH_SHORT).show();
                    return true;
                }

                return true;
            }
        });
        popupMenu.show();
    }
}
