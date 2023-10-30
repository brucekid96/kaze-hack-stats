package com.kazehackstats.data.remote;

import android.content.Context;
import android.util.Log;

import com.amazonaws.amplify.generated.graphql.CreateBasketballMatchMutation;
import com.amazonaws.amplify.generated.graphql.CreateMatchMutation;
import com.amazonaws.amplify.generated.graphql.ListBasketballMatchesQuery;
import com.amazonaws.amplify.generated.graphql.ListMatchesQuery;
import com.amazonaws.amplify.generated.graphql.UpdateBasketballMatchMutation;
import com.amazonaws.amplify.generated.graphql.UpdateMatchMutation;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.apollographql.apollo.GraphQLCall;

import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import com.kazehackstats.data.BasketballMatch;
import com.kazehackstats.data.Match;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import io.reactivex.Completable;
import io.reactivex.Single;
import type.CreateBasketballMatchInput;
import type.CreateMatchInput;
import type.UpdateBasketballMatchInput;
import type.UpdateMatchInput;


public class AppSyncApi {
  private static final String DBG_TAG = AppSyncApi.class.getSimpleName();
  private static final Object LOCK = new Object();
  private static AppSyncApi sInstance;

  private static AWSAppSyncClient mAppSyncClient;

  public AppSyncApi(Context context) {
    mAppSyncClient = com.kazehackstats.data.remote.AppSyncProvider.getAppSyncClient(context);
  }

  public static AppSyncApi getInstance(Context context) {
    if (sInstance == null) {
      synchronized (LOCK) {
        sInstance = new AppSyncApi(context);
      }
    }

    return sInstance;
  }

  public Single<List<Match>> getMatchs() {
    return Single.create(source ->
        mAppSyncClient
            .query(ListMatchesQuery.builder().build())
            .enqueue(new GraphQLCall.Callback<ListMatchesQuery.Data>() {
              @Override
              public void onResponse(@Nonnull Response<ListMatchesQuery.Data> response) {
                if (response.data() != null) {
                  List<Match> matches = new ArrayList();
                  for(ListMatchesQuery.Item item : response.data().listMatches().items()) {
                    matches.add(new Match(
                        item.id(),
                        item.league(),
                        item.date(),
                        item.homeTeam(),
                        item.awayTeam(),
                        item.homeShotsScore(),
                        item.awayShotsScore(),
                        item.shotsWinner(),
                        item.shotsDifference(),
                        item.homeShotsOnGoalScore(),
                        item.awayShotsOnGoalScore(),
                        item.shotsOnGoalWinner(),
                        item.shotsOnGoalDifference(),
                        item.homeCornersScore(),
                        item.awayCornersScore(),
                        item.cornersWinner(),
                        item.cornersDifference(),
                        item.homeThrowsInScore(),
                        item.awayThrowsInScore(),
                        item.throwsInWinner(),
                        item.throwsInDifference(),
                        item.homeSavesScore(),
                        item.awaySavesScore(),
                        item.savesWinner(),
                        item.savesDifference(),
                        item.homeFoulsScore(),
                        item.awayFoulsScore(),
                        item.foulsWinner(),
                        item.foulsDifference(),
                        item.homeTacklesScore(),
                        item.awayTacklesScore(),
                        item.tacklesWinner(),
                        item.tacklesDifference())
                    );
                  }


                  source.onSuccess(matches);
                } else {
                  Log.d(DBG_TAG, "AppSync getMatches response was null");
                }
              }

              @Override
              public void onFailure(@Nonnull ApolloException e) {
                Log.d(DBG_TAG, "AppSync getMatches query failed: error = " + e.toString() + ", cause = " + e.getCause());
                source.onError(e);
              }
            }));
  }

