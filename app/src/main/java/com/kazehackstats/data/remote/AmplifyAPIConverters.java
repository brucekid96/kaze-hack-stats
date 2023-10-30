package com.kazehackstats.data.remote;

import com.kazehackstats.data.BasketballMatch;
import com.kazehackstats.data.Match;

public class AmplifyAPIConverters {
  /*public static com.curuza.data.stock.Product toProduct(Product product) {
    return new com.curuza.data.stock.Product(
        product.getId(),

    )
  } */

  public static Match toMatch(com.amplifyframework.datastore.generated.model.Match match) {
    return new Match(
        match.getId(),
        match.getLeague(),
        match.getDate(),
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
  }

  public static com.amplifyframework.datastore.generated.model.Match toMatch(Match match) {
    return com.amplifyframework.datastore.generated.model.Match.builder()
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
        .build();
  }

  public static BasketballMatch toBasketballMatch(com.amplifyframework.datastore.generated.model.BasketballMatch basketballMatch) {
    return new BasketballMatch(
        basketballMatch.getId(),
        basketballMatch.getLeague(),
        basketballMatch.getDate(),
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

  public static com.amplifyframework.datastore.generated.model.BasketballMatch toBasketballMatch(BasketballMatch basketballMatch) {
    return com.amplifyframework.datastore.generated.model.BasketballMatch.builder()
        .id(basketballMatch.getBasketballMatch_id())
        .league(basketballMatch.getLeague())
        .date(basketballMatch.getDate())
        .homeTeam(basketballMatch.getHomeTeam())
        .awayTeam(basketballMatch.getAwayTeam())
        .homeTwoPtsScore(basketballMatch.getHomeTwoPtsScore())
        .awayTwoPtsScore(basketballMatch.getAwayTwoPtsScore())
        .twoPtsWinner(basketballMatch.getTwoPtsWinner())
        .threePtsDifference(basketballMatch.getThreePtsDifference())
        .homeReboundsScore(basketballMatch.getHomeReboundsScore())
        .awayReboundsScore(basketballMatch.getAwayReboundsScore())
        .reboundsWinner(basketballMatch.getReboundsWinner())
        .reboundsDifference(basketballMatch.getReboundsDifference())
        .homeAssistsScore(basketballMatch.getHomeAssistsScore())
        .awayAssistsScore(basketballMatch.getAwayAssistsScore())
        .assistsWinner(basketballMatch.getAssistsWinner())
        .assistsDifference(basketballMatch.getAssistsDifference())
        .build();
  }


}
