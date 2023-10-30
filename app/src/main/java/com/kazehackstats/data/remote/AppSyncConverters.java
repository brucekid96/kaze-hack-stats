package com.kazehackstats.data.remote;

import android.net.Uri;

import com.kazehackstats.data.BasketballMatch;
import com.kazehackstats.data.Match;

public class AppSyncConverters {
  public static Match toMatch(com.amplifyframework.datastore.generated.model.Match match) {
    return new Match(
        match.getId(),
        match.getDate(),
        match.getLeague(),
        match.getHomeTeam(),
        match.getAwayTeam(),
        match.getHomeShotsScore(),
        match.getAwayShotsScore(),
        match.getShotsWinner(),
        match.getShotsDifference(),
        match.getHomeShotsOnGoalScore(),
        match.getAwayShotsOnGoalScore(),
        match.getShotsOnGoalWinner(),
        match.getShotsOnGoalDifference(),
        match.getHomeCornersScore(),
        match.getAwayCornersScore(),
        match.getCornersWinner(),
        match.getCornersDifference(),
        match.getHomeThrowsInScore(),
        match.getAwayThrowsInScore(),
        match.getThrowsInWinner(),
        match.getThrowsInDifference(),
        match.getHomeSavesScore(),
        match.getAwaySavesScore(),
        match.getSavesWinner(),
        match.getSavesDifference(),
        match.getHomeFoulsScore(),
        match.getAwayFoulsScore(),
        match.getFoulsWinner(),
        match.getFoulsDifference(),
        match.getHomeTacklesScore(),
        match.getAwayTacklesScore(),
        match.getTacklesWinner(),
        match.getTacklesDifference());
  };


  public static BasketballMatch toBasketballMatch(com.amplifyframework.datastore.generated.model.BasketballMatch basketballMatch) {
    return new BasketballMatch(
        basketballMatch.getId(),
        basketballMatch.getDate(),
        basketballMatch.getLeague(),
        basketballMatch.getHomeTeam(),
        basketballMatch.getAwayTeam(),
        basketballMatch.getHomeTwoPtsScore(),
        basketballMatch.getAwayTwoPtsScore(),
        basketballMatch.getTwoPtsWinner(),
        basketballMatch.getTwoPtsDifference(),
        basketballMatch.getHomeThreePtsScore(),
        basketballMatch.getAwayThreePtsScore(),
        basketballMatch.getThreePtsWinner(),
        basketballMatch.getThreePtsDifference(),
        basketballMatch.getHomeReboundsScore(),
        basketballMatch.getAwayReboundsScore(),
        basketballMatch.getReboundsWinner(),
        basketballMatch.getReboundsDifference(),
        basketballMatch.getHomeAssistsScore(),
        basketballMatch.getAwayAssistsScore(),
        basketballMatch.getAssistsWinner(),
        basketballMatch.getAssistsDifference());
  }


}
