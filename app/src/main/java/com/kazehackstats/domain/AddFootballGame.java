package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;
import com.kazehackstats.R;
import com.kazehackstats.data.Match;
import com.kazehackstats.data.MatchRepository;

import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.ZonedDateTime;

import java.util.UUID;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddFootballGame extends AppCompatActivity {
  private String matchId;
  private String mDate;
  private TextInputLayout mLeague;
  private AutoCompleteTextView mLeagueText;
  private TextInputLayout mHomeTeam;
  private AutoCompleteTextView mHomeTeamText;
  private TextInputLayout mAwayTeam;
  private AutoCompleteTextView mAwayTeamText;
  private TextInputLayout mHomeShotScore;
  private TextInputLayout mAwayShotScore;
  private TextInputLayout mShotWinner;
  private AutoCompleteTextView mShotWinnerText;
  private TextInputLayout mShotDifference;
  private TextInputLayout mHomeShotOnGoalScore;
  private TextInputLayout mAwayShotOnGoalScore;
  private TextInputLayout mShotOnGoalWinner;
  private AutoCompleteTextView mShotOnGoalWinnerText;
  private TextInputLayout mShotOnGoalDifference;
  private TextInputLayout mHomeCornerScore;
  private TextInputLayout mAwayCornerScore;
  private TextInputLayout mCornerWinner;
  private AutoCompleteTextView mCornerWinnerText;
  private TextInputLayout mCornerDifference;
  private TextInputLayout mHomeThrowsInScore;
  private TextInputLayout mAwayThrowsInScore;
  private TextInputLayout mThrowsInWinner;
  private AutoCompleteTextView mThrowsInWinnerText;
  private TextInputLayout mThrowsInDifference;
  private TextInputLayout mHomeSaveScore;
  private TextInputLayout mAwaySaveScore;
  private TextInputLayout mSaveWinner;
  private AutoCompleteTextView mSaveWinnerText;
  private TextInputLayout mSaveDifference;
  private TextInputLayout mHomeFoulScore;
  private TextInputLayout mAwayFoulScore;
  private TextInputLayout mFoulWinner;
  private AutoCompleteTextView mFoulWinnerText;
  private TextInputLayout mFoulDifference;
  private TextInputLayout mHomeTackleScore;
  private TextInputLayout mAwayTackleScore;
  private TextInputLayout mTackleWinner;
  private AutoCompleteTextView mTackleWinnerText;
  private TextInputLayout mTackleDifference;
  private Button mValidate;
  private Button mDatePicker;
  private MatchRepository mFootballMatchRepository;
  private Match match;
  private String leagui;
  private String hometeamu;
  private String awayteamu;
  private String shotsWinna;
  private String shotsongoalWinna;
  private String cornerWinna;
  private String throwsinWinna;
  private String foulsWinna;
  private String savesWinna;
  private String tacklesWinna;
  private ArrayAdapter<String> LeagueAdapter;
  private ArrayAdapter<String> TeamsAdapter;
  private String[] Leagues = {"Premiere League","La Liga","Bundesliga","SerieA","Ligue1","Championship","Eredivisie","JupilerPro","LigaPortugal"};
  private String[] Teams = {"Le Havre","Lille","Lorient","Metz","Monaco","Nantes","Nice","PSG","Strasbourg","Brest","Clermont","Montpellier","Reims","Marseille","Toulouse","Lens","Rennes","Lyon",
  "Arsenal","Aston Villa","Chelsea","Everton","Fulham","Liverpool","Manchester City","Manchester Utd","Newcastle","Tottenham","West Ham","Burnley","Crystal Palace","Sheffield Utd","Wolves","Bournemouth","Brighton","Luton","Nottingham","Brentford",
  "Real Sociedad","Las Palmas","Alaves","Celta Vigo","Cadix CF","Vallecano","Real Madrid","Villarreal","Barcelone","Atletico Madrid","FC Seville","Majorque","Almeria","Valence","Atletico Bilbao","Betis","Getafe","Osasuna","Gerone","Grenade",
  "Union Berlin","Eintracht Francfort","Bayern Munich","Bayer Leverkusen","Werder Breme","Wolfsburg","Bochum","Dortmund","Borussia Monchengladbach","Hoffenheim","FC Cologne","Mayence","Fribourg","Augsburg","Stuttgart","Darmstadt","Heidenheim","RB Leipzig",
  "Lecce","Bologne","Frosinone","Genoa","Naples","Udinese","Monza","Sassuolo","Salernitana","AS Rome","Inter","Juventus","Fiorentina","AC Milan","Atalanta","Lazio","Cagliari","Torino","Empoli","Hellas Verone",
  "Birmingham","Blackburn","Middlesbrough","Sunderland","Bristol City","Cardiff","Coventry","Hull","Ipswich","Leicester","Norwich","Plymouth","Preston","QPR","Sheffield Wed","Southampton","Stoke City","Watford","West Brom","Huddersfield","Leeds","Millwall","Swansea","Rotherham",
  "Almere","Sittard","FC Volendam","Waalwijk","Zwolle","PSV","Ajax","Twente","Heerenveen","Feyenoord","Nijmegen","Utrecht","Alkmaar","Vitesse","Sparta Rotterdam","Heracles","Excelsior","G.A. Eagles",
  "Estrela","Boavista","Guimaraes","Estoril","Gil Vicente","Portimonense","Rio Ave","Vizela","Chaves","Moreirense","FC Porto","Sporting Portugal","Benfica","Braga","Arouca","Casa Pia","Famalicao","Farense",
  "Genk","Royale Union SG","La Gantoise","Antwerp","Saint-Trond","Westerlo","Eupen","Louvain","Charleroi","Club Brugge","Malines","Courtrai","Cercle Bruges","Standard Liege","Anderlecht","RWDM"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_foot_game_template);

    Intent intent = getIntent();
    match = intent.getParcelableExtra(match.Match_EXTRA);

    Toolbar toolbar = findViewById(R.id.toolbar_add_footgame);
    setSupportActionBar(toolbar);
    mFootballMatchRepository = new MatchRepository(getApplicationContext());
    Log.d(AddFootballGame.class.getSimpleName(),"Foot: " + match);


      mLeague = findViewById(R.id.footleague);
      mLeagueText = findViewById(R.id.footleague_autocompletetextview);
      LeagueAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Leagues);
     mLeagueText.setAdapter(LeagueAdapter);
     mLeagueText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        leagui = parent.getItemAtPosition(position).toString();
      }
    });

      mHomeTeam = findViewById(R.id.hometeam);
      mHomeTeamText = findViewById(R.id.homuteam_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mHomeTeamText.setAdapter(TeamsAdapter);
      mHomeTeamText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        hometeamu = parent.getItemAtPosition(position).toString();
      }
    });

      mAwayTeam = findViewById(R.id.awayteam);
      mAwayTeamText = findViewById(R.id.awayiteam_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mAwayTeamText.setAdapter(TeamsAdapter);
      mAwayTeamText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        awayteamu = parent.getItemAtPosition(position).toString();
      }
    });

      mHomeShotScore = findViewById(R.id.homeshotscore);

      mAwayShotScore = findViewById(R.id.awayshotscore);

      mShotWinner = findViewById(R.id.shotwinner);
      mShotWinnerText = findViewById(R.id.shotwinner_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mShotWinnerText.setAdapter(TeamsAdapter);
      mShotWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        shotsWinna = parent.getItemAtPosition(position).toString();
      }
    });

      mShotDifference = findViewById(R.id.shotdifference);

      mHomeShotOnGoalScore = findViewById(R.id.homeshotongoalscore);

      mAwayShotOnGoalScore = findViewById(R.id.awayshotongoalscore);

      mShotOnGoalWinner= findViewById(R.id.shotongoalwinner);
      mShotOnGoalWinnerText = findViewById(R.id.shotongoal_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mShotOnGoalWinnerText.setAdapter(TeamsAdapter);
      mShotOnGoalWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        shotsongoalWinna = parent.getItemAtPosition(position).toString();
      }
    });

      mShotOnGoalDifference = findViewById(R.id.shotongoaldifference);

      mHomeCornerScore = findViewById(R.id.homecornerscore);

      mAwayCornerScore = findViewById(R.id.awaycornerscore);

      mCornerWinner = findViewById(R.id.cornerwinner);
      mCornerWinnerText = findViewById(R.id.cornerwinner_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mCornerWinnerText.setAdapter(TeamsAdapter);
      mCornerWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        cornerWinna = parent.getItemAtPosition(position).toString();
      }
    });

      mCornerDifference = findViewById(R.id.cornerdifference);

      mHomeThrowsInScore = findViewById(R.id.throwsinhomescore);

      mAwayThrowsInScore = findViewById(R.id.throwsinawayscore);

      mThrowsInWinner = findViewById(R.id.throwsinwinner);
      mThrowsInWinnerText = findViewById(R.id.throwsinwinner_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mThrowsInWinnerText.setAdapter(TeamsAdapter);
      mThrowsInWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        throwsinWinna = parent.getItemAtPosition(position).toString();
      }
    });

      mThrowsInDifference = findViewById(R.id.throwsindifference);

      mHomeSaveScore = findViewById(R.id.savehomescore);

      mAwaySaveScore = findViewById(R.id.saveawayscore);

      mSaveWinner = findViewById(R.id.savewinner);
      mSaveWinnerText = findViewById(R.id.savewinner_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mSaveWinnerText.setAdapter(TeamsAdapter);
      mSaveWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        savesWinna = parent.getItemAtPosition(position).toString();
      }
    });

      mSaveDifference = findViewById(R.id.savedifference);

      mHomeFoulScore = findViewById(R.id.foulhomescore);

      mAwayFoulScore = findViewById(R.id.foulawayscore);

      mFoulWinner = findViewById(R.id.foulwinner);
      mFoulWinnerText = findViewById(R.id.foulwinner_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mFoulWinnerText.setAdapter(TeamsAdapter);
      mFoulWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        foulsWinna = parent.getItemAtPosition(position).toString();
      }
    });

      mFoulDifference = findViewById(R.id.fouldifference);

      mHomeTackleScore = findViewById(R.id.tacklehomescore);

      mAwayTackleScore = findViewById(R.id.tackleawayscore);

      mTackleWinner = findViewById(R.id.tacklewinner);
      mTackleWinnerText = findViewById(R.id.tacklewinner_autocompletetextview);
      TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);
      mTackleWinnerText.setAdapter(TeamsAdapter);
      mTackleWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AddFootballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        tacklesWinna = parent.getItemAtPosition(position).toString();
      }
    });

      mTackleDifference = findViewById(R.id.tackledifference);


    mDatePicker = findViewById(R.id.target_date_picker_button);
    mDatePicker.setOnClickListener(view -> showDatePicker());

    mValidate = findViewById(R.id.match_validate);
    mValidate.setOnClickListener(view -> {


      if (mLeague.getEditText().length() == 0 && mHomeTeam.getEditText().length() == 0 && mAwayTeam.getEditText().length() == 0   ) {

      }
      else
      if(mLeague.getEditText().length() != 0 && mHomeTeam.getEditText().length() != 0 && mAwayTeam.getEditText().length() != 0 ) {

        matchId = UUID.randomUUID().toString();

        Match match = new Match(
            matchId,
            leagui,
            mDate,
            hometeamu,
            awayteamu,
            Integer.parseInt(mHomeShotScore.getEditText().getText().toString()),
            Integer.parseInt( mAwayShotScore.getEditText().getText().toString()),
            shotsWinna,
            Integer.parseInt(mShotDifference.getEditText().getText().toString()),
            Integer.parseInt(mHomeShotOnGoalScore.getEditText().getText().toString()),
            Integer.parseInt( mAwayShotOnGoalScore.getEditText().getText().toString()),
            shotsongoalWinna,
            Integer.parseInt(mShotOnGoalDifference.getEditText().getText().toString()),
            Integer.parseInt(mHomeCornerScore.getEditText().getText().toString()),
            Integer.parseInt(mAwayCornerScore.getEditText().getText().toString()),
            cornerWinna,
            Integer.parseInt( mCornerDifference.getEditText().getText().toString()),
            Integer.parseInt(mHomeThrowsInScore.getEditText().getText().toString()),
            Integer.parseInt(mAwayThrowsInScore.getEditText().getText().toString()),
            throwsinWinna,
            Integer.parseInt(mThrowsInDifference.getEditText().getText().toString()),
            Integer.parseInt( mHomeSaveScore.getEditText().getText().toString()),
            Integer.parseInt(mAwaySaveScore.getEditText().getText().toString()),
            savesWinna,
            Integer.parseInt(mSaveDifference.getEditText().getText().toString()),
            Integer.parseInt(mHomeFoulScore.getEditText().getText().toString()),
            Integer.parseInt(mAwayFoulScore.getEditText().getText().toString()),
            foulsWinna,
            Integer.parseInt(mFoulDifference.getEditText().getText().toString()),
            Integer.parseInt(mHomeTackleScore.getEditText().getText().toString()),
            Integer.parseInt( mAwayTackleScore.getEditText().getText().toString()),
            tacklesWinna,
            Integer.parseInt(mTackleDifference.getEditText().getText().toString())
        );
        mFootballMatchRepository.insert(match)
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(() -> {
            }, e -> {
            });
        Log.d(AddFootballGame.class.getSimpleName(), "Added match: " + match.toString());

        Intent intent1 = new Intent(AddFootballGame.this, LigueChoosed.class);
        intent1.putExtra(Match.Match_EXTRA, match);
        startActivity(intent1);
      }

    });
  }
  private void showDatePicker() {
    MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder
        .datePicker()
        .setCalendarConstraints(
            new CalendarConstraints.Builder()
                .setStart(MaterialDatePicker.INPUT_MODE_CALENDAR)
                .build())
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .build();

    materialDatePicker.addOnPositiveButtonClickListener(selection -> {
      mDate = com.kazehackstats.utils.DateTimeUtils.epochMillisToLocalDate(materialDatePicker.getSelection()).toString();
      mDatePicker.setText(com.kazehackstats.utils.DateTimeUtils.getShortLocalizedDateString(this, materialDatePicker.getSelection(), true));
    });

    materialDatePicker.show(getSupportFragmentManager(), null);
  }

}
