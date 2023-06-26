package com.kazehackstats.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public class MatchRepository {


  private MatchDao matchDao;
  private Executor executor;

  public MatchRepository(Context context) {
    MainDatabase db = MainDatabase.getDatabase(context);
    matchDao = db.matchDao();
    executor = Executors.newSingleThreadExecutor();
  }

    public LiveData<List<Match>> getAllMatches() {
   return matchDao.getAllMatches();
  }

  public LiveData<List<Match>> getAllMatchesByShotsWinner() {
    return matchDao.getAllMatchesByShotsWinner();
  }

  public LiveData<List<String>> getTeamsThatPlayedAtLeastOneMatch() {
    return matchDao.getTeamsThatPlayedAtLeastOneMatch();
  }
  public LiveData<Integer> getMatchesPlayedByTeam(String team) {
    return matchDao.getMatchesPlayedByTeam(team);
  }

  public void insertAll(List<Match> matches) {
    executor.execute(() -> matchDao.bulkInsert(matches));
  }



}
