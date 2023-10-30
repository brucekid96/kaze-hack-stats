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
  Completable bulkInsert(List<Match> matches);

  @Insert
  Completable insert(Match match);
  @Delete
  Completable delete(Match match);
  @Update
  Completable update(Match match);


  @Query("SELECT * FROM `match`")
  Observable<List<Match>> getAllMatches();

  @Query("SELECT DISTINCT awayTeam AS team FROM `match` UNION SELECT DISTINCT homeTeam AS team FROM `match`")
  LiveData<List<String>> getTeamsThatPlayedAtLeastOneMatch();


  @Query("SELECT * FROM `match` ORDER BY shotsWinner")
  LiveData<List<Match>> getAllMatchesByShotsWinner();


  @Query("SELECT COUNT(*) FROM `match` WHERE homeTeam = :team OR awayTeam = :team")
  LiveData<Integer> getMatchesPlayedByTeam(String team);

  @Query("SELECT * FROM `match` ORDER BY id DESC LIMIT 5")
  LiveData<List<Match>> getLastFiveMatches();

  @Query("with teams as (select homeTeam as team from `match`  where league =:league union select awayTeam as team from `match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "shots_wins as (select team, shots_wins from (select shotsWinner as team, count(*) as shots_wins from `match` group by shotsWinner union select team, 0 as shot_wins from teams) group by team),\n" +
      "home_shots as (select team, sum(homeShotsScore) as shotsScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_shots as (select team, sum(awayShotsScore) as shotsScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_shots as (select * from home_shots union all select * from away_shots),\n" +
      "avg_shots as (select team, sum(shotsScore) / sum(matches_played) as avg_shots from all_shots group by team),\n" +
      "home_differences as (select team, sum(homeShotsScore) - sum(awayShotsScore) as shots_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayShotsScore) - sum(homeShotsScore) as shots_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(shots_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_shots_stats as (select teams.team, matches_played, shots_wins as stat_wins, avg_shots as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, shots_wins, avg_shots, avg_difference on teams.team = matches_played.team and teams.team = shots_wins.team and  teams.team = avg_shots.team and teams.team = avg_difference.team) \n" +
      "select * from team_shots_stats order by stat_wins desc  ")
  LiveData<List<TeamStatLine>> getShotStats(String league);

  @Query("with teams as (select homeTeam as team from `match` where league=:league union select awayTeam as team from `match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "shots_on_goal_wins as (select team, shots_on_goal_wins from (select shotsOnGoalWinner as team, count(*) as shots_on_goal_wins from `match` group by shotsOnGoalWinner union select team, 0 as shots_on_goal_wins from teams) group by team),\n" +
      "home_shots_on_goal as (select team, sum(homeShotsOnGoalScore) as shotsOnGoalScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_shots_on_goal as (select team, sum(awayShotsOnGoalScore) as shotsOnGoalScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_shots_on_goal as (select * from home_shots_on_goal union all select * from away_shots_on_goal),\n" +
      "avg_shots_on_goal as (select team, sum(shotsOnGoalScore) / sum(matches_played) as avg_shots_on_goal from all_shots_on_goal group by team),\n" +
      "home_differences as (select team, sum(homeShotsOnGoalScore) - sum(awayShotsOnGoalScore) as shots_on_goal_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayShotsOnGoalScore) - sum(homeShotsOnGoalScore) as shots_on_goal_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(shots_on_goal_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_shots_on_goal_stats as (select teams.team, matches_played, shots_on_goal_wins as stat_wins, avg_shots_on_goal as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, shots_on_goal_wins, avg_shots_on_goal, avg_difference on teams.team = matches_played.team and teams.team = shots_on_goal_wins.team and  teams.team = avg_shots_on_goal.team and teams.team = avg_difference.team) \n" +
      "select * from team_shots_on_goal_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getShotOnGoalStats(String league);


  @Query("with teams as (select homeTeam as team from `match` where league=:league union select awayTeam as team from `match` where league=:league),\n" +
      "team_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "corners_wins as (select team, corners_wins from (select CornersWinner as team, count(*) as corners_wins from `match` group by CornersWinner union select team, 0 as corners_wins from teams) group by team),\n" +
      "home_corners as (select team, sum(homeCornersScore) as cornersScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_corners as (select team, sum(awayCornersScore) as cornersScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_corners as (select * from home_corners union all select * from away_corners),\n" +
      "avg_corners as (select team, sum(cornersScore) / sum(matches_played) as avg_corners from all_corners group by team),\n" +
      "home_differences as (select team, sum(homeCornersScore) - sum(awayCornersScore) as corners_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayCornersScore) - sum(homeCornersScore) as corners_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(corners_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_corners_stats as (select teams.team, matches_played, corners_wins as stat_wins, avg_corners as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, corners_wins, avg_corners, avg_difference on teams.team = matches_played.team and teams.team = corners_wins.team and  teams.team = avg_corners.team and teams.team = avg_difference.team) \n" +
      "select * from team_corners_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getCornersStats(String league);


  @Query("with teams as (select homeTeam as team from `match` where league=:league union select awayTeam as team from `match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "throws_in_wins as (select team, throws_in_wins from (select ThrowsInWinner as team, count(*) as throws_in_wins from `match` group by ThrowsInWinner union select team, 0 as throws_in_wins from teams) group by team),\n" +
      "home_throws_in as (select team, sum(homeThrowsInScore) as throwsInScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_throws_in as (select team, sum(awayThrowsInScore) as throwsInScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_throws_in as (select * from home_throws_in union all select * from away_throws_in),\n" +
      "avg_throws_in as (select team, sum(throwsInScore) / sum(matches_played) as avg_throws_in from all_throws_in group by team),\n" +
      "home_differences as (select team, sum(homeThrowsInScore) - sum(awayThrowsInScore) as throws_in_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayThrowsInScore) - sum(homeThrowsInScore) as throws_in_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(throws_in_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_throws_in_stats as (select teams.team, matches_played, throws_in_wins as stat_wins, avg_throws_in as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, throws_in_wins, avg_throws_in, avg_difference on teams.team = matches_played.team and teams.team = throws_in_wins.team and  teams.team = avg_throws_in.team and teams.team = avg_difference.team) \n" +
      "select * from team_throws_in_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getThrowsInStats(String league);

  @Query("with teams as (select homeTeam as team from `match` where league=:league union select awayTeam as team from `match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "saves_wins as (select team, saves_wins from (select SavesWinner as team, count(*) as saves_wins from `match` group by savesWinner union select team, 0 as saves_wins from teams) group by team),\n" +
      "home_saves as (select team, sum(homeSavesScore) as savesScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_saves as (select team, sum(awaySavesScore) as savesScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_saves as (select * from home_saves union all select * from away_saves),\n" +
      "avg_saves as (select team, sum(savesScore) / sum(matches_played) as avg_saves from all_saves group by team),\n" +
      "home_differences as (select team, sum(homeSavesScore) - sum(awaySavesScore) as saves_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awaySavesScore) - sum(homeSavesScore) as saves_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(saves_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_saves_stats as (select teams.team, matches_played, saves_wins as stat_wins, avg_saves as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, saves_wins, avg_saves, avg_difference on teams.team = matches_played.team and teams.team = saves_wins.team and  teams.team = avg_saves.team and teams.team = avg_difference.team) \n" +
      "select * from team_saves_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getSavesStats(String league);

  @Query("with teams as (select homeTeam as team from `match` where league=:league union select awayTeam as team from `match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "fouls_wins as (select team, fouls_wins from (select FoulsWinner as team, count(*) as fouls_wins from `match` group by FoulsWinner union select team, 0 as fouls_wins from teams) group by team),\n" +
      "home_fouls as (select team, sum(homeFoulsScore) as foulsScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_fouls as (select team, sum(awayFoulsScore) as foulsScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_fouls as (select * from home_fouls union all select * from away_fouls),\n" +
      "avg_fouls as (select team, sum(foulsScore) / sum(matches_played) as avg_fouls from all_fouls group by team),\n" +
      "home_differences as (select team, sum(homeFoulsScore) - sum(awayFoulsScore) as fouls_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayFoulsScore) - sum(homeFoulsScore) as fouls_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(fouls_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_fouls_stats as (select teams.team, matches_played, fouls_wins as stat_wins, avg_fouls as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, fouls_wins, avg_fouls, avg_difference on teams.team = matches_played.team and teams.team = fouls_wins.team and  teams.team = avg_fouls.team and teams.team = avg_difference.team) \n" +
      "select * from team_fouls_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getFoulsStats(String league);

  @Query("with teams as (select homeTeam as team from `match` where league=:league union select awayTeam as team from `match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "tackles_wins as (select team, tackles_wins from (select TacklesWinner as team, count(*) as tackles_wins from `match` group by TacklesWinner union select team, 0 as tackles_wins from teams) group by team),\n" +
      "home_tackles as (select team, sum(homeTacklesScore) as tacklesScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_tackles as (select team, sum(awayTacklesScore) as tacklesScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_tackles as (select * from home_tackles union all select * from away_tackles),\n" +
      "avg_tackles as (select team, sum(tacklesScore) / sum(matches_played) as avg_tackles from all_tackles group by team),\n" +
      "home_differences as (select team, sum(homeTacklesScore) - sum(awayTacklesScore) as tackles_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayTacklesScore) - sum(homeTacklesScore) as tackles_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(tackles_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_tackles_stats as (select teams.team, matches_played, tackles_wins as stat_wins, avg_tackles as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, tackles_wins, avg_tackles, avg_difference on teams.team = matches_played.team and teams.team = tackles_wins.team and  teams.team = avg_tackles.team and teams.team = avg_difference.team) \n" +
      "select * from team_tackles_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getTacklesStats(String league);




  @Query("with teams as (select distinct homeTeam as team from `match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "shots_wins as (select team, shots_wins from (select shotsWinner as team, count(*) as shots_wins from home_matches where team = shotsWinner group by shotsWinner union select team, 0 as shot_wins from teams) group by team),\n" +
      "home_shots as (select team, sum(homeShotsScore) as shotsScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_shots as (select team, sum(awayShotsScore) as shotsScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_shots as (select * from home_shots union all select * from away_shots),\n" +
      "avg_shots as (select team, sum(shotsScore) / sum(matches_played) as avg_shots from all_shots group by team),\n" +
      "home_differences as (select team, sum(homeShotsScore) - sum(awayShotsScore) as shots_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayShotsScore) - sum(homeShotsScore) as shots_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(shots_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_shots_stats as (select teams.team, matches_played, shots_wins as stat_wins, avg_shots as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, shots_wins, avg_shots, avg_difference on teams.team = matches_played.team and teams.team = shots_wins.team and  teams.team = avg_shots.team and teams.team = avg_difference.team) \n" +
      "select * from team_shots_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeShotStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "shots_on_goal_wins as (select team, shots_on_goal_wins from (select shotsOnGoalWinner as team, count(*) as shots_on_goal_wins from home_matches where team = ShotsOnGoalwinner group by shotsOnGoalWinner union select team, 0 as shots_on_goal_wins from teams) group by team),\n" +
      "home_shots_on_goal as (select team, sum(homeShotsOnGoalScore) as shotsOnGoalScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_shots_on_goal as (select team, sum(awayShotsOnGoalScore) as shotsOnGoalScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_shots_on_goal as (select * from home_shots_on_goal union all select * from away_shots_on_goal),\n" +
      "avg_shots_on_goal as (select team, sum(shotsOnGoalScore) / sum(matches_played) as avg_shots_on_goal from all_shots_on_goal group by team),\n" +
      "home_differences as (select team, sum(homeShotsOnGoalScore) - sum(awayShotsOnGoalScore) as shots_on_goal_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayShotsOnGoalScore) - sum(homeShotsOnGoalScore) as shots_on_goal_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(shots_on_goal_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_shots_on_goal_stats as (select teams.team, matches_played, shots_on_goal_wins as stat_wins, avg_shots_on_goal as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, shots_on_goal_wins, avg_shots_on_goal, avg_difference on teams.team = matches_played.team and teams.team = shots_on_goal_wins.team and  teams.team = avg_shots_on_goal.team and teams.team = avg_difference.team) \n" +
      "select * from team_shots_on_goal_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeShotOnGoalStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "corners_wins as (select team, corners_wins from (select CornersWinner as team, count(*) as corners_wins from home_matches where team = CornersWinner group by CornersWinner union select team, 0 as corners_wins from teams) group by team),\n" +
      "home_corners as (select team, sum(homeCornersScore) as cornersScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_corners as (select team, sum(awayCornersScore) as cornersScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_corners as (select * from home_corners union all select * from away_corners),\n" +
      "avg_corners as (select team, sum(cornersScore) / sum(matches_played) as avg_corners from all_corners group by team),\n" +
      "home_differences as (select team, sum(homeCornersScore) - sum(awayCornersScore) as corners_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayCornersScore) - sum(homeCornersScore) as corners_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(corners_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_corners_stats as (select teams.team, matches_played, corners_wins as stat_wins, avg_corners as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, corners_wins, avg_corners, avg_difference on teams.team = matches_played.team and teams.team = corners_wins.team and  teams.team = avg_corners.team and teams.team = avg_difference.team) \n" +
      "select * from team_corners_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeCornersStats(String league);


  @Query("with teams as (select distinct homeTeam as team from `match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "throws_in_wins as (select team, throws_in_wins from (select ThrowsInWinner as team, count(*) as throws_in_wins from home_matches where team = ThrowsInWinner group by ThrowsInWinner union select team, 0 as throws_in_wins from teams) group by team),\n" +
      "home_throws_in as (select team, sum(homeThrowsInScore) as throwsInScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_throws_in as (select team, sum(awayThrowsInScore) as throwsInScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_throws_in as (select * from home_throws_in union all select * from away_throws_in),\n" +
      "avg_throws_in as (select team, sum(throwsInScore) / sum(matches_played) as avg_throws_in from all_throws_in group by team),\n" +
      "home_differences as (select team, sum(homeThrowsInScore) - sum(awayThrowsInScore) as throws_in_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayThrowsInScore) - sum(homeThrowsInScore) as throws_in_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(throws_in_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_throws_in_stats as (select teams.team, matches_played, throws_in_wins as stat_wins, avg_throws_in as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, throws_in_wins, avg_throws_in, avg_difference on teams.team = matches_played.team and teams.team = throws_in_wins.team and  teams.team = avg_throws_in.team and teams.team = avg_difference.team) \n" +
      "select * from team_throws_in_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeThrowsInStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam ),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "saves_wins as (select team, saves_wins from (select SavesWinner as team, count(*) as saves_wins from home_matches where team = SavesWinner group by savesWinner union select team, 0 as saves_wins from teams) group by team),\n" +
      "home_saves as (select team, sum(homeSavesScore) as savesScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_saves as (select team, sum(awaySavesScore) as savesScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_saves as (select * from home_saves union all select * from away_saves),\n" +
      "avg_saves as (select team, sum(savesScore) / sum(matches_played) as avg_saves from all_saves group by team),\n" +
      "home_differences as (select team, sum(homeSavesScore) - sum(awaySavesScore) as saves_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awaySavesScore) - sum(homeSavesScore) as saves_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(saves_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_saves_stats as (select teams.team, matches_played, saves_wins as stat_wins, avg_saves as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, saves_wins, avg_saves, avg_difference on teams.team = matches_played.team and teams.team = saves_wins.team and  teams.team = avg_saves.team and teams.team = avg_difference.team) \n" +
      "select * from team_saves_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeSavesStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam ),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "fouls_wins as (select team, fouls_wins from (select FoulsWinner as team, count(*) as fouls_wins from home_matches where team = FoulsWinner group by FoulsWinner union select team, 0 as fouls_wins from teams) group by team),\n" +
      "home_fouls as (select team, sum(homeFoulsScore) as foulsScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_fouls as (select team, sum(awayFoulsScore) as foulsScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_fouls as (select * from home_fouls union all select * from away_fouls),\n" +
      "avg_fouls as (select team, sum(foulsScore) / sum(matches_played) as avg_fouls from all_fouls group by team),\n" +
      "home_differences as (select team, sum(homeFoulsScore) - sum(awayFoulsScore) as fouls_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayFoulsScore) - sum(homeFoulsScore) as fouls_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(fouls_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_fouls_stats as (select teams.team, matches_played, fouls_wins as stat_wins, avg_fouls as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, fouls_wins, avg_fouls, avg_difference on teams.team = matches_played.team and teams.team = fouls_wins.team and  teams.team = avg_fouls.team and teams.team = avg_difference.team) \n" +
      "select * from team_fouls_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeFoulsStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.homeTeam ),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "tackles_wins as (select team, tackles_wins from (select TacklesWinner as team, count(*) as tackles_wins from home_matches where team = TacklesWinner group by TacklesWinner union select team, 0 as tackles_wins from teams) group by team),\n" +
      "home_tackles as (select team, sum(homeTacklesScore) as tacklesScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_tackles as (select team, sum(awayTacklesScore) as tacklesScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_tackles as (select * from home_tackles union all select * from away_tackles),\n" +
      "avg_tackles as (select team, sum(tacklesScore) / sum(matches_played) as avg_tackles from all_tackles group by team),\n" +
      "home_differences as (select team, sum(homeTacklesScore) - sum(awayTacklesScore) as tackles_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayTacklesScore) - sum(homeTacklesScore) as tackles_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(tackles_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_tackles_stats as (select teams.team, matches_played, tackles_wins as stat_wins, avg_tackles as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, tackles_wins, avg_tackles, avg_difference on teams.team = matches_played.team and teams.team = tackles_wins.team and  teams.team = avg_tackles.team and teams.team = avg_difference.team) \n" +
      "select * from team_tackles_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeTacklesStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "shots_wins as (select team, shots_wins from (select shotsWinner as team, count(*) as shots_wins from away_matches where team = shotsWinner group by shotsWinner union select team, 0 as shot_wins from teams) group by team),\n" +
      "home_shots as (select team, sum(homeShotsScore) as shotsScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_shots as (select team, sum(awayShotsScore) as shotsScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_shots as (select * from home_shots union all select * from away_shots),\n" +
      "avg_shots as (select team, sum(shotsScore) / sum(matches_played) as avg_shots from all_shots group by team),\n" +
      "home_differences as (select team, sum(homeShotsScore) - sum(awayShotsScore) as shots_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayShotsScore) - sum(homeShotsScore) as shots_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(shots_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_shots_stats as (select teams.team, matches_played, shots_wins as stat_wins, avg_shots as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, shots_wins, avg_shots, avg_difference on teams.team = matches_played.team and teams.team = shots_wins.team and  teams.team = avg_shots.team and teams.team = avg_difference.team) \n" +
      "select * from team_shots_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayShotStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "shots_on_goal_wins as (select team, shots_on_goal_wins from (select shotsOnGoalWinner as team, count(*) as shots_on_goal_wins from away_matches where team = ShotsOnGoalwinner group by shotsOnGoalWinner union select team, 0 as shots_on_goal_wins from teams) group by team),\n" +
      "home_shots_on_goal as (select team, sum(homeShotsOnGoalScore) as shotsOnGoalScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_shots_on_goal as (select team, sum(awayShotsOnGoalScore) as shotsOnGoalScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_shots_on_goal as (select * from home_shots_on_goal union all select * from away_shots_on_goal),\n" +
      "avg_shots_on_goal as (select team, sum(shotsOnGoalScore) / sum(matches_played) as avg_shots_on_goal from all_shots_on_goal group by team),\n" +
      "home_differences as (select team, sum(homeShotsOnGoalScore) - sum(awayShotsOnGoalScore) as shots_on_goal_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayShotsOnGoalScore) - sum(homeShotsOnGoalScore) as shots_on_goal_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(shots_on_goal_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_shots_on_goal_stats as (select teams.team, matches_played, shots_on_goal_wins as stat_wins, avg_shots_on_goal as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, shots_on_goal_wins, avg_shots_on_goal, avg_difference on teams.team = matches_played.team and teams.team = shots_on_goal_wins.team and  teams.team = avg_shots_on_goal.team and teams.team = avg_difference.team) \n" +
      "select * from team_shots_on_goal_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayShotOnGoalStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "corners_wins as (select team, corners_wins from (select CornersWinner as team, count(*) as corners_wins from away_matches where team = CornersWinner group by CornersWinner union select team, 0 as corners_wins from teams) group by team),\n" +
      "home_corners as (select team, sum(homeCornersScore) as cornersScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_corners as (select team, sum(awayCornersScore) as cornersScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_corners as (select * from home_corners union all select * from away_corners),\n" +
      "avg_corners as (select team, sum(cornersScore) / sum(matches_played) as avg_corners from all_corners group by team),\n" +
      "home_differences as (select team, sum(homeCornersScore) - sum(awayCornersScore) as corners_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayCornersScore) - sum(homeCornersScore) as corners_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(corners_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_corners_stats as (select teams.team, matches_played, corners_wins as stat_wins, avg_corners as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, corners_wins, avg_corners, avg_difference on teams.team = matches_played.team and teams.team = corners_wins.team and  teams.team = avg_corners.team and teams.team = avg_difference.team) \n" +
      "select * from team_corners_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayCornersStats(String league);


  @Query("with teams as (select distinct awayTeam as team from `match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "throws_in_wins as (select team, throws_in_wins from (select ThrowsInWinner as team, count(*) as throws_in_wins from away_matches where team = ThrowsInWinner group by ThrowsInWinner union select team, 0 as throws_in_wins from teams) group by team),\n" +
      "home_throws_in as (select team, sum(homeThrowsInScore) as throwsInScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_throws_in as (select team, sum(awayThrowsInScore) as throwsInScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_throws_in as (select * from home_throws_in union all select * from away_throws_in),\n" +
      "avg_throws_in as (select team, sum(throwsInScore) / sum(matches_played) as avg_throws_in from all_throws_in group by team),\n" +
      "home_differences as (select team, sum(homeThrowsInScore) - sum(awayThrowsInScore) as throws_in_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayThrowsInScore) - sum(homeThrowsInScore) as throws_in_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(throws_in_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_throws_in_stats as (select teams.team, matches_played, throws_in_wins as stat_wins, avg_throws_in as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, throws_in_wins, avg_throws_in, avg_difference on teams.team = matches_played.team and teams.team = throws_in_wins.team and  teams.team = avg_throws_in.team and teams.team = avg_difference.team) \n" +
      "select * from team_throws_in_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayThrowsInStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `match`where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`match` as m on t.team = m.awayTeam ),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "saves_wins as (select team, saves_wins from (select SavesWinner as team, count(*) as saves_wins from away_matches where team = SavesWinner group by savesWinner union select team, 0 as saves_wins from teams) group by team),\n" +
      "home_saves as (select team, sum(homeSavesScore) as savesScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_saves as (select team, sum(awaySavesScore) as savesScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_saves as (select * from home_saves union all select * from away_saves),\n" +
      "avg_saves as (select team, sum(savesScore) / sum(matches_played) as avg_saves from all_saves group by team),\n" +
      "home_differences as (select team, sum(homeSavesScore) - sum(awaySavesScore) as saves_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awaySavesScore) - sum(homeSavesScore) as saves_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(saves_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_saves_stats as (select teams.team, matches_played, saves_wins as stat_wins, avg_saves as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, saves_wins, avg_saves, avg_difference on teams.team = matches_played.team and teams.team = saves_wins.team and  teams.team = avg_saves.team and teams.team = avg_difference.team) \n" +
      "select * from team_saves_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwaySavesStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `match`  where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`match` as m on t.team = m.awayTeam ),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "fouls_wins as (select team, fouls_wins from (select FoulsWinner as team, count(*) as fouls_wins from home_matches where team = FoulsWinner group by FoulsWinner union select team, 0 as fouls_wins from teams) group by team),\n" +
      "home_fouls as (select team, sum(homeFoulsScore) as foulsScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_fouls as (select team, sum(awayFoulsScore) as foulsScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_fouls as (select * from home_fouls union all select * from away_fouls),\n" +
      "avg_fouls as (select team, sum(foulsScore) / sum(matches_played) as avg_fouls from all_fouls group by team),\n" +
      "home_differences as (select team, sum(homeFoulsScore) - sum(awayFoulsScore) as fouls_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayFoulsScore) - sum(homeFoulsScore) as fouls_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(fouls_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_fouls_stats as (select teams.team, matches_played, fouls_wins as stat_wins, avg_fouls as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, fouls_wins, avg_fouls, avg_difference on teams.team = matches_played.team and teams.team = fouls_wins.team and  teams.team = avg_fouls.team and teams.team = avg_difference.team) \n" +
      "select * from team_fouls_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayFoulsStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `match` where league=:league ),\n" +
      "away_matches as (select * from teams as t inner join`match` as m on t.team = m.awayTeam ),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "tackles_wins as (select team, tackles_wins from (select TacklesWinner as team, count(*) as tackles_wins from away_matches where team = TacklesWinner group by TacklesWinner union select team, 0 as tackles_wins from teams) group by team),\n" +
      "home_tackles as (select team, sum(homeTacklesScore) as tacklesScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_tackles as (select team, sum(awayTacklesScore) as tacklesScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_tackles as (select * from home_tackles union all select * from away_tackles),\n" +
      "avg_tackles as (select team, sum(tacklesScore) / sum(matches_played) as avg_tackles from all_tackles group by team),\n" +
      "home_differences as (select team, sum(homeTacklesScore) - sum(awayTacklesScore) as tackles_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayTacklesScore) - sum(homeTacklesScore) as tackles_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(tackles_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_tackles_stats as (select teams.team, matches_played, tackles_wins as stat_wins, avg_tackles as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, tackles_wins, avg_tackles, avg_difference on teams.team = matches_played.team and teams.team = tackles_wins.team and  teams.team = avg_tackles.team and teams.team = avg_difference.team) \n" +
      "select * from team_tackles_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayTacklesStats(String league);



}
