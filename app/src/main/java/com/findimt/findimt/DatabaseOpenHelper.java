package com.findimt.findimt;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "FindIMT2.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_LOCATION = "/data/data/com.findimt.findimt/databases/";


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


}

