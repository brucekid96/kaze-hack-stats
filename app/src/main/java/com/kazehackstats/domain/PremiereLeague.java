package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.kazehackstats.R;
import com.kazehackstats.data.BasketballMatchRepository;
import com.kazehackstats.data.MatchRepository;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PremiereLeague extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  private static final String DBG_TAG = PremiereLeague.class.getSimpleName();
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

    DrawerLayout drawer =  findViewById(R.id.drawer_layout);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    mShots = findViewById(R.id.shots_card);
    Intent a = new Intent(PremiereLeague.this, ShotsStandings.class);
    a.putExtra("league","Premiere League");
    mShots.setOnClickListener(view -> startActivity(a));
    

    mShotsOnGoal = findViewById(R.id.shots_on_g_card);
    Intent b = new Intent(PremiereLeague.this, ShotsOnGoalStandings.class);
    b.putExtra("league","Premiere League");
    mShotsOnGoal.setOnClickListener(view -> startActivity(new Intent(b)));

    mCorners = findViewById(R.id.corners_card);
    Intent c = new Intent(PremiereLeague.this, CornersStandings.class);
    c.putExtra("league","Premiere League");
    mCorners.setOnClickListener(view -> startActivity(new Intent(c)));

    mThrowsIn = findViewById(R.id.throws_in_card);
    Intent d = new Intent(PremiereLeague.this, ThrowsInStandings.class);
    d.putExtra("league","Premiere League");
    mThrowsIn.setOnClickListener(view -> startActivity(d));

    mSaves = findViewById(R.id.saves_card);
    Intent e = new Intent(PremiereLeague.this, SavesStandings.class);
    e.putExtra("league","Premiere League");
    mSaves.setOnClickListener(view -> startActivity(e));

    mFouls = findViewById(R.id.fouls_card);
    Intent f = new Intent(PremiereLeague.this, FoulsStandings.class);
    f.putExtra("league","Premiere League");
    mFouls.setOnClickListener(view -> startActivity(f));

    mTackles = findViewById(R.id.tackles_card);
    Intent g = new Intent(PremiereLeague.this, TacklesStandings.class);
    g.putExtra("league","Premiere League");
    mTackles.setOnClickListener(view -> startActivity(g));

    mHShots = findViewById(R.id.home_shots_card);
    Intent h = new Intent(PremiereLeague.this, HomeShotsStandings.class);
    h.putExtra("league","Premiere League");
    mHShots.setOnClickListener(view -> startActivity(h));

    mHShotsOnGoal= findViewById(R.id.home_shots_on_g_card);
    Intent i = new Intent(PremiereLeague.this, HomeShotsOnGoalStandings.class);
    i.putExtra("league","Premiere League");
    mHShotsOnGoal.setOnClickListener(view -> startActivity(i));
    mHThrowsIn= findViewById(R.id.home_throws_in_card);
    Intent j = new Intent(PremiereLeague.this, HomeThrowsInStandings.class);
    j.putExtra("league","Premiere League");
    mHThrowsIn.setOnClickListener(view -> startActivity(j));

    mHCorners= findViewById(R.id.home_corners_card);
    Intent k = new Intent(PremiereLeague.this, HomeCornersStandings.class);
    k.putExtra("league","Premiere League");
    mHCorners.setOnClickListener(view -> startActivity(k));

    mHSaves= findViewById(R.id.home_saves_card);
    Intent l = new Intent(PremiereLeague.this, HomeSavesStandings.class);
    l.putExtra("league","Premiere League");
    mHSaves.setOnClickListener(view -> startActivity(l));

    mHFouls= findViewById(R.id.home_fouls_card);
    Intent m = new Intent(PremiereLeague.this, HomeFoulsStandings.class);
    m.putExtra("league","Premiere League");
    mHFouls.setOnClickListener(view -> startActivity(m));

    mHTackles= findViewById(R.id.home_tackles_card);
    Intent n = new Intent(PremiereLeague.this, HomeTacklesStandings.class);
    n.putExtra("league","Premiere League");
    mHTackles.setOnClickListener(view -> startActivity(n));

    mAShots= findViewById(R.id.away_shots_card);
    Intent o = new Intent(PremiereLeague.this, AwayShotsStandings.class);
    o.putExtra("league","Premiere League");
    mAShots.setOnClickListener(view -> startActivity(o));

    mAShotsOnGoal= findViewById(R.id.away_shots_on_g_card);
    Intent p = new Intent(PremiereLeague.this, AwayShotsOnGoalStandings.class);
    p.putExtra("league","Premiere League");
    mAShotsOnGoal.setOnClickListener(view -> startActivity(p));

    mACorners= findViewById(R.id.Away_corners_card);
    Intent q = new Intent(PremiereLeague.this, AwayCornersStandings.class);
    q.putExtra("league","Premiere League");
    mACorners.setOnClickListener(view -> startActivity(q));

    mAThrowsIn= findViewById(R.id.away_throws_in_card);
    Intent r = new Intent(PremiereLeague.this, AwayThrowsInStandings.class);
    r.putExtra("league","Premiere League");
    mAThrowsIn.setOnClickListener(view -> startActivity(r));

    mASaves= findViewById(R.id.away_saves_card);
    Intent s = new Intent(PremiereLeague.this, AwaySavesStandings.class);
    s.putExtra("league","Premiere League");
    mASaves.setOnClickListener(view -> startActivity(s));

    mAFouls= findViewById(R.id.away_fouls_card);
    Intent t = new Intent(PremiereLeague.this, AwayFoulsStandings.class);
    t.putExtra("league","Premiere League");
    mAFouls.setOnClickListener(view -> startActivity(t));

    mATackles= findViewById(R.id.away_tackles_card);
    Intent u = new Intent(PremiereLeague.this, AwayTacklesStandings.class);
    u.putExtra("league","Premiere League");
    mATackles.setOnClickListener(view -> startActivity(u));

    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView =
        findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

