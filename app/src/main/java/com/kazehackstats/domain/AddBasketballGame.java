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
import com.kazehackstats.data.BasketballMatch;
import com.kazehackstats.data.BasketballMatchRepository;
import com.kazehackstats.data.Match;
import com.kazehackstats.data.MatchRepository;

import java.util.UUID;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddBasketballGame extends AppCompatActivity {
  private String basketballMatchId;
  private String mDate;
  private TextInputLayout mLeague;
  private AutoCompleteTextView mLeagueText;
  private TextInputLayout mHomeTeam;
  private AutoCompleteTextView mHomeTeamText;
  private TextInputLayout mAwayTeam;
  private AutoCompleteTextView mAwayTeamText;
  private TextInputLayout mHome2PtsScore;
  private TextInputLayout mAway2PtsScore;
  private TextInputLayout m2PtsWinner;
  private AutoCompleteTextView m2PtsWinnerText;
  private TextInputLayout m2PtsDifference;
  private TextInputLayout mHome3PtsScore;
  private TextInputLayout mAway3PtsScore;
  private TextInputLayout m3PtsWinner;
  private AutoCompleteTextView m3PtsWinnerText;
  private TextInputLayout m3PtsDifference;
  private TextInputLayout mHomeReboundScore;
  private TextInputLayout mAwayReboundScore;
  private TextInputLayout mReboundWinner;
  private AutoCompleteTextView mReboundWinnerText;
  private TextInputLayout mReboundDifference;
  private TextInputLayout mHomeAssistScore;
  private TextInputLayout mAwayAssistScore;
  private TextInputLayout mAssistWinner;
  private AutoCompleteTextView mAssistWinnerText;
  private TextInputLayout mAssistDifference;
  private Button mValidate;
  private Button mDatePicker;
  private BasketballMatchRepository mBasketballMatchRepository;
  private BasketballMatch basketballMatch;
  private ArrayAdapter<String> LeagueAdapter;
  private ArrayAdapter<String> TeamsAdapter;
  private String[] Leagues = {"NBA"};
  private String leagui;
  private String hometeamu;
  private String awayteamu;
  private String twoPtsWinna;
  private String threePtsWinna;
  private String reboundsWinna;
  private String assistsWinna;
  private String[] Teams = {"Denver Nuggets","Memphis Grizzlies", "Sacramento Kings", "Phoenix Suns", "Los Angeles Clippers",
      "Golden State Warriors","Los Angeles Lakers","Minnesota Timberwolves","New Orleans Pelicans","Oklahoma City Thunder",
      "Dallas Mavericks","Utah Jazz","Portland Trail Blazers","Houston Rockets","San Antonio Spurs","Milwaukee Bucks",
  "Boston Celtics","Philadelphia 76ers","Cleveland Cavaliers","New York Knicks","Brooklyn Nets","Miami Heat","Atlanta Hawks",
  "Toronto Raptors","Chicago Bulls","Washington Wizards","Indiana Pacers","Orlando Magic","Charlotte Hornets","Detroit Pistons"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_basketball_game_template);

    Intent intent = getIntent();
    basketballMatch = intent.getParcelableExtra(BasketballMatch.BasketballMatch_EXTRA);

    Toolbar toolbar = findViewById(R.id.toolbar_add_basketballgame);
    setSupportActionBar(toolbar);
    mBasketballMatchRepository = new BasketballMatchRepository(getApplicationContext());
    Log.d(AddBasketballGame.class.getSimpleName(),"BasketballGame: " + basketballMatch);


    mLeague = findViewById(R.id.basketballLeague);
    mLeagueText = findViewById(R.id.league_autocompletetextview);
    // Créez l'adaptateur avec le tableau de noms d'équipes
    LeagueAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Leagues);

// Associez l'adaptateur à l'AutoCompleteTextView
    mLeagueText.setAdapter(LeagueAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    mLeagueText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddBasketballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        leagui = parent.getItemAtPosition(position).toString();
      }
    });

    mHomeTeam = findViewById(R.id.hometeam);
    mHomeTeamText= findViewById(R.id.hometeam_autocompletetextview);

// Créez l'adaptateur avec le tableau de noms d'équipes
    TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);

// Associez l'adaptateur à l'AutoCompleteTextView
    mHomeTeamText.setAdapter(TeamsAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    mHomeTeamText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddBasketballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        hometeamu = parent.getItemAtPosition(position).toString();
      }
    });

    mAwayTeam = findViewById(R.id.awayteam);
    mAwayTeamText = findViewById(R.id.awayteam_autocompletetextview);

    // Créez l'adaptateur avec le tableau de noms d'équipes
    TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);

// Associez l'adaptateur à l'AutoCompleteTextView
    mAwayTeamText.setAdapter(TeamsAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    mAwayTeamText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddBasketballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        awayteamu = parent.getItemAtPosition(position).toString();
      }
    });

    mHome2PtsScore = findViewById(R.id.hometwoptsScore);

    mAway2PtsScore = findViewById(R.id.awaytwoptsScore);

    m2PtsWinner = findViewById(R.id.twoptswinner);
    m2PtsWinnerText= findViewById(R.id.twoptswinner_autocompletetextview);

    // Créez l'adaptateur avec le tableau de noms d'équipes
    TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);