  public static Completable addMatch(Match match) {
    return Completable.create(source -> {
      CreateMatchMutation mutation = CreateMatchMutation.builder().input(
          CreateMatchInput.builder()
            .id(match.getMatch_id())
              .league(match.getLeague())
            .date(match.getDate())
            .homeTeam(match.getHomeTeam())
            .awayTeam(match.getAwayTeam())
            .homeShotsScore(match.getHomeShotsScore())
            .awayShotsScore(match.getAwayShotsScore())
            .shotsWinner(match.getShotsWinner())
            .shotsDifference(match.getShotsDifference())
            .homeShotsOnGoalScore(match.getHomeShotsOnGoalScore())
            .awayShotsOnGoalScore(match.getAwayShotsOnGoalScore())
            .shotsOnGoalWinner(match.getShotsOnGoalWinner())
            .shotsOnGoalDifference(match.getShotsOnGoalDifference())
            .homeCornersScore(match.getHomeCornersScore())
            .awayCornersScore(match.getAwayCornersScore())
            .cornersWinner(match.getCornersWinner())
            .cornersDifference(match.getCornersDifference())
            .homeThrowsInScore(match.getHomeThrowsInScore())
            .awayThrowsInScore(match.getAwayThrowsInScore())
            .throwsInWinner(match.getThrowsInWinner())
            .throwsInDifference(match.getThrowsInDifference())
            .homeSavesScore(match.getHomeSavesScore())
            .awaySavesScore(match.getAwaySavesScore())
            .savesWinner(match.getSavesWinner())
            .savesDifference(match.getSavesDifference())
            .homeFoulsScore(match.getHomeFoulsScore())
            .awayFoulsScore(match.getAwayFoulsScore())
            .foulsWinner(match.getFoulsWinner())
            .foulsDifference(match.getFoulsDifference())
            .homeTacklesScore(match.getHomeTacklesScore())
            .awayTacklesScore(match.getAwayTacklesScore())
            .tacklesWinner(match.getTacklesWinner())
            .tacklesDifference(match.getTacklesDifference())
              .build())
          .build();

      mAppSyncClient.mutate(mutation)
          .enqueue(new GraphQLCall.Callback<CreateMatchMutation.Data>(){
            @Override
            public void onResponse(@Nonnull Response<CreateMatchMutation.Data> response) {
              if (response.data() != null) {
                Log.d(DBG_TAG, "AppSync createMatch mutation was successful");
                CreateMatchMutation.CreateMatch prod = response.data().createMatch();
                Log.d(DBG_TAG, "Match created: " + prod);
                source.onComplete();
              } else {
                Log.d(DBG_TAG, "AppSync createMatch response was null");
                source.onError(new ApolloException("AppSync response was null"));
              }
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
              Log.d(DBG_TAG, "AppSync createMatch mutation failed: " + e.toString() + ", cause = " + e.getCause());
              source.onError(e);
            }
          });
    });
  }

  public Single<List<Match>> getUpdateMatchs() {
    return Single.create(source ->
        mAppSyncClient
            .query(ListMatchesQuery.builder().build())
            .enqueue(new GraphQLCall.Callback<ListMatchesQuery.Data>() {
              @Override
              public void onResponse(@Nonnull Response<ListMatchesQuery.Data> response) {
                if (response.data() != null) {
                  List<Match> matches = new ArrayList();
                  for(ListMatchesQuery.Item item : response.data().listMatches().items()) {
                    matches.add(new Match(
                        item.id(),
                        item.league(),
                        item.date(),
                        item.homeTeam(),
                        item.awayTeam(),
                        item.homeShotsScore(),
                        item.awayShotsScore(),
                        item.shotsWinner(),
                        item.shotsDifference(),
                        item.homeShotsOnGoalScore(),
                        item.awayShotsOnGoalScore(),
                        item.shotsOnGoalWinner(),
                        item.shotsOnGoalDifference(),
                        item.homeCornersScore(),
                        item.awayCornersScore(),
                        item.cornersWinner(),
                        item.cornersDifference(),
                        item.homeThrowsInScore(),
                        item.awayThrowsInScore(),
                        item.throwsInWinner(),
                        item.throwsInDifference(),
                        item.homeSavesScore(),
                        item.awaySavesScore(),
                        item.savesWinner(),
                        item.savesDifference(),
                        item.homeFoulsScore(),
                        item.awayFoulsScore(),
                        item.foulsWinner(),
                        item.foulsDifference(),
                        item.homeTacklesScore(),
                        item.awayTacklesScore(),
                        item.tacklesWinner(),
                        item.tacklesDifference()

                    ));
                  }


                  source.onSuccess(matches);
                } else {
                  Log.d(DBG_TAG, "AppSync getMatches response was null");
                }
              }

              @Override
              public void onFailure(@Nonnull ApolloException e) {
                Log.d(DBG_TAG, "AppSync getMatches query failed: error = " + e.toString() + ", cause = " + e.getCause());
                source.onError(e);
              }
            }));
  }

