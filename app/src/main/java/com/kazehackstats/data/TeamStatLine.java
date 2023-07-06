package com.kazehackstats.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.DatabaseView;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class TeamStatLine {
  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "team")
  private String team;
  @NonNull
  @ColumnInfo(name = "matches_played")
  private int matchesPlayed;
  @NonNull
  @ColumnInfo(name = "stat_wins")
  private int wins;

  @ColumnInfo(name = "stat_average_count")
  private int averageCount;

  @ColumnInfo(name = "stat_average_difference")
  private int averageDifference;


  public TeamStatLine(@NonNull String team, int matchesPlayed, int wins, int averageCount, int averageDifference) {
    this.team = team;
    this.matchesPlayed = matchesPlayed;
    this.wins = wins;
    this.averageCount = averageCount;
    this.averageDifference = averageDifference;
  }

  @NonNull
  public String getTeam() {
    return team;
  }

  public void setTeam(@NonNull String team) {
    this.team = team;
  }

  public int getMatchesPlayed() {
    return matchesPlayed;
  }

  public void setMatchesPlayed(int matchesPlayed) {
    this.matchesPlayed = matchesPlayed;
  }

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getAverageCount() {
    return averageCount;
  }

  public void setAverageCount(int averageCount) {
    this.averageCount = averageCount;
  }

  public int getAverageDifference() {
    return averageDifference;
  }

  public void setAverageDifference(int averageDifference) {
    this.averageDifference = averageDifference;
  }

  @Override
  public String toString() {
    return "TeamStatLine{" +
        "team='" + team + '\'' +
        ", matchesPlayed=" + matchesPlayed +
        ", wins=" + wins +
        ", averageCount=" + averageCount +
        ", averageDifference=" + averageDifference +
        '}';
  }
}