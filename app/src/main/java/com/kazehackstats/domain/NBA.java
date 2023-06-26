package com.kazehackstats.domain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.kazehackstats.R;

public class NBA extends AppCompatActivity {
  private CardView m2pts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.nba);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);



    m2pts = findViewById(R.id.two_pts_card);


  }
}
