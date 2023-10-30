package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Match type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Matches", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.DELETE, ModelOperation.UPDATE, ModelOperation.READ })
})
public final class Match implements Model {
  public static final QueryField ID = field("Match", "id");
  public static final QueryField LEAGUE = field("Match", "league");
  public static final QueryField DATE = field("Match", "date");
  public static final QueryField HOME_TEAM = field("Match", "homeTeam");
  public static final QueryField AWAY_TEAM = field("Match", "awayTeam");
  public static final QueryField HOME_SHOTS_SCORE = field("Match", "homeShotsScore");
  public static final QueryField AWAY_SHOTS_SCORE = field("Match", "awayShotsScore");
  public static final QueryField SHOTS_WINNER = field("Match", "shotsWinner");
  public static final QueryField SHOTS_DIFFERENCE = field("Match", "shotsDifference");
  public static final QueryField HOME_SHOTS_ON_GOAL_SCORE = field("Match", "homeShotsOnGoalScore");
  public static final QueryField AWAY_SHOTS_ON_GOAL_SCORE = field("Match", "awayShotsOnGoalScore");
  public static final QueryField SHOTS_ON_GOAL_WINNER = field("Match", "shotsOnGoalWinner");
  public static final QueryField SHOTS_ON_GOAL_DIFFERENCE = field("Match", "shotsOnGoalDifference");
  public static final QueryField HOME_CORNERS_SCORE = field("Match", "homeCornersScore");
  public static final QueryField AWAY_CORNERS_SCORE = field("Match", "awayCornersScore");
  public static final QueryField CORNERS_WINNER = field("Match", "cornersWinner");
  public static final QueryField CORNERS_DIFFERENCE = field("Match", "cornersDifference");
  public static final QueryField HOME_THROWS_IN_SCORE = field("Match", "homeThrowsInScore");
  public static final QueryField AWAY_THROWS_IN_SCORE = field("Match", "awayThrowsInScore");
  public static final QueryField THROWS_IN_WINNER = field("Match", "throwsInWinner");
  public static final QueryField THROWS_IN_DIFFERENCE = field("Match", "throwsInDifference");
  public static final QueryField HOME_SAVES_SCORE = field("Match", "homeSavesScore");
  public static final QueryField AWAY_SAVES_SCORE = field("Match", "awaySavesScore");
  public static final QueryField SAVES_WINNER = field("Match", "savesWinner");
  public static final QueryField SAVES_DIFFERENCE = field("Match", "savesDifference");
  public static final QueryField HOME_FOULS_SCORE = field("Match", "homeFoulsScore");
  public static final QueryField AWAY_FOULS_SCORE = field("Match", "awayFoulsScore");
  public static final QueryField FOULS_WINNER = field("Match", "foulsWinner");
  public static final QueryField FOULS_DIFFERENCE = field("Match", "foulsDifference");
  public static final QueryField HOME_TACKLES_SCORE = field("Match", "homeTacklesScore");
  public static final QueryField AWAY_TACKLES_SCORE = field("Match", "awayTacklesScore");
  public static final QueryField TACKLES_WINNER = field("Match", "tacklesWinner");
  public static final QueryField TACKLES_DIFFERENCE = field("Match", "tacklesDifference");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String league;
  private final @ModelField(targetType="String") String date;
  private final @ModelField(targetType="String") String homeTeam;
  private final @ModelField(targetType="String") String awayTeam;
  private final @ModelField(targetType="Int") Integer homeShotsScore;
  private final @ModelField(targetType="Int") Integer awayShotsScore;
  private final @ModelField(targetType="String") String shotsWinner;
  private final @ModelField(targetType="Int") Integer shotsDifference;
  private final @ModelField(targetType="Int") Integer homeShotsOnGoalScore;
  private final @ModelField(targetType="Int") Integer awayShotsOnGoalScore;
  private final @ModelField(targetType="String") String shotsOnGoalWinner;
  private final @ModelField(targetType="Int") Integer shotsOnGoalDifference;
  private final @ModelField(targetType="Int") Integer homeCornersScore;
  private final @ModelField(targetType="Int") Integer awayCornersScore;
  private final @ModelField(targetType="String") String cornersWinner;
  private final @ModelField(targetType="Int") Integer cornersDifference;
  private final @ModelField(targetType="Int") Integer homeThrowsInScore;
  private final @ModelField(targetType="Int") Integer awayThrowsInScore;
  private final @ModelField(targetType="String") String throwsInWinner;
  private final @ModelField(targetType="Int") Integer throwsInDifference;
  private final @ModelField(targetType="Int") Integer homeSavesScore;
  private final @ModelField(targetType="Int") Integer awaySavesScore;
  private final @ModelField(targetType="String") String savesWinner;
  private final @ModelField(targetType="Int") Integer savesDifference;
  private final @ModelField(targetType="Int") Integer homeFoulsScore;
  private final @ModelField(targetType="Int") Integer awayFoulsScore;
  private final @ModelField(targetType="String") String foulsWinner;
  private final @ModelField(targetType="Int") Integer foulsDifference;
  private final @ModelField(targetType="Int") Integer homeTacklesScore;
  private final @ModelField(targetType="Int") Integer awayTacklesScore;
  private final @ModelField(targetType="String") String tacklesWinner;
  private final @ModelField(targetType="Int") Integer tacklesDifference;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getLeague() {
      return league;
  }
  
