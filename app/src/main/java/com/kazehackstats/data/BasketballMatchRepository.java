package com.kazehackstats.data;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.kazehackstats.data.remote.AmplifyAPI;
import com.kazehackstats.data.remote.AppSyncApi;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class BasketballMatchRepository {
  private BasketballMatchDao basketballMatchDao;
  private Executor executor;
  private MainDatabase db;
  private AppSyncApi appSyncApi;

  public BasketballMatchRepository(Context context) {
    appSyncApi = new AppSyncApi(context);
    db = MainDatabase.getDatabase(context);
    basketballMatchDao = db.basketballMatchDao();
    executor = Executors.newSingleThreadExecutor();
  }

  public Observable<List<BasketballMatch>> getAllMatches() {
    return basketballMatchDao.getAllMatches();
  }

  public Completable insert(BasketballMatch basketballMatch) {
    return db.basketballMatchDao().insert(basketballMatch)
        .andThen(AppSyncApi.addBasketballMatch(basketballMatch));
  }
  public Completable update(BasketballMatch basketballMatch) {
    return db.basketballMatchDao().update(basketballMatch)
        .andThen(AppSyncApi.updateBasketballMatch(basketballMatch));
  }

  public Completable delete(BasketballMatch basketballMatch) {
    return db.basketballMatchDao().delete(basketballMatch)
        .andThen(AmplifyAPI.removeBasketballMatch(basketballMatch));
  }

  public LiveData<List<TeamStatLine>> getTwoPtsStats(String league) {
    return basketballMatchDao.getTwoPtsStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeTwoPtsStats(String league) {
    return basketballMatchDao.getHomeTwoPtsStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayTwoPtsStats(String league) {
    return basketballMatchDao.getAwayTwoPtsStats(league);
  }

  public LiveData<List<TeamStatLine>> getThreePtsStats(String league) {
    return basketballMatchDao.getThreePtsStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeThreePtsStats(String league) {
    return basketballMatchDao.getHomeThreePtsStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayThreePtsStats(String league) {
    return basketballMatchDao.getAwayThreePtsStats(league);
  }

  public LiveData<List<TeamStatLine>> getReboundsStats(String league) {
    return basketballMatchDao.getReboundsStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeReboundsStats(String league) {
    return basketballMatchDao.getHomeReboundsStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayReboundsStats(String league) {
    return basketballMatchDao.getAwayReboundsStats(league);
  }

  public LiveData<List<TeamStatLine>> getAssistsStats(String league) {
    return basketballMatchDao.getAssistsStats(league);
  }
  public LiveData<List<TeamStatLine>> getHomeAssistsStats(String league) {
    return basketballMatchDao.getHomeAssistsStats(league);
  }
  public LiveData<List<TeamStatLine>> getAwayAssistsStats(String league) {
    return basketballMatchDao.getAwayAssistsStats(league);
  }

  public void insertAll(List<BasketballMatch> basketballMatches) {
    executor.execute(() -> basketballMatchDao.bulkInsert(basketballMatches)
        );
  }

  public Completable syncBasketballMatchs() {
    return  appSyncApi.getBasketballMatchs()
        .flatMapCompletable(db.basketballMatchDao()::bulkInsert);
  }
}
