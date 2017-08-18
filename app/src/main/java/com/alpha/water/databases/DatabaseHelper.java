package com.alpha.water.databases;

/**
 * Created by Pascal dev on 3/3/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "water.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        OrderTable.onCreate(db);
        CustomerTable.onCreate(db);
        SupplierTable.onCreate(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        OrderTable.onUpgrade(db, oldVersion, newVersion);
        CustomerTable.onUpgrade(db, oldVersion, newVersion);
        SupplierTable.onUpgrade(db, oldVersion, newVersion);

    }
}