//    mDisposable.add(
//        Completable.concatArray(
//            syncMatches())
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(() -> {
//            }, io -> {
//              Log.d(DBG_TAG, "Synchronization failed: " + io.toString() + ", cause = " + io.getCause());
//            }));


  }

//  private Completable syncMatches() {
//    return Single.fromCallable(() -> new MatchRepository(this))
//        .flatMapCompletable(MatchRepository::syncMatchs);
//  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout)
        findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    Intent intent = null;
    int id = item.getItemId();

    if (id == R.id.nav_home) {
      // Handle the camera action
      Toast.makeText(getApplicationContext(),"home",Toast.LENGTH_LONG).show();

    } /*else if (id == R.id.nav_home_2points) {
      startActivity(new Intent(MainActivity.this, HomeTeam2points.class));

    } else if (id == R.id.nav_home_3points) {
      startActivity(new Intent(MainActivity.this, HomeTeam3points.class));


    }  else if (id == R.id.nav_home_rebounds) {
      startActivity(new Intent(MainActivity.this, HomeTeamRebounds.class));
    }  else if (id == R.id.nav_home_assists) {
      startActivity(new Intent(MainActivity.this, HomeTeamAssists.class));
    }  else if (id == R.id.nav_home_fautes) {
      startActivity(new Intent( MainActivity.this, HomeTeamFautes.class));
    }
    else if (id == R.id.nav_away_2points) {
      startActivity(new Intent( MainActivity.this, AwayTeam2points.class));
    }  else if (id == R.id.nav_away_3points) {
      startActivity(new Intent( MainActivity.this, AwayTeam3points.class));
    } else if (id == R.id.nav_away_rebounds) {
      startActivity(new Intent( MainActivity.this, AwayTeamRebounds.class));
    }  else if (id == R.id.nav_away_assists) {
      startActivity(new Intent( MainActivity.this, AwayTeamAssists.class));
    }  else if (id == R.id.nav_away_fautes) {
      startActivity(new Intent( MainActivity.this, AwayTeamFautes.class));
    } else if (id == R.id.nav_overall_2points) {
      startActivity(new Intent( MainActivity.this, OverAll2points.class));
    } else if (id == R.id.nav_overall_3points) {
      startActivity(new Intent( MainActivity.this, OverAll3points.class));
    } else if (id == R.id.nav_overall_rebounds) {
      startActivity(new Intent( MainActivity.this, OverAllRebounds.class));
    } else if (id == R.id.nav_overall_assists) {
      startActivity(new Intent( MainActivity.this, OverAllAssists.class));
    } else if (id == R.id.nav_overall_fautes) {
      startActivity(new Intent( MainActivity.this, OverAllfautes.class));
    }*/
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
}