  public static Completable updateMatch(Match match) {
    return Completable.create(source -> {
      UpdateMatchMutation mutation = UpdateMatchMutation.builder().input(
          UpdateMatchInput.builder()
              .id(match.getMatch_id())
              .league(match.getLeague())
              .date(match.getDate())
              .homeTeam(match.getHomeTeam())
              .awayTeam(match.getAwayTeam())
              .homeShotsScore(match.getHomeShotsScore())
              .awayShotsScore(match.getAwayShotsScore())
              .shotsWinner(match.getShotsWinner())
              .shotsDifference(match.getShotsDifference())
              .homeShotsOnGoalScore(match.getHomeShotsOnGoalScore())
              .awayShotsOnGoalScore(match.getAwayShotsOnGoalScore())
              .shotsOnGoalWinner(match.getShotsOnGoalWinner())
              .shotsOnGoalDifference(match.getShotsOnGoalDifference())
              .homeCornersScore(match.getHomeCornersScore())
              .awayCornersScore(match.getAwayCornersScore())
              .cornersWinner(match.getCornersWinner())
              .cornersDifference(match.getCornersDifference())
              .homeThrowsInScore(match.getHomeThrowsInScore())
              .awayThrowsInScore(match.getAwayThrowsInScore())
              .throwsInWinner(match.getThrowsInWinner())
              .throwsInDifference(match.getThrowsInDifference())
              .homeSavesScore(match.getHomeSavesScore())
              .awaySavesScore(match.getAwaySavesScore())
              .savesWinner(match.getSavesWinner())
              .savesDifference(match.getSavesDifference())
              .homeFoulsScore(match.getHomeFoulsScore())
              .awayFoulsScore(match.getAwayFoulsScore())
              .foulsWinner(match.getFoulsWinner())
              .foulsDifference(match.getFoulsDifference())
              .homeTacklesScore(match.getHomeTacklesScore())
              .awayTacklesScore(match.getAwayTacklesScore())
              .tacklesWinner(match.getTacklesWinner())
              .tacklesDifference(match.getTacklesDifference())
              .build())
          .build();

      mAppSyncClient.mutate(mutation)
          .enqueue(new GraphQLCall.Callback<UpdateMatchMutation.Data>(){
            @Override
            public void onResponse(@Nonnull Response<UpdateMatchMutation.Data> response) {
              if (response.data() != null) {
                Log.d(DBG_TAG, "AppSync Matches mutation was successful");
                UpdateMatchMutation.UpdateMatch prod = response.data().updateMatch();
                Log.d(DBG_TAG, "Match : " + prod);
                source.onComplete();
              } else {
                Log.d(DBG_TAG, "AppSync match response was null");
                source.onError(new ApolloException("AppSync response was null"));
              }
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
              Log.d(DBG_TAG, "AppSync sellCredit mutation failed: " + e.toString() + ", cause = " + e.getCause());
              source.onError(e);
            }
          });
    });
  }

