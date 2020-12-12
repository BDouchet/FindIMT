package com.findimt.findimt;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;


public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_activity);
        Intent results = getIntent();
        String query = results.getStringExtra("resultats");
        DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();
        Cursor liste_produits = db.AskProduit(query);
        liste_produits.moveToFirst();

        ListView lv = findViewById(R.id.LV);
        ClientCursorAdapter adapter = new ClientCursorAdapter(
                this, R.layout.list_items, liste_produits, 0);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ResultsActivity.this, ActivityRayon.class);
                Cursor item = (Cursor) parent.getItemAtPosition(position);

                intent.putExtra("Sport", item.getString(item.getColumnIndexOrThrow("Rayon.Zone")));
                startActivity(intent);
            }
        });
        db.close();
        FloatingActionButton retour = findViewById(R.id.ReturnButton);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour = new Intent(ResultsActivity.this, Activitymenu.class);
                startActivity(retour);
            }
        });
    }
}


class ClientCursorAdapter extends ResourceCursorAdapter {

    public ClientCursorAdapter(Context context, int layout, Cursor cursor, int flags) {
        super(context, layout, cursor, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView Produit = view.findViewById(R.id.Produit);
        Produit.setText(cursor.getString(cursor.getColumnIndexOrThrow("Produit.Nom_Produit")));
        TextView Rayon = view.findViewById(R.id.Rayon);
        Rayon.setText(cursor.getString(cursor.getColumnIndexOrThrow("Rayon.Nom_Rayon")));
    }
}