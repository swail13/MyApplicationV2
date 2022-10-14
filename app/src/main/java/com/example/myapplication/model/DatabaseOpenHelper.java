package com.example.myapplication.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static String TAG = "DatabaseOpenHelper";
    final public static String TABLE_NAME = "etudiant";
    final public static String NAME_FIELD = "nom";
    final public static String AGE_FIELD = "age";
    final public static String MAIL_FIELD = "mail";
    final public static String PHONE_FIELD = "phone";
    final public static String FORMATION_FIELD = "sexe";
    final public static String ADRESSE_FIELD = "adresse";
    final public static String GENRE_FIELD = "genre";
    final public static String ID_FIELD = "Id";
    final public static String[] columns = { NAME_FIELD, AGE_FIELD, MAIL_FIELD, PHONE_FIELD, FORMATION_FIELD, ADRESSE_FIELD, GENRE_FIELD, ID_FIELD};
    private String create_table="create table " + TABLE_NAME + "("
            + NAME_FIELD + " TEXT,"
            + AGE_FIELD + " INTEGER NOT NULL,"
            + ID_FIELD + "INTEGER NOT NULL PRIMARY KEY,"
            + MAIL_FIELD + " TEXT,"
            + PHONE_FIELD + "TEXT,"
            + ADRESSE_FIELD + "TEXT,"
            + GENRE_FIELD + "TEXT,"
            + FORMATION_FIELD +" TEXT);";


    final private static String NAME_DB = "etudiant_db";
    final private static Integer VERSION = 1;
    final private Context mContext;

    public DatabaseOpenHelper(Context context) {
        super(context, NAME_DB, null, VERSION);
        this.mContext = context;
        Log.i(TAG,"constructeur DatabaseOpenHelper");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,"onCreate");
        db.execSQL(create_table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// N/A
    }
}
