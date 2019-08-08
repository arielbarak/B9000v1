package com.example.b9000v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.main_nav_host);

        Toast.makeText(this, "Opened succesfully", Toast.LENGTH_SHORT).show();
        BottomNavigationView navView = findViewById(R.id.bottom_nav_view);

//        navView.setOnNavigationItemSelectedListener( menuItem -> {
//            navController.navigate(menuItem.getItemId());
//            return true;
//        });

    }
}
