package com.kazehackstats.data;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "basketball_match")
public class BasketballMatch  {
  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "basketball_id")
  private String BasketballMatch_id;
  @ColumnInfo(name = "league")
  private String league;
  @NonNull
  private String date;
  @ColumnInfo(name = "homeTeam")
  private String homeTeam;
  @ColumnInfo(name = "awayTeam")
  private String awayTeam;
  @ColumnInfo(name = "homeTwoPtsScore")
  private int homeTwoPtsScore;
  @ColumnInfo(name = "awayTwoPtsScore")
  private int awayTwoPtsScore;
  @ColumnInfo(name = "TwoPtsWinner")
  private String TwoPtsWinner;
  @ColumnInfo(name = "TwoPtsDifference")
  private int TwoPtsDifference;
  @ColumnInfo(name = "homeThreePtsScore")
  private int homeThreePtsScore;
  @ColumnInfo(name = "awayThreePtsScore")
  private int awayThreePtsScore;
  @ColumnInfo(name = "ThreePtsWinner")
  private String ThreePtsWinner;
  @ColumnInfo(name = "ThreePtsDifference")
  private int ThreePtsDifference;
  @ColumnInfo(name = "homeReboundsScore")
  private int homeReboundsScore;
  @ColumnInfo(name = "awayReboundsScore")
  private int awayReboundsScore;
  @ColumnInfo(name = "ReboundsWinner")
  private String ReboundsWinner;
  @ColumnInfo(name = "ReboundsDifference")
  private int ReboundsDifference;
  @ColumnInfo(name = "homeAssistsScore")
  private int homeAssistsScore;
  @ColumnInfo(name = "awayAssistsScore")
  private int awayAssistsScore;
  @ColumnInfo(name = "AssistsWinner")
  private String AssistsWinner;
  @ColumnInfo(name = "AssistsDifference")
  private int AssistsDifference;


  public BasketballMatch(@NonNull String basketballMatch_id, String league, @NonNull String date, String homeTeam,
                         String awayTeam, int homeTwoPtsScore, int awayTwoPtsScore, String twoPtsWinner, int twoPtsDifference,
                         int homeThreePtsScore, int awayThreePtsScore, String threePtsWinner, int threePtsDifference,
                         int homeReboundsScore, int awayReboundsScore, String reboundsWinner, int reboundsDifference,
                         int homeAssistsScore, int awayAssistsScore, String assistsWinner, int assistsDifference) {
    BasketballMatch_id = basketballMatch_id;
    this.league = league;
    this.date = date;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.homeTwoPtsScore = homeTwoPtsScore;
    this.awayTwoPtsScore = awayTwoPtsScore;
    TwoPtsWinner = twoPtsWinner;
    TwoPtsDifference = twoPtsDifference;
    this.homeThreePtsScore = homeThreePtsScore;
    this.awayThreePtsScore = awayThreePtsScore;
    ThreePtsWinner = threePtsWinner;
    ThreePtsDifference = threePtsDifference;
    this.homeReboundsScore = homeReboundsScore;
    this.awayReboundsScore = awayReboundsScore;
    ReboundsWinner = reboundsWinner;
    ReboundsDifference = reboundsDifference;
    this.homeAssistsScore = homeAssistsScore;
    this.awayAssistsScore = awayAssistsScore;
    AssistsWinner = assistsWinner;
    AssistsDifference = assistsDifference;
  }

  @NonNull
  public String getBasketballMatch_id() {
    return BasketballMatch_id;
  }

  public void setBasketballMatch_id(@NonNull String basketballMatch_id) {
    BasketballMatch_id = basketballMatch_id;
  }

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
  }

  @NonNull
  public String getDate() {
    return date;
  }

  public void setDate(@NonNull String date) {
    this.date = date;
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(String homeTeam) {
    this.homeTeam = homeTeam;
  }

  public String getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(String awayTeam) {
    this.awayTeam = awayTeam;
  }

  public int getHomeTwoPtsScore() {
    return homeTwoPtsScore;
  }

  public void setHomeTwoPtsScore(int homeTwoPtsScore) {
    this.homeTwoPtsScore = homeTwoPtsScore;
  }

  public int getAwayTwoPtsScore() {
    return awayTwoPtsScore;
  }

  public void setAwayTwoPtsScore(int awayTwoPtsScore) {
    this.awayTwoPtsScore = awayTwoPtsScore;
  }

  public String getTwoPtsWinner() {
    return TwoPtsWinner;
  }

  public void setTwoPtsWinner(String twoPtsWinner) {
    TwoPtsWinner = twoPtsWinner;
  }

  public int getTwoPtsDifference() {
    return TwoPtsDifference;
  }

  public void setTwoPtsDifference(int twoPtsDifference) {
    TwoPtsDifference = twoPtsDifference;
  }

  public int getHomeThreePtsScore() {
    return homeThreePtsScore;
  }

  public void setHomeThreePtsScore(int homeThreePtsScore) {
    this.homeThreePtsScore = homeThreePtsScore;
  }

  public int getAwayThreePtsScore() {
    return awayThreePtsScore;
  }

  public void setAwayThreePtsScore(int awayThreePtsScore) {
    this.awayThreePtsScore = awayThreePtsScore;
  }

  public String getThreePtsWinner() {
    return ThreePtsWinner;
  }

  public void setThreePtsWinner(String threePtsWinner) {
    ThreePtsWinner = threePtsWinner;
  }

  public int getThreePtsDifference() {
    return ThreePtsDifference;
  }

  public void setThreePtsDifference(int threePtsDifference) {
    ThreePtsDifference = threePtsDifference;
  }

  public int getHomeReboundsScore() {
    return homeReboundsScore;
  }

  public void setHomeReboundsScore(int homeReboundsScore) {
    this.homeReboundsScore = homeReboundsScore;
  }

  public int getAwayReboundsScore() {
    return awayReboundsScore;
  }

  public void setAwayReboundsScore(int awayReboundsScore) {
    this.awayReboundsScore = awayReboundsScore;
  }

  public String getReboundsWinner() {
    return ReboundsWinner;
  }

  public void setReboundsWinner(String reboundsWinner) {
    ReboundsWinner = reboundsWinner;
  }

  public int getReboundsDifference() {
    return ReboundsDifference;
  }

  public void setReboundsDifference(int reboundsDifference) {
    ReboundsDifference = reboundsDifference;
  }

  public int getHomeAssistsScore() {
    return homeAssistsScore;
  }

  public void setHomeAssistsScore(int homeAssistsScore) {
    this.homeAssistsScore = homeAssistsScore;
  }

  public int getAwayAssistsScore() {
    return awayAssistsScore;
  }

  public void setAwayAssistsScore(int awayAssistsScore) {
    this.awayAssistsScore = awayAssistsScore;
  }

  public String getAssistsWinner() {
    return AssistsWinner;
  }

  public void setAssistsWinner(String assistsWinner) {
    AssistsWinner = assistsWinner;
  }

  public int getAssistsDifference() {
    return AssistsDifference;
  }

  public void setAssistsDifference(int assistsDifference) {
    AssistsDifference = assistsDifference;
  }


  @Override
  public String toString() {
    return "BasketballMatch{" +
        "BasketballMatch_id='" + BasketballMatch_id + '\'' +
        ", league='" + league + '\'' +
        ", date='" + date + '\'' +
        ", homeTeam='" + homeTeam + '\'' +
        ", awayTeam='" + awayTeam + '\'' +
        ", homeTwoPtsScore=" + homeTwoPtsScore +
        ", awayTwoPtsScore=" + awayTwoPtsScore +
        ", TwoPtsWinner='" + TwoPtsWinner + '\'' +
        ", TwoPtsDifference=" + TwoPtsDifference +
        ", homeThreePtsScore=" + homeThreePtsScore +
        ", awayThreePtsScore=" + awayThreePtsScore +
        ", ThreePtsWinner='" + ThreePtsWinner + '\'' +
        ", ThreePtsDifference=" + ThreePtsDifference +
        ", homeReboundsScore=" + homeReboundsScore +
        ", awayReboundsScore=" + awayReboundsScore +
        ", ReboundsWinner='" + ReboundsWinner + '\'' +
        ", ReboundsDifference=" + ReboundsDifference +
        ", homeAssistsScore=" + homeAssistsScore +
        ", awayAssistsScore=" + awayAssistsScore +
        ", AssistsWinner='" + AssistsWinner + '\'' +
        ", AssistsDifference=" + AssistsDifference +
        '}';
  }


}
