package com.example.recyclerviewtesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.recyclerviewtesting.adapters.CategoryItemAdapter;
import com.example.recyclerviewtesting.adapters.VideoItemAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NewContentActivity extends AppCompatActivity {

    String[] duration = {"13:30","13:40","15:00"};
    String[] name = {"Test1","Test2","Test3"};
    String[] views = {"1mln","2mln","3mln"};
    String[] date = {"2years","5years","2months"};
    int[] player = {R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background};
    int[] profile = {R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home};
    int[] icon = {R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp};



    int[] icon2 = {R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home};
    int[] bg = {R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background, R.drawable.ic_launcher_2_background};
    String[] name2 = {"Test1", "Test2", "Test3", "Test4", "Test5", "Test6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_items);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bar);
        bottomNavigationView.setSelectedItemId(R.id.newContent);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.newContent:
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

        RecyclerView category_list = findViewById(R.id.category_list);
        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(this, icon2, bg, name2);
        category_list.setAdapter(categoryItemAdapter);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        category_list.setLayoutManager(manager);



        RecyclerView list_view = findViewById(R.id.video_list);
        VideoItemAdapter videoItemAdapter = new VideoItemAdapter(this, duration, name, views, date, player, profile, icon);
        list_view.setAdapter(videoItemAdapter);


        LinearLayoutManager layout = new LinearLayoutManager(this);
        list_view.setLayoutManager(layout);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(list_view.getContext(),
                layout.getOrientation());
        list_view.addItemDecoration(dividerItemDecoration);

    }
}
