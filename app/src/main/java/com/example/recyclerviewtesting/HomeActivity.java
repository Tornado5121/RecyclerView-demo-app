package com.example.recyclerviewtesting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtesting.adapters.VideoItemAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    String[] duration = {"13:30","13:40","15:00"};
    String[] name = {"Test1","Test2","Test3"};
    String[] views = {"1mln","2mln","3mln"};
    String[] date = {"2years","5years","2months"};
    int[] player = {R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background};
    int[] profile = {R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home};
    int[] icon = {R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_home);
        getSupportActionBar().setTitle("");

//        getSupportActionBar().hide();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bar);
        bottomNavigationView.setSelectedItemId(R.id.main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.main:
                        return true;
                    case R.id.newContent:
                        startActivity(new Intent(getApplicationContext(), NewContentActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.subscriptions:
                        startActivity(new Intent(getApplicationContext(), SubscriptionActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notifications:
                        startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.library:
                        startActivity(new Intent(getApplicationContext(), LibraryActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        RecyclerView list_view = findViewById(R.id.video_list);
        VideoItemAdapter videoItemAdapter = new VideoItemAdapter(this, duration, name, views, date, player, profile, icon);
        list_view.setAdapter(videoItemAdapter);

        LinearLayoutManager layout = new LinearLayoutManager(this);
        list_view.setLayoutManager(layout);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(list_view.getContext(),
                layout.getOrientation());
        list_view.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater layoutInflater = getMenuInflater();
        layoutInflater.inflate(R.menu.tool_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Test1:
                Toast.makeText(this, "HelloWorld", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}