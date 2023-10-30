package com.kazehackstats.domain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;


import com.kazehackstats.R;
import com.kazehackstats.data.BasketballMatchRepository;
import com.kazehackstats.data.MatchRepository;
import com.kazehackstats.data.remote.AmplifyAPI;
import com.kazehackstats.data.remote.AppSyncApi;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LigueChoosed extends AppCompatActivity {
  private static final String DBG_TAG = LigueChoosed.class.getSimpleName();
  private CardView mPremierLeague;
  private CardView mLaLiga;
  private CardView mSerieA;
  private CardView mBundesliga;
  private CardView mLigue1;
  private CardView mChampionship;
  private CardView mEredivisie;
  private CardView mjupiterProLeague;
  private CardView mLigaPortugal;
  private CardView mNBA;
  private CardView mAddFootGame;
  private CardView mAddBasketballGame;


  AppSyncApi mAppSyncApi;

  private MatchRepository mMatchRepository;
  private BasketballMatchRepository mBasketballMatchRepository;
  private CompositeDisposable mDisposable = new CompositeDisposable();

  public static void launch(Context context, boolean clearHistory) {
    Intent intent = new Intent(context, LigueChoosed.class);
    if (clearHistory) {
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    context.startActivity(intent);
  }

  public static void launch(Context context) {
    launch(context, true);
  }



  @Override
  protected void onStart() {
    super.onStart();
    mAppSyncApi = new AppSyncApi(getApplicationContext());

    mMatchRepository = new MatchRepository(getApplicationContext());

    mBasketballMatchRepository= new BasketballMatchRepository(getApplicationContext());

//    mAppSyncApi.getMatchs()
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(matches -> Log.d(DBG_TAG,"appsync matches"+matches), e -> {});

    mMatchRepository.syncMatchs()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(() ->  {}, e -> {});

    mBasketballMatchRepository.syncBasketballMatchs()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(() -> {}, e -> {});

//    mAppSyncApi.getBasketballMatchs()
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(basketballMatches -> Log.d(DBG_TAG,"appsync basketballmatches"+basketballMatches), e -> {});

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ligue_choosed_item);
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

    mPremierLeague = findViewById(R.id.premiere_league_card);
    mPremierLeague.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, PremiereLeague.class)));
    mLaLiga = findViewById(R.id.laliga_card);
    mLaLiga.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, LaLiga.class)));
    mSerieA = findViewById(R.id.serie_a_card);
    mSerieA.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, SerieA.class)));
    mBundesliga = findViewById(R.id.bundesliga_card);
    mBundesliga.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Bundesliga.class)));
    mLigue1 = findViewById(R.id.Ligue1_card);
    mLigue1.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Ligue1.class)));
    mChampionship = findViewById(R.id.championship_card);
    mChampionship.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Championship.class)));
    mEredivisie = findViewById(R.id.eredivisie_card);
    mEredivisie.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, Eredivisie.class)));
    mjupiterProLeague = findViewById(R.id.jupiler_pro_league_card);
    mjupiterProLeague.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, JupilerPro.class)));
    mLigaPortugal = findViewById(R.id.liga_portugal_card);
    mLigaPortugal.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, LigaPortugal.class)));
    mNBA = findViewById(R.id.nba_card);
    mNBA.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, NBA.class)));
    mAddFootGame = findViewById(R.id.addmatch_card);
    mAddFootGame.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, AddFootballGame.class)));
    mAddBasketballGame = findViewById(R.id.addbasketballmatch_card);
    mAddBasketballGame.setOnClickListener(v -> startActivity(new Intent(LigueChoosed.this, AddBasketballGame.class)));


    mDisposable.add(
        Completable.concatArray(
            syncMatches(),
            syncBasketballMatches())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(() -> {
            }, e -> {
              Log.d(DBG_TAG, "Synchronization failed: " + e.toString() + ", cause = " + e.getCause());
            }));
  }

  private Completable syncMatches() {
    return Single.fromCallable(() -> new MatchRepository(this))
        .flatMapCompletable(MatchRepository::syncMatchs);
  }

  private Completable syncBasketballMatches() {
    return Single.fromCallable(() -> new BasketballMatchRepository(this))
        .flatMapCompletable(BasketballMatchRepository::syncBasketballMatchs);
  }
}
