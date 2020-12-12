package com.findimt.findimt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;


public class Activitymenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        Button activity_main_button = findViewById(R.id.activity_main_button);
        ImageView image = findViewById(R.id.logo);
        activity_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2 = new Intent(Activitymenu.this, AvtivityR2.class);
                startActivity(activity2);
            }
        });

        SearchView recherche = findViewById(R.id.Rrecherche);

        recherche.setFocusable(false);
        recherche.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent results = new Intent(Activitymenu.this, ResultsActivity.class);
                results.putExtra("resultats", query);
                startActivity(results);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }


}
