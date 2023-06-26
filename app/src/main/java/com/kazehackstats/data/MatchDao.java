package com.kazehackstats.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kazehackstats.domain.SampleData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
@Dao
public interface MatchDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void bulkInsert(List<Match> matches);


  @Query("SELECT * FROM `match`")
  LiveData<List<Match>> getAllMatches();

  @Query("SELECT DISTINCT awayTeam AS team FROM `match` UNION SELECT DISTINCT homeTeam AS team FROM `match`")
  LiveData<List<String>> getTeamsThatPlayedAtLeastOneMatch();


  @Query("SELECT * FROM `match` ORDER BY shotsWinner")
  LiveData<List<Match>> getAllMatchesByShotsWinner();


  @Query("SELECT COUNT(*) FROM `match` WHERE homeTeam = :team OR awayTeam = :team")
  LiveData<Integer> getMatchesPlayedByTeam(String team);


}
