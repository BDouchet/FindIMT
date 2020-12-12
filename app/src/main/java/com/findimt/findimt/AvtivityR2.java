package com.findimt.findimt;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;


public class AvtivityR2 extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avtivity_r2);
        Button Football = findViewById(R.id.Football);
        Football.setOnClickListener(this);
        Button Basket = findViewById(R.id.Basket);
        Basket.setOnClickListener(this);
        Button Run = findViewById(R.id.Run);
        Run.setOnClickListener(this);
        Button Fitness = findViewById(R.id.Fitness);
        Fitness.setOnClickListener(this);
        Button Velo = findViewById(R.id.Velo);
        Velo.setOnClickListener(this);
        Button Glisse = findViewById(R.id.Glisse);
        Glisse.setOnClickListener(this);
        Button Hiver = findViewById(R.id.Hiver);
        Hiver.setOnClickListener(this);
        Button Combat = findViewById(R.id.Combat);
        Combat.setOnClickListener(this);
        Button Vetements = findViewById(R.id.Vetements);
        Vetements.setOnClickListener(this);
        Button Cabine = findViewById(R.id.Cabine);
        Cabine.setOnClickListener(this);
        Button Randonnee = findViewById(R.id.Randonnee);
        Randonnee.setOnClickListener(this);
        Button Promo = findViewById(R.id.Promo);
        Promo.setOnClickListener(this);
        Button Tennis = findViewById(R.id.Tennis);
        Tennis.setOnClickListener(this);
        Button Natation = findViewById(R.id.Natation);
        Natation.setOnClickListener(this);
        Button Retour = findViewById(R.id.Retour);
        Retour.setOnClickListener(this);
        Button Chaussures = findViewById(R.id.Chaussures);
        Chaussures.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();
        switch (v.getId()) {
            case R.id.Retour:
                Intent Menu = new Intent(AvtivityR2.this, Activitymenu.class);
                startActivity(Menu);
                break;
            case R.id.Football:
                Intent intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Football"));
                startActivity(intent);
                break;
            case R.id.Basket:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Basket"));
                startActivity(intent);
                break;
            case R.id.Run:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Running"));
                startActivity(intent);
                break;
            case R.id.Fitness:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Fitness"));
                startActivity(intent);
                break;
            case R.id.Velo:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Vélo"));
                startActivity(intent);
                break;
            case R.id.Glisse:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Trotinette Skate"));
                startActivity(intent);
                break;
            case R.id.Hiver:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Saisonnier"));
                startActivity(intent);
                break;
            case R.id.Cabine:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("%Cabines%"));
                startActivity(intent);
                break;
            case R.id.Vetements:
                Intent Vetements = new Intent(AvtivityR2.this, ActVetements.class);
                startActivity(Vetements);
                break;
            case R.id.Combat:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("%Boxe%"));
                startActivity(intent);
                break;
            case R.id.Randonnee:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Boxe Judo Musculation"));
                startActivity(intent);
                break;
            case R.id.Promo:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Promotions"));
                startActivity(intent);
                break;
            case R.id.Tennis:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Raquette"));
                startActivity(intent);
                break;
            case R.id.Natation:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Natation"));
                startActivity(intent);
                break;
            case R.id.Chaussures:
                intent = new Intent(AvtivityR2.this, ActivityRayon.class);
                intent.putExtra("Sport", db.AskRayon("Chaussures"));
                startActivity(intent);
                break;
        }
        db.close();
    }
}