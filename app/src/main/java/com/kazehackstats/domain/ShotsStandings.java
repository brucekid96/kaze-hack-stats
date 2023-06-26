package com.kazehackstats.domain;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kazehackstats.R;
import com.kazehackstats.data.Match;
import com.kazehackstats.data.MatchRepository;

import java.util.ArrayList;
import java.util.List;

public class ShotsStandings extends AppCompatActivity {
  private RecyclerView mRecyclerView;
  private ShotsStandingsAdapter adapter;
  private List<Match> matchList;
  private Context mContext;
  private ShotsStandingsAdapter.OnItemListener OnitemListener;
  private CardView mShots;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.shots_standings);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mRecyclerView =findViewById(R.id.recycleview);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new ShotsStandingsAdapter(this);
    mRecyclerView.setAdapter(adapter);

    MatchRepository matchRepository = new MatchRepository(this);
    List<Match> sampleMatches = SampleData.getSampleMatches();
    matchRepository.insertAll(sampleMatches);

    matchRepository.getTeamsThatPlayedAtLeastOneMatch().observe(this, new Observer<List<String>>() {
      @Override
      public void onChanged(List<String> teams) {
      }
    });
    matchRepository.getAllMatches().observe(this, new Observer<List<Match>>() {
      @Override
      public void onChanged(@Nullable List<Match> matches) {
        adapter.setMatchList(matches);
      }
    });



  }
}
