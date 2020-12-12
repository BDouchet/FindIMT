package com.findimt.findimt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private static SQLiteDatabase database;
    private static DatabaseAccess instance;
    private SQLiteOpenHelper openHelper;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }


    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    public String AskRayon(String Sport) {
        Cursor cursor = database.rawQuery("SELECT Zone FROM Rayon WHERE Nom_Rayon LIKE '" + Sport + "'", new String[]{});
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor.getString(0);
        } else {
            return "Porblem";
        }
    }

    public Cursor AskProduit(String Search) {
        Cursor cursor = database.rawQuery("SELECT Produit._id,Produit.Nom_Produit,Rayon.Nom_Rayon,Rayon.Zone FROM Produit,Rayon WHERE Nom_Produit Like '%" + Search + "%' AND Produit.ID_Rayon=Rayon._id", null);
        return cursor;

    }
}
