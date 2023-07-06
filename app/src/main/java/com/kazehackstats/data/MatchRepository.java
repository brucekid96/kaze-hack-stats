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

  public LiveData<List<TeamStatLine>> getShotStats(String league) {
    return matchDao.getShotStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeShotStats(String league) {
    return matchDao.getHomeShotStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayShotStats(String league) {
    return matchDao.getAwayShotStats(league);
  }
  public LiveData<List<TeamStatLine>> getShotOnGoalStats(String league) {
    return matchDao.getShotOnGoalStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeShotOnGoalStats(String league) {
    return matchDao.getHomeShotOnGoalStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayShotOnGoalStats(String league) {
    return matchDao.getAwayShotOnGoalStats(league);
  }
  public LiveData<List<TeamStatLine>> getCornersStats(String league) {
    return matchDao.getCornersStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeCornersStats(String league) {
    return matchDao.getHomeCornersStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayCornersStats(String league) {
    return matchDao.getAwayCornersStats(league);
  }
  public LiveData<List<TeamStatLine>> getThrowsInStats(String league) {
    return matchDao.getThrowsInStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeThrowsInStats(String league) {
    return matchDao.getHomeThrowsInStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayThrowsInStats(String league) {
    return matchDao.getAwayThrowsInStats(league);
  }
  public LiveData<List<TeamStatLine>> getSavesStats(String league) {
    return matchDao.getSavesStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeSavesStats(String league) {
    return matchDao.getHomeSavesStats(league);
  }
  public LiveData<List<TeamStatLine>> getFoulsStats(String league) {
    return matchDao.getFoulsStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeFoulsStats(String league) {
    return matchDao.getHomeFoulsStats(league);
  }
  public LiveData<List<TeamStatLine>> getTacklesStats(String league) {
    return matchDao.getTacklesStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeTacklesStats(String league) {
    return matchDao.getHomeTacklesStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayTacklesStats(String league) {
    return matchDao.getAwayTacklesStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwaySavesStats(String league) {
    return matchDao.getAwaySavesStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayFoulsStats(String league) {
    return matchDao.getAwayFoulsStats(league);
  }


  public void insertAll(List<Match> matches) {
    executor.execute(() -> matchDao.bulkInsert(matches));
  }



}
