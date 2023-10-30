package com.kazehackstats.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "basketball_match")
public class BasketballMatch implements Parcelable {
  public static final String BasketballMatch_EXTRA = "basketballmatch_code";

  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "basketball_id")
  private String basketballMatch_id;
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
  private String twoPtsWinner;
  @ColumnInfo(name = "twoPtsDifference")
  private int twoPtsDifference;
  @ColumnInfo(name = "homeThreePtsScore")
  private int homeThreePtsScore;
  @ColumnInfo(name = "awayThreePtsScore")
  private int awayThreePtsScore;
  @ColumnInfo(name = "ThreePtsWinner")
  private String threePtsWinner;
  @ColumnInfo(name = "threePtsDifference")
  private int threePtsDifference;
  @ColumnInfo(name = "homeReboundsScore")
  private int homeReboundsScore;
  @ColumnInfo(name = "awayReboundsScore")
  private int awayReboundsScore;
  @ColumnInfo(name = "reboundsWinner")
  private String reboundsWinner;
  @ColumnInfo(name = "reboundsDifference")
  private int reboundsDifference;
  @ColumnInfo(name = "homeAssistsScore")
  private int homeAssistsScore;
  @ColumnInfo(name = "awayAssistsScore")
  private int awayAssistsScore;
  @ColumnInfo(name = "assistsWinner")
  private String assistsWinner;
  @ColumnInfo(name = "assistsDifference")
  private int assistsDifference;


  public BasketballMatch(@NonNull String basketballMatch_id, String league, @NonNull String date, String homeTeam, String awayTeam, int homeTwoPtsScore, int awayTwoPtsScore, String twoPtsWinner, int twoPtsDifference, int homeThreePtsScore, int awayThreePtsScore, String threePtsWinner, int threePtsDifference, int homeReboundsScore, int awayReboundsScore, String reboundsWinner, int reboundsDifference, int homeAssistsScore, int awayAssistsScore, String assistsWinner, int assistsDifference) {
    this.basketballMatch_id = basketballMatch_id;
    this.league = league;
    this.date = date;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.homeTwoPtsScore = homeTwoPtsScore;
    this.awayTwoPtsScore = awayTwoPtsScore;
    this.twoPtsWinner = twoPtsWinner;
    this.twoPtsDifference = twoPtsDifference;
    this.homeThreePtsScore = homeThreePtsScore;
    this.awayThreePtsScore = awayThreePtsScore;
    this.threePtsWinner = threePtsWinner;
    this.threePtsDifference = threePtsDifference;
    this.homeReboundsScore = homeReboundsScore;
    this.awayReboundsScore = awayReboundsScore;
    this.reboundsWinner = reboundsWinner;
    this.reboundsDifference = reboundsDifference;
    this.homeAssistsScore = homeAssistsScore;
    this.awayAssistsScore = awayAssistsScore;
    this.assistsWinner = assistsWinner;
    this.assistsDifference = assistsDifference;
  }

  @NonNull
  public String getBasketballMatch_id() {
    return basketballMatch_id;
  }

  public void setBasketballMatch_id(@NonNull String basketballMatch_id) {
    this.basketballMatch_id = basketballMatch_id;
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
    return twoPtsWinner;
  }

  public void setTwoPtsWinner(String twoPtsWinner) {
    this.twoPtsWinner = twoPtsWinner;
  }

  public int getTwoPtsDifference() {
    return twoPtsDifference;
  }

  public void setTwoPtsDifference(int twoPtsDifference) {
    this.twoPtsDifference = twoPtsDifference;
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
    return threePtsWinner;
  }

  public void setThreePtsWinner(String threePtsWinner) {
    this.threePtsWinner = threePtsWinner;
  }

  public int getThreePtsDifference() {
    return threePtsDifference;
  }

  public void setThreePtsDifference(int threePtsDifference) {
    this.threePtsDifference = threePtsDifference;
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
    return reboundsWinner;
  }

  public void setReboundsWinner(String reboundsWinner) {
    this.reboundsWinner = reboundsWinner;
  }

  public int getReboundsDifference() {
    return reboundsDifference;
  }

  public void setReboundsDifference(int reboundsDifference) {
    this.reboundsDifference = reboundsDifference;
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
    return assistsWinner;
  }

  public void setAssistsWinner(String assistsWinner) {
    this.assistsWinner = assistsWinner;
  }

  public int getAssistsDifference() {
    return assistsDifference;
  }

  public void setAssistsDifference(int assistsDifference) {
    this.assistsDifference = assistsDifference;
  }


  @Override
  public String toString() {
    return "BasketballMatch{" +
        "BasketballMatch_id='" + basketballMatch_id + '\'' +
        ", league='" + league + '\'' +
        ", date='" + date + '\'' +
        ", homeTeam='" + homeTeam + '\'' +
        ", awayTeam='" + awayTeam + '\'' +
        ", homeTwoPtsScore=" + homeTwoPtsScore +
        ", awayTwoPtsScore=" + awayTwoPtsScore +
        ", TwoPtsWinner='" + twoPtsWinner + '\'' +
        ", TwoPtsDifference=" + twoPtsDifference +
        ", homeThreePtsScore=" + homeThreePtsScore +
        ", awayThreePtsScore=" + awayThreePtsScore +
        ", ThreePtsWinner='" + threePtsWinner + '\'' +
        ", ThreePtsDifference=" + threePtsDifference +
        ", homeReboundsScore=" + homeReboundsScore +
        ", awayReboundsScore=" + awayReboundsScore +
        ", ReboundsWinner='" + reboundsWinner + '\'' +
        ", ReboundsDifference=" + reboundsDifference +
        ", homeAssistsScore=" + homeAssistsScore +
        ", awayAssistsScore=" + awayAssistsScore +
        ", AssistsWinner='" + assistsWinner + '\'' +
        ", AssistsDifference=" + assistsDifference +
        '}';
  }

  public BasketballMatch(Parcel in) {
    this.basketballMatch_id = in.readString();
    this.date = in.readString();
    this.league= in.readString();
    this.homeTeam = in.readString();
    this.awayTeam = in.readString();
    this.homeTwoPtsScore = in.readInt();
    this.awayTwoPtsScore = in.readInt();
    this.twoPtsWinner = in.readString();
    this.twoPtsDifference = in.readInt();
    this.homeThreePtsScore = in.readInt();
    this.awayThreePtsScore = in.readInt();
    this.threePtsWinner = in.readString();
    this.threePtsDifference = in.readInt();
    this.homeThreePtsScore = in.readInt();
    this.awayThreePtsScore = in.readInt();
    this.threePtsWinner = in.readString();
    this.threePtsDifference = in.readInt();
    this.homeReboundsScore = in.readInt();
    this.awayReboundsScore = in.readInt();
    this.reboundsWinner = in.readString();
    this.reboundsDifference = in.readInt();
    this.homeAssistsScore = in.readInt();
    this.awayAssistsScore = in.readInt();
    this.assistsWinner = in.readString();
    this.assistsDifference = in.readInt();
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeString(this.basketballMatch_id);
    dest.writeString(this.date);
    dest.writeString(this.league);
    dest.writeString(this.homeTeam);
    dest.writeString(this.awayTeam);
    dest.writeInt(this.homeTwoPtsScore);
    dest.writeInt(this.awayTwoPtsScore);
    dest.writeString(this.twoPtsWinner);
    dest.writeInt(this.twoPtsDifference);
    dest.writeInt(this.homeThreePtsScore);
    dest.writeInt(this.awayThreePtsScore);
    dest.writeString(this.threePtsWinner);
    dest.writeInt(this.threePtsDifference);
    dest.writeInt(this.homeReboundsScore);
    dest.writeInt(this.awayReboundsScore);
    dest.writeString(this.reboundsWinner);
    dest.writeInt(this.reboundsDifference);
    dest.writeInt(this.homeAssistsScore);
    dest.writeInt(this.awayAssistsScore);
    dest.writeString(this.assistsWinner);
    dest.writeInt(this.assistsDifference);
  }

  public static final Parcelable.Creator<BasketballMatch> CREATOR =
      new Parcelable.Creator<BasketballMatch>() {
        @Override
        public BasketballMatch createFromParcel(Parcel source) {
          return new BasketballMatch(source);
        }

        @Override
        public BasketballMatch[] newArray(int size) {
          return new BasketballMatch[size];
        }
      };


}
