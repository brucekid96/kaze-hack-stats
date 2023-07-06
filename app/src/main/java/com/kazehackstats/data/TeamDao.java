package com.kazehackstats.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TeamDao {


  @Query("SELECT COUNT(*) FROM `match` WHERE homeTeam = :team OR awayTeam = :team")
  LiveData<Integer> getTotalMatchesByTeam(String team);

  @Query("SELECT DISTINCT awayTeam AS team FROM `match` UNION SELECT DISTINCT homeTeam AS team FROM `match`")
  LiveData<List<String>> getAllTeams();
}
