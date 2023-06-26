package com.kazehackstats.domain;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.kazehackstats.R;

public class LaLiga extends AppCompatActivity {
  private CardView mShots;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.la_liga);


    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);



    mShots = findViewById(R.id.shots_card);


  }
}
