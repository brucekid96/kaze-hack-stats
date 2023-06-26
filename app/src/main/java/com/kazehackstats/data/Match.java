package com.kazehackstats.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "match")
public class Match  implements Parcelable {
  public static final String Shots_EXTRA = "shots_code";

  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "id")
  private String match_id;
  @NonNull
  private String date;
  @ColumnInfo(name = "homeTeam")
  private String homeTeam;
  @ColumnInfo(name = "awayTeam")
  private String awayTeam;
  @ColumnInfo(name = "homeShotsScore")
  private int homeShotsScore;
  @ColumnInfo(name = "awayShotsScore")
  private int awayShotsScore;
  @ColumnInfo(name = "shotsWinner")
  private String shotsWinner;
  @ColumnInfo(name = "shotsDifference")
  private int shotsDifference;
  @ColumnInfo(name = "homeShotsOnGoalScore")
  private int homeShotsOnGoalScore;
  @ColumnInfo(name = "awayShotsOnGoalScore")
  private int awayShotsOnGoalScore;
  @ColumnInfo(name = "shotsOnGoalWinner")
  private String shotsOnGoalWinner;
  @ColumnInfo(name = "shotsOnGoalDifference")
  private int shotsOnGoalDifference;
  @ColumnInfo(name = "homeCornersScore")
  private int homeCornersScore;
  @ColumnInfo(name = "awayCornersScore")
  private int awayCornersScore;
  @ColumnInfo(name = "cornersWinner")
  private String cornersWinner;
  @ColumnInfo(name = "cornersDifference")
  private int cornersDifference;
  @ColumnInfo(name = "homeThrowsInScore")
  private int homeThrowsInScore;
  @ColumnInfo(name = "awayThrowsInScore")
  private int awayThrowsInScore;
  @ColumnInfo(name = "throwsInWinner")
  private String throwsInWinner;
  @ColumnInfo(name = "throwsInDifference")
  private int throwsInDifference;
  @ColumnInfo(name = "homeSavesScore")
  private int homeSavesScore;
  @ColumnInfo(name = "awaySavesScore")
  private int awaySavesScore;
  @ColumnInfo(name = "savesWinner")
  private String savesWinner;
  @ColumnInfo(name = "savesDifference")
  private int savesDifference;
  @ColumnInfo(name = "homeFoulsScore")
  private int homeFoulsScore;
  @ColumnInfo(name = "awayFoulsScore")
  private int awayFoulsScore;
  @ColumnInfo(name = "foulsWinner")
  private String foulsWinner;
  @ColumnInfo(name = "foulsDifference")
  private int foulsDifference;
  @ColumnInfo(name = "homeTacklesScore")
  private int homeTacklesScore;
  @ColumnInfo(name = "awayTacklesScore")
  private int awayTacklesScore;
  @ColumnInfo(name = "tacklesWinner")
  private String tacklesWinner;
  @ColumnInfo(name = "tacklesDifference")
  private int tacklesDifference;


  public Match(String match_id, String date, String homeTeam,
               String awayTeam, int homeShotsScore, int awayShotsScore,
               String shotsWinner, int shotsDifference, int homeShotsOnGoalScore,
               int awayShotsOnGoalScore, String shotsOnGoalWinner, int shotsOnGoalDifference,
               int homeCornersScore, int awayCornersScore, String cornersWinner, int cornersDifference,
               int homeThrowsInScore, int awayThrowsInScore, String throwsInWinner, int throwsInDifference,
               int homeSavesScore, int awaySavesScore, String savesWinner, int savesDifference, int homeFoulsScore,
               int awayFoulsScore, String foulsWinner, int foulsDifference, int homeTacklesScore, int awayTacklesScore,
               String tacklesWinner, int tacklesDifference) {
    this.match_id = match_id;
    this.date = date;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.homeShotsScore = homeShotsScore;
    this.awayShotsScore = awayShotsScore;
    this.shotsWinner = shotsWinner;
    this.shotsDifference = shotsDifference;
    this.homeShotsOnGoalScore = homeShotsOnGoalScore;
    this.awayShotsOnGoalScore = awayShotsOnGoalScore;
    this.shotsOnGoalWinner = shotsOnGoalWinner;
    this.shotsOnGoalDifference = shotsOnGoalDifference;
    this.homeCornersScore = homeCornersScore;
    this.awayCornersScore = awayCornersScore;
    this.cornersWinner = cornersWinner;
    this.cornersDifference = cornersDifference;
    this.homeThrowsInScore = homeThrowsInScore;
    this.awayThrowsInScore = awayThrowsInScore;
    this.throwsInWinner = throwsInWinner;
    this.throwsInDifference = throwsInDifference;
    this.homeSavesScore = homeSavesScore;
    this.awaySavesScore = awaySavesScore;
    this.savesWinner = savesWinner;
    this.savesDifference = savesDifference;
    this.homeFoulsScore = homeFoulsScore;
    this.awayFoulsScore = awayFoulsScore;
    this.foulsWinner = foulsWinner;
    this.foulsDifference = foulsDifference;
    this.homeTacklesScore = homeTacklesScore;
    this.awayTacklesScore = awayTacklesScore;
    this.tacklesWinner = tacklesWinner;
    this.tacklesDifference = tacklesDifference;
  }

  public String getMatch_id() {
    return match_id;
  }

  public void setMatch_id(String match_id) {
    this.match_id = match_id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String time) {
    this.date = time;
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

  public int getHomeShotsScore() {
    return homeShotsScore;
  }

  public void setHomeShotsScore(int homeShotsScore) {
    this.homeShotsScore = homeShotsScore;
  }

  public int getAwayShotsScore() {
    return awayShotsScore;
  }

  public void setAwayShotsScore(int awayShotsScore) {
    this.awayShotsScore = awayShotsScore;
  }

  public String getShotsWinner() {
    return shotsWinner;
  }

  public void setShotsWinner(String shotsWinner) {
    this.shotsWinner = shotsWinner;
  }

  public int getShotsDifference() {
    return shotsDifference;
  }

  public void setShotsDifference(int shotsDifference) {
    this.shotsDifference = shotsDifference;
  }

  public int getHomeShotsOnGoalScore() {
    return homeShotsOnGoalScore;
  }

  public void setHomeShotsOnGoalScore(int homeShotsOnGoalScore) {
    this.homeShotsOnGoalScore = homeShotsOnGoalScore;
  }

  public int getAwayShotsOnGoalScore() {
    return awayShotsOnGoalScore;
  }

  public void setAwayShotsOnGoalScore(int awayShotsOnGoalScore) {
    this.awayShotsOnGoalScore = awayShotsOnGoalScore;
  }

  public String getShotsOnGoalWinner() {
    return shotsOnGoalWinner;
  }

  public void setShotsOnGoalWinner(String shotsOnGoalWinner) {
    this.shotsOnGoalWinner = shotsOnGoalWinner;
  }

  public int getShotsOnGoalDifference() {
    return shotsOnGoalDifference;
  }

  public void setShotsOnGoalDifference(int shotsOnGoalDifference) {
    this.shotsOnGoalDifference = shotsOnGoalDifference;
  }

  public int getHomeCornersScore() {
    return homeCornersScore;
  }

  public void setHomeCornersScore(int homeCornersScore) {
    this.homeCornersScore = homeCornersScore;
  }

  public int getAwayCornersScore() {
    return awayCornersScore;
  }

  public void setAwayCornersScore(int awayCornersScore) {
    this.awayCornersScore = awayCornersScore;
  }

  public String getCornersWinner() {
    return cornersWinner;
  }

  public void setCornersWinner(String cornersWinner) {
    this.cornersWinner = cornersWinner;
  }

  public int getCornersDifference() {
    return cornersDifference;
  }

  public void setCornersDifference(int cornersDifference) {
    this.cornersDifference = cornersDifference;
  }

  public int getHomeThrowsInScore() {
    return homeThrowsInScore;
  }

  public void setHomeThrowsInScore(int homeThrowsInScore) {
    this.homeThrowsInScore = homeThrowsInScore;
  }

  public int getAwayThrowsInScore() {
    return awayThrowsInScore;
  }

  public void setAwayThrowsInScore(int awayThrowsInScore) {
    this.awayThrowsInScore = awayThrowsInScore;
  }

  public String getThrowsInWinner() {
    return throwsInWinner;
  }

  public void setThrowsInWinner(String throwsInWinner) {
    this.throwsInWinner = throwsInWinner;
  }

  public int getThrowsInDifference() {
    return throwsInDifference;
  }

  public void setThrowsInDifference(int throwsInDifference) {
    this.throwsInDifference = throwsInDifference;
  }

  public int getHomeSavesScore() {
    return homeSavesScore;
  }

  public void setHomeSavesScore(int homeSavesScore) {
    this.homeSavesScore = homeSavesScore;
  }

  public int getAwaySavesScore() {
    return awaySavesScore;
  }

  public void setAwaySavesScore(int awaySavesScore) {
    this.awaySavesScore = awaySavesScore;
  }

  public String getSavesWinner() {
    return savesWinner;
  }

  public void setSavesWinner(String savesWinner) {
    this.savesWinner = savesWinner;
  }

  public int getSavesDifference() {
    return savesDifference;
  }

  public void setSavesDifference(int savesDifference) {
    this.savesDifference = savesDifference;
  }

  public int getHomeFoulsScore() {
    return homeFoulsScore;
  }

  public void setHomeFoulsScore(int homeFoulsScore) {
    this.homeFoulsScore = homeFoulsScore;
  }

  public int getAwayFoulsScore() {
    return awayFoulsScore;
  }

  public void setAwayFoulsScore(int awayFoulsScore) {
    this.awayFoulsScore = awayFoulsScore;
  }

  public String getFoulsWinner() {
    return foulsWinner;
  }

  public void setFoulsWinner(String foulsWinner) {
    this.foulsWinner = foulsWinner;
  }

  public int getFoulsDifference() {
    return foulsDifference;
  }

  public void setFoulsDifference(int foulsDifference) {
    this.foulsDifference = foulsDifference;
  }

  public int getHomeTacklesScore() {
    return homeTacklesScore;
  }

  public void setHomeTacklesScore(int homeTacklesScore) {
    this.homeTacklesScore = homeTacklesScore;
  }

  public int getAwayTacklesScore() {
    return awayTacklesScore;
  }

  public void setAwayTacklesScore(int awayTacklesScore) {
    this.awayTacklesScore = awayTacklesScore;
  }

  public String getTacklesWinner() {
    return tacklesWinner;
  }

  public void setTacklesWinner(String tacklesWinner) {
    this.tacklesWinner = tacklesWinner;
  }

  public int getTacklesDifference() {
    return tacklesDifference;
  }

  public void setTacklesDifference(int tacklesDifference) {
    this.tacklesDifference = tacklesDifference;
  }

  public int countMatches(List<Match> matches, String team) {
    int count = 0;

    for (Match match : matches)
    {
      if
      (match.homeTeam.equals(team)|| match.awayTeam.equals(team)) {
        count++;
      }
    }
    return count;
  }

  @Override
  public String toString() {
    return "Match{" +
        "match_id='" + match_id + '\'' +
        ", date='" + date + '\'' +
        ", homeTeam='" + homeTeam + '\'' +
        ", awayTeam='" + awayTeam + '\'' +
        ", homeShotsScore=" + homeShotsScore +
        ", awayShotsScore=" + awayShotsScore +
        ", shotsWinner='" + shotsWinner + '\'' +
        ", shotsDifference=" + shotsDifference +
        ", homeShotsOnGoalScore=" + homeShotsOnGoalScore +
        ", awayShotsOnGoalScore=" + awayShotsOnGoalScore +
        ", shotsOnGoalWinner='" + shotsOnGoalWinner + '\'' +
        ", shotsOnGoalDifference=" + shotsOnGoalDifference +
        ", homeCornersScore=" + homeCornersScore +
        ", awayCornersScore=" + awayCornersScore +
        ", CornersWinner='" + cornersWinner + '\'' +
        ", CornersDifference=" + cornersDifference +
        ", homeThrowsInScore=" + homeThrowsInScore +
        ", awayThrowsInScore=" + awayThrowsInScore +
        ", ThrowsInWinner='" + throwsInWinner + '\'' +
        ", ThrowsInDifference=" + throwsInDifference +
        ", homeSavesScore=" + homeSavesScore +
        ", awaySavesScore=" + awaySavesScore +
        ", SavesWinner='" + savesWinner + '\'' +
        ", SavesDifference=" + savesDifference +
        ", homeFoulsScore=" + homeFoulsScore +
        ", awayFoulsScore=" + awayFoulsScore +
        ", FoulsWinner='" + foulsWinner + '\'' +
        ", FoulsDifference=" + foulsDifference +
        ", homeTacklesScore=" + homeTacklesScore +
        ", awayTacklesScore=" + awayTacklesScore +
        ", TacklesWinner='" + tacklesWinner + '\'' +
        ", TacklesDifference=" + tacklesDifference +
        '}';
  }

  public Match(Parcel in) {
    this.match_id = in.readString();
    this.date = in.readString();
    this.homeTeam = in.readString();
    this.awayTeam = in.readString();
    this.homeShotsScore = in.readInt();
    this.awayShotsScore = in.readInt();
    this.shotsWinner = in.readString();
    this.shotsDifference = in.readInt();
    this.homeShotsOnGoalScore = in.readInt();
    this.awayShotsOnGoalScore = in.readInt();
    this.shotsOnGoalWinner = in.readString();
    this.shotsOnGoalDifference = in.readInt();
    this.homeCornersScore = in.readInt();
    this.awayCornersScore = in.readInt();
    this.cornersWinner = in.readString();
    this.cornersDifference = in.readInt();
    this.homeThrowsInScore = in.readInt();
    this.awayThrowsInScore = in.readInt();
    this.throwsInWinner = in.readString();
    this.throwsInDifference = in.readInt();
    this.homeSavesScore = in.readInt();
    this.awaySavesScore = in.readInt();
    this.savesWinner = in.readString();
    this.savesDifference = in.readInt();
    this.homeFoulsScore = in.readInt();
    this.awayFoulsScore = in.readInt();
    this.foulsWinner = in.readString();
    this.foulsDifference = in.readInt();
    this.homeTacklesScore = in.readInt();
    this.awayTacklesScore = in.readInt();
    this.tacklesWinner = in.readString();
    this.tacklesDifference = in.readInt();

  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeString(this.match_id);
    dest.writeString(this.date);
    dest.writeString(this.homeTeam);
    dest.writeString(this.awayTeam);
    dest.writeInt(this.homeShotsScore);
    dest.writeInt(this.awayShotsScore);
    dest.writeString(this.shotsWinner);
    dest.writeInt(this.shotsDifference);
    dest.writeInt(this.homeShotsOnGoalScore);
    dest.writeInt(this.awayShotsOnGoalScore);
    dest.writeString(this.shotsOnGoalWinner);
    dest.writeInt(this.shotsOnGoalDifference);
    dest.writeInt(this.homeCornersScore);
    dest.writeInt(this.awayCornersScore);
    dest.writeString(this.cornersWinner);
    dest.writeInt(this.cornersDifference);
    dest.writeInt(this.homeThrowsInScore);
    dest.writeInt(this.awayThrowsInScore);
    dest.writeString(this.throwsInWinner);
    dest.writeInt(this.throwsInDifference);
    dest.writeInt(this.homeSavesScore);
    dest.writeInt(this.awaySavesScore);
    dest.writeString(this.savesWinner);
    dest.writeInt(this.savesDifference);
    dest.writeInt(this.homeFoulsScore);
    dest.writeInt(this.awayFoulsScore);
    dest.writeString(this.foulsWinner);
    dest.writeInt(this.foulsDifference);
    dest.writeInt(this.homeTacklesScore);
    dest.writeInt(this.awayTacklesScore);
    dest.writeString(this.tacklesWinner);
    dest.writeInt(this.tacklesDifference);


  }

  public static final Parcelable.Creator<Match> CREATOR =
      new Parcelable.Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel source) {
          return new Match(source);
        }

        @Override
        public Match[] newArray(int size) {
          return new Match[size];
        }
      };



}
