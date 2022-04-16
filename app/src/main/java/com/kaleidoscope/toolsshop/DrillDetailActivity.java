package com.kaleidoscope.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private ImageView imageViewItem;
    private TextView textViewName;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        imageViewItem = findViewById(R.id.imageViewItem);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);

        Intent intent = getIntent();
        if (intent.hasExtra("info") &&
                intent.hasExtra("title") &&
                intent.hasExtra("resId")) {

            imageViewItem.setImageResource(intent.getIntExtra("resId", -1));
            textViewName.setText(intent.getStringExtra("title"));
            textViewDescription.setText(intent.getStringExtra("info"));
        } else {
            Intent  backToCategory = new Intent(this, DrillCategoryActivity.class);
        }

    }
}



//        intent.putExtra("title", drill.getTitle());
//        intent.putExtra("info", drill.getInfo());
//        intent.putExtra("resId", drill.getImageResourceId());