package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.kazehackstats.R;

public class NBA extends AppCompatActivity {
  private CardView mTwoPts;
  private CardView mHTwoPts;
  private CardView mThreePts;
  private CardView mHThreePts;
  private CardView mRebounds;
  private CardView mHRebounds;
  private CardView mAssists;
  private CardView mHAssists;
  private CardView mATwoPts;
  private CardView mAThreePts;
  private CardView mARebounds;
  private CardView mAAssists;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.nba);

    DrawerLayout drawer = findViewById(R.id.drawer_layout);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    mTwoPts = findViewById(R.id.two_pts_card);
    Intent a = new Intent(this, TwoPtsStandings.class);
    a.putExtra("league","NBA");
    mTwoPts.setOnClickListener(view -> startActivity(a));


    mThreePts = findViewById(R.id.three_pts_card);
    Intent b = new Intent(this, ThreePtsStandings.class);
    b.putExtra("league","NBA");
    mThreePts.setOnClickListener(view -> startActivity(new Intent(b)));

    mRebounds = findViewById(R.id.rebounds_card);
    Intent c = new Intent(this, ReboundsStandings.class);
    c.putExtra("league","NBA");
    mRebounds.setOnClickListener(view -> startActivity(new Intent(c)));

    mAssists = findViewById(R.id.assists_card);
    Intent d = new Intent(this, AssistsStandings.class);
    d.putExtra("league","NBA");
    mAssists.setOnClickListener(view -> startActivity(d));


    mHTwoPts = findViewById(R.id.home_two_pts_card);
    Intent h = new Intent(this, HomeTwoPtsStandings.class);
    h.putExtra("league","NBA");
    mHTwoPts.setOnClickListener(view -> startActivity(h));

    mHThreePts= findViewById(R.id.home_three_pts_card);
    Intent i = new Intent(this, HomeThreePtsStandings.class);
    i.putExtra("league","NBA");
    mHThreePts.setOnClickListener(view -> startActivity(i));
    mHThreePts= findViewById(R.id.home_three_pts_card);
    Intent j = new Intent(this, HomeThreePtsStandings.class);
    j.putExtra("league","NBA");
    mHThreePts.setOnClickListener(view -> startActivity(j));

    mHRebounds= findViewById(R.id.home_rebounds_card);
    Intent k = new Intent(this, HomeReboundsStandings.class);
    k.putExtra("league","NBA");
    mHRebounds.setOnClickListener(view -> startActivity(k));

    mHAssists= findViewById(R.id.home_assists_card);
    Intent l = new Intent(this, HomeAssistsStandings.class);
    l.putExtra("league","NBA");
    mHAssists.setOnClickListener(view -> startActivity(l));


    mATwoPts= findViewById(R.id.away_two_pts_card);
    Intent o = new Intent(this, AwayTwoPtsStandings.class);
    o.putExtra("league","NBA");
    mATwoPts.setOnClickListener(view -> startActivity(o));

    mAThreePts= findViewById(R.id.away_three_pts_card);
    Intent p = new Intent(this, AwayThreePtsStandings.class);
    p.putExtra("league","NBA");
    mAThreePts.setOnClickListener(view -> startActivity(p));

    mARebounds= findViewById(R.id.Away_rebound_card);
    Intent q = new Intent(this, AwayReboundsStandings.class);
    q.putExtra("league","NBA");
    mARebounds.setOnClickListener(view -> startActivity(q));

    mAAssists= findViewById(R.id.away_assists_card);
    Intent r = new Intent(this, AwayAssistsStandings.class);
    r.putExtra("league","NBA");
    mAAssists.setOnClickListener(view -> startActivity(r));


  }
}
