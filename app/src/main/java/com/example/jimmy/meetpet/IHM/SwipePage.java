package com.example.jimmy.meetpet.IHM;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jimmy.meetpet.DAL.Bdd;
import com.example.jimmy.meetpet.DAL.DBOpenHelper;
import com.example.jimmy.meetpet.R;

public class SwipePage extends FragmentActivity {

    // The database.
    private SQLiteDatabase db;

    // The database creator and updater helper.
    DBOpenHelper dbOpenHelper;

    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_page);

        String resultat_insert;
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mDemoCollectionPagerAdapter =
                new DemoCollectionPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);

        ImageView img= (ImageView) findViewById(R.id.imageViewPet);

        dbOpenHelper = new DBOpenHelper(this, DBOpenHelper.Constants.DATABASE_NAME, null,
                DBOpenHelper.Constants.DATABASE_VERSION);

        resultat_insert = Bdd.insert_pet(dbOpenHelper);

        Toast.makeText(this, resultat_insert , Toast.LENGTH_LONG).show();
    }
}
