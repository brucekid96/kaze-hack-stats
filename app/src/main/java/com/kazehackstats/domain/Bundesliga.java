package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.kazehackstats.R;

public class Bundesliga extends AppCompatActivity {
  private static final String DBG_TAG = Bundesliga.class.getSimpleName();
  private CardView mShots;
  private CardView mHShots;
  private CardView mShotsOnGoal;
  private CardView mHShotsOnGoal;
  private CardView mCorners;
  private CardView mHCorners;
  private CardView mThrowsIn;
  private CardView mHThrowsIn;
  private CardView mSaves;
  private CardView mHSaves;
  private CardView mFouls;
  private CardView mHFouls;
  private CardView mTackles;
  private CardView mHTackles;
  private CardView mAShots;
  private CardView mAShotsOnGoal;
  private CardView mACorners;
  private CardView mAThrowsIn;
  private CardView mASaves;
  private CardView mAFouls;
  private CardView mATackles;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.premiere_league);

    DrawerLayout drawer = findViewById(R.id.drawer_layout);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    mShots = findViewById(R.id.shots_card);
    Intent a = new Intent(this, ShotsStandings.class);
    a.putExtra("league","Bundesliga");
    mShots.setOnClickListener(view -> startActivity(a));


    mShotsOnGoal = findViewById(R.id.shots_on_g_card);
    Intent b = new Intent(this, ShotsOnGoalStandings.class);
    b.putExtra("league","Bundesliga");
    mShotsOnGoal.setOnClickListener(view -> startActivity(new Intent(b)));

    mCorners = findViewById(R.id.corners_card);
    Intent c = new Intent(this, CornersStandings.class);
    c.putExtra("league","Bundesliga");
    mCorners.setOnClickListener(view -> startActivity(new Intent(c)));

    mThrowsIn = findViewById(R.id.throws_in_card);
    Intent d = new Intent(this, ThrowsInStandings.class);
    d.putExtra("league","Bundesliga");
    mThrowsIn.setOnClickListener(view -> startActivity(d));

    mSaves = findViewById(R.id.saves_card);
    Intent e = new Intent(this, SavesStandings.class);
    e.putExtra("league","Bundesliga");
    mSaves.setOnClickListener(view -> startActivity(e));

    mFouls = findViewById(R.id.fouls_card);
    Intent f = new Intent(this, FoulsStandings.class);
    f.putExtra("league","Bundesliga");
    mFouls.setOnClickListener(view -> startActivity(f));

    mTackles = findViewById(R.id.tackles_card);
    Intent g = new Intent(this, TacklesStandings.class);
    g.putExtra("league","Bundesliga");
    mTackles.setOnClickListener(view -> startActivity(g));

    mHShots = findViewById(R.id.home_shots_card);
    Intent h = new Intent(this, HomeShotsStandings.class);
    h.putExtra("league","Bundesliga");
    mHShots.setOnClickListener(view -> startActivity(h));

    mHShotsOnGoal= findViewById(R.id.home_shots_on_g_card);
    Intent i = new Intent(this, HomeShotsOnGoalStandings.class);
    i.putExtra("league","Bundesliga");
    mHShotsOnGoal.setOnClickListener(view -> startActivity(i));
    mHThrowsIn= findViewById(R.id.home_throws_in_card);
    Intent j = new Intent(this, HomeThrowsInStandings.class);
    j.putExtra("league","Bundesliga");
    mHThrowsIn.setOnClickListener(view -> startActivity(j));

    mHCorners= findViewById(R.id.home_corners_card);
    Intent k = new Intent(this, HomeCornersStandings.class);
    k.putExtra("league","Bundesliga");
    mHCorners.setOnClickListener(view -> startActivity(k));

    mHSaves= findViewById(R.id.home_saves_card);
    Intent l = new Intent(this, HomeSavesStandings.class);
    l.putExtra("league","Bundesliga");
    mHSaves.setOnClickListener(view -> startActivity(l));

    mHFouls= findViewById(R.id.home_fouls_card);
    Intent m = new Intent(this, HomeFoulsStandings.class);
    m.putExtra("league","Bundesliga");
    mHFouls.setOnClickListener(view -> startActivity(m));

    mHTackles= findViewById(R.id.home_tackles_card);
    Intent n = new Intent(this, HomeTacklesStandings.class);
    n.putExtra("league","Bundesliga");
    mHTackles.setOnClickListener(view -> startActivity(n));

    mAShots= findViewById(R.id.away_shots_card);
    Intent o = new Intent(this, AwayShotsStandings.class);
    o.putExtra("league","Bundesliga");
    mAShots.setOnClickListener(view -> startActivity(o));

    mAShotsOnGoal= findViewById(R.id.away_shots_on_g_card);
    Intent p = new Intent(this, AwayShotsOnGoalStandings.class);
    p.putExtra("league","Bundesliga");
    mAShotsOnGoal.setOnClickListener(view -> startActivity(p));

    mACorners= findViewById(R.id.Away_corners_card);
    Intent q = new Intent(this, AwayCornersStandings.class);
    q.putExtra("league","Bundesliga");
    mACorners.setOnClickListener(view -> startActivity(q));

    mAThrowsIn= findViewById(R.id.away_throws_in_card);
    Intent r = new Intent(this, AwayThrowsInStandings.class);
    r.putExtra("league","Bundesliga");
    mAThrowsIn.setOnClickListener(view -> startActivity(r));

    mASaves= findViewById(R.id.away_saves_card);
    Intent s = new Intent(this, AwaySavesStandings.class);
    s.putExtra("league","Bundesliga");
    mASaves.setOnClickListener(view -> startActivity(s));

    mAFouls= findViewById(R.id.away_fouls_card);
    Intent t = new Intent(this, AwayFoulsStandings.class);
    t.putExtra("league","Bundesliga");
    mAFouls.setOnClickListener(view -> startActivity(t));

    mATackles= findViewById(R.id.away_tackles_card);
    Intent u = new Intent(this, AwayTacklesStandings.class);
    u.putExtra("league","Bundesliga");
    mATackles.setOnClickListener(view -> startActivity(u));
  }

}