  public Single<List<BasketballMatch>> getBasketballMatchs() {
    return Single.create(source ->
        mAppSyncClient
            .query(ListBasketballMatchesQuery.builder().build())
            .enqueue(new GraphQLCall.Callback<ListBasketballMatchesQuery.Data>() {
              @Override
              public void onResponse(@Nonnull Response<ListBasketballMatchesQuery.Data> response) {
                  Log.d(DBG_TAG, AppSyncUtils.stringifyResponse(response));
                if (response.data() != null) {
                  List<BasketballMatch> basketballMatches = new ArrayList();
                  for(ListBasketballMatchesQuery.Item item : response.data().listBasketballMatches().items()) {
                    basketballMatches.add(new BasketballMatch(
                        item.id(),
                        item.league(),
                        item.date(),
                        item.homeTeam(),
                        item.awayTeam(),
                        item.homeTwoPtsScore(),
                        item.awayTwoPtsScore(),
                        item.twoPtsWinner(),
                        item.twoPtsDifference(),
                        item.homeThreePtsScore(),
                        item.awayThreePtsScore(),
                        item.threePtsWinner(),
                        item.threePtsDifference(),
                        item.homeReboundsScore(),
                        item.awayReboundsScore(),
                        item.reboundsWinner(),
                        item.reboundsDifference(),
                        item.homeAssistsScore(),
                        item.awayAssistsScore(),
                        item.assistsWinner(),
                        item.assistsDifference())
                    );
                  }


                  source.onSuccess(basketballMatches);
                } else {
                  Log.d(DBG_TAG, "AppSync getBasketballMatches response was null");
                }
              }

              @Override
              public void onFailure(@Nonnull ApolloException e) {
                Log.d(DBG_TAG, "AppSync getBasketballMatches query failed: error = " + e.toString() + ", cause = " + e.getCause());
                source.onError(e);
              }
            }));
  }

  public static Completable addBasketballMatch(BasketballMatch basketballMatch) {
    return Completable.create(source -> {
      CreateBasketballMatchMutation mutation = CreateBasketballMatchMutation.builder().input(
          CreateBasketballMatchInput.builder()
              .id(basketballMatch.getBasketballMatch_id())
              .league(basketballMatch.getLeague())
              .date(basketballMatch.getDate())
              .homeTeam(basketballMatch.getHomeTeam())
              .awayTeam(basketballMatch.getAwayTeam())
              .homeTwoPtsScore(basketballMatch.getHomeTwoPtsScore())
              .awayTwoPtsScore(basketballMatch.getAwayTwoPtsScore())
              .twoPtsWinner(basketballMatch.getTwoPtsWinner())
              .twoPtsDifference(basketballMatch.getTwoPtsDifference())
              .homeThreePtsScore(basketballMatch.getHomeThreePtsScore())
              .awayThreePtsScore(basketballMatch.getAwayThreePtsScore())
              .threePtsWinner(basketballMatch.getThreePtsWinner())
              .threePtsDifference(basketballMatch.getThreePtsDifference())
              .homeReboundsScore(basketballMatch.getHomeReboundsScore())
              .awayReboundsScore(basketballMatch.getAwayReboundsScore())
              .reboundsWinner(basketballMatch.getReboundsWinner())
              .reboundsDifference(basketballMatch.getReboundsDifference())
              .homeAssistsScore(basketballMatch.getHomeAssistsScore())
              .awayAssistsScore(basketballMatch.getAwayAssistsScore())
              .assistsWinner(basketballMatch.getAssistsWinner())
              .assistsDifference(basketballMatch.getAssistsDifference())
              .build())
          .build();

      mAppSyncClient.mutate(mutation)
          .enqueue(new GraphQLCall.Callback<CreateBasketballMatchMutation.Data>(){
            @Override
            public void onResponse(@Nonnull Response<CreateBasketballMatchMutation.Data> response) {
              if (response.data() != null) {
                Log.d(DBG_TAG, "AppSync createBasketballMatch mutation was successful");
                CreateBasketballMatchMutation.CreateBasketballMatch prod = response.data().createBasketballMatch();
                Log.d(DBG_TAG, "BasketballMatch created: " + prod);
                source.onComplete();
              } else {
                Log.d(DBG_TAG, "AppSync createBasketballMatch response was null");
                source.onError(new ApolloException("AppSync response was null"));
              }
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
              Log.d(DBG_TAG, "AppSync createMatch mutation failed: " + e.toString() + ", cause = " + e.getCause());
              source.onError(e);
            }
          });
    });
  }

