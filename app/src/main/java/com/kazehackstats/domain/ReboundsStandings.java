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
import com.kazehackstats.data.Match;
import com.kazehackstats.data.MatchRepository;
import com.kazehackstats.data.TeamStatLine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ReboundsStandings extends AppCompatActivity {

  private RecyclerView mRecyclerView;
  private ReboundsStandingsAdapter adapter;
  private List<BasketballMatch> basketballMatchList;
  private Context mContext;
  private CardView mShots;
  private BasketballMatchRepository basketballMatchRepository;
  private CompositeDisposable mDisposable = new CompositeDisposable();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.rebounds_standings);

    Toolbar toolbar = findViewById(R.id.toolbarC);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);
    basketballMatchRepository = new BasketballMatchRepository(this);

    mRecyclerView =findViewById(R.id.recycleview);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new ReboundsStandingsAdapter(getListMatch(),this);
    mRecyclerView.setAdapter(adapter);

    mDisposable.add(
        basketballMatchRepository.getAllMatches()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::loadMatchs));


    basketballMatchRepository = new BasketballMatchRepository(this);
    basketballMatchRepository.insertAll(basketballMatchList);

    Intent intent = getIntent();
    String league = intent.getStringExtra("league");

    basketballMatchRepository.getReboundsStats(league).observe(this, new Observer<List<TeamStatLine>>() {
      @Override
      public void onChanged(@Nullable List<TeamStatLine> teamStatLines) {
        adapter.setTeamStatLineList(teamStatLines);
      }
    });




  };

  public void loadMatchs(List<BasketballMatch> basketballMatchs) {
    basketballMatchList = basketballMatchs;
    adapter.setData(basketballMatchs);
  }

  private List<BasketballMatch> getListMatch() {
    List<BasketballMatch> list = new ArrayList<>();
    Date date = new Date();


    return list;
  }
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
