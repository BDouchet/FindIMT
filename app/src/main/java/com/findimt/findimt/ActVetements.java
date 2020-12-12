package com.findimt.findimt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActVetements extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vetements);
        Button Garcon = findViewById(R.id.Garcon);
        Garcon.setOnClickListener(this);
        Button Fille = findViewById(R.id.Fille);
        Fille.setOnClickListener(this);
        Button HommeS = findViewById(R.id.Homme_Sport);
        HommeS.setOnClickListener(this);
        Button FemmeS = findViewById(R.id.Femme_Sport);
        FemmeS.setOnClickListener(this);
        Button HommeL = findViewById(R.id.Homme_Life);
        HommeL.setOnClickListener(this);
        Button FemmeL = findViewById(R.id.Femme_Life);
        FemmeL.setOnClickListener(this);
        Button Retour = findViewById(R.id.Retour);
        Retour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();
        switch (v.getId()) {
            case R.id.Garcon:
                Intent intent = new Intent(ActVetements.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Garçon Junior"));
                startActivity(intent);
                break;
            case R.id.Fille:
                intent = new Intent(ActVetements.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Fille Junior"));
                startActivity(intent);
                break;
            case R.id.Homme_Sport:
                intent = new Intent(ActVetements.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Homme Sport"));
                startActivity(intent);
                break;
            case R.id.Femme_Sport:
                intent = new Intent(ActVetements.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Femme Sport"));
                startActivity(intent);
                break;
            case R.id.Homme_Life:
                intent = new Intent(ActVetements.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Homme Loisir"));
                startActivity(intent);
                break;
            case R.id.Femme_Life:
                intent = new Intent(ActVetements.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Femme Loisir"));
                startActivity(intent);
                break;
            case R.id.Retour:
                Intent Retour = new Intent(ActVetements.this, AvtivityR2.class);
                startActivity(Retour);
                break;
        }
        db.close();
    }
}