  public Single<List<BasketballMatch>> getUpdateBasketballMatchs() {
    return Single.create(source ->
        mAppSyncClient
            .query(ListBasketballMatchesQuery.builder().build())
            .enqueue(new GraphQLCall.Callback<ListBasketballMatchesQuery.Data>() {
              @Override
              public void onResponse(@Nonnull Response<ListBasketballMatchesQuery.Data> response) {
                if (response.data() != null) {
                  List<BasketballMatch> basketballMatches = new ArrayList();
                  for(ListBasketballMatchesQuery.Item item : response.data().listBasketballMatches().items()) {
                    basketballMatches.add(new BasketballMatch(
                        item.id(),
                        item.date(),
                        item.league(),
                        item.homeTeam(),
                        item.awayTeam(),
                        item.homeTwoPtsScore(),
                        item.awayTwoPtsScore(),
                        item.twoPtsWinner(),
                        item.twoPtsDifference(),
                        item.homeThreePtsScore(),
                        item.awayThreePtsScore(),
                        item.threePtsWinner(),
                        item.threePtsDifference(),
                        item.homeReboundsScore(),
                        item.awayReboundsScore(),
                        item.reboundsWinner(),
                        item.reboundsDifference(),
                        item.homeAssistsScore(),
                        item.awayAssistsScore(),
                        item.assistsWinner(),
                        item.assistsDifference())

                    );
                  }


                  source.onSuccess(basketballMatches);
                } else {
                  Log.d(DBG_TAG, "AppSync getBasketballMatches response was null");
                }
              }

              @Override
              public void onFailure(@Nonnull ApolloException e) {
                Log.d(DBG_TAG, "AppSync getBasketballMatches query failed: error = " + e.toString() + ", cause = " + e.getCause());
                source.onError(e);
              }
            }));
  }

  public static Completable updateBasketballMatch(BasketballMatch basketballMatch) {
    return Completable.create(source -> {
      UpdateBasketballMatchMutation mutation = UpdateBasketballMatchMutation.builder().input(
          UpdateBasketballMatchInput.builder()
              .id(basketballMatch.getBasketballMatch_id())
              .date(basketballMatch.getDate())
              .league(basketballMatch.getLeague())
              .homeTeam(basketballMatch.getHomeTeam())
              .awayTeam(basketballMatch.getAwayTeam())
              .homeTwoPtsScore(basketballMatch.getHomeTwoPtsScore())
              .awayThreePtsScore(basketballMatch.getAwayThreePtsScore())
              .threePtsWinner(basketballMatch.getThreePtsWinner())
              .threePtsDifference(basketballMatch.getThreePtsDifference())
              .homeReboundsScore(basketballMatch.getHomeReboundsScore())
              .awayReboundsScore(basketballMatch.getAwayReboundsScore())
              .reboundsWinner(basketballMatch.getReboundsWinner())
              .reboundsDifference(basketballMatch.getReboundsDifference())
              .homeAssistsScore(basketballMatch.getHomeAssistsScore())
              .awayAssistsScore(basketballMatch.getAwayAssistsScore())
              .assistsWinner(basketballMatch.getAssistsWinner())
              .assistsDifference(basketballMatch.getAssistsDifference())
              .build())
          .build();

      mAppSyncClient.mutate(mutation)
          .enqueue(new GraphQLCall.Callback<UpdateBasketballMatchMutation.Data>(){
            @Override
            public void onResponse(@Nonnull Response<UpdateBasketballMatchMutation.Data> response) {
              if (response.data() != null) {
                Log.d(DBG_TAG, "AppSync BasketballMatches mutation was successful");
                UpdateBasketballMatchMutation.UpdateBasketballMatch prod = response.data().updateBasketballMatch();
                Log.d(DBG_TAG, "BasketballMatch : " + prod);
                source.onComplete();
              } else {
                Log.d(DBG_TAG, "AppSync basketballMatch response was null");
                source.onError(new ApolloException("AppSync response was null"));
              }
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
              Log.d(DBG_TAG, "AppSync BasketballMatch mutation failed: " + e.toString() + ", cause = " + e.getCause());
              source.onError(e);
            }
          });
    });
  }






}
