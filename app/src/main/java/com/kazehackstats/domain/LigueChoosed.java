package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import com.kazehackstats.R;

public class LigueChoosed extends AppCompatActivity {
  private CardView mPremierLeague;
  private CardView mLaLiga;
  private CardView mSerieA;
  private CardView mBundesliga;
  private CardView mLigue1;
  private CardView mChampionship;
  private CardView mEredivisie;
  private CardView mjupiterProLeague;
  private CardView mLigaPortugal;
  private CardView mNBA;




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ligue_choosed_item);
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

    mPremierLeague = findViewById(R.id.premiere_league_card);
    mPremierLeague.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, PremiereLeague.class)));
    mLaLiga = findViewById(R.id.laliga_card);
    mLaLiga.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, LaLiga.class)));
    mSerieA = findViewById(R.id.serie_a_card);
    mSerieA.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, SerieA.class)));
    mBundesliga = findViewById(R.id.bundesliga_card);
    mBundesliga.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Bundesliga.class)));
    mLigue1 = findViewById(R.id.Ligue1_card);
    mLigue1.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Ligue1.class)));
    mChampionship = findViewById(R.id.championship_card);
    mChampionship.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Championship.class)));
    mEredivisie = findViewById(R.id.eredivisie_card);
    mEredivisie.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Eredivisie.class)));
    mjupiterProLeague = findViewById(R.id.jupiler_pro_league_card);
    mjupiterProLeague.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, JupilerPro.class)));
    mLigaPortugal = findViewById(R.id.liga_portugal_card);
    mLigaPortugal.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, LigaPortugal.class)));
    mNBA = findViewById(R.id.nba_card);
    mNBA.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, NBA.class)));


  }
}
