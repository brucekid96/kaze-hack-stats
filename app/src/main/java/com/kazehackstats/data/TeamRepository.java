package com.kazehackstats.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TeamRepository {

  private TeamDao teamDao;
  private Executor executor;

  public TeamRepository(Context context) {
    MainDatabase db = MainDatabase.getDatabase(context);
    teamDao = db.teamDao();
    executor = Executors.newSingleThreadExecutor();
  }


  public LiveData<Integer> getTotalMatchesByTeam(String team) {
    return teamDao.getTotalMatchesByTeam(team);
  }

  public LiveData<List<String>> getAllTeams() {
    return teamDao.getAllTeams();
  }

  private static volatile TeamRepository INSTANCE;



}
