package com.example.recyclerviewtesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.recyclerviewtesting.adapters.SubscriptionItemAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SubscriptionActivity extends AppCompatActivity {

    String[] n1 = {"Test1", "Test2", "Test3", "Test2","Test2","Test2","Test2","Test2","Test2",};
    int[] p1 = {R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bar);
        bottomNavigationView.setSelectedItemId(R.id.subscriptions);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.newContent:
                        startActivity(new Intent(getApplicationContext(), NewContentActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.subscriptions:
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

        RecyclerView recyclerView = findViewById(R.id.subscription_list);
        SubscriptionItemAdapter subscriptionItemAdapter = new SubscriptionItemAdapter(this, n1, p1);
        recyclerView.setAdapter(subscriptionItemAdapter);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layout);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}
