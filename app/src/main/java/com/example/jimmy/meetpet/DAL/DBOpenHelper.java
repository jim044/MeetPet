package com.example.jimmy.meetpet.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    /**
     * @goals This class aims to show the constant to use for the DBOpenHelper
     */
    public static class Constants implements BaseColumns {

        // The database name
        public static final String DATABASE_NAME = "myData.db";

        // The database version
        public static final int DATABASE_VERSION = 1;

        // The table Name
        public static final String MY_TABLE = "Pet";

        // ## Column name ##
        // My Column ID and the associated explanation for end-users
        public static final String KEY_COL_ID = "id";// Mandatory

        // My Column Name and the associated explanation for end-users
        public static final String KEY_COL_NAME = "name";

        // My Column First Name and the associated explanation for end-users
        public static final String KEY_COL_RACE = "race";

        // My Column Eyes Color and the associated explanation for end-users
        public static final String KEY_COL_EYES_COLOR = "eyesColor";

        // My Column Hair color and the associated explanation for end-users
        public static final String KEY_COL_HAIR_COLOR = "hairColor";

        // My Column age and the associated explanation for end-users
        public static final String KEY_COL_AGE = "age";

        public static final String KEY_COL_LIEN_IMAGE = "lien_image";

        // Indexes des colonnes
        // The index of the column ID
        public static final int ID_COLUMN = 1;

        // The index of the column NAME
        public static final int NAME_COLUMN = 2;

        // The index of the column FIRST NAME
        public static final int RACE_COLUMN = 3;

        // The index of the column EYES COLOR
        public static final int EYES_COLOR_COLUMN = 4;

        // The index of the column HAIR COLOR
        public static final int HAIR_COLOR_COLUMN = 5;

        // The index of the column AGE
        public static final int AGE_COLUMN = 6;

        public static final int LIEN_IMAGE_COLUMN = 7;
    }

    /**
     * The static string to create the database.
     */
    private static final String DATABASE_CREATE = "create table "
            + Constants.MY_TABLE + "(" + Constants.KEY_COL_ID
            + " integer primary key autoincrement, " + Constants.KEY_COL_AGE
            + " INTEGER, " + Constants.KEY_COL_NAME + " TEXT, "
            + Constants.KEY_COL_RACE + " TEXT, "
            + Constants.KEY_COL_EYES_COLOR + " TEXT, "
            + Constants.KEY_COL_HAIR_COLOR + " TEXT, "
            + Constants.KEY_COL_LIEN_IMAGE + " TEXT) ";

    /**
     * @param context
     *            = the context of the caller
     * @param name
     *            = Database's name
     * @param factory
     *            = null
     * @param version
     *            = Database's version
     */
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("DBOpenHelper", "Mise à jour de la version " + oldVersion
                + " vers la version " + newVersion
                + ", les anciennes données seront détruites ");
        // Drop the old database
        db.execSQL("DROP TABLE IF EXISTS " + Constants.MY_TABLE);
        // Create the new one
        onCreate(db);
        // or do a smartest stuff
    }
}