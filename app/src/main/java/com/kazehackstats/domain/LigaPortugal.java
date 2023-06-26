package com.kazehackstats.domain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.kazehackstats.R;

public class LigaPortugal extends AppCompatActivity {
  private CardView mShots;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.la_liga_portugal);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);



    mShots = findViewById(R.id.shots_card);


  }
}
