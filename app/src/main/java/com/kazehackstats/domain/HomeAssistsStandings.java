package com.kazehackstats.domain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kazehackstats.R;
import com.kazehackstats.data.BasketballMatch;
import com.kazehackstats.data.BasketballMatchRepository;
import com.kazehackstats.data.TeamStatLine;

import java.util.List;

public class HomeAssistsStandings extends AppCompatActivity {

  private RecyclerView mRecyclerView;
  private SavesStandingsAdapter adapter;
  private List<BasketballMatch> basketballMatchList;
  private Context mContext;
  private CardView mShots;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.assists_standings);

    Toolbar toolbar = findViewById(R.id.toolbarH);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);

    mRecyclerView =findViewById(R.id.recycleview);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new SavesStandingsAdapter(this);
    mRecyclerView.setAdapter(adapter);

    BasketballMatchRepository basketballMatchRepository = new BasketballMatchRepository(this);
    List<BasketballMatch> sampleMatches = SampleData.getSampleBasketballMatches();
    basketballMatchRepository.insertAll(sampleMatches);

    Intent intent = getIntent();
    String league = intent.getStringExtra("league");

    basketballMatchRepository.getHomeAssistsStats(league).observe(this, new Observer<List<TeamStatLine>>() {
      @Override
      public void onChanged(@Nullable List<TeamStatLine> teamStatLines) {
        adapter.setTeamStatLineList(teamStatLines);
      }
    });




  };


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.trier, menu);

    return true;
  }




  @Override
  public boolean onOptionsItemSelected(MenuItem item) {


    int id = item.getItemId();

    if (id == R.id.filter) {
      return true;
    }

    if (id == R.id.all_games) {
      return true;
    }

    if (id == R.id.last_five) {

      return true;
    }



    return super.onOptionsItemSelected(item);
  }
}
