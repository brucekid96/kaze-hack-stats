package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;
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

public class PremiereLeague extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

  private CardView mShots;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.premiere_league);

    DrawerLayout drawer =  findViewById(R.id.drawer_layout);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);



    mShots = findViewById(R.id.shots_card);
    mShots.setOnClickListener(view -> startActivity(new Intent(PremiereLeague.this, ShotsStandings.class)));



    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView =
        findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);


  }

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
