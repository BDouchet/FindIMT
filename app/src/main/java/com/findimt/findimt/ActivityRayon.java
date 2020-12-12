package com.findimt.findimt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ActivityRayon extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rayon);
        FloatingActionButton Menu = findViewById(R.id.Menu);
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour = new Intent(ActivityRayon.this, Activitymenu.class);
                startActivity(retour);
            }
        });
        Intent intent = getIntent();
        String Lieu = intent.getExtras().getString("Sport");
        String name = "@drawable/" + Lieu.toLowerCase();
        ImageView img = findViewById(R.id.img);
        int imageressource = getResources().getIdentifier(name, null, this.getPackageName());
        img.setImageResource(imageressource);
    }
}
