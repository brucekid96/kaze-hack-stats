package com.kazehackstats.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface BasketballMatchDao {

  @Insert
  Completable insert(BasketballMatch basketballMatch);
  @Delete
  Completable delete(BasketballMatch basketballMmatch);
  @Update
  Completable update(BasketballMatch basketballMatch);

  @Query("SELECT * FROM `basketball_match`")
  Observable<List<BasketballMatch>> getAllMatches();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Completable bulkInsert(List<BasketballMatch> basketballMatches);

  @Query("with teams as (select homeTeam as team from `basketball_match`  where league =:league union select awayTeam as team from `basketball_match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "two_pts_wins as (select team, two_pts_wins from (select twoPtsWinner as team, count(*) as two_pts_wins from `basketball_match` group by twoPtsWinner union select team, 0 as two_pt_wins from teams) group by team),\n" +
      "home_two_pts as (select team, sum(homeTwoPtsScore) as twoPtsScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_two_pts as (select team, sum(awayTwoPtsScore) as twoPtsScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_two_pts as (select * from home_two_pts union all select * from away_two_pts),\n" +
      "avg_two_pts as (select team, sum(twoPtsScore) / sum(matches_played) as avg_two_pts from all_two_pts group by team),\n" +
      "home_differences as (select team, sum(homeTwoPtsScore) - sum(awayTwoPtsScore) as twoPts_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayTwoPtsScore) - sum(homeTwoPtsScore) as twoPts_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(twoPts_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_two_pts_stats as (select teams.team, matches_played, two_pts_wins as stat_wins, avg_two_pts as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, two_pts_wins, avg_two_pts, avg_difference on teams.team = matches_played.team and teams.team = two_pts_wins.team and  teams.team = avg_two_pts.team and teams.team = avg_difference.team) \n" +
      "select * from team_two_pts_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getTwoPtsStats(String league);

  @Query("with teams as (select homeTeam as team from `basketball_match`  where league =:league union select awayTeam as team from `basketball_match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "three_pts_wins as (select team, three_pts_wins from (select ThreePtsWinner as team, count(*) as three_pts_wins from `basketball_match` group by ThreePtsWinner union select team, 0 as three_pt_wins from teams) group by team),\n" +
      "home_three_pts as (select team, sum(homeThreePtsScore) as threePtsScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_three_pts as (select team, sum(awayThreePtsScore) as threePtsScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_three_pts as (select * from home_three_pts union all select * from away_three_pts),\n" +
      "avg_three_pts as (select team, sum(threePtsScore) / sum(matches_played) as avg_three_pts from all_three_pts group by team),\n" +
      "home_differences as (select team, sum(homeThreePtsScore) - sum(awayThreePtsScore) as threePts_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayThreePtsScore) - sum(homeThreePtsScore) as threePts_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(threePts_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_three_pts_stats as (select teams.team, matches_played, three_pts_wins as stat_wins, avg_three_pts as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, three_pts_wins, avg_three_pts, avg_difference on teams.team = matches_played.team and teams.team = three_pts_wins.team and  teams.team = avg_three_pts.team and teams.team = avg_difference.team) \n" +
      "select * from team_three_pts_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getThreePtsStats(String league);

  @Query("with teams as (select homeTeam as team from `basketball_match`  where league =:league union select awayTeam as team from `basketball_match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "rebounds_wins as (select team, rebounds_wins from (select reboundsWinner as team, count(*) as rebounds_wins from `basketball_match` group by reboundsWinner union select team, 0 as rebound_wins from teams) group by team),\n" +
      "home_rebounds as (select team, sum(homeReboundsScore) as reboundsScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_rebounds as (select team, sum(awayReboundsScore) as reboundsScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_rebounds as (select * from home_rebounds union all select * from away_rebounds),\n" +
      "avg_rebounds as (select team, sum(reboundsScore) / sum(matches_played) as avg_rebounds from all_rebounds group by team),\n" +
      "home_differences as (select team, sum(homeReboundsScore) - sum(awayReboundsScore) as rebounds_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayReboundsScore) - sum(homeReboundsScore) as rebounds_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(rebounds_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_rebounds_stats as (select teams.team, matches_played, rebounds_wins as stat_wins, avg_rebounds as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, rebounds_wins, avg_rebounds, avg_difference on teams.team = matches_played.team and teams.team = rebounds_wins.team and  teams.team = avg_rebounds.team and teams.team = avg_difference.team) \n" +
      "select * from team_rebounds_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getReboundsStats(String league);

  @Query("with teams as (select homeTeam as team from `basketball_match`  where league =:league union select awayTeam as team from `basketball_match` where league=:league ),\n" +
      "team_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam or t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from team_matches group by team),\n" +
      "assists_wins as (select team, assists_wins from (select AssistsWinner as team, count(*) as assists_wins from `basketball_match` group by AssistsWinner union select team, 0 as assist_wins from teams) group by team),\n" +
      "home_assists as (select team, sum(homeAssistsScore) as assistsScore, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_assists as (select team, sum(awayAssistsScore) as assistsScore, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_assists as (select * from home_assists union all select * from away_assists),\n" +
      "avg_assists as (select team, sum(assistsScore) / sum(matches_played) as avg_assists from all_assists group by team),\n" +
      "home_differences as (select team, sum(homeAssistsScore) - sum(awayAssistsScore) as assists_difference, count(*) as matches_played from team_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayAssistsScore) - sum(homeAssistsScore) as assists_difference, count(*) as matches_played from team_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(assists_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_assists_stats as (select teams.team, matches_played, assists_wins as stat_wins, avg_assists as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, assists_wins, avg_assists, avg_difference on teams.team = matches_played.team and teams.team = assists_wins.team and  teams.team = avg_assists.team and teams.team = avg_difference.team) \n" +
      "select * from team_assists_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAssistsStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `basketball_match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "two_pts_wins as (select team, two_pts_wins from (select TwoPtsWinner as team, count(*) as two_pts_wins from home_matches where team = TwoPtsWinner group by TwoPtsWinner union select team, 0 as two_pt_wins from teams) group by team),\n" +
      "home_two_pts as (select team, sum(homeTwoPtsScore) as twoPtsScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_two_pts as (select team, sum(awayTwoPtsScore) as twoPtsScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_two_pts as (select * from home_two_pts union all select * from away_two_pts),\n" +
      "avg_two_pts as (select team, sum(twoPtsScore) / sum(matches_played) as avg_two_pts from all_two_pts group by team),\n" +
      "home_differences as (select team, sum(homeTwoPtsScore) - sum(awayTwoPtsScore) as two_pts_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayTwoPtsScore) - sum(homeTwoPtsScore) as two_pts_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(two_pts_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_two_pts_stats as (select teams.team, matches_played, two_pts_wins as stat_wins, avg_two_pts as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, two_pts_wins, avg_two_pts, avg_difference on teams.team = matches_played.team and teams.team = two_pts_wins.team and  teams.team = avg_two_pts.team and teams.team = avg_difference.team) \n" +
      "select * from team_two_pts_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeTwoPtsStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `basketball_match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "three_pts_wins as (select team, three_pts_wins from (select ThreePtsWinner as team, count(*) as three_pts_wins from home_matches where team = ThreePtsWinner group by ThreePtsWinner union select team, 0 as three_pt_wins from teams) group by team),\n" +
      "home_three_pts as (select team, sum(homeThreePtsScore) as threePtsScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_three_pts as (select team, sum(awayThreePtsScore) as threePtsScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_three_pts as (select * from home_three_pts union all select * from away_three_pts),\n" +
      "avg_three_pts as (select team, sum(threePtsScore) / sum(matches_played) as avg_three_pts from all_three_pts group by team),\n" +
      "home_differences as (select team, sum(homeThreePtsScore) - sum(awayThreePtsScore) as three_pts_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayThreePtsScore) - sum(homeThreePtsScore) as three_pts_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(three_pts_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_three_pts_stats as (select teams.team, matches_played, three_pts_wins as stat_wins, avg_three_pts as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, three_pts_wins, avg_three_pts, avg_difference on teams.team = matches_played.team and teams.team = three_pts_wins.team and  teams.team = avg_three_pts.team and teams.team = avg_difference.team) \n" +
      "select * from team_three_pts_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeThreePtsStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `basketball_match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "rebounds_wins as (select team, rebounds_wins from (select ReboundsWinner as team, count(*) as rebounds_wins from home_matches where team = ReboundsWinner group by ReboundsWinner union select team, 0 as rebound_wins from teams) group by team),\n" +
      "home_rebounds as (select team, sum(homeReboundsScore) as reboundsScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_rebounds as (select team, sum(awayReboundsScore) as reboundsScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_rebounds as (select * from home_rebounds union all select * from away_rebounds),\n" +
      "avg_rebounds as (select team, sum(reboundsScore) / sum(matches_played) as avg_rebounds from all_rebounds group by team),\n" +
      "home_differences as (select team, sum(homeReboundsScore) - sum(awayReboundsScore) as rebounds_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayReboundsScore) - sum(homeReboundsScore) as rebounds_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(rebounds_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_rebounds_stats as (select teams.team, matches_played, rebounds_wins as stat_wins, avg_rebounds as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, rebounds_wins, avg_rebounds, avg_difference on teams.team = matches_played.team and teams.team = rebounds_wins.team and  teams.team = avg_rebounds.team and teams.team = avg_difference.team) \n" +
      "select * from team_rebounds_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeReboundsStats(String league);

  @Query("with teams as (select distinct homeTeam as team from `basketball_match` where league=:league),\n" +
      "home_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.homeTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from home_matches group by team),\n" +
      "assists_wins as (select team, assists_wins from (select AssistsWinner as team, count(*) as assists_wins from home_matches where team = AssistsWinner group by AssistsWinner union select team, 0 as assist_wins from teams) group by team),\n" +
      "home_assists as (select team, sum(homeAssistsScore) as assistsScore, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_assists as (select team, sum(awayAssistsScore) as assistsScore, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_assists as (select * from home_assists union all select * from away_assists),\n" +
      "avg_assists as (select team, sum(assistsScore) / sum(matches_played) as avg_assists from all_assists group by team),\n" +
      "home_differences as (select team, sum(homeAssistsScore) - sum(awayAssistsScore) as assists_difference, count(*) as matches_played from home_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayAssistsScore) - sum(homeAssistsScore) as assists_difference, count(*) as matches_played from home_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(assists_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_assists_stats as (select teams.team, matches_played, assists_wins as stat_wins, avg_assists as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, assists_wins, avg_assists, avg_difference on teams.team = matches_played.team and teams.team = assists_wins.team and  teams.team = avg_assists.team and teams.team = avg_difference.team) \n" +
      "select * from team_assists_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getHomeAssistsStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `basketball_match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "two_pts_wins as (select team, two_pts_wins from (select TwoPtsWinner as team, count(*) as two_pts_wins from away_matches where team = TwoPtsWinner group by TwoPtsWinner union select team, 0 as two_pt_wins from teams) group by team),\n" +
      "home_two_pts as (select team, sum(homeTwoPtsScore) as twoPtsScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_two_pts as (select team, sum(awayTwoPtsScore) as twoPtsScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_two_pts as (select * from home_two_pts union all select * from away_two_pts),\n" +
      "avg_two_pts as (select team, sum(twoPtsScore) / sum(matches_played) as avg_two_pts from all_two_pts group by team),\n" +
      "home_differences as (select team, sum(homeTwoPtsScore) - sum(awayTwoPtsScore) as two_pts_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayTwoPtsScore) - sum(homeTwoPtsScore) as two_pts_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(two_pts_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_two_pts_stats as (select teams.team, matches_played, two_pts_wins as stat_wins, avg_two_pts as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, two_pts_wins, avg_two_pts, avg_difference on teams.team = matches_played.team and teams.team = two_pts_wins.team and  teams.team = avg_two_pts.team and teams.team = avg_difference.team) \n" +
      "select * from team_two_pts_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayTwoPtsStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `basketball_match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "three_pts_wins as (select team, three_pts_wins from (select ThreePtsWinner as team, count(*) as three_pts_wins from away_matches where team = ThreePtsWinner group by ThreePtsWinner union select team, 0 as three_pt_wins from teams) group by team),\n" +
      "home_three_pts as (select team, sum(homeThreePtsScore) as threePtsScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_three_pts as (select team, sum(awayThreePtsScore) as threePtsScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_three_pts as (select * from home_three_pts union all select * from away_three_pts),\n" +
      "avg_three_pts as (select team, sum(threePtsScore) / sum(matches_played) as avg_three_pts from all_three_pts group by team),\n" +
      "home_differences as (select team, sum(homeThreePtsScore) - sum(awayThreePtsScore) as three_pts_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayThreePtsScore) - sum(homeThreePtsScore) as three_pts_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(three_pts_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_three_pts_stats as (select teams.team, matches_played, three_pts_wins as stat_wins, avg_three_pts as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, three_pts_wins, avg_three_pts, avg_difference on teams.team = matches_played.team and teams.team = three_pts_wins.team and  teams.team = avg_three_pts.team and teams.team = avg_difference.team) \n" +
      "select * from team_three_pts_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayThreePtsStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `basketball_match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "rebounds_wins as (select team, rebounds_wins from (select ReboundsWinner as team, count(*) as rebounds_wins from away_matches where team = ReboundsWinner group by ReboundsWinner union select team, 0 as rebound_wins from teams) group by team),\n" +
      "home_rebounds as (select team, sum(homeReboundsScore) as reboundsScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_rebounds as (select team, sum(awayReboundsScore) as reboundsScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_rebounds as (select * from home_rebounds union all select * from away_rebounds),\n" +
      "avg_rebounds as (select team, sum(reboundsScore) / sum(matches_played) as avg_rebounds from all_rebounds group by team),\n" +
      "home_differences as (select team, sum(homeReboundsScore) - sum(awayReboundsScore) as rebounds_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayReboundsScore) - sum(homeReboundsScore) as rebounds_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(rebounds_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_rebounds_stats as (select teams.team, matches_played, rebounds_wins as stat_wins, avg_rebounds as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, rebounds_wins, avg_rebounds, avg_difference on teams.team = matches_played.team and teams.team = rebounds_wins.team and  teams.team = avg_rebounds.team and teams.team = avg_difference.team) \n" +
      "select * from team_rebounds_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayReboundsStats(String league);

  @Query("with teams as (select distinct awayTeam as team from `basketball_match` where league=:league),\n" +
      "away_matches as (select * from teams as t inner join`basketball_match` as m on t.team = m.awayTeam),\n" +
      "matches_played as (select team, count(*) as matches_played from away_matches group by team),\n" +
      "assists_wins as (select team, assists_wins from (select AssistsWinner as team, count(*) as assists_wins from away_matches where team = AssistsWinner group by AssistsWinner union select team, 0 as assist_wins from teams) group by team),\n" +
      "home_assists as (select team, sum(homeAssistsScore) as assistsScore, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_assists as (select team, sum(awayAssistsScore) as assistsScore, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_assists as (select * from home_assists union all select * from away_assists),\n" +
      "avg_assists as (select team, sum(assistsScore) / sum(matches_played) as avg_assists from all_assists group by team),\n" +
      "home_differences as (select team, sum(homeAssistsScore) - sum(awayAssistsScore) as assists_difference, count(*) as matches_played from away_matches where team = homeTeam group by team),\n" +
      "away_differences as (select team, sum(awayAssistsScore) - sum(homeAssistsScore) as assists_difference, count(*) as matches_played from away_matches where team = awayTeam group by team),\n" +
      "all_differences as (select * from home_differences union all select * from away_differences),\n" +
      "avg_difference as (select team, sum(assists_difference) / sum(matches_played) as avg_difference from all_differences group by team),\n" +
      "team_assists_stats as (select teams.team, matches_played, assists_wins as stat_wins, avg_assists as stat_average_count, avg_difference as stat_average_difference from teams, matches_played, assists_wins, avg_assists, avg_difference on teams.team = matches_played.team and teams.team = assists_wins.team and  teams.team = avg_assists.team and teams.team = avg_difference.team) \n" +
      "select * from team_assists_stats order by stat_wins desc ")
  LiveData<List<TeamStatLine>> getAwayAssistsStats(String league);


}