  public String getDate() {
      return date;
  }
  
  public String getHomeTeam() {
      return homeTeam;
  }
  
  public String getAwayTeam() {
      return awayTeam;
  }
  
  public Integer getHomeShotsScore() {
      return homeShotsScore;
  }
  
  public Integer getAwayShotsScore() {
      return awayShotsScore;
  }
  
  public String getShotsWinner() {
      return shotsWinner;
  }
  
  public Integer getShotsDifference() {
      return shotsDifference;
  }
  
  public Integer getHomeShotsOnGoalScore() {
      return homeShotsOnGoalScore;
  }
  
  public Integer getAwayShotsOnGoalScore() {
      return awayShotsOnGoalScore;
  }
  
  public String getShotsOnGoalWinner() {
      return shotsOnGoalWinner;
  }
  
  public Integer getShotsOnGoalDifference() {
      return shotsOnGoalDifference;
  }
  
  public Integer getHomeCornersScore() {
      return homeCornersScore;
  }
  
  public Integer getAwayCornersScore() {
      return awayCornersScore;
  }
  
  public String getCornersWinner() {
      return cornersWinner;
  }
  
  public Integer getCornersDifference() {
      return cornersDifference;
  }
  
  public Integer getHomeThrowsInScore() {
      return homeThrowsInScore;
  }
  
  public Integer getAwayThrowsInScore() {
      return awayThrowsInScore;
  }
  
  public String getThrowsInWinner() {
      return throwsInWinner;
  }
  
  public Integer getThrowsInDifference() {
      return throwsInDifference;
  }
  
  public Integer getHomeSavesScore() {
      return homeSavesScore;
  }
  
  public Integer getAwaySavesScore() {
      return awaySavesScore;
  }
  
  public String getSavesWinner() {
      return savesWinner;
  }
  
  public Integer getSavesDifference() {
      return savesDifference;
  }
  
  public Integer getHomeFoulsScore() {
      return homeFoulsScore;
  }
  
  public Integer getAwayFoulsScore() {
      return awayFoulsScore;
  }
  
  public String getFoulsWinner() {
      return foulsWinner;
  }
  
  public Integer getFoulsDifference() {
      return foulsDifference;
  }
  
  public Integer getHomeTacklesScore() {
      return homeTacklesScore;
  }
  
  public Integer getAwayTacklesScore() {
      return awayTacklesScore;
  }
  
  public String getTacklesWinner() {
      return tacklesWinner;
  }
  
