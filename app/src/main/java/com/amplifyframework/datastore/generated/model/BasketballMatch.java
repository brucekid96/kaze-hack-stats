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

/** This is an auto generated class representing the BasketballMatch type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "BasketballMatches", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.DELETE, ModelOperation.UPDATE, ModelOperation.READ })
})
public final class BasketballMatch implements Model {
  public static final QueryField ID = field("BasketballMatch", "id");
  public static final QueryField LEAGUE = field("BasketballMatch", "league");
  public static final QueryField DATE = field("BasketballMatch", "date");
  public static final QueryField HOME_TEAM = field("BasketballMatch", "homeTeam");
  public static final QueryField AWAY_TEAM = field("BasketballMatch", "awayTeam");
  public static final QueryField HOME_TWO_PTS_SCORE = field("BasketballMatch", "homeTwoPtsScore");
  public static final QueryField AWAY_TWO_PTS_SCORE = field("BasketballMatch", "awayTwoPtsScore");
  public static final QueryField TWO_PTS_WINNER = field("BasketballMatch", "twoPtsWinner");
  public static final QueryField TWO_PTS_DIFFERENCE = field("BasketballMatch", "twoPtsDifference");
  public static final QueryField HOME_THREE_PTS_SCORE = field("BasketballMatch", "homeThreePtsScore");
  public static final QueryField AWAY_THREE_PTS_SCORE = field("BasketballMatch", "awayThreePtsScore");
  public static final QueryField THREE_PTS_WINNER = field("BasketballMatch", "threePtsWinner");
  public static final QueryField THREE_PTS_DIFFERENCE = field("BasketballMatch", "threePtsDifference");
  public static final QueryField HOME_REBOUNDS_SCORE = field("BasketballMatch", "homeReboundsScore");
  public static final QueryField AWAY_REBOUNDS_SCORE = field("BasketballMatch", "awayReboundsScore");
  public static final QueryField REBOUNDS_WINNER = field("BasketballMatch", "reboundsWinner");
  public static final QueryField REBOUNDS_DIFFERENCE = field("BasketballMatch", "reboundsDifference");
  public static final QueryField HOME_ASSISTS_SCORE = field("BasketballMatch", "homeAssistsScore");
  public static final QueryField AWAY_ASSISTS_SCORE = field("BasketballMatch", "awayAssistsScore");
  public static final QueryField ASSISTS_WINNER = field("BasketballMatch", "assistsWinner");
  public static final QueryField ASSISTS_DIFFERENCE = field("BasketballMatch", "assistsDifference");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String league;
  private final @ModelField(targetType="String") String date;
  private final @ModelField(targetType="String") String homeTeam;
  private final @ModelField(targetType="String") String awayTeam;
  private final @ModelField(targetType="Int") Integer homeTwoPtsScore;
  private final @ModelField(targetType="Int") Integer awayTwoPtsScore;
  private final @ModelField(targetType="String") String twoPtsWinner;
  private final @ModelField(targetType="Int") Integer twoPtsDifference;
  private final @ModelField(targetType="Int") Integer homeThreePtsScore;
  private final @ModelField(targetType="Int") Integer awayThreePtsScore;
  private final @ModelField(targetType="String") String threePtsWinner;
  private final @ModelField(targetType="Int") Integer threePtsDifference;
  private final @ModelField(targetType="Int") Integer homeReboundsScore;
  private final @ModelField(targetType="Int") Integer awayReboundsScore;
  private final @ModelField(targetType="String") String reboundsWinner;
  private final @ModelField(targetType="Int") Integer reboundsDifference;
  private final @ModelField(targetType="Int") Integer homeAssistsScore;
  private final @ModelField(targetType="Int") Integer awayAssistsScore;
  private final @ModelField(targetType="String") String assistsWinner;
  private final @ModelField(targetType="Int") Integer assistsDifference;
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
  
  public Integer getHomeTwoPtsScore() {
      return homeTwoPtsScore;
  }
  
  public Integer getAwayTwoPtsScore() {
      return awayTwoPtsScore;
  }
  
  public String getTwoPtsWinner() {
      return twoPtsWinner;
  }
  
  public Integer getTwoPtsDifference() {
      return twoPtsDifference;
  }
  
  public Integer getHomeThreePtsScore() {
      return homeThreePtsScore;
  }
  
  public Integer getAwayThreePtsScore() {
      return awayThreePtsScore;
  }
  
  public String getThreePtsWinner() {
      return threePtsWinner;
  }
  
  public Integer getThreePtsDifference() {
      return threePtsDifference;
  }
  
  public Integer getHomeReboundsScore() {
      return homeReboundsScore;
  }
  
  public Integer getAwayReboundsScore() {
      return awayReboundsScore;
  }
  
  public String getReboundsWinner() {
      return reboundsWinner;
  }
  
  public Integer getReboundsDifference() {
      return reboundsDifference;
  }
  
  public Integer getHomeAssistsScore() {
      return homeAssistsScore;
  }
  
  public Integer getAwayAssistsScore() {
      return awayAssistsScore;
  }
  
  public String getAssistsWinner() {
      return assistsWinner;
  }
  
  public Integer getAssistsDifference() {
      return assistsDifference;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private BasketballMatch(String id, String league, String date, String homeTeam, String awayTeam, Integer homeTwoPtsScore, Integer awayTwoPtsScore, String twoPtsWinner, Integer twoPtsDifference, Integer homeThreePtsScore, Integer awayThreePtsScore, String threePtsWinner, Integer threePtsDifference, Integer homeReboundsScore, Integer awayReboundsScore, String reboundsWinner, Integer reboundsDifference, Integer homeAssistsScore, Integer awayAssistsScore, String assistsWinner, Integer assistsDifference) {
    this.id = id;
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
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      BasketballMatch basketballMatch = (BasketballMatch) obj;
      return ObjectsCompat.equals(getId(), basketballMatch.getId()) &&
              ObjectsCompat.equals(getLeague(), basketballMatch.getLeague()) &&
              ObjectsCompat.equals(getDate(), basketballMatch.getDate()) &&
              ObjectsCompat.equals(getHomeTeam(), basketballMatch.getHomeTeam()) &&
              ObjectsCompat.equals(getAwayTeam(), basketballMatch.getAwayTeam()) &&
              ObjectsCompat.equals(getHomeTwoPtsScore(), basketballMatch.getHomeTwoPtsScore()) &&
              ObjectsCompat.equals(getAwayTwoPtsScore(), basketballMatch.getAwayTwoPtsScore()) &&
              ObjectsCompat.equals(getTwoPtsWinner(), basketballMatch.getTwoPtsWinner()) &&
              ObjectsCompat.equals(getTwoPtsDifference(), basketballMatch.getTwoPtsDifference()) &&
              ObjectsCompat.equals(getHomeThreePtsScore(), basketballMatch.getHomeThreePtsScore()) &&
              ObjectsCompat.equals(getAwayThreePtsScore(), basketballMatch.getAwayThreePtsScore()) &&
              ObjectsCompat.equals(getThreePtsWinner(), basketballMatch.getThreePtsWinner()) &&
              ObjectsCompat.equals(getThreePtsDifference(), basketballMatch.getThreePtsDifference()) &&
              ObjectsCompat.equals(getHomeReboundsScore(), basketballMatch.getHomeReboundsScore()) &&
              ObjectsCompat.equals(getAwayReboundsScore(), basketballMatch.getAwayReboundsScore()) &&
              ObjectsCompat.equals(getReboundsWinner(), basketballMatch.getReboundsWinner()) &&
              ObjectsCompat.equals(getReboundsDifference(), basketballMatch.getReboundsDifference()) &&
              ObjectsCompat.equals(getHomeAssistsScore(), basketballMatch.getHomeAssistsScore()) &&
              ObjectsCompat.equals(getAwayAssistsScore(), basketballMatch.getAwayAssistsScore()) &&
              ObjectsCompat.equals(getAssistsWinner(), basketballMatch.getAssistsWinner()) &&
              ObjectsCompat.equals(getAssistsDifference(), basketballMatch.getAssistsDifference()) &&
              ObjectsCompat.equals(getCreatedAt(), basketballMatch.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), basketballMatch.getUpdatedAt());
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
      .append(getHomeTwoPtsScore())
      .append(getAwayTwoPtsScore())
      .append(getTwoPtsWinner())
      .append(getTwoPtsDifference())
      .append(getHomeThreePtsScore())
      .append(getAwayThreePtsScore())
      .append(getThreePtsWinner())
      .append(getThreePtsDifference())
      .append(getHomeReboundsScore())
      .append(getAwayReboundsScore())
      .append(getReboundsWinner())
      .append(getReboundsDifference())
      .append(getHomeAssistsScore())
      .append(getAwayAssistsScore())
      .append(getAssistsWinner())
      .append(getAssistsDifference())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("BasketballMatch {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("league=" + String.valueOf(getLeague()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("homeTeam=" + String.valueOf(getHomeTeam()) + ", ")
      .append("awayTeam=" + String.valueOf(getAwayTeam()) + ", ")
      .append("homeTwoPtsScore=" + String.valueOf(getHomeTwoPtsScore()) + ", ")
      .append("awayTwoPtsScore=" + String.valueOf(getAwayTwoPtsScore()) + ", ")
      .append("twoPtsWinner=" + String.valueOf(getTwoPtsWinner()) + ", ")
      .append("twoPtsDifference=" + String.valueOf(getTwoPtsDifference()) + ", ")
      .append("homeThreePtsScore=" + String.valueOf(getHomeThreePtsScore()) + ", ")
      .append("awayThreePtsScore=" + String.valueOf(getAwayThreePtsScore()) + ", ")
      .append("threePtsWinner=" + String.valueOf(getThreePtsWinner()) + ", ")
      .append("threePtsDifference=" + String.valueOf(getThreePtsDifference()) + ", ")
      .append("homeReboundsScore=" + String.valueOf(getHomeReboundsScore()) + ", ")
      .append("awayReboundsScore=" + String.valueOf(getAwayReboundsScore()) + ", ")
      .append("reboundsWinner=" + String.valueOf(getReboundsWinner()) + ", ")
      .append("reboundsDifference=" + String.valueOf(getReboundsDifference()) + ", ")
      .append("homeAssistsScore=" + String.valueOf(getHomeAssistsScore()) + ", ")
      .append("awayAssistsScore=" + String.valueOf(getAwayAssistsScore()) + ", ")
      .append("assistsWinner=" + String.valueOf(getAssistsWinner()) + ", ")
      .append("assistsDifference=" + String.valueOf(getAssistsDifference()) + ", ")
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
  public static BasketballMatch justId(String id) {
    return new BasketballMatch(
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      league,
      date,
      homeTeam,
      awayTeam,
      homeTwoPtsScore,
      awayTwoPtsScore,
      twoPtsWinner,
      twoPtsDifference,
      homeThreePtsScore,
      awayThreePtsScore,
      threePtsWinner,
      threePtsDifference,
      homeReboundsScore,
      awayReboundsScore,
      reboundsWinner,
      reboundsDifference,
      homeAssistsScore,
      awayAssistsScore,
      assistsWinner,
      assistsDifference);
  }
  public interface BuildStep {
    BasketballMatch build();
    BuildStep id(String id);
    BuildStep league(String league);
    BuildStep date(String date);
    BuildStep homeTeam(String homeTeam);
    BuildStep awayTeam(String awayTeam);
    BuildStep homeTwoPtsScore(Integer homeTwoPtsScore);
    BuildStep awayTwoPtsScore(Integer awayTwoPtsScore);
    BuildStep twoPtsWinner(String twoPtsWinner);
    BuildStep twoPtsDifference(Integer twoPtsDifference);
    BuildStep homeThreePtsScore(Integer homeThreePtsScore);
    BuildStep awayThreePtsScore(Integer awayThreePtsScore);
    BuildStep threePtsWinner(String threePtsWinner);
    BuildStep threePtsDifference(Integer threePtsDifference);
    BuildStep homeReboundsScore(Integer homeReboundsScore);
    BuildStep awayReboundsScore(Integer awayReboundsScore);
    BuildStep reboundsWinner(String reboundsWinner);
    BuildStep reboundsDifference(Integer reboundsDifference);
    BuildStep homeAssistsScore(Integer homeAssistsScore);
    BuildStep awayAssistsScore(Integer awayAssistsScore);
    BuildStep assistsWinner(String assistsWinner);
    BuildStep assistsDifference(Integer assistsDifference);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String league;
    private String date;
    private String homeTeam;
    private String awayTeam;
    private Integer homeTwoPtsScore;
    private Integer awayTwoPtsScore;
    private String twoPtsWinner;
    private Integer twoPtsDifference;
    private Integer homeThreePtsScore;
    private Integer awayThreePtsScore;
    private String threePtsWinner;
    private Integer threePtsDifference;
    private Integer homeReboundsScore;
    private Integer awayReboundsScore;
    private String reboundsWinner;
    private Integer reboundsDifference;
    private Integer homeAssistsScore;
    private Integer awayAssistsScore;
    private String assistsWinner;
    private Integer assistsDifference;
    @Override
     public BasketballMatch build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new BasketballMatch(
          id,
          league,
          date,
          homeTeam,
          awayTeam,
          homeTwoPtsScore,
          awayTwoPtsScore,
          twoPtsWinner,
          twoPtsDifference,
          homeThreePtsScore,
          awayThreePtsScore,
          threePtsWinner,
          threePtsDifference,
          homeReboundsScore,
          awayReboundsScore,
          reboundsWinner,
          reboundsDifference,
          homeAssistsScore,
          awayAssistsScore,
          assistsWinner,
          assistsDifference);
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
     public BuildStep homeTwoPtsScore(Integer homeTwoPtsScore) {
        this.homeTwoPtsScore = homeTwoPtsScore;
        return this;
    }
    
    @Override
     public BuildStep awayTwoPtsScore(Integer awayTwoPtsScore) {
        this.awayTwoPtsScore = awayTwoPtsScore;
        return this;
    }
    
    @Override
     public BuildStep twoPtsWinner(String twoPtsWinner) {
        this.twoPtsWinner = twoPtsWinner;
        return this;
    }
    
    @Override
     public BuildStep twoPtsDifference(Integer twoPtsDifference) {
        this.twoPtsDifference = twoPtsDifference;
        return this;
    }
    
    @Override
     public BuildStep homeThreePtsScore(Integer homeThreePtsScore) {
        this.homeThreePtsScore = homeThreePtsScore;
        return this;
    }
    
    @Override
     public BuildStep awayThreePtsScore(Integer awayThreePtsScore) {
        this.awayThreePtsScore = awayThreePtsScore;
        return this;
    }
    
    @Override
     public BuildStep threePtsWinner(String threePtsWinner) {
        this.threePtsWinner = threePtsWinner;
        return this;
    }
    
    @Override
     public BuildStep threePtsDifference(Integer threePtsDifference) {
        this.threePtsDifference = threePtsDifference;
        return this;
    }
    
    @Override
     public BuildStep homeReboundsScore(Integer homeReboundsScore) {
        this.homeReboundsScore = homeReboundsScore;
        return this;
    }
    
    @Override
     public BuildStep awayReboundsScore(Integer awayReboundsScore) {
        this.awayReboundsScore = awayReboundsScore;
        return this;
    }
    
    @Override
     public BuildStep reboundsWinner(String reboundsWinner) {
        this.reboundsWinner = reboundsWinner;
        return this;
    }
    
    @Override
     public BuildStep reboundsDifference(Integer reboundsDifference) {
        this.reboundsDifference = reboundsDifference;
        return this;
    }
    
    @Override
     public BuildStep homeAssistsScore(Integer homeAssistsScore) {
        this.homeAssistsScore = homeAssistsScore;
        return this;
    }
    
    @Override
     public BuildStep awayAssistsScore(Integer awayAssistsScore) {
        this.awayAssistsScore = awayAssistsScore;
        return this;
    }
    
    @Override
     public BuildStep assistsWinner(String assistsWinner) {
        this.assistsWinner = assistsWinner;
        return this;
    }
    
    @Override
     public BuildStep assistsDifference(Integer assistsDifference) {
        this.assistsDifference = assistsDifference;
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
    private CopyOfBuilder(String id, String league, String date, String homeTeam, String awayTeam, Integer homeTwoPtsScore, Integer awayTwoPtsScore, String twoPtsWinner, Integer twoPtsDifference, Integer homeThreePtsScore, Integer awayThreePtsScore, String threePtsWinner, Integer threePtsDifference, Integer homeReboundsScore, Integer awayReboundsScore, String reboundsWinner, Integer reboundsDifference, Integer homeAssistsScore, Integer awayAssistsScore, String assistsWinner, Integer assistsDifference) {
      super.id(id);
      super.league(league)
        .date(date)
        .homeTeam(homeTeam)
        .awayTeam(awayTeam)
        .homeTwoPtsScore(homeTwoPtsScore)
        .awayTwoPtsScore(awayTwoPtsScore)
        .twoPtsWinner(twoPtsWinner)
        .twoPtsDifference(twoPtsDifference)
        .homeThreePtsScore(homeThreePtsScore)
        .awayThreePtsScore(awayThreePtsScore)
        .threePtsWinner(threePtsWinner)
        .threePtsDifference(threePtsDifference)
        .homeReboundsScore(homeReboundsScore)
        .awayReboundsScore(awayReboundsScore)
        .reboundsWinner(reboundsWinner)
        .reboundsDifference(reboundsDifference)
        .homeAssistsScore(homeAssistsScore)
        .awayAssistsScore(awayAssistsScore)
        .assistsWinner(assistsWinner)
        .assistsDifference(assistsDifference);
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
     public CopyOfBuilder homeTwoPtsScore(Integer homeTwoPtsScore) {
      return (CopyOfBuilder) super.homeTwoPtsScore(homeTwoPtsScore);
    }
    
    @Override
     public CopyOfBuilder awayTwoPtsScore(Integer awayTwoPtsScore) {
      return (CopyOfBuilder) super.awayTwoPtsScore(awayTwoPtsScore);
    }
    
    @Override
     public CopyOfBuilder twoPtsWinner(String twoPtsWinner) {
      return (CopyOfBuilder) super.twoPtsWinner(twoPtsWinner);
    }
    
    @Override
     public CopyOfBuilder twoPtsDifference(Integer twoPtsDifference) {
      return (CopyOfBuilder) super.twoPtsDifference(twoPtsDifference);
    }
    
    @Override
     public CopyOfBuilder homeThreePtsScore(Integer homeThreePtsScore) {
      return (CopyOfBuilder) super.homeThreePtsScore(homeThreePtsScore);
    }
    
    @Override
     public CopyOfBuilder awayThreePtsScore(Integer awayThreePtsScore) {
      return (CopyOfBuilder) super.awayThreePtsScore(awayThreePtsScore);
    }
    
    @Override
     public CopyOfBuilder threePtsWinner(String threePtsWinner) {
      return (CopyOfBuilder) super.threePtsWinner(threePtsWinner);
    }
    
    @Override
     public CopyOfBuilder threePtsDifference(Integer threePtsDifference) {
      return (CopyOfBuilder) super.threePtsDifference(threePtsDifference);
    }
    
    @Override
     public CopyOfBuilder homeReboundsScore(Integer homeReboundsScore) {
      return (CopyOfBuilder) super.homeReboundsScore(homeReboundsScore);
    }
    
    @Override
     public CopyOfBuilder awayReboundsScore(Integer awayReboundsScore) {
      return (CopyOfBuilder) super.awayReboundsScore(awayReboundsScore);
    }
    
    @Override
     public CopyOfBuilder reboundsWinner(String reboundsWinner) {
      return (CopyOfBuilder) super.reboundsWinner(reboundsWinner);
    }
    
    @Override
     public CopyOfBuilder reboundsDifference(Integer reboundsDifference) {
      return (CopyOfBuilder) super.reboundsDifference(reboundsDifference);
    }
    
    @Override
     public CopyOfBuilder homeAssistsScore(Integer homeAssistsScore) {
      return (CopyOfBuilder) super.homeAssistsScore(homeAssistsScore);
    }
    
    @Override
     public CopyOfBuilder awayAssistsScore(Integer awayAssistsScore) {
      return (CopyOfBuilder) super.awayAssistsScore(awayAssistsScore);
    }
    
    @Override
     public CopyOfBuilder assistsWinner(String assistsWinner) {
      return (CopyOfBuilder) super.assistsWinner(assistsWinner);
    }
    
    @Override
     public CopyOfBuilder assistsDifference(Integer assistsDifference) {
      return (CopyOfBuilder) super.assistsDifference(assistsDifference);
    }
  }
  
}
