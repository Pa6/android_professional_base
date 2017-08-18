package com.alpha.water.databases;

import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pascal dev on 3/3/2017.
 */
public class OrderTable {
    public static final String TABLE_NAME = "order";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ORDER_ID = "order_id";
    public static final String COLUMN_SUPPLIER_ID = "supplier_id";
    public static final String COLUMN_CUSTOMER_ID = "customer_id";
    public static final String COLUMN_QUANTITY = "quantity_id";
    public static final String COLUMN_PAYMENT_TYPE = "payment_type";
    public static final String COLUMN_PROVIDER_TYPE = "provider_type";
    public static final String COLUMN_STATUS = "status";


    //All column names here
    public static final String COLUMN_ID_FULL = TABLE_NAME + "." + COLUMN_ID;
    public static final String COLUMN_ORDER_ID_FULL = TABLE_NAME + "." + COLUMN_ORDER_ID;
    public static final String COLUMN_SUPPLIER_ID_FULL = TABLE_NAME + "." + COLUMN_SUPPLIER_ID;
    public static final String COLUMN_CUSTOMER_ID_FULL = TABLE_NAME + "." + COLUMN_CUSTOMER_ID;
    public static final String COLUMN_QUANTITY_FULL = TABLE_NAME + "." + COLUMN_QUANTITY;
    public static final String COLUMN_PAYMENT_TYPE_FULL = TABLE_NAME + "." + COLUMN_PAYMENT_TYPE;
    public static final String COLUMN_PROVIDER_TYPE_FULL = TABLE_NAME + "." + COLUMN_PROVIDER_TYPE;
    public static final String COLUMN_STATUS_FULL = TABLE_NAME + "." + COLUMN_STATUS;

    //all column alias here
    public static final String COLUMN_ID_ALIAS = TABLE_NAME + "_" + COLUMN_ID;
    public static final String COLUMN_ORDER_ID_ALIAS = TABLE_NAME + "_" + COLUMN_ORDER_ID;
    public static final String COLUMN_SUPPLIER_ID_ALIAS = TABLE_NAME + "_" + COLUMN_SUPPLIER_ID;
    public static final String COLUMN_CUSTOMER_ID_ALIAS = TABLE_NAME + "_" + COLUMN_CUSTOMER_ID;
    public static final String COLUMN_QUANTITY_ALIAS = TABLE_NAME + "_" + COLUMN_QUANTITY;
    public static final String COLUMN_PAYMENT_TYPE_ALIAS = TABLE_NAME + "_" + COLUMN_PAYMENT_TYPE;
    public static final String COLUMN_PROVIDER_TYPE_ALIAS = TABLE_NAME + "_" + COLUMN_PROVIDER_TYPE;
    public static final String COLUMN_STATUS_ALIAS = TABLE_NAME + "_" + COLUMN_STATUS;

    public static final Map<String, String> PROJECTION_MAP;

    static {
        PROJECTION_MAP = new HashMap<>();
        PROJECTION_MAP.put(COLUMN_ID_FULL, COLUMN_ID_FULL + " AS " + COLUMN_ID_ALIAS);
        PROJECTION_MAP.put(COLUMN_ORDER_ID_FULL, COLUMN_ORDER_ID_FULL + " AS " + COLUMN_ORDER_ID_ALIAS);
        PROJECTION_MAP.put(COLUMN_SUPPLIER_ID_FULL, COLUMN_SUPPLIER_ID_FULL + " AS " + COLUMN_SUPPLIER_ID_ALIAS);
        PROJECTION_MAP.put(COLUMN_CUSTOMER_ID_FULL, COLUMN_CUSTOMER_ID_FULL + " AS " + COLUMN_CUSTOMER_ID_ALIAS);
        PROJECTION_MAP.put(COLUMN_QUANTITY_FULL, COLUMN_QUANTITY_FULL + " AS " + COLUMN_QUANTITY_ALIAS);
        PROJECTION_MAP.put(COLUMN_PAYMENT_TYPE_FULL, COLUMN_PAYMENT_TYPE_FULL + " AS " + COLUMN_PAYMENT_TYPE_ALIAS);
        PROJECTION_MAP.put(COLUMN_PROVIDER_TYPE_FULL, COLUMN_PROVIDER_TYPE_FULL + " AS " + COLUMN_PROVIDER_TYPE_ALIAS);
        PROJECTION_MAP.put(COLUMN_STATUS_FULL, COLUMN_STATUS_FULL + " AS " + COLUMN_STATUS_ALIAS);

    }

    private static final String CREATE_TABLE = "create table IF NOT EXISTS " + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_ORDER_ID + " text, "
            + COLUMN_SUPPLIER_ID + " text, "
            + COLUMN_CUSTOMER_ID + " text, "
            + COLUMN_QUANTITY + " text, "
            + COLUMN_PAYMENT_TYPE + " text, "
            + COLUMN_PROVIDER_TYPE + " text, "
            + COLUMN_STATUS + " text "

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