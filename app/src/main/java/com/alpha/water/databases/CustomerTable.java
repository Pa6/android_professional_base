package com.alpha.water.databases;

import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pascal dev on 3/3/2017.
 */
public class CustomerTable {
    public static final String TABLE_NAME = "customer";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CUSTOMER_ID = "customer_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED = "updated_at";
    public static final String COLUMN_DELETED = "deleted_at";


    //All column names here
    public static final String COLUMN_ID_FULL = TABLE_NAME + "." + COLUMN_ID;
    public static final String COLUMN_CUSTOMER_ID_FULL = TABLE_NAME + "." + COLUMN_CUSTOMER_ID;
    public static final String COLUMN_NAME_FULL = TABLE_NAME + "." + COLUMN_NAME;
    public static final String COLUMN_EMAIL_FULL = TABLE_NAME + "." + COLUMN_EMAIL;
    public static final String COLUMN_CREATED_AT_FULL = TABLE_NAME + "." + COLUMN_CREATED_AT;
    public static final String COLUMN_UPDATED_FULL = TABLE_NAME + "." + COLUMN_UPDATED;
    public static final String COLUMN_DELETED_FULL = TABLE_NAME + "." + COLUMN_DELETED;

    //all column alias here
    public static final String COLUMN_ID_ALIAS = TABLE_NAME + "_" + COLUMN_ID;
    public static final String COLUMN_CUSTOMER_ID_ALIAS = TABLE_NAME + "_" + COLUMN_CUSTOMER_ID;
    public static final String COLUMN_NAME_ALIAS = TABLE_NAME + "_" + COLUMN_NAME;
    public static final String COLUMN_EMAIL_ALIAS = TABLE_NAME + "_" + COLUMN_EMAIL;
    public static final String COLUMN_CREATED_AT_ALIAS = TABLE_NAME + "_" + COLUMN_CREATED_AT;
    public static final String COLUMN_UPDATED_ALIAS = TABLE_NAME + "_" + COLUMN_UPDATED;
    public static final String COLUMN_DELETED_ALIAS = TABLE_NAME + "_" + COLUMN_DELETED;

    public static final Map<String, String> PROJECTION_MAP;

    static {
        PROJECTION_MAP = new HashMap<>();
        PROJECTION_MAP.put(COLUMN_ID_FULL, COLUMN_ID_FULL + " AS " + COLUMN_ID_ALIAS);
        PROJECTION_MAP.put(COLUMN_CUSTOMER_ID_FULL, COLUMN_CUSTOMER_ID_FULL + " AS " + COLUMN_CUSTOMER_ID_ALIAS);
        PROJECTION_MAP.put(COLUMN_NAME_FULL, COLUMN_NAME_FULL + " AS " + COLUMN_NAME_ALIAS);
        PROJECTION_MAP.put(COLUMN_EMAIL_FULL, COLUMN_EMAIL_FULL + " AS " + COLUMN_EMAIL_ALIAS);
        PROJECTION_MAP.put(COLUMN_CREATED_AT_FULL, COLUMN_CREATED_AT_FULL + " AS " + COLUMN_CREATED_AT_ALIAS);
        PROJECTION_MAP.put(COLUMN_UPDATED_FULL, COLUMN_UPDATED_FULL + " AS " + COLUMN_UPDATED_ALIAS);
        PROJECTION_MAP.put(COLUMN_DELETED_FULL, COLUMN_DELETED_FULL + " AS " + COLUMN_DELETED_ALIAS);

    }

    private static final String CREATE_TABLE = "create table IF NOT EXISTS " + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_CUSTOMER_ID + " text, "
            + COLUMN_NAME + " text, "
            + COLUMN_EMAIL + " text, "
            + COLUMN_CREATED_AT + " text, "
            + COLUMN_UPDATED + " text, "
            + COLUMN_DELETED + " text "

            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        while (oldVersion < newVersion) {
            switch (oldVersion) {
                default:
                    database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                    onCreate(database);
                    break;
            }
            oldVersion++;
        }

    }

}