// Associez l'adaptateur à l'AutoCompleteTextView
    m2PtsWinnerText.setAdapter(TeamsAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    m2PtsWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddBasketballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        twoPtsWinna = parent.getItemAtPosition(position).toString();
      }
    });

    m2PtsDifference = findViewById(R.id.twoptsdifference);

    mHome3PtsScore = findViewById(R.id.homethreeptsscore);

    mAway3PtsScore = findViewById(R.id.awaythreeptsscore);

    m3PtsWinner= findViewById(R.id.threeptswinner);
    m3PtsWinnerText = findViewById(R.id.threeptswinner_autocompletetextview);

    // Créez l'adaptateur avec le tableau de noms d'équipes
    TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);

// Associez l'adaptateur à l'AutoCompleteTextView
    m3PtsWinnerText.setAdapter(TeamsAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    m3PtsWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddBasketballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        threePtsWinna = parent.getItemAtPosition(position).toString();
      }
    });

    m3PtsDifference = findViewById(R.id.threeptsdifference);

    mHomeReboundScore = findViewById(R.id.homereboundscore);

    mAwayReboundScore = findViewById(R.id.awayreboundscore);

    mReboundWinner = findViewById(R.id.reboundwinner);
    mReboundWinnerText = findViewById(R.id.reboundwinner_autocompletetextview);

    // Créez l'adaptateur avec le tableau de noms d'équipes
    TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);

// Associez l'adaptateur à l'AutoCompleteTextView
    mReboundWinnerText.setAdapter(TeamsAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    mReboundWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddBasketballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        reboundsWinna = parent.getItemAtPosition(position).toString();
      }
    });

    mReboundDifference = findViewById(R.id.rebounddifference);

    mHomeAssistScore = findViewById(R.id.assisthomescore);

    mAwayAssistScore = findViewById(R.id.assistawayscore);


    mAssistWinner = findViewById(R.id.assistwinner);
    mAssistWinnerText = findViewById(R.id.assistwinner_autocompletetextview);

    // Créez l'adaptateur avec le tableau de noms d'équipes
    TeamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Teams);

// Associez l'adaptateur à l'AutoCompleteTextView
    mAssistWinnerText.setAdapter(TeamsAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    mAssistWinnerText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(AddBasketballGame.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        assistsWinna = parent.getItemAtPosition(position).toString();
      }
    });


    mAssistDifference = findViewById(R.id.assistdifference);

    mDatePicker = findViewById(R.id.target_date_picker_button);
    mDatePicker.setOnClickListener(view -> showDatePicker());

    mValidate = findViewById(R.id.match_validate);
    mValidate.setOnClickListener(view -> {


      if (mLeague.getEditText().length() == 0 && mHomeTeam.getEditText().length() == 0 && mAwayTeam.getEditText().length() == 0) {

      } else if (mLeague.getEditText().length() != 0 && mHomeTeam.getEditText().length() != 0 && mAwayTeam.getEditText().length() != 0) {

        basketballMatchId = UUID.randomUUID().toString();

        BasketballMatch basketballMatch = new BasketballMatch(
            basketballMatchId,
            leagui,
            mDate,
            hometeamu,
            awayteamu,
            Integer.parseInt(mHome2PtsScore.getEditText().getText().toString()),
            Integer.parseInt(mAway2PtsScore.getEditText().getText().toString()),
            twoPtsWinna,
            Integer.parseInt(m2PtsDifference.getEditText().getText().toString()),
            Integer.parseInt(mHome3PtsScore.getEditText().getText().toString()),
            Integer.parseInt(mAway3PtsScore.getEditText().getText().toString()),
            threePtsWinna,
            Integer.parseInt(m3PtsDifference.getEditText().getText().toString()),
            Integer.parseInt(mHomeReboundScore.getEditText().getText().toString()),
            Integer.parseInt(mAwayReboundScore.getEditText().getText().toString()),
            reboundsWinna,
            Integer.parseInt(mReboundDifference.getEditText().getText().toString()),
            Integer.parseInt(mHomeAssistScore.getEditText().getText().toString()),
            Integer.parseInt(mAwayAssistScore.getEditText().getText().toString()),
            assistsWinna,
            Integer.parseInt(mAssistDifference.getEditText().getText().toString()));

        mBasketballMatchRepository.insert(basketballMatch)
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(() -> {
            }, e -> {
            });
        Log.d(AddBasketballGame.class.getSimpleName(), "Added basketball match: " + basketballMatch.toString());

        Intent intent1 = new Intent(AddBasketballGame.this, LigueChoosed.class);
        intent1.putExtra(BasketballMatch.BasketballMatch_EXTRA, basketballMatch);
        startActivity(intent1);
      }

    });


  };

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
