package org.pursuit.unit_03_assessment.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_03_assessment.DisplayActivity;
import org.pursuit.unit_03_assessment.R;


import org.pursuit.unit_03_assessment.model.MyPlanets;

public class PlanetViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView imageImageView;
    private MyPlanets myPlanets;
    private Intent intent;
    private SharedPreferences sharedPreferences;

    public static final String NAME_KEY = "name";
    public static final String NUMBER_KEY = "number";
    public static final String IMAGE_KEY = "image";

    private static final String TAG = "image_call";


    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_textView_RecyclerView);
        numberTextView = itemView.findViewById(R.id.number_textView_RecyclerView);
        //imageImageView = itemView.findViewById(R.id.image_textView_RecyclerView);
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);

    }

    public void onBind(final MyPlanets myPlanets) {
        this.myPlanets=myPlanets;
        nameTextView.setText(myPlanets.getName());
        //numberTextView.setText(myPlanets.getNumber());
        //imageImageView.setImageURI(myPlanets.getImage());
        //Picasso.get().load(myPlanets.getImage()).into(imageImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra(NAME_KEY, myPlanets.getName());
                intent.putExtra(NUMBER_KEY, myPlanets.getNumber());
                intent.putExtra(IMAGE_KEY, myPlanets.getImage());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
