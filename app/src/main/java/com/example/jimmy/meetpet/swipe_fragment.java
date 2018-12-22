package com.example.jimmy.meetpet;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class swipe_fragment extends Fragment {

    public static final String ARG_OBJECT = "object";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_swipe_fragment, container, false);
        Bundle args = getArguments();
        TextView textImplement = rootView.findViewById(R.id.textViewNomAnimal);
        ImageView imageImplement = rootView.findViewById(R.id.imageViewPet);
        //Button buttonImplement = rootView.findViewById(R.id.buttonPet);

        textImplement.setText("Oscar " + Integer.toString(args.getInt(ARG_OBJECT)));

        Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Finalnew.ttf");
        textImplement.setTypeface(custom_font);

        return rootView;
    }
}
