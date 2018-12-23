package com.example.jimmy.meetpet.DAL;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class Bdd {

    public static String insert_pet(DBOpenHelper dbOpenHelper)
    {
        String resultat_insert = null;
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        ContentValues newTaskValues = new ContentValues();

// Assign the values for each column.
        newTaskValues.put(DBOpenHelper.Constants.KEY_COL_NAME, "Oscar");
        newTaskValues.put(DBOpenHelper.Constants.KEY_COL_RACE, "Yorkshire Terrier");
        newTaskValues.put(DBOpenHelper.Constants.KEY_COL_EYES_COLOR, "Marron");
        newTaskValues.put(DBOpenHelper.Constants.KEY_COL_HAIR_COLOR, "Brun Or");
        newTaskValues.put(DBOpenHelper.Constants.KEY_COL_AGE, 0.3);
        newTaskValues.put(DBOpenHelper.Constants.KEY_COL_AGE, 0.3);

        long rowId = db.insert(DBOpenHelper.Constants.MY_TABLE, null, newTaskValues);

// test to see if the insertion was ok
        if (rowId == -1) {
            resultat_insert = "Error when creating an human";
        } else {
            resultat_insert = "Pet created and stored in database";
        }

        return resultat_insert;
    }
}
