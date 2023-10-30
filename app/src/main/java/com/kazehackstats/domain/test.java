package com.kazehackstats.domain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.kazehackstats.R;
import com.kazehackstats.data.BasketballMatch;
import com.kazehackstats.data.BasketballMatchRepository;

import java.util.UUID;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class test extends AppCompatActivity {
  private TextInputLayout mHomeTeam;
  private AutoCompleteTextView mHomeTeamText;
  private ArrayAdapter<String> homeTeamAdapter;
  private String[] homeTeams = {"PSG","Lyon", "Marseille", "Monaco", "Lille"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.complete);






    mHomeTeam = findViewById(R.id.hometeam);

    mHomeTeamText = findViewById(R.id.homuteamtext);

// Créez l'adaptateur avec le tableau de noms d'équipes
    homeTeamAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, homeTeams);

// Associez l'adaptateur à l'AutoCompleteTextView
    mHomeTeamText.setAdapter(homeTeamAdapter);

// Définissez un écouteur d'événements pour l'AutoCompleteTextView
    mHomeTeamText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Affichez un message avec le nom de l'équipe sélectionnée
        Toast.makeText(test.this, "Vous avez choisi l'équipe " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
      }
    });


  };
}
