package com.kazehackstats.data.remote;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.core.Amplify;

import com.amplifyframework.datastore.generated.model.BasketballMatch;
import com.kazehackstats.data.Match;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class AmplifyAPI {
  public static Single<List<com.kazehackstats.data.Match>> getMatchs() {
    return Single.create(source ->
        Amplify.API.query(
          ModelQuery.list(com.amplifyframework.datastore.generated.model.Match.class),
          response -> {
            List<com.kazehackstats.data.Match> matchs = new ArrayList<>();

            if(response.getData() != null) {
              for(com.amplifyframework.datastore.generated.model.Match match : response.getData()) {
                matchs.add(com.kazehackstats.data.remote.AmplifyAPIConverters.toMatch(match));
              }
            }

            source.onSuccess(matchs);
        },
        error -> source.onError(error)));
  }
   //to get specific attribute like username
//  public static Single<List<AuthUserAttribute>> getUserAttributes() {
//    return Single.create(source ->
//        Amplify.Auth.fetchUserAttributes(
//          source::onSuccess,
//          source::onError));
//  }
  public static Completable addMatch(com.kazehackstats.data.Match match) {
    return Completable.create(source ->
        Amplify.API.mutate(
            ModelMutation.create(com.kazehackstats.data.remote.AmplifyAPIConverters.toMatch(match)),
            response -> source.onComplete(),
            source::onError));

  }
  public static Completable removeMatch(com.kazehackstats.data.Match match) {
    return Completable.create(source ->
        Amplify.API.mutate(
            ModelMutation.delete(com.kazehackstats.data.remote.AmplifyAPIConverters.toMatch(match)),
            response -> source.onComplete(),
            source::onError));

  }

  public static Single<List<com.kazehackstats.data.BasketballMatch>> getBasketballMatchs() {
    return Single.create(source ->
        Amplify.API.query(
            ModelQuery.list(BasketballMatch.class),
            response -> {
              List<com.kazehackstats.data.BasketballMatch> basketballMatches = new ArrayList<>();

              if(response.getData() != null) {

              for(BasketballMatch basketballMatch : response.getData()) {
                basketballMatches.add(com.kazehackstats.data.remote.AmplifyAPIConverters.toBasketballMatch(basketballMatch));
              } }
              source.onSuccess(basketballMatches);
            },
            error -> source.onError(error)));
  }

  public static Completable addBasketballMatch(com.kazehackstats.data.BasketballMatch basketballMatch) {
    return Completable.create(source ->
        Amplify.API.mutate(
            ModelMutation.create(com.kazehackstats.data.remote.AmplifyAPIConverters.toBasketballMatch(basketballMatch)),
            response -> source.onComplete(),
            source::onError));

  }
  public static Completable removeBasketballMatch(com.kazehackstats.data.BasketballMatch basketballMatch) {
    return Completable.create(source ->
        Amplify.API.mutate(
            ModelMutation.delete(com.kazehackstats.data.remote.AmplifyAPIConverters.toBasketballMatch(basketballMatch)),
            response -> source.onComplete(),
            source::onError));

  }




}
 