package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.view.PlanetViewHolder;

public class DisplayActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView imageImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        nameTextView = findViewById(R.id.name_textView_DisplayActivity);
        numberTextView = findViewById(R.id.number_textView_DisplayActivity);
        imageImageView = findViewById(R.id.image_textView_DisplayActivity);

        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra(PlanetViewHolder.NAME_KEY));
        numberTextView.setText(intent.getStringExtra(PlanetViewHolder.NUMBER_KEY));
        Picasso.get().load(intent.getStringExtra(PlanetViewHolder.IMAGE_KEY)).into(imageImageView);


        /*
        * TODO: Add logic that will:
        * TODO done! 1. Receive values from sending intent
        * TODO done! 2. Create a TextView instance for the Planet Name
        * TODO done! 3. Create a TextView instance for the Planet Number count
        * TODO done! 4. Create an ImageView for the image url
        * TODO done! 5. Display each value in views - Strings for TextViews, and Picasso for the ImageView
        */
    }
}
