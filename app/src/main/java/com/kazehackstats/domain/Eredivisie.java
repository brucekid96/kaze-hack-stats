package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.kazehackstats.R;
import com.kazehackstats.data.MatchRepository;

import io.reactivex.disposables.CompositeDisposable;

public class Eredivisie extends AppCompatActivity {
  private static final String DBG_TAG = Eredivisie.class.getSimpleName();
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
  private CompositeDisposable mDisposable = new CompositeDisposable();

  private MatchRepository matchRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.premiere_league);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mShots = findViewById(R.id.shots_card);
    Intent a = new Intent(this, ShotsStandings.class);
    a.putExtra("league","Eredivisie");
    mShots.setOnClickListener(view -> startActivity(a));


    mShotsOnGoal = findViewById(R.id.shots_on_g_card);
    Intent b = new Intent(this, ShotsOnGoalStandings.class);
    b.putExtra("league","Eredivisie");
    mShotsOnGoal.setOnClickListener(view -> startActivity(new Intent(b)));

    mCorners = findViewById(R.id.corners_card);
    Intent c = new Intent(this, CornersStandings.class);
    c.putExtra("league","Eredivisie");
    mCorners.setOnClickListener(view -> startActivity(new Intent(c)));

    mThrowsIn = findViewById(R.id.throws_in_card);
    Intent d = new Intent(this, ThrowsInStandings.class);
    d.putExtra("league","Eredivisie");
    mThrowsIn.setOnClickListener(view -> startActivity(d));

    mSaves = findViewById(R.id.saves_card);
    Intent e = new Intent(this, SavesStandings.class);
    e.putExtra("league","Eredivisie");
    mSaves.setOnClickListener(view -> startActivity(e));

    mFouls = findViewById(R.id.fouls_card);
    Intent f = new Intent(this, FoulsStandings.class);
    f.putExtra("league","Eredivisie");
    mFouls.setOnClickListener(view -> startActivity(f));

    mTackles = findViewById(R.id.tackles_card);
    Intent g = new Intent(this, TacklesStandings.class);
    g.putExtra("league","Eredivisie");
    mTackles.setOnClickListener(view -> startActivity(g));

    mHShots = findViewById(R.id.home_shots_card);
    Intent h = new Intent(this, HomeShotsStandings.class);
    h.putExtra("league","Eredivisie");
    mHShots.setOnClickListener(view -> startActivity(h));

    mHShotsOnGoal= findViewById(R.id.home_shots_on_g_card);
    Intent i = new Intent(this, HomeShotsOnGoalStandings.class);
    i.putExtra("league","Eredivisie");
    mHShotsOnGoal.setOnClickListener(view -> startActivity(i));
    mHThrowsIn= findViewById(R.id.home_throws_in_card);
    Intent j = new Intent(this, HomeThrowsInStandings.class);
    j.putExtra("league","Eredivisie");
    mHThrowsIn.setOnClickListener(view -> startActivity(j));

    mHCorners= findViewById(R.id.home_corners_card);
    Intent k = new Intent(this, HomeCornersStandings.class);
    k.putExtra("league","Eredivisie");
    mHCorners.setOnClickListener(view -> startActivity(k));

    mHSaves= findViewById(R.id.home_saves_card);
    Intent l = new Intent(this, HomeSavesStandings.class);
    l.putExtra("league","Eredivisie");
    mHSaves.setOnClickListener(view -> startActivity(l));

    mHFouls= findViewById(R.id.home_fouls_card);
    Intent m = new Intent(this, HomeFoulsStandings.class);
    m.putExtra("league","Eredivisie");
    mHFouls.setOnClickListener(view -> startActivity(m));

    mHTackles= findViewById(R.id.home_tackles_card);
    Intent n = new Intent(this, HomeTacklesStandings.class);
    n.putExtra("league","Eredivisie");
    mHTackles.setOnClickListener(view -> startActivity(n));

    mAShots= findViewById(R.id.away_shots_card);
    Intent o = new Intent(this, AwayShotsStandings.class);
    o.putExtra("league","Eredivisie");
    mAShots.setOnClickListener(view -> startActivity(o));

    mAShotsOnGoal= findViewById(R.id.away_shots_on_g_card);
    Intent p = new Intent(this, AwayShotsOnGoalStandings.class);
    p.putExtra("league","Eredivisie");
    mAShotsOnGoal.setOnClickListener(view -> startActivity(p));

    mACorners= findViewById(R.id.Away_corners_card);
    Intent q = new Intent(this, AwayCornersStandings.class);
    q.putExtra("league","Eredivisie");
    mACorners.setOnClickListener(view -> startActivity(q));

    mAThrowsIn= findViewById(R.id.away_throws_in_card);
    Intent r = new Intent(this, AwayThrowsInStandings.class);
    r.putExtra("league","Eredivisie");
    mAThrowsIn.setOnClickListener(view -> startActivity(r));

    mASaves= findViewById(R.id.away_saves_card);
    Intent s = new Intent(this, AwaySavesStandings.class);
    s.putExtra("league","Eredivisie");
    mASaves.setOnClickListener(view -> startActivity(s));

    mAFouls= findViewById(R.id.away_fouls_card);
    Intent t = new Intent(this, AwayFoulsStandings.class);
    t.putExtra("league","Eredivisie");
    mAFouls.setOnClickListener(view -> startActivity(t));

    mATackles= findViewById(R.id.away_tackles_card);
    Intent u = new Intent(this, AwayTacklesStandings.class);
    u.putExtra("league","Eredivisie");
    mATackles.setOnClickListener(view -> startActivity(u));


  }
}
