package com.example.e_commerce;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

//import com.example.e_commerce.ResponseModelClass.fetch_response_model;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView nav;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("FoodCart");
//        processdata();
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        nav = findViewById(R.id.navmenuview);
        drawerLayout = findViewById(R.id.dl);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //--for toggle tin humburger jaise jo rhta hai usko dikhane kai lie

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.nav_logout):
                        Toast.makeText(MainActivity2.this, "you clicked on logout", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
//    public void processdata(){
//        Call<List<fetch_response_model>> call=apicontroller
//                .getInstance()
//                .getapi()
//                .getfetch();
//
//        call.enqueue(new Callback<List<fetch_response_model>>() {
//            @Override
//            public void onResponse(Call<List<fetch_response_model>> call, Response<List<fetch_response_model>> response) {
//                Log.e("ayush", "onResponse: code"+response.code() );
//                List<fetch_response_model> data = response.body();
//                myadapter adapter= new myadapter(data);
//                rv.setAdapter(adapter);
//                Toast.makeText(MainActivity2.this, "ayush thakur", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<List<fetch_response_model>> call, Throwable t) {
//                Toast.makeText(MainActivity2.this,t.toString(), Toast.LENGTH_LONG).show();
//                             Log.e("ayush", "onFailure: "+t.getMessage());
//
//            }
//        });




//    }
//}