  public Integer getTacklesDifference() {
      return tacklesDifference;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Match(String id, String league, String date, String homeTeam, String awayTeam, Integer homeShotsScore, Integer awayShotsScore, String shotsWinner, Integer shotsDifference, Integer homeShotsOnGoalScore, Integer awayShotsOnGoalScore, String shotsOnGoalWinner, Integer shotsOnGoalDifference, Integer homeCornersScore, Integer awayCornersScore, String cornersWinner, Integer cornersDifference, Integer homeThrowsInScore, Integer awayThrowsInScore, String throwsInWinner, Integer throwsInDifference, Integer homeSavesScore, Integer awaySavesScore, String savesWinner, Integer savesDifference, Integer homeFoulsScore, Integer awayFoulsScore, String foulsWinner, Integer foulsDifference, Integer homeTacklesScore, Integer awayTacklesScore, String tacklesWinner, Integer tacklesDifference) {
    this.id = id;
    this.league = league;
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
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Match match = (Match) obj;
      return ObjectsCompat.equals(getId(), match.getId()) &&
              ObjectsCompat.equals(getLeague(), match.getLeague()) &&
              ObjectsCompat.equals(getDate(), match.getDate()) &&
              ObjectsCompat.equals(getHomeTeam(), match.getHomeTeam()) &&
              ObjectsCompat.equals(getAwayTeam(), match.getAwayTeam()) &&
              ObjectsCompat.equals(getHomeShotsScore(), match.getHomeShotsScore()) &&
              ObjectsCompat.equals(getAwayShotsScore(), match.getAwayShotsScore()) &&
              ObjectsCompat.equals(getShotsWinner(), match.getShotsWinner()) &&
              ObjectsCompat.equals(getShotsDifference(), match.getShotsDifference()) &&
              ObjectsCompat.equals(getHomeShotsOnGoalScore(), match.getHomeShotsOnGoalScore()) &&
              ObjectsCompat.equals(getAwayShotsOnGoalScore(), match.getAwayShotsOnGoalScore()) &&
              ObjectsCompat.equals(getShotsOnGoalWinner(), match.getShotsOnGoalWinner()) &&
              ObjectsCompat.equals(getShotsOnGoalDifference(), match.getShotsOnGoalDifference()) &&
              ObjectsCompat.equals(getHomeCornersScore(), match.getHomeCornersScore()) &&
              ObjectsCompat.equals(getAwayCornersScore(), match.getAwayCornersScore()) &&
              ObjectsCompat.equals(getCornersWinner(), match.getCornersWinner()) &&
              ObjectsCompat.equals(getCornersDifference(), match.getCornersDifference()) &&
              ObjectsCompat.equals(getHomeThrowsInScore(), match.getHomeThrowsInScore()) &&
              ObjectsCompat.equals(getAwayThrowsInScore(), match.getAwayThrowsInScore()) &&
              ObjectsCompat.equals(getThrowsInWinner(), match.getThrowsInWinner()) &&
              ObjectsCompat.equals(getThrowsInDifference(), match.getThrowsInDifference()) &&
              ObjectsCompat.equals(getHomeSavesScore(), match.getHomeSavesScore()) &&
              ObjectsCompat.equals(getAwaySavesScore(), match.getAwaySavesScore()) &&
              ObjectsCompat.equals(getSavesWinner(), match.getSavesWinner()) &&
              ObjectsCompat.equals(getSavesDifference(), match.getSavesDifference()) &&
              ObjectsCompat.equals(getHomeFoulsScore(), match.getHomeFoulsScore()) &&
              ObjectsCompat.equals(getAwayFoulsScore(), match.getAwayFoulsScore()) &&
              ObjectsCompat.equals(getFoulsWinner(), match.getFoulsWinner()) &&
              ObjectsCompat.equals(getFoulsDifference(), match.getFoulsDifference()) &&
              ObjectsCompat.equals(getHomeTacklesScore(), match.getHomeTacklesScore()) &&
              ObjectsCompat.equals(getAwayTacklesScore(), match.getAwayTacklesScore()) &&
              ObjectsCompat.equals(getTacklesWinner(), match.getTacklesWinner()) &&
              ObjectsCompat.equals(getTacklesDifference(), match.getTacklesDifference()) &&
              ObjectsCompat.equals(getCreatedAt(), match.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), match.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getLeague())
      .append(getDate())
      .append(getHomeTeam())
      .append(getAwayTeam())
      .append(getHomeShotsScore())
      .append(getAwayShotsScore())
      .append(getShotsWinner())
      .append(getShotsDifference())
      .append(getHomeShotsOnGoalScore())
      .append(getAwayShotsOnGoalScore())
      .append(getShotsOnGoalWinner())
      .append(getShotsOnGoalDifference())
      .append(getHomeCornersScore())
      .append(getAwayCornersScore())
      .append(getCornersWinner())
      .append(getCornersDifference())
      .append(getHomeThrowsInScore())
      .append(getAwayThrowsInScore())
      .append(getThrowsInWinner())
      .append(getThrowsInDifference())
      .append(getHomeSavesScore())
      .append(getAwaySavesScore())
      .append(getSavesWinner())
      .append(getSavesDifference())
      .append(getHomeFoulsScore())
      .append(getAwayFoulsScore())
      .append(getFoulsWinner())
      .append(getFoulsDifference())
      .append(getHomeTacklesScore())
      .append(getAwayTacklesScore())
      .append(getTacklesWinner())
      .append(getTacklesDifference())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Match {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("league=" + String.valueOf(getLeague()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("homeTeam=" + String.valueOf(getHomeTeam()) + ", ")
      .append("awayTeam=" + String.valueOf(getAwayTeam()) + ", ")
      .append("homeShotsScore=" + String.valueOf(getHomeShotsScore()) + ", ")
      .append("awayShotsScore=" + String.valueOf(getAwayShotsScore()) + ", ")
      .append("shotsWinner=" + String.valueOf(getShotsWinner()) + ", ")
      .append("shotsDifference=" + String.valueOf(getShotsDifference()) + ", ")
      .append("homeShotsOnGoalScore=" + String.valueOf(getHomeShotsOnGoalScore()) + ", ")
      .append("awayShotsOnGoalScore=" + String.valueOf(getAwayShotsOnGoalScore()) + ", ")
      .append("shotsOnGoalWinner=" + String.valueOf(getShotsOnGoalWinner()) + ", ")
      .append("shotsOnGoalDifference=" + String.valueOf(getShotsOnGoalDifference()) + ", ")
      .append("homeCornersScore=" + String.valueOf(getHomeCornersScore()) + ", ")
      .append("awayCornersScore=" + String.valueOf(getAwayCornersScore()) + ", ")
      .append("cornersWinner=" + String.valueOf(getCornersWinner()) + ", ")
      .append("cornersDifference=" + String.valueOf(getCornersDifference()) + ", ")
      .append("homeThrowsInScore=" + String.valueOf(getHomeThrowsInScore()) + ", ")
      .append("awayThrowsInScore=" + String.valueOf(getAwayThrowsInScore()) + ", ")
      .append("throwsInWinner=" + String.valueOf(getThrowsInWinner()) + ", ")
      .append("throwsInDifference=" + String.valueOf(getThrowsInDifference()) + ", ")
      .append("homeSavesScore=" + String.valueOf(getHomeSavesScore()) + ", ")
      .append("awaySavesScore=" + String.valueOf(getAwaySavesScore()) + ", ")
      .append("savesWinner=" + String.valueOf(getSavesWinner()) + ", ")
      .append("savesDifference=" + String.valueOf(getSavesDifference()) + ", ")
      .append("homeFoulsScore=" + String.valueOf(getHomeFoulsScore()) + ", ")
      .append("awayFoulsScore=" + String.valueOf(getAwayFoulsScore()) + ", ")
      .append("foulsWinner=" + String.valueOf(getFoulsWinner()) + ", ")
      .append("foulsDifference=" + String.valueOf(getFoulsDifference()) + ", ")
      .append("homeTacklesScore=" + String.valueOf(getHomeTacklesScore()) + ", ")
      .append("awayTacklesScore=" + String.valueOf(getAwayTacklesScore()) + ", ")
      .append("tacklesWinner=" + String.valueOf(getTacklesWinner()) + ", ")
      .append("tacklesDifference=" + String.valueOf(getTacklesDifference()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Match justId(String id) {
    return new Match(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      league,
      date,
      homeTeam,
      awayTeam,
      homeShotsScore,
      awayShotsScore,
      shotsWinner,
      shotsDifference,
      homeShotsOnGoalScore,
      awayShotsOnGoalScore,
      shotsOnGoalWinner,
      shotsOnGoalDifference,
      homeCornersScore,
      awayCornersScore,
      cornersWinner,
      cornersDifference,
      homeThrowsInScore,
      awayThrowsInScore,
      throwsInWinner,
      throwsInDifference,
      homeSavesScore,
      awaySavesScore,
      savesWinner,
      savesDifference,
      homeFoulsScore,
      awayFoulsScore,
      foulsWinner,
      foulsDifference,
      homeTacklesScore,
      awayTacklesScore,
      tacklesWinner,
      tacklesDifference);
  }
  public interface BuildStep {
    Match build();
    BuildStep id(String id);
    BuildStep league(String league);
    BuildStep date(String date);
    BuildStep homeTeam(String homeTeam);
    BuildStep awayTeam(String awayTeam);
    BuildStep homeShotsScore(Integer homeShotsScore);
    BuildStep awayShotsScore(Integer awayShotsScore);
    BuildStep shotsWinner(String shotsWinner);
    BuildStep shotsDifference(Integer shotsDifference);
    BuildStep homeShotsOnGoalScore(Integer homeShotsOnGoalScore);
    BuildStep awayShotsOnGoalScore(Integer awayShotsOnGoalScore);
    BuildStep shotsOnGoalWinner(String shotsOnGoalWinner);
    BuildStep shotsOnGoalDifference(Integer shotsOnGoalDifference);
    BuildStep homeCornersScore(Integer homeCornersScore);
    BuildStep awayCornersScore(Integer awayCornersScore);
    BuildStep cornersWinner(String cornersWinner);
    BuildStep cornersDifference(Integer cornersDifference);
    BuildStep homeThrowsInScore(Integer homeThrowsInScore);
    BuildStep awayThrowsInScore(Integer awayThrowsInScore);
    BuildStep throwsInWinner(String throwsInWinner);
    BuildStep throwsInDifference(Integer throwsInDifference);
    BuildStep homeSavesScore(Integer homeSavesScore);
    BuildStep awaySavesScore(Integer awaySavesScore);
    BuildStep savesWinner(String savesWinner);
    BuildStep savesDifference(Integer savesDifference);
    BuildStep homeFoulsScore(Integer homeFoulsScore);
    BuildStep awayFoulsScore(Integer awayFoulsScore);
    BuildStep foulsWinner(String foulsWinner);
    BuildStep foulsDifference(Integer foulsDifference);
    BuildStep homeTacklesScore(Integer homeTacklesScore);
    BuildStep awayTacklesScore(Integer awayTacklesScore);
    BuildStep tacklesWinner(String tacklesWinner);
    BuildStep tacklesDifference(Integer tacklesDifference);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String league;
    private String date;
    private String homeTeam;
    private String awayTeam;
    private Integer homeShotsScore;
    private Integer awayShotsScore;
    private String shotsWinner;
    private Integer shotsDifference;
    private Integer homeShotsOnGoalScore;
    private Integer awayShotsOnGoalScore;
    private String shotsOnGoalWinner;
    private Integer shotsOnGoalDifference;
    private Integer homeCornersScore;
    private Integer awayCornersScore;
    private String cornersWinner;
    private Integer cornersDifference;
    private Integer homeThrowsInScore;
    private Integer awayThrowsInScore;
    private String throwsInWinner;
    private Integer throwsInDifference;
    private Integer homeSavesScore;
    private Integer awaySavesScore;
    private String savesWinner;
    private Integer savesDifference;
    private Integer homeFoulsScore;
    private Integer awayFoulsScore;
    private String foulsWinner;
    private Integer foulsDifference;
    private Integer homeTacklesScore;
    private Integer awayTacklesScore;
    private String tacklesWinner;
    private Integer tacklesDifference;
    @Override
     public Match build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Match(
          id,
          league,
          date,
          homeTeam,
          awayTeam,
          homeShotsScore,
          awayShotsScore,
          shotsWinner,
          shotsDifference,
          homeShotsOnGoalScore,
          awayShotsOnGoalScore,
          shotsOnGoalWinner,
          shotsOnGoalDifference,
          homeCornersScore,
          awayCornersScore,
          cornersWinner,
          cornersDifference,
          homeThrowsInScore,
          awayThrowsInScore,
          throwsInWinner,
          throwsInDifference,
          homeSavesScore,
          awaySavesScore,
          savesWinner,
          savesDifference,
          homeFoulsScore,
          awayFoulsScore,
          foulsWinner,
          foulsDifference,
          homeTacklesScore,
          awayTacklesScore,
          tacklesWinner,
          tacklesDifference);
    }
    
    @Override
     public BuildStep league(String league) {
        this.league = league;
        return this;
    }
    
    @Override
     public BuildStep date(String date) {
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep homeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }
    
    @Override
     public BuildStep awayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }
    
    @Override
     public BuildStep homeShotsScore(Integer homeShotsScore) {
        this.homeShotsScore = homeShotsScore;
        return this;
    }
    
    @Override
     public BuildStep awayShotsScore(Integer awayShotsScore) {
        this.awayShotsScore = awayShotsScore;
        return this;
    }
    
    @Override
     public BuildStep shotsWinner(String shotsWinner) {
        this.shotsWinner = shotsWinner;
        return this;
    }
    
    @Override
     public BuildStep shotsDifference(Integer shotsDifference) {
        this.shotsDifference = shotsDifference;
        return this;
    }
    
    @Override
     public BuildStep homeShotsOnGoalScore(Integer homeShotsOnGoalScore) {
        this.homeShotsOnGoalScore = homeShotsOnGoalScore;
        return this;
    }
    
    @Override
     public BuildStep awayShotsOnGoalScore(Integer awayShotsOnGoalScore) {
        this.awayShotsOnGoalScore = awayShotsOnGoalScore;
        return this;
    }
    
    @Override
     public BuildStep shotsOnGoalWinner(String shotsOnGoalWinner) {
        this.shotsOnGoalWinner = shotsOnGoalWinner;
        return this;
    }
    
    @Override
     public BuildStep shotsOnGoalDifference(Integer shotsOnGoalDifference) {
        this.shotsOnGoalDifference = shotsOnGoalDifference;
        return this;
    }
    
    @Override
     public BuildStep homeCornersScore(Integer homeCornersScore) {
        this.homeCornersScore = homeCornersScore;
        return this;
    }
    
    @Override
     public BuildStep awayCornersScore(Integer awayCornersScore) {
        this.awayCornersScore = awayCornersScore;
        return this;
    }
    
    @Override
     public BuildStep cornersWinner(String cornersWinner) {
        this.cornersWinner = cornersWinner;
        return this;
    }
    
    @Override
     public BuildStep cornersDifference(Integer cornersDifference) {
        this.cornersDifference = cornersDifference;
        return this;
    }
    
    @Override
     public BuildStep homeThrowsInScore(Integer homeThrowsInScore) {
        this.homeThrowsInScore = homeThrowsInScore;
        return this;
    }
    
    @Override
     public BuildStep awayThrowsInScore(Integer awayThrowsInScore) {
        this.awayThrowsInScore = awayThrowsInScore;
        return this;
    }
    
    @Override
     public BuildStep throwsInWinner(String throwsInWinner) {
        this.throwsInWinner = throwsInWinner;
        return this;
    }
    
    @Override
     public BuildStep throwsInDifference(Integer throwsInDifference) {
        this.throwsInDifference = throwsInDifference;
        return this;
    }
    
    @Override
     public BuildStep homeSavesScore(Integer homeSavesScore) {
        this.homeSavesScore = homeSavesScore;
        return this;
    }
    
    @Override
     public BuildStep awaySavesScore(Integer awaySavesScore) {
        this.awaySavesScore = awaySavesScore;
        return this;
    }
    
    @Override
     public BuildStep savesWinner(String savesWinner) {
        this.savesWinner = savesWinner;
        return this;
    }
    
    @Override
     public BuildStep savesDifference(Integer savesDifference) {
        this.savesDifference = savesDifference;
        return this;
    }
    
    @Override
     public BuildStep homeFoulsScore(Integer homeFoulsScore) {
        this.homeFoulsScore = homeFoulsScore;
        return this;
    }
    
    @Override
     public BuildStep awayFoulsScore(Integer awayFoulsScore) {
        this.awayFoulsScore = awayFoulsScore;
        return this;
    }
    
    @Override
     public BuildStep foulsWinner(String foulsWinner) {
        this.foulsWinner = foulsWinner;
        return this;
    }
    
    @Override
     public BuildStep foulsDifference(Integer foulsDifference) {
        this.foulsDifference = foulsDifference;
        return this;
    }
    
    @Override
     public BuildStep homeTacklesScore(Integer homeTacklesScore) {
        this.homeTacklesScore = homeTacklesScore;
        return this;
    }
    
    @Override
     public BuildStep awayTacklesScore(Integer awayTacklesScore) {
        this.awayTacklesScore = awayTacklesScore;
        return this;
    }
    
    @Override
     public BuildStep tacklesWinner(String tacklesWinner) {
        this.tacklesWinner = tacklesWinner;
        return this;
    }
    
    @Override
     public BuildStep tacklesDifference(Integer tacklesDifference) {
        this.tacklesDifference = tacklesDifference;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String league, String date, String homeTeam, String awayTeam, Integer homeShotsScore, Integer awayShotsScore, String shotsWinner, Integer shotsDifference, Integer homeShotsOnGoalScore, Integer awayShotsOnGoalScore, String shotsOnGoalWinner, Integer shotsOnGoalDifference, Integer homeCornersScore, Integer awayCornersScore, String cornersWinner, Integer cornersDifference, Integer homeThrowsInScore, Integer awayThrowsInScore, String throwsInWinner, Integer throwsInDifference, Integer homeSavesScore, Integer awaySavesScore, String savesWinner, Integer savesDifference, Integer homeFoulsScore, Integer awayFoulsScore, String foulsWinner, Integer foulsDifference, Integer homeTacklesScore, Integer awayTacklesScore, String tacklesWinner, Integer tacklesDifference) {
      super.id(id);
      super.league(league)
        .date(date)
        .homeTeam(homeTeam)
        .awayTeam(awayTeam)
        .homeShotsScore(homeShotsScore)
        .awayShotsScore(awayShotsScore)
        .shotsWinner(shotsWinner)
        .shotsDifference(shotsDifference)
        .homeShotsOnGoalScore(homeShotsOnGoalScore)
        .awayShotsOnGoalScore(awayShotsOnGoalScore)
        .shotsOnGoalWinner(shotsOnGoalWinner)
        .shotsOnGoalDifference(shotsOnGoalDifference)
        .homeCornersScore(homeCornersScore)
        .awayCornersScore(awayCornersScore)
        .cornersWinner(cornersWinner)
        .cornersDifference(cornersDifference)
        .homeThrowsInScore(homeThrowsInScore)
        .awayThrowsInScore(awayThrowsInScore)
        .throwsInWinner(throwsInWinner)
        .throwsInDifference(throwsInDifference)
        .homeSavesScore(homeSavesScore)
        .awaySavesScore(awaySavesScore)
        .savesWinner(savesWinner)
        .savesDifference(savesDifference)
        .homeFoulsScore(homeFoulsScore)
        .awayFoulsScore(awayFoulsScore)
        .foulsWinner(foulsWinner)
        .foulsDifference(foulsDifference)
        .homeTacklesScore(homeTacklesScore)
        .awayTacklesScore(awayTacklesScore)
        .tacklesWinner(tacklesWinner)
        .tacklesDifference(tacklesDifference);
    }
    
    @Override
     public CopyOfBuilder league(String league) {
      return (CopyOfBuilder) super.league(league);
    }
    
    @Override
     public CopyOfBuilder date(String date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder homeTeam(String homeTeam) {
      return (CopyOfBuilder) super.homeTeam(homeTeam);
    }
    
    @Override
     public CopyOfBuilder awayTeam(String awayTeam) {
      return (CopyOfBuilder) super.awayTeam(awayTeam);
    }
    
    @Override
     public CopyOfBuilder homeShotsScore(Integer homeShotsScore) {
      return (CopyOfBuilder) super.homeShotsScore(homeShotsScore);
    }
    
    @Override
     public CopyOfBuilder awayShotsScore(Integer awayShotsScore) {
      return (CopyOfBuilder) super.awayShotsScore(awayShotsScore);
    }
    
    @Override
     public CopyOfBuilder shotsWinner(String shotsWinner) {
      return (CopyOfBuilder) super.shotsWinner(shotsWinner);
    }
    
    @Override
     public CopyOfBuilder shotsDifference(Integer shotsDifference) {
      return (CopyOfBuilder) super.shotsDifference(shotsDifference);
    }
    
    @Override
     public CopyOfBuilder homeShotsOnGoalScore(Integer homeShotsOnGoalScore) {
      return (CopyOfBuilder) super.homeShotsOnGoalScore(homeShotsOnGoalScore);
    }
    
    @Override
     public CopyOfBuilder awayShotsOnGoalScore(Integer awayShotsOnGoalScore) {
      return (CopyOfBuilder) super.awayShotsOnGoalScore(awayShotsOnGoalScore);
    }
    
    @Override
     public CopyOfBuilder shotsOnGoalWinner(String shotsOnGoalWinner) {
      return (CopyOfBuilder) super.shotsOnGoalWinner(shotsOnGoalWinner);
    }
    
    @Override
     public CopyOfBuilder shotsOnGoalDifference(Integer shotsOnGoalDifference) {
      return (CopyOfBuilder) super.shotsOnGoalDifference(shotsOnGoalDifference);
    }
    
    @Override
     public CopyOfBuilder homeCornersScore(Integer homeCornersScore) {
      return (CopyOfBuilder) super.homeCornersScore(homeCornersScore);
    }
    
    @Override
     public CopyOfBuilder awayCornersScore(Integer awayCornersScore) {
      return (CopyOfBuilder) super.awayCornersScore(awayCornersScore);
    }
    
    @Override
     public CopyOfBuilder cornersWinner(String cornersWinner) {
      return (CopyOfBuilder) super.cornersWinner(cornersWinner);
    }
    
    @Override
     public CopyOfBuilder cornersDifference(Integer cornersDifference) {
      return (CopyOfBuilder) super.cornersDifference(cornersDifference);
    }
    
    @Override
     public CopyOfBuilder homeThrowsInScore(Integer homeThrowsInScore) {
      return (CopyOfBuilder) super.homeThrowsInScore(homeThrowsInScore);
    }
    
    @Override
     public CopyOfBuilder awayThrowsInScore(Integer awayThrowsInScore) {
      return (CopyOfBuilder) super.awayThrowsInScore(awayThrowsInScore);
    }
    
    @Override
     public CopyOfBuilder throwsInWinner(String throwsInWinner) {
      return (CopyOfBuilder) super.throwsInWinner(throwsInWinner);
    }
    
    @Override
     public CopyOfBuilder throwsInDifference(Integer throwsInDifference) {
      return (CopyOfBuilder) super.throwsInDifference(throwsInDifference);
    }
    
    @Override
     public CopyOfBuilder homeSavesScore(Integer homeSavesScore) {
      return (CopyOfBuilder) super.homeSavesScore(homeSavesScore);
    }
    
    @Override
     public CopyOfBuilder awaySavesScore(Integer awaySavesScore) {
      return (CopyOfBuilder) super.awaySavesScore(awaySavesScore);
    }
    
    @Override
     public CopyOfBuilder savesWinner(String savesWinner) {
      return (CopyOfBuilder) super.savesWinner(savesWinner);
    }
    
    @Override
     public CopyOfBuilder savesDifference(Integer savesDifference) {
      return (CopyOfBuilder) super.savesDifference(savesDifference);
    }
    
    @Override
     public CopyOfBuilder homeFoulsScore(Integer homeFoulsScore) {
      return (CopyOfBuilder) super.homeFoulsScore(homeFoulsScore);
    }
    
    @Override
     public CopyOfBuilder awayFoulsScore(Integer awayFoulsScore) {
      return (CopyOfBuilder) super.awayFoulsScore(awayFoulsScore);
    }
    
    @Override
     public CopyOfBuilder foulsWinner(String foulsWinner) {
      return (CopyOfBuilder) super.foulsWinner(foulsWinner);
    }
    
    @Override
     public CopyOfBuilder foulsDifference(Integer foulsDifference) {
      return (CopyOfBuilder) super.foulsDifference(foulsDifference);
    }
    
    @Override
     public CopyOfBuilder homeTacklesScore(Integer homeTacklesScore) {
      return (CopyOfBuilder) super.homeTacklesScore(homeTacklesScore);
    }
    
    @Override
     public CopyOfBuilder awayTacklesScore(Integer awayTacklesScore) {
      return (CopyOfBuilder) super.awayTacklesScore(awayTacklesScore);
    }
    
    @Override
     public CopyOfBuilder tacklesWinner(String tacklesWinner) {
      return (CopyOfBuilder) super.tacklesWinner(tacklesWinner);
    }
    
    @Override
     public CopyOfBuilder tacklesDifference(Integer tacklesDifference) {
      return (CopyOfBuilder) super.tacklesDifference(tacklesDifference);
    }
  }
  
}
