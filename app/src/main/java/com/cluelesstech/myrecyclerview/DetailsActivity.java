package com.cluelesstech.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView name, description, rating;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name = findViewById(R.id.dNameID);
        description = findViewById(R.id.dDescriptionId);
        rating = findViewById(R.id.dRatingID);

        extras = getIntent().getExtras();

        if(extras!=null){
            name.setText(extras.getString("Name"));
            description.setText(extras.getString("Description"));
            rating.setText(extras.getString("Rating"));

        }
    }